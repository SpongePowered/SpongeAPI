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

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.plugin.jvm.Plugin;
import org.spongepowered.plugin.metadata.PluginMetadata;
import org.spongepowered.plugin.metadata.util.PluginMetadataHelper;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

/**
 * Modify all plugins.json files for detected AP paths
 */
@SupportedAnnotationTypes(PluginMainClassProcessor.PLUGIN_ANNOTATION)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class PluginMainClassProcessor extends AbstractProcessor {

    static final String PLUGIN_ANNOTATION = "org.spongepowered.plugin.jvm.Plugin";
    static final String PLUGINS_JSON = "META-INF/plugins.json";
    private static final PluginMetadataHelper METADATA_IO = PluginMetadataHelper.builder()
        .configureGson(gson -> gson.disableHtmlEscaping().setPrettyPrinting())
        .build();

    private @MonotonicNonNull TypeElement pluginAnnotation;
    private @MonotonicNonNull Map<String, PluginScanData> metadata;
    private Set<Element> pluginAnnotations = new HashSet<>();

    @Override
    public synchronized void init(final ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.pluginAnnotation = processingEnv.getElementUtils().getTypeElement(PluginMainClassProcessor.PLUGIN_ANNOTATION);
    }

    @Override
    public boolean process(
        final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv
    ) {
        final Messager messager = this.processingEnv.getMessager();
        // read existing plugins.json
        if (this.metadata == null) {
            final FileObject pluginsJson;

            try {
                pluginsJson = this.processingEnv.getFiler().getResource(StandardLocation.SOURCE_PATH, "", PluginMainClassProcessor.PLUGINS_JSON);
            } catch (final IOException ex) {
                messager.printMessage(Diagnostic.Kind.ERROR, "Failed to locate plugins.json on the source path");
                ex.printStackTrace();
                return false;
            }

            try (final Reader read = pluginsJson.openReader(false)) {
                final Collection<PluginMetadata> plugins = PluginMainClassProcessor.METADATA_IO.read(read);
                this.metadata = new LinkedHashMap<>();
                for (final PluginMetadata plugin : plugins) {
                    if (this.metadata.putIfAbsent(plugin.id(), new PluginScanData(plugin)) != null) {
                        messager.printMessage(Diagnostic.Kind.ERROR, "Repeated plugin with ID '" + plugin.id() + "' found in plugins.json");
                    }
                }
            } catch (final Exception ex) {
                messager.printMessage(Diagnostic.Kind.ERROR, "Failed to read incoming plugin metadata: " + ex.getMessage());
                ex.printStackTrace();
                return false;
            }
        }

        // scan any annotated plugins
        if (annotations.contains(this.pluginAnnotation)) {
            for (final Element element : roundEnv.getElementsAnnotatedWith(this.pluginAnnotation)) {
                if (!element.getKind().isClass()) {
                    messager.printMessage(Diagnostic.Kind.ERROR, "@Plugin annotation was used on something that's not a class", element);
                    continue;
                }

                final String pluginId = element.getAnnotation(Plugin.class).value();
                final PluginScanData data = this.metadata.get(pluginId);
                if (data == null) {
                    messager.printMessage(Diagnostic.Kind.ERROR, "@Plugin annotation has unknown plugin ID of " + pluginId + ", not declared in json", element);
                    continue;
                }

                final String existingMainClass = data.initMainClass(this.processingEnv.getElementUtils().getBinaryName((TypeElement) element).toString());
                if (existingMainClass != null) {
                    messager.printMessage(Diagnostic.Kind.ERROR, "Main class for '" + pluginId + "' in plugins.json does not match the actual annotated main class");
                }
            }
        }

        // Then write out an updated plugins.json
        if (roundEnv.processingOver()) {
            try {
                final FileObject pluginResource = this.processingEnv.getFiler().createResource(
                    StandardLocation.CLASS_OUTPUT,
                    "",
                    PluginMainClassProcessor.PLUGINS_JSON,
                    this.pluginAnnotations.toArray(new Element[0])
                );

                final List<PluginMetadata> plugins = new ArrayList<>(this.metadata.size());
                for (final Map.Entry<String, PluginScanData> entry : this.metadata.entrySet()) {
                    plugins.add(entry.getValue().output());
                }

                PluginMainClassProcessor.METADATA_IO.write(pluginResource.openWriter(), plugins);
            } catch (final Exception ex) {
                messager.printMessage(Diagnostic.Kind.ERROR, "Failed to write plugin metadata: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return false;
    }

    static final class PluginScanData {
        final PluginMetadata inputMetadata;
        @Nullable String mainClass;

        PluginScanData(final PluginMetadata inputMetadata) {
            this.inputMetadata = inputMetadata;
            this.mainClass = inputMetadata.mainClass();
        }

        String initMainClass(final String binaryName) {
            if (this.mainClass == null || this.mainClass.equals(binaryName)) {
                this.mainClass = binaryName;
                return null;
            } else {
                return this.mainClass;
            }
        }

        PluginMetadata output() {
            if (Objects.equals(this.mainClass, this.inputMetadata.mainClass())) {
                return this.inputMetadata;
            } else {
                return this.inputMetadata.toBuilder()
                    .mainClass(this.mainClass)
                    .build();
            }
        }
    }
}
