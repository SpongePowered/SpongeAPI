/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.event;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.spongepowered.api.util.event.factory.EventFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SpongeEventFactoryTest {

    @Test
    public void testCreate() throws InvocationTargetException, IllegalAccessException {
        for (Method method : SpongeEventFactory.class.getMethods()) {
            if (method.getName().startsWith("create") && Modifier.isStatic(method.getModifiers())) {
                try {
                    Class<?>[] paramTypes = method.getParameterTypes();
                    Object[] params = new Object[paramTypes.length];
                    for (int i = 0; i < paramTypes.length; i++) {
                        params[i] = mockParam(paramTypes[i]);
                    }

                    method.invoke(null, params);
                } catch (Exception e) {
                    throw new RuntimeException(
                            "Runtime creation of the '" + method.getReturnType().getName() + "' event failed\n\n"
                                    + "(To avoid the need to create numerous boilerplate concrete classes for Sponge's many event "
                                    + "interfaces, the " + SpongeEventFactory.class.getSimpleName()
                                    + " class dynamically creates concrete classes at "
                                    + "runtime. However, as this means that errors may only become known at runtime, this test ensures that problems "
                                    + "are caught during development.)\n\n"
                                    + "The failure of this test is in regards to creation of the '" + method.getReturnType().getName()
                                    + "' event.\n\n"
                                    + "Reasons for failure include:\n"
                                    + "(1) The event was changed and there are new, removed, or modified properties (most likely)\n"
                                    + "\tSolution: Make appropriate changes to " + SpongeEventFactory.class.getName() + "." + method.getName()
                                    + "(). "
                                    + "See the wrapped exception for more details.\n"
                                    + "(2) A bug in the class generator was found\n"
                                    + "\tSolution: Look into " + EventFactory.class.getName() + " and its implementations.\n"
                                    + "(3) A method that does not follow getter/setter semantics (getProp(), isBool(), setProp()) "
                                    + "was added (i.e. blockList())\n"
                                    + "\tSolution: Revisit " + method.getReturnType().getName() + " and its supertypes. If the method in question "
                                    + "must exist, then the event factory is capable of accepting a base class to build the "
                                    + "runtime concrete class upon (i.e. " + AbstractEvent.class.getName()
                                    + " is the supertype of all generated event classes).\n", e);
                }
            }
        }
    }

    private Object mockParam(Class<?> paramType) {
        if (paramType == byte.class) {
            return (byte) 0;
        } else if (paramType == short.class) {
            return (short) 0;
        } else if (paramType == int.class) {
            return 0;
        } else if (paramType == long.class) {
            return (long) 0;
        } else if (paramType == float.class) {
            return (float) 0;
        } else if (paramType == double.class) {
            return (double) 0;
        } else if (paramType == char.class) {
            return (char) 0;
        } else if (paramType == boolean.class) {
            return false;
        } else if (paramType == String.class) {
            return "Cupcakes";
        } else if (Enum.class.isAssignableFrom(paramType)) {
            return paramType.getEnumConstants()[0];
        } else {
            return mock(paramType);
        }
    }
}
