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
package org.spongepowered.api.event;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.entity.HealEntityEvent;
import org.spongepowered.api.event.entity.ai.AITaskEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.event.factory.EventFactory;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.InetSocketAddress;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Transaction.class)
public class SpongeEventFactoryTest {

    private Set<Class<?>> excludedEvents;


    @Before
    public void setUp() {
        this.excludedEvents = Sets.newHashSet(DamageEntityEvent.class, HealEntityEvent.class, AITaskEvent.class, AITaskEvent.Add.class, AITaskEvent.Remove.class);
    }

    @Test
    public void testCreate() throws InvocationTargetException, IllegalAccessException {

        Object event;
        for (Method method : SpongeEventFactory.class.getMethods()) {
            if (method.getName().startsWith("create") && Modifier.isStatic(method.getModifiers()) && !this.excludedEvents.contains(method.getReturnType())) {
                try {
                    Class<?>[] paramTypes = method.getParameterTypes();
                    Object[] params = new Object[paramTypes.length];
                    for (int i = 0; i < paramTypes.length; i++) {
                        params[i] = mockParam(paramTypes[i]);
                    }
                    Method eventMethod2 = null;

                    event = method.invoke(null, params);
                    for (Method eventMethod : event.getClass().getMethods()) {
                        try {
                            eventMethod2 = eventMethod;
                            paramTypes = eventMethod.getParameterTypes();
                            params = new Object[paramTypes.length];
                            for (int i = 0; i < paramTypes.length; i++) {
                                params[i] = mockParam(paramTypes[i]);
                            }

                            if (eventMethod.getReturnType() != void.class) {
                                assertNotNull("The return type of " + eventMethod + " was null!", eventMethod.invoke(event, params));
                            }

                        } catch (Exception e) {
                            throw new RuntimeException(
                                    "Invocation of the method '" + eventMethod2 + "' failed\n\n"
                                    + "(To avoid the need to create numerous boilerplate concrete classes for Sponge's many event "
                                    + "interfaces, the " + SpongeEventFactory.class.getSimpleName()
                                    + " class dynamically creates concrete classes at "
                                    + "runtime. However, as this means that errors may only become known at runtime, this test ensures that problems "
                                    + "are caught during development.)\n\n"
                                    + "The failure of this test is in regards to invocation of a method of the '" + method.getReturnType().getName()
                                    + "' event.\n\n"
                                    + "Reasons for failure include:\n"
                                    + "(1) The called method does not conform to format that the class generator expects for getters or setters,"
                                    + "and is not implemented by the abstract class used as the superclass of the generated event."
                                    + "See the wrapped exception for more details.\n"
                                    + "\tSolution: Modify the method name and/or signature to follow the expected getter/sett er semantics,"
                                    + "or annotate the event with @ImplementedBy to indicate the abstract class used as the superclass."
                                    + "(2) A bug in the class generator was found\n"
                                    + "\tSolution: Look into " + EventFactory.class.getName() + " and its implementations.\n",
                            e);
                        }
                    }

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
                                    + "runtime concrete class upon.\n", e);
                }
            }
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Object mockParam(final Class<?> paramType) {
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
        } else if (paramType == Optional.class) {
            return Optional.empty();
        } else if (Enum.class.isAssignableFrom(paramType)) {
            return paramType.getEnumConstants()[0];
        } else if (Location.class.isAssignableFrom(paramType)) {
            return new Location<>((Extent) mockParam(Extent.class), 0, 0, 0);
        } else if (paramType == Transform.class) {
            return new Transform<>((Extent) mockParam(Extent.class));
        } else if (paramType == Transaction.class) {
            return PowerMockito.mock(Transaction.class);
        } else if (paramType == Text[].class) {
            return new Text[] {};
        } else if (InetSocketAddress.class.isAssignableFrom(paramType)){
            return new InetSocketAddress(12345);
        } else if (paramType == UUID.class) {
            return UUID.randomUUID();
        } else if (paramType == DataTransactionResult.class) {
            return DataTransactionResult.successNoData();
        } else if (paramType == Cause.class) {
            return Cause.of(NamedCause.source("none"));
        } else if (paramType == Location.class) {
            return new Location<>(mock(World.class), Vector3d.ZERO);
        } else {
            return mock(paramType, withSettings().defaultAnswer(Mockito.RETURNS_MOCKS));
        }
    }
}
