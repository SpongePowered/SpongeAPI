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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static javax.tools.Diagnostic.Kind.ERROR;
import static javax.tools.Diagnostic.Kind.WARNING;
import static org.spongepowered.api.plugin.Plugin.ID_PATTERN;

import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.plugin.meta.PluginMetadata;
import org.spongepowered.plugin.meta.SpongeExtension;
import org.spongepowered.plugin.meta.version.InvalidVersionSpecificationException;
import org.spongepowered.plugin.meta.version.VersionRange;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import javax.annotation.processing.Messager;
import javax.lang.model.element.TypeElement;

final class PluginElement {

    private final TypeElement element;
    private final AnnotationWrapper<Plugin> annotation;
    private final PluginMetadata metadata;

    PluginElement(TypeElement element, AnnotationWrapper<Plugin> annotation, PluginMetadata metadata) {
        this.element = checkNotNull(element, "element");
        this.annotation = checkNotNull(annotation, "annotation");
        this.metadata = metadata;
    }

    TypeElement getElement() {
        return this.element;
    }

    AnnotationWrapper<Plugin> getAnnotation() {
        return this.annotation;
    }

    PluginMetadata getMetadata() {
        return this.metadata;
    }

    void apply(Messager messager) {
        String value = this.annotation.get().id();
        if (!ID_PATTERN.matcher(value).matches()) {
            messager.printMessage(ERROR, "Plugin ID '" + value + "' should match pattern " + ID_PATTERN.pattern(),
                    this.element, this.annotation.getMirror(), this.annotation.getValue("id"));
        }

        value = this.annotation.get().name();
        if (value.isEmpty()) {
            if (this.metadata.getName() == null) {
                messager.printMessage(WARNING, "Missing plugin name", this.element, this.annotation.getMirror());
            }
        } else {
            this.metadata.setName(value);
        }

        value = this.annotation.get().version();
        if (value.isEmpty()) {
            if (this.metadata.getVersion() == null) {
                messager.printMessage(WARNING, "Missing plugin version", this.element, this.annotation.getMirror());
            }
        } else {
            this.metadata.setVersion(value);
        }

        value = this.annotation.get().description();
        if (value.isEmpty()) {
            if (this.metadata.getDescription() == null) {
                messager.printMessage(WARNING, "Missing plugin description", this.element, this.annotation.getMirror());
            }
        } else {
            this.metadata.setDescription(value);
        }

        value = this.annotation.get().url();
        if (!value.isEmpty()) {
            if (!isLikelyValidUrl(value)) {
                messager.printMessage(ERROR, "Invalid URL: " + value, this.element, this.annotation.getMirror(), this.annotation.getValue("url"));
            }

            this.metadata.setUrl(value);
        } else if ((value = this.metadata.getUrl()) != null) {
            if (!isLikelyValidUrl(value)) {
                messager.printMessage(ERROR, "Invalid URL: " + value + " in extra metadata files", this.element, this.annotation.getMirror());
            }
        }

        value = this.annotation.get().assets();
        if (!value.isEmpty()) {
            if (!isValidPath(value)) {
                messager.printMessage(ERROR, "Invalid asset directory path: " + value, this.element, this.annotation.getMirror(),
                        this.annotation.getValue("assets"));
            }
            SpongeExtension ext = new SpongeExtension();
            ext.setAssetDirectory(value);
            this.metadata.setExtension("sponge", ext);
        } else {
            SpongeExtension ext = this.metadata.getExtension("sponge");
            if (ext != null && ext.getAssetDirectory() != null && !isValidPath(ext.getAssetDirectory())) {
                messager.printMessage(ERROR, "Invalid asset directory path: " + value + " in extra metadata files", this.element,
                        this.annotation.getMirror());
            }
        }

        String[] authors = this.annotation.get().authors();
        if (authors.length > 0) {
            this.metadata.getAuthors().clear();
            for (String author : authors) {
                if (author.isEmpty()) {
                    messager.printMessage(ERROR, "Empty author is not allowed", this.element, this.annotation.getMirror(),
                            this.annotation.getValue("authors"));
                    continue;
                }

                this.metadata.addAuthor(author);
            }
        }

        checkDependencies(this.metadata.getRequiredDependencies(), messager);
        checkDependencies(this.metadata.getLoadAfter(), messager);
        checkDependencies(this.metadata.getLoadBefore(), messager);

        Dependency[] dependencies = this.annotation.get().dependencies();
        if (dependencies.length > 0) {
            for (Dependency dependency : dependencies) {
                final String id = dependency.id();
                if (id.isEmpty()) {
                    messager.printMessage(ERROR, "Dependency ID should not be empty", this.element, this.annotation.getMirror(),
                            this.annotation.getValue("dependencies"));
                }

                final String version = dependency.version();
                if (!version.isEmpty()) {
                    try {
                        VersionRange.createFromVersionSpec(version);
                    } catch (InvalidVersionSpecificationException e) {
                        messager.printMessage(ERROR, "Invalid dependency version range: " + version + " (" + e.getMessage() +
                                ") Please check the Javadocs of @Dependency.version() for details.",
                                this.element, this.annotation.getMirror(), this.annotation.getValue("dependencies"));
                    }
                }

                // TODO: Load order
                this.metadata.loadAfter(new PluginMetadata.Dependency(id, dependency.version()), !dependency.optional());
            }
        }
    }

