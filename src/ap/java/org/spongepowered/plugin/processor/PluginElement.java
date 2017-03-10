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

import static com.google.common.base.Preconditions.checkNotNull;
import static javax.tools.Diagnostic.Kind.ERROR;
import static javax.tools.Diagnostic.Kind.WARNING;
import static org.spongepowered.api.plugin.Plugin.ID_PATTERN;

import org.spongepowered.api.Platform;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.plugin.meta.PluginDependency;
import org.spongepowered.plugin.meta.PluginMetadata;
import org.spongepowered.plugin.meta.version.InvalidVersionSpecificationException;
import org.spongepowered.plugin.meta.version.VersionRange;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.Messager;
import javax.lang.model.element.TypeElement;

final class PluginElement {

    private static final String API_VERSION = PluginElement.class.getPackage().getSpecificationVersion();

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
            messager.printMessage(ERROR, "Plugin ID '" + value + "' must match pattern '" + ID_PATTERN.pattern() + "'. "
                    + "It should be lower case, start with an alphabetic character and may only contain alphanumeric characters, underscores or "
                    + "dashes.",
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

        checkDependencies(this.metadata.getDependencies(), messager);

        Set<String> addedDependencies = new HashSet<>();

        Dependency[] dependencies = this.annotation.get().dependencies();
        if (dependencies.length > 0) {
            for (Dependency dependency : dependencies) {
                final String id = dependency.id();
                if (id.isEmpty()) {
                    messager.printMessage(ERROR, "Dependency ID should not be empty", this.element, this.annotation.getMirror(),
                            this.annotation.getValue("dependencies"));
                    continue;
                }

                if (id.equals("*")) {
                    messager.printMessage(ERROR, "Wildcard dependencies are not supported on Sponge", this.element, this.annotation.getMirror(),
                            this.annotation.getValue("dependencies"));
                    continue;
                }

                final String version = dependency.version();
                if (!version.isEmpty()) {
                    try {
                        VersionRange.createFromVersionSpec(version);
                    } catch (InvalidVersionSpecificationException e) {
                        messager.printMessage(ERROR, "Invalid dependency version range: " + version + " (" + e.getMessage()
                                + ") Please check the Javadocs of @Dependency.version() for details.",
                                this.element, this.annotation.getMirror(), this.annotation.getValue("dependencies"));
                    }
                }

                if (addedDependencies.add(id)) {
                    // TODO: Load order
                    this.metadata.replaceDependency(new PluginDependency(PluginDependency.LoadOrder.BEFORE, id, dependency.version(),
                            dependency.optional()));
                } else {
                    messager.printMessage(ERROR, "Duplicate dependency with plugin ID: " + id, this.element, this.annotation.getMirror(),
                            this.annotation.getValue("dependencies"));
                }
            }
        }

        if (this.metadata.getDependency(Platform.API_ID) == null) {
            // Add SpongeAPI as required dependency to the metadata
            this.metadata.addDependency(new PluginDependency(PluginDependency.LoadOrder.BEFORE, Platform.API_ID, API_VERSION, false));
        }
    }

    private void checkDependencies(Iterable<PluginDependency> dependencies, Messager messager) {
        for (PluginDependency dependency : dependencies) {
            if (dependency.getId().isEmpty()) {
                messager.printMessage(ERROR, "Dependency from extra metadata file cannot have an empty plugin ID", this.element,
                        this.annotation.getMirror());
                continue;
            }

            if (dependency.getId().equals("*")) {
                messager.printMessage(ERROR, "Wildcard dependency from extra metadata file is not supported on Sponge", this.element,
                        this.annotation.getMirror());
                continue;
            }

            final String version = dependency.getVersion();
            if (version != null) {
                try {
                    VersionRange.createFromVersionSpec(version);
                } catch (InvalidVersionSpecificationException e) {
                    messager.printMessage(ERROR, "Invalid dependency version range from extra metadata file: " + version + " (" + e.getMessage()
                            + ") Please check the Javadocs of @Dependency.version() for details.", this.element, this.annotation.getMirror());
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

}
