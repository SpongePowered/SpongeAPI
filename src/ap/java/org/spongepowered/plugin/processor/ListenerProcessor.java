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

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes(ListenerProcessor.LISTENER_ANNOTATION_CLASS)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ListenerProcessor extends AbstractProcessor {

    static final String LISTENER_ANNOTATION_CLASS = "org.spongepowered.api.event.Listener";
    private static final String EVENT_CLASS = Event.class.getName();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (ProcessorUtils.contains(annotations, Listener.class)) {
            for (Element e : roundEnv.getElementsAnnotatedWith(Listener.class)) {
                if (e.getKind() != ElementKind.METHOD) {
                    this.processingEnv.getMessager().printMessage(ERROR, "Invalid element of type " + e.getKind() + " annotated with @Listener", e);
                    continue;
                }
                ExecutableElement method = (ExecutableElement) e;

                Messager msg = this.processingEnv.getMessager();
                if (method.getModifiers().contains(Modifier.STATIC)) {
                    msg.printMessage(Diagnostic.Kind.ERROR, "method must not be static", method);
                }
                if (!method.getModifiers().contains(Modifier.PUBLIC)) {
                    msg.printMessage(Diagnostic.Kind.ERROR, "method must be public", method);
                }
                if (method.getModifiers().contains(Modifier.ABSTRACT)) {
                    msg.printMessage(Diagnostic.Kind.ERROR, "method must not be abstract", method);
                }
                if (method.getEnclosingElement().getKind().isInterface()) {
                    msg.printMessage(Diagnostic.Kind.ERROR, "interfaces cannot declare listeners", method);
                }
                if (method.getReturnType().getKind() != TypeKind.VOID) {
                    msg.printMessage(Diagnostic.Kind.ERROR, "method must return void", method);
                }
                List<? extends VariableElement> parameters = method.getParameters();
                if (parameters.isEmpty() || !isTypeSubclass(parameters.get(0), EVENT_CLASS)) {
                    msg.printMessage(Diagnostic.Kind.ERROR, "method must have an Event as its first parameter", method);
                }
            }
        }

        return false;
    }

    private boolean isTypeSubclass(Element typedElement, String subclass) {
        Elements elements = this.processingEnv.getElementUtils();
        Types types = this.processingEnv.getTypeUtils();

        TypeMirror event = types.getDeclaredType(elements.getTypeElement(subclass));
        return types.isAssignable(typedElement.asType(), event);
    }

}