    private void checkDependencies(Iterable<PluginMetadata.Dependency> dependencies, Messager messager) {
        for (PluginMetadata.Dependency dependency : dependencies) {
            final String version = dependency.getVersion();
            if (version != null) {
                try {
                    VersionRange.createFromVersionSpec(version);
                } catch (InvalidVersionSpecificationException e) {
                    messager.printMessage(ERROR, "Invalid dependency version range from extra metadata file: " + version + " (" + e.getMessage() +
                            ") Please check the Javadocs of @Dependency.version() for details.", this.element, this.annotation.getMirror());
                }
            }
        }
    }

    private static boolean isLikelyValidUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException ignored) {
            return false;
        }
    }

    private static boolean isValidPath(String path) {
        try {
            Paths.get(path);
            return true;
        } catch (InvalidPathException e) {
            return false;
        }
    }

    static void applyMeta(PluginMetadata meta, PluginMetadata other, Messager messager) {
        checkArgument(meta.getId().equals(other.getId()), "Plugin meta IDs don't match");

        if (other.getName() != null) {
            meta.setName(other.getName());
        }
        if (other.getVersion() != null) {
            meta.setVersion(other.getVersion());
        }
        if (other.getDescription() != null) {
            meta.setDescription(other.getDescription());
        }
        if (other.getUrl() != null) {
            meta.setUrl(other.getUrl());
        }
        if (!other.getAuthors().isEmpty()) {
            meta.getAuthors().clear();
            meta.getAuthors().addAll(other.getAuthors());
        }

        SpongeExtension ext = other.getExtension("sponge");
        if (ext != null) {
            SpongeExtension otherExt = new SpongeExtension();
            otherExt.setAssetDirectory(ext.getAssetDirectory());
            meta.setExtension("sponge", otherExt);
        }

        // TODO: Dependencies
        if (!other.getRequiredDependencies().isEmpty() || !other.getLoadAfter().isEmpty() || !other.getLoadBefore().isEmpty()) {
            messager.printMessage(WARNING, "Trying to merge dependencies from extra metadata file. This is currently not supported.");
        }

        other.getExtensions().forEach((key, extension) -> {
            // TODO
            if (meta.getExtensions().containsKey(key)) {
                messager.printMessage(WARNING, "Cannot merge extension " + key + " of type " + extension.getClass() + " from extra metadata file");
            } else {
                meta.setExtension(key, extension);
            }
        });
    }

}
