package org.spongepowered.plugin.processor;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;
import java.util.Optional;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

public class ParameterContext {
    private final ProcessingEnvironment env;
    private final Optional<DeclaredType> eventType;
    private final Optional<TypeElement> eventElement;
    private VariableElement param;
    private AnnotationMirror anno;

    public ParameterContext(final ProcessingEnvironment env, final @Nullable DeclaredType eventType) {
        this.env = env;
        this.eventType = Optional.ofNullable(eventType);
        this.eventElement = this.eventType.map(t -> (TypeElement) t.asElement());
    }

    void init(final VariableElement param, final AnnotationMirror anno) {
        this.param = Objects.requireNonNull(param, "param");
        this.anno = Objects.requireNonNull(anno, "anno");
    }

    Types types() {
        return this.env.getTypeUtils();
    }

    Elements elements() {
        return this.env.getElementUtils();
    }

    Optional<DeclaredType> eventType() {
        return this.eventType;
    }

    Optional<TypeElement> event() {
        return this.eventElement;
    }

    VariableElement param() {
        return this.param;
    }

    AnnotationMirror anno() {
        return this.anno;
    }

    void logParamError(final String message) {
        this.env.getMessager().printMessage(Diagnostic.Kind.ERROR, message, this.param);
    }

    void logError(final String message) {
        this.env.getMessager().printMessage(Diagnostic.Kind.ERROR, message, this.param, this.anno);
    }

    void logError(final String message, final AnnotationValue value) {
        this.env.getMessager().printMessage(Diagnostic.Kind.ERROR, message, this.param, this.anno, value);
    }

    void logWarning(final String message) {
        this.env.getMessager().printMessage(Diagnostic.Kind.WARNING, message, this.param, this.anno);
    }

    void logWarning(final String message, final AnnotationValue value) {
        this.env.getMessager().printMessage(Diagnostic.Kind.WARNING, message, this.param, this.anno, value);
    }
}
