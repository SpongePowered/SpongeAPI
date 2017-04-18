package org.spongepowered.api.data;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;

import javax.annotation.Nullable;

public class DataRegistrationNotFoundException extends DataException {

    @Nullable private String registrationQuery;
    @Nullable private Class<? extends DataManipulator<?, ?>> manipulatorClass;
    @Nullable private Class<? extends ImmutableDataManipulator<?, ?>> immutableClass;

    public DataRegistrationNotFoundException() {
        super();
    }

    public DataRegistrationNotFoundException(String registrationQuery) {
        this.registrationQuery = registrationQuery;
    }

    public DataRegistrationNotFoundException(String message, String registrationQuery) {
        super(message);
        this.registrationQuery = registrationQuery;
    }

    public DataRegistrationNotFoundException(String message,
        Class<? extends DataManipulator<?, ?>> manipulatorClass) {
        super(message);
        this.manipulatorClass = manipulatorClass;
    }

    public DataRegistrationNotFoundException(String message, Throwable cause,
        Class<? extends DataManipulator<?, ?>> manipulatorClass) {
        super(message, cause);
        this.manipulatorClass = manipulatorClass;
    }

    public DataRegistrationNotFoundException(String message,
        @Nullable Class<? extends DataManipulator<?, ?>> manipulatorClass,
        Class<? extends ImmutableDataManipulator<?, ?>> immutableClass) {
        super(message);
        this.manipulatorClass = manipulatorClass;
        this.immutableClass = immutableClass;
    }

    public DataRegistrationNotFoundException(String message, Throwable cause,
        @Nullable Class<? extends DataManipulator<?, ?>> manipulatorClass,
        Class<? extends ImmutableDataManipulator<?, ?>> immutableClass) {
        super(message, cause);
        this.manipulatorClass = manipulatorClass;
        this.immutableClass = immutableClass;
    }

    @Nullable
    public String getRegistrationQuery() {
        return this.registrationQuery;
    }

    @Nullable
    public Class<? extends DataManipulator<?, ?>> getManipulatorClass() {
        return this.manipulatorClass;
    }

    @Nullable
    public Class<? extends ImmutableDataManipulator<?, ?>> getImmutableClass() {
        return this.immutableClass;
    }
}
