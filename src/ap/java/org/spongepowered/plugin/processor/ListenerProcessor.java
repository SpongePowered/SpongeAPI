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

import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.IsCancelled;
import org.spongepowered.api.event.filter.type.Exclude;
import org.spongepowered.api.event.filter.type.Include;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

@SupportedAnnotationTypes(ListenerProcessor.LISTENER_ANNOTATION_CLASS)
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class ListenerProcessor extends AbstractProcessor {

    static final String LISTENER_ANNOTATION_CLASS = "org.spongepowered.api.event.Listener";
    private static final String EVENT_CLASS = Event.class.getName();
    private static final String IS_CANCELLED_ANNOTATION = IsCancelled.class.getName();
    private static final String INCLUDE_ANNOTATION = Include.class.getName();
    private static final String EXCLUDE_ANNOTATION = Exclude.class.getName();

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        final Set<String> types = new HashSet<>(super.getSupportedAnnotationTypes());
        for (final ListenerParameterAnnotation annotation : ListenerParameterAnnotation.values()) {
            types.add(annotation.className());
        }
        return Collections.unmodifiableSet(types);
    }

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
        if (ProcessorUtils.contains(annotations, Listener.class)) {
            for (final Element e : roundEnv.getElementsAnnotatedWith(Listener.class)) {
                if (e.getKind() != ElementKind.METHOD) {
                    this.processingEnv.getMessager().printMessage(ERROR, "Invalid element of type " + e.getKind() + " annotated with @Listener", e);
                    continue;
                }
                final ExecutableElement method = (ExecutableElement) e;

                if (method.getModifiers().contains(Modifier.STATIC)) {
                    this.error("Event listener method must not be static", method);
                }
                if (method.getModifiers().contains(Modifier.ABSTRACT)) {
                    this.error("Event listener method must not be abstract", method);
                }
                if (method.getEnclosingElement().getKind().isInterface()) {
                    this.error("interfaces cannot declare listeners", method);
                }
                if (method.getReturnType().getKind() != TypeKind.VOID) {
                    this.error("Event listener method must return void", method);
                }
                final List<? extends VariableElement> parameters = method.getParameters();
                final DeclaredType eventType;
                if (parameters.isEmpty() || !this.isTypeSubclass(parameters.get(0), ListenerProcessor.EVENT_CLASS)) {
                    this.error("Event listener method must have an Event as its first parameter", method);
                    eventType = null;
                } else {
                    eventType = (DeclaredType) parameters.get(0).asType();
                }

                final Types types = this.processingEnv.getTypeUtils();
                if (eventType != null) {
                    for (final AnnotationMirror annotation : method.getAnnotationMirrors()) {
                        final String name = this.processingEnv.getElementUtils()
                            .getBinaryName((TypeElement) annotation.getAnnotationType().asElement()).toString();
                        if (name.equals(ListenerProcessor.IS_CANCELLED_ANNOTATION)) {
                            // ensure the event parameter inherits from Cancellable
                            final TypeElement cancellable =
                                this.processingEnv.getElementUtils().getTypeElement("org.spongepowered.api.event.Cancellable");
                            if (cancellable != null && !types.isAssignable(eventType, cancellable.asType())) {
                                this.error("A listener for a non-Cancellable method cannot be annotated with @IsCancelled", method);
                            }
                        } else if (name.equals(ListenerProcessor.INCLUDE_ANNOTATION) || name.equals(ListenerProcessor.EXCLUDE_ANNOTATION)) {
                            // ensure that all referenced types are subtypes of Cancellable
                            for (final Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry
                                : annotation.getElementValues().entrySet()) {
                                if (entry.getKey().getSimpleName().contentEquals("value")) {
                                    @SuppressWarnings("unchecked") final List<? extends AnnotationValue> values =
                                        (List<? extends AnnotationValue>) entry.getValue().getValue();
                                    for (final AnnotationValue subtype : values) {
                                        if (!types.isAssignable((TypeMirror) subtype.getValue(), eventType)) {
                                            this.error(
                                                "All filtered types must be subtypes of the event type '" + eventType.asElement().getSimpleName() + "'",
                                                method,
                                                annotation,
                                                subtype
                                            );
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


                final ParameterContext ctx = new ParameterContext(this.processingEnv, eventType);
                for (int i = 1; i < parameters.size(); ++i) {
                    this.checkParameter(ctx, parameters.get(i));
                }
            }
        }

        return false;
    }

    /**
     * Check method parameters of event listeners for valid uses of event handler annotations
     *
     * @param element element to check
     */
    private void checkParameter(final ParameterContext ctx, final VariableElement element) {
        // for every filtering annotation registered, check if this element is annotated
        // then, we get to
        for (final AnnotationMirror annotation : element.getAnnotationMirrors()) {
            ctx.init(element, annotation);
            final CharSequence name = this.processingEnv.getElementUtils().getBinaryName((TypeElement) annotation.getAnnotationType().asElement());
            final ListenerParameterAnnotation anno = ListenerParameterAnnotation.byClassName(name.toString());
            if (anno != null) {
                anno.validate(ctx);
            }
        }
    }

    private boolean isTypeSubclass(final Element typedElement, final String subclass) {
        final Elements elements = this.processingEnv.getElementUtils();
        final Types types = this.processingEnv.getTypeUtils();

        final TypeMirror event = types.getDeclaredType(elements.getTypeElement(subclass));
        return types.isAssignable(typedElement.asType(), event);
    }

    // Error collection

    private void error(final CharSequence message, final Element element) {
        this.processingEnv.getMessager().printMessage(ERROR, message, element);
    }

    private void error(final CharSequence message, final Element element, final AnnotationMirror annotation, final AnnotationValue value) {
        this.processingEnv.getMessager().printMessage(ERROR, message, element, annotation, value);
    }

}
