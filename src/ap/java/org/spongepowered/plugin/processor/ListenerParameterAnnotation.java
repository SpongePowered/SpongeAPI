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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.ContextValue;
import org.spongepowered.api.event.filter.data.GetValue;
import org.spongepowered.api.event.filter.data.Has;
import org.spongepowered.api.event.filter.data.Supports;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

public enum ListenerParameterAnnotation {
    CONTEXT_VALUE(ContextValue.class) {
        @Override
        void validate(final ParameterContext ctx) {
            for (final Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : ctx.anno().getElementValues().entrySet()) {
                if (entry.getKey().getSimpleName().contentEquals("value")) {
                    final TypeElement key = ctx.elements().getTypeElement("org.spongepowered.api.event.EventContextKey");
                    final TypeElement keys = ctx.elements().getTypeElement("org.spongepowered.api.event.EventContextKeys");
                    final Element contained = ProcessorUtils.containingWithNameAndType(keys.getEnclosedElements(), entry.getValue().getValue().toString(), ElementKind.FIELD);
                    if (contained == null) {
                        ctx.logError("Could not find a context key matching the provided name", entry.getValue());
                        return; // cannot resolve, not possible to provide more information
                    }
                    if (!contained.getModifiers().contains(Modifier.STATIC)) {
                        ctx.logError("The @ContextValue annotation must refer to a static field", entry.getValue());
                    }
                    if (!ctx.types().isSubtype(contained.asType(), key.asType())) {
                        ctx.logError("The @ContextValue annotation must refer to a field with type EventContextKey, but got '" + contained.asType() + "' instead", entry.getValue());
                    }
                    // validate field type?
                    break;
                }
            }
        }
    },
    HAS(Has.class) {
        @Override
        void validate(final ParameterContext ctx) {
            ListenerParameterAnnotation.validateValueContainerChild("@Has", ctx);
            ListenerParameterAnnotation.validateKeyReference("@Has", ctx);
        }
    },
    SUPPORTS(Supports.class) {
        @Override
        void validate(final ParameterContext ctx) {
            ListenerParameterAnnotation.validateValueContainerChild("@Supports", ctx);
            ListenerParameterAnnotation.validateKeyReference("@Supports", ctx);
        }
    },
    GET_VALUE(GetValue.class) {
        @Override
        void validate(final ParameterContext ctx) {
            ListenerParameterAnnotation.validateKeyReference("@GetValue", ctx);
        }
    },
    GETTER(Getter.class) {

        private boolean isOptional(final TypeMirror mirror) {
            return mirror.getKind() == TypeKind.DECLARED && ((DeclaredType) mirror).asElement().getSimpleName().contentEquals("Optional");
        }

        @Override
        void validate(final ParameterContext ctx) {
            if (!ctx.event().isPresent()) {
                return;
            }
            final TypeElement event = ctx.event().get();
            for (final Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : ctx.anno().getElementValues().entrySet()) {
                if (entry.getKey().getSimpleName().contentEquals("value")) {
                    final CharSequence getterName = (CharSequence) entry.getValue().getValue();
                    final Element possible = ctx.elements().getAllMembers(event).stream()
                        .filter(el -> el.getKind() == ElementKind.METHOD && el.getSimpleName().contentEquals(getterName))
                        .filter(el -> ((ExecutableElement) el).getParameters().isEmpty())
                        .findFirst().orElse(null);
                    if (possible == null) {
                        ctx.logError("No zero-argument method with this name found in event type '" + event.getSimpleName() + "'", entry.getValue());
                        break;
                    }

                    TypeMirror expectedType = ((ExecutableType) ctx.types().asMemberOf(ctx.eventType().get(), possible)).getReturnType();
                    if (expectedType.getKind() == TypeKind.DECLARED) { // maybe Optional, if so unwrap
                        final DeclaredType declared = (DeclaredType) expectedType;
                        if (this.isOptional(declared) && declared.getTypeArguments().size() == 1 && !this.isOptional(ctx.param().asType())) {
                            expectedType = declared.getTypeArguments().get(0);
                        }
                    }
                    if (!ctx.types().isSameType(expectedType, ctx.param().asType())) {
                        ctx.logParamError(
                            "Annotated parameter was of incorrect type for the method referenced in @Getter. The parameter type should be '"
                            + expectedType + "'!"
                        );
                    }
                    break;
                }
            }
        }
    }
    ;

    private static final Map<String, ListenerParameterAnnotation> BY_CLAZZ = new HashMap<>();
    private final String className;

    ListenerParameterAnnotation(final Class<? extends Annotation> anno) {
        this.className = anno.getName();
    }

    String className() {
        return this.className;
    }

    abstract void validate(final ParameterContext ctx);

    static @Nullable ListenerParameterAnnotation byClassName(final String annotation) {
        return ListenerParameterAnnotation.BY_CLAZZ.get(annotation);
    }

    static void validateValueContainerChild(final String annotation, final ParameterContext ctx) {
        final TypeElement valueContainer = ctx.elements().getTypeElement("org.spongepowered.api.data.value.ValueContainer");
        if (valueContainer == null) {
            return;
        }
        if (!ctx.types().isAssignable(ctx.param().asType(), valueContainer.asType())) {
            ctx.logError(annotation + " is only applicable to parameters whose type is a subtype of ValueContainer");
        }
    }

    static void validateKeyReference(final String annotation, final ParameterContext ctx) {
        TypeMirror container = null;
        String value = null;
        for (final Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : ctx.anno().getElementValues().entrySet()) {
            final Name name = entry.getKey().getSimpleName();
            if (name.contentEquals("container")) {
                container = (TypeMirror) entry.getValue().getValue();
            } else if (name.contentEquals("value")) {
                value = (String) entry.getValue().getValue();
            }
            if (container != null && value != null) {
                break;
            }
        }
        if (container == null) {
            // set to Keys
            container = ctx.elements().getTypeElement("org.spongepowered.api.data.Keys").asType();
        }

        if (container.getKind() != TypeKind.DECLARED) { // otherwise incorrect
            return;
        }

        final TypeElement key = ctx.elements().getTypeElement("org.spongepowered.api.data.Key");
        final TypeElement element = (TypeElement) ((DeclaredType) container).asElement();

        final Element contained = ProcessorUtils.containingWithNameAndType(element.getEnclosedElements(), value, ElementKind.FIELD);
        if (contained == null) {
            ctx.logError("Could not find a matching Key in the specified container class");
            return; // cannot resolve, not possible to provide more information
        }

        final Set<Modifier> modifiers = contained.getModifiers();
        if (!modifiers.contains(Modifier.STATIC) || !modifiers.contains(Modifier.PUBLIC)) {
            ctx.logError("The " + annotation + " annotation must refer to a public static field");
        }

        if (!ctx.types().isAssignable(contained.asType(), ctx.types().erasure(key.asType()))) {
            ctx.logError("The " + annotation + " annotation must refer to a field with type Key, but got '" + contained.asType() + "' instead");
        }
    }

    static {
        for (final ListenerParameterAnnotation element : ListenerParameterAnnotation.values()) {
            ListenerParameterAnnotation.BY_CLAZZ.put(element.className, element);
        }
    }
}
