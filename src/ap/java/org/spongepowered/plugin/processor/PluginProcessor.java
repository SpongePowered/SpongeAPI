/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.plugin.processor;

import static javax.tools.Diagnostic.Kind.ERROR;
import static javax.tools.Diagnostic.Kind.NOTE;
import static javax.tools.Diagnostic.Kind.WARNING;
import static javax.tools.StandardLocation.CLASS_OUTPUT;

import com.google.common.base.Splitter;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.plugin.meta.McModInfo;
import org.spongepowered.plugin.meta.PluginMetadata;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;

@SupportedAnnotationTypes({ PluginProcessor.PLUGIN_ANNOTATION_CLASS, PluginProcessor.DEPENDENCY_ANNOTATION_CLASS })
@SupportedOptions({ PluginProcessor.EXTRA_FILES_OPTION, PluginProcessor.OUTPUT_FILE_OPTION })
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class PluginProcessor extends AbstractProcessor {

    static final String PLUGIN_PACKAGE = "org.spongepowered.api.plugin.";
    static final String PLUGIN_ANNOTATION_CLASS = PluginProcessor.PLUGIN_PACKAGE + "Plugin";
    static final String DEPENDENCY_ANNOTATION_CLASS = PluginProcessor.PLUGIN_PACKAGE + "Dependency";
    
    public static final String EXTRA_FILES_OPTION = "extraMetadataFiles";
    public static final String OUTPUT_FILE_OPTION = "metadataOutputFile";

    private static final Splitter FILE_SPLITTER = Splitter.on(';');

    private final Map<String, PluginMetadata> meta = new HashMap<>();
    private final Map<String, PluginElement> plugins = new HashMap<>();
    private final Set<String> duplicates = new HashSet<>();

    private Path outputPath;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        String extraFiles = processingEnv.getOptions().get(EXTRA_FILES_OPTION);
        if (extraFiles != null && !extraFiles.isEmpty()) {
            for (String file : FILE_SPLITTER.split(extraFiles)) {
                Path path = Paths.get(file);
                getMessager().printMessage(NOTE, "Reading extra plugin metadata from " + path);
                try {
                    for (PluginMetadata meta : McModInfo.DEFAULT.read(path)) {
                        PluginMetadata base = this.meta.putIfAbsent(meta.getId(), meta);
                        if (base != null) {
                            base.accept(meta);
                        }
                    }
                } catch (IOException e) {
                    throw new PluginProcessException("Failed to read extra plugin metadata from " + path, e);
                }
            }
        }

        String outputFile = processingEnv.getOptions().get(OUTPUT_FILE_OPTION);
        if (outputFile != null && !outputFile.isEmpty()) {
            this.outputPath = Paths.get(outputFile);
        }
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            if (!roundEnv.errorRaised()) {
                finish();
            }

            return false;
        }

        if (!ProcessorUtils.contains(annotations, Plugin.class)) {
            return false;
        }

        for (Element e : roundEnv.getElementsAnnotatedWith(Plugin.class)) {
            if (e.getKind() != ElementKind.CLASS) {
                getMessager().printMessage(ERROR, "Invalid element of type " + e.getKind() + " annotated with @Plugin", e);
                continue;
            }

            final TypeElement pluginElement = (TypeElement) e;
            AnnotationWrapper<Plugin> annotation = AnnotationWrapper.of(pluginElement, Plugin.class);

            final String id = annotation.get().id();
            if (id.isEmpty()) {
                getMessager().printMessage(ERROR, "Plugin ID cannot be empty", pluginElement, annotation.getMirror(), annotation.getValue("id"));
                continue;
            }

            PluginMetadata meta = this.meta.remove(id);
            if (meta == null) {
                meta = new PluginMetadata(id);
            }

            PluginElement plugin = new PluginElement(pluginElement, annotation, meta);

            // Check for conflicting plugin IDs
            if (this.duplicates.contains(id) || this.plugins.containsKey(id)) {
                PluginElement otherPlugin = this.plugins.remove(id);
                if (otherPlugin != null) {
                    reportDuplicatePlugin(id, otherPlugin);
                    this.duplicates.add(id);
                }

                reportDuplicatePlugin(id, plugin);
                continue;
            }

            this.plugins.put(id, plugin);
            plugin.apply(getMessager());
        }

        return false;
    }

    private void finish() {
        if (!this.meta.isEmpty()) {
            getMessager().printMessage(WARNING, "The following extra plugin IDs were not found: " + this.meta.keySet());
        }

        List<PluginMetadata> meta = this.plugins.values().stream()
                .map(PluginElement::getMetadata)
                .collect(Collectors.toList());
        meta.addAll(this.meta.values());

        try (BufferedWriter writer = createWriter()) {
            McModInfo.DEFAULT.write(writer, meta);
        } catch (IOException e) {
            throw new PluginProcessException("Failed to write plugin metadata", e);
        }
    }

    private BufferedWriter createWriter() throws IOException {
        if (this.outputPath != null) {
            getMessager().printMessage(NOTE, "Writing plugin metadata to " + this.outputPath);
            return Files.newBufferedWriter(this.outputPath);
        }

        FileObject obj = this.processingEnv.getFiler().createResource(CLASS_OUTPUT, "", McModInfo.STANDARD_FILENAME);
        getMessager().printMessage(NOTE, "Writing plugin metadata to " + obj.toUri());
        return new BufferedWriter(obj.openWriter());
    }

    private void reportDuplicatePlugin(String id, PluginElement plugin) {
        getMessager().printMessage(ERROR, "Duplicate plugin ID: " + id, plugin.getElement(), plugin.getAnnotation().getMirror(),
                plugin.getAnnotation().getValue("id"));
    }

    private Messager getMessager() {
        return this.processingEnv.getMessager();
    }

}
