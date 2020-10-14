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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import io.leangen.geantyref.GenericTypeReflector;
import io.leangen.geantyref.TypeToken;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.event.entity.AttackEntityEvent;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.entity.ai.goal.GoalEvent;
import org.spongepowered.api.event.impl.AbstractEvent;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.PEBKACException;
import org.spongepowered.api.util.Transform;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.configurate.util.Types;
import org.spongepowered.math.vector.Vector3d;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.UUID;

//@RunWith(Parameterized.class)
public class SpongeEventFactoryTest {

    private static final Set<Class<?>> excludedEvents = ImmutableSet.of(DamageEntityEvent.class,
            GoalEvent.class, GoalEvent.Add.class, GoalEvent.Remove.class, AttackEntityEvent.class);

    private static final Set<String> excludedMethods = ImmutableSet.of("getEntitySnapshots");

    // We need to keep a reference to any mocked World passed into a Location,
    // to ensure that it is not GC'd for the duration of a test. This list
    private static List<World> worlds = new ArrayList<>();

    private static final Answer<Object> EVENT_MOCKING_ANSWER = (invoc -> {
        // We use the original mock type to try to get more information about
        // the return type. For example, imagine that SignData#asImmutable is called
        // on a mocked SignData instance. The return type given to use by
        // by 'invoc.getMethod().getReturnType()' will be 'ImmutableDataManipulator',
        // since that's the return type of the method itself. However, we need to consider
        // the 'generic' return type of SignData#asImmutable, which is ImmutableSignData.
        // Guava's TypeToken takes generic parameters into account, allowing us to mock
        // the most specific known return type.
        Type returnType = GenericTypeReflector.getExactReturnType(invoc.getMethod(),
                Mockito.mockingDetails(invoc.getMock()).getMockCreationSettings().getTypeToMock()
        );
        return mockParam(returnType);
    });

    @Parameterized.Parameters(name = "{0}")
    public static List<Object[]> getMethods() {
        ImmutableList.Builder<Object[]> methods = ImmutableList.builder();
        for (Method method : SpongeEventFactory.class.getMethods()) {
            if (method.getName().startsWith("create") && Modifier.isStatic(method.getModifiers())
                    && !excludedEvents.contains(method.getReturnType())) {
                methods.add(new Object[]{method.getReturnType().getName(), method});
            }
        }
        return methods.build();
    }

    @Parameterized.Parameter
    public String event;
    @Parameterized.Parameter(1)
    public Method method;

//    @Test
    public void testCreate() {
        try {
            // We only care about keeping extends around for the duration
            // of this particular event.
            worlds.clear();

            Type[] paramTypes = this.method.getGenericParameterTypes();
            Object[] params = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                params[i] = mockParam(paramTypes[i]);
            }
            Object testEvent = this.method.invoke(null, params);
            for (Method eventMethod : testEvent.getClass().getMethods()) {

                if (excludedMethods.contains(eventMethod.getName())) {
                    continue;
                }

                try {
                    paramTypes = eventMethod.getGenericParameterTypes();
                    params = new Object[paramTypes.length];
                    for (int i = 0; i < paramTypes.length; i++) {
                        params[i] = mockParam(paramTypes[i]);
                    }

                    if (eventMethod.getReturnType() != void.class) {
                        assertNotNull("The return type of " + eventMethod + " was null!", eventMethod.invoke(testEvent, params));
                    }

                } catch (Exception e) {
                    throw new RuntimeException(
                            "Invocation of the method '" + eventMethod + "' failed\n\n"
                                    + "(To avoid the need to create numerous boilerplate concrete classes for Sponge's many event "
                                    + "interfaces, the " + SpongeEventFactory.class.getSimpleName()
                                    + " class dynamically creates concrete classes at "
                                    + "runtime. However, as this means that errors may only become known at runtime, this test ensures that problems "
                                    + "are caught during development.)\n\n"
                                    + "The failure of this test is in regards to invocation of a method of the '" + this.method.getReturnType().getName()
                                    + "' event.\n\n"
                                    + "Reasons for failure include:\n"
                                    + "(1) The called method does not conform to format that the class generator expects for getters or setters,"
                                    + "and is not implemented by the abstract class used as the superclass of the generated event."
                                    + "See the wrapped exception for more details.\n"
                                    + "\tSolution: Modify the method name and/or signature to follow the expected getter/sett er semantics,"
                                    + "or annotate the event with @ImplementedBy to indicate the abstract class used as the superclass."
                                    + "(2) A bug in the class generator was found\n"
                                    + "\tSolution: Look into event-impl-gen.\n",
                            e);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    "Runtime creation of the '" + this.method.getReturnType().getName() + "' event failed\n\n"
                            + "(To avoid the need to create numerous boilerplate concrete classes for Sponge's many event "
                            + "interfaces, the " + SpongeEventFactory.class.getSimpleName()
                            + " class dynamically creates concrete classes at "
                            + "runtime. However, as this means that errors may only become known at runtime, this test ensures that problems "
                            + "are caught during development.)\n\n"
                            + "The failure of this test is in regards to creation of the '" + this.method.getReturnType().getName()
                            + "' event.\n\n"
                            + "Reasons for failure include:\n"
                            + "(1) The event was changed and there are new, removed, or modified properties (most likely)\n"
                            + "\tSolution: Make appropriate changes to " + SpongeEventFactory.class.getName() + "." + this.method.getName()
                            + "(). "
                            + "See the wrapped exception for more details.\n"
                            + "(2) A bug in the class generator was found\n"
                            + "\tSolution: Look into event-impl-gen.\n"
                            + "(3) A method that does not follow getter/setter semantics (getProp(), isBool(), setProp()) "
                            + "was added (i.e. blockList())\n"
                            + "\tSolution: Revisit " + this.method.getReturnType().getName() + " and its supertypes. If the method in question "
                            + "must exist, then the event factory is capable of accepting a base class to build the "
                            + "runtime concrete class upon (i.e. " + AbstractEvent.class.getName()
                            + " is the supertype of all generated event classes).\n", e);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Nullable
    public static Object mockParam(final Type paramType) {
        if (paramType == Class.class) {
            return PEBKACException.class;
        } else if (paramType == byte.class || paramType == Byte.class) {
            return (byte) 0;
        } else if (paramType == short.class || paramType == Short.class) {
            return (short) 0;
        } else if (paramType == int.class || paramType == Integer.class) {
            return 0;
        } else if (paramType == long.class || paramType == Long.class) {
            return (long) 0;
        } else if (paramType == float.class || paramType == Float.class) {
            return (float) 0;
        } else if (paramType == double.class || paramType == Double.class) {
            return (double) 0;
        } else if (paramType == char.class || paramType == Character.class) {
            return (char) 0;
        } else if (paramType == boolean.class || paramType == Boolean.class) {
            return false;
        } else if (paramType == void.class || paramType == Void.class) {
            return null;
        } else if (Types.isArray(paramType)) {
            final Type componentType = GenericTypeReflector.getArrayComponentType(paramType);
            Object array = Array.newInstance(GenericTypeReflector.erase(componentType), 1);
            Array.set(array, 0, mockParam(componentType));
            return array;
        } else if (paramType == String.class) {
            return "Cupcakes";
        } else if (paramType == Optional.class) {
            return Optional.empty();
        } else if (paramType == OptionalInt.class) {
            return OptionalInt.empty();
        } else if (GenericTypeReflector.isSuperType(Enum.class, paramType)) {
            return GenericTypeReflector.erase(paramType).getEnumConstants()[0];
        } else if (GenericTypeReflector.isSuperType(ServerLocation.class, paramType)) {
            ServerWorld world = (ServerWorld) mockParam(ServerWorld.class);
            // Make sure we keep a reference to the World,
            // as Location stores a weak reference
            worlds.add(world);
            final ServerLocation mock = mock(ServerLocation.class);
            Mockito.when(mock.getWorld()).thenReturn(world);
            return mock;
        } else if (paramType == Transform.class) {
            return mock(Transform.class);
        } else if (GenericTypeReflector.isSuperType(InetSocketAddress.class, paramType)) {
            return new InetSocketAddress(12345);
        } else if (paramType == UUID.class) {
            return UUID.randomUUID();
        } else if (paramType == DataTransactionResult.class) {
            return DataTransactionResult.successNoData();
        } else if (paramType == Cause.class) {
            return Cause.of(EventContext.empty(), "none");
        } else if (paramType == ServerLocation.class) {
            return ServerLocation.of(mock(ServerWorld.class), Vector3d.ZERO);
        } else if (paramType == Locale.class) {
            return Locale.ROOT;
        } else if (paramType == Duration.class) {
            return Duration.ZERO;
        } else if (paramType == Instant.class) {
            return Instant.now();
        } else if (paramType == TypeToken.class) {
            return TypeToken.get(Object.class);
        } else if (paramType == Color.class) {
            return Color.BLACK;
        } else if (GenericTypeReflector.isSuperType(DataHolder.class, paramType)) {
            DataHolder mock = (DataHolder) mock(GenericTypeReflector.erase(paramType),
                    withSettings().defaultAnswer(EVENT_MOCKING_ANSWER));
            return mock;

        } else {
            if (paramType instanceof Class<?>) {
                return mock((Class<?>) paramType, withSettings().defaultAnswer(EVENT_MOCKING_ANSWER));
            }
            // If we have a TypeToken available, we use to try to resolve a more specific
            // return type on any of the methods that we mock. This allows us to correctly
            // return an Integer from MutableBoundedValue<Integer>#get(), instead of accidentally
            // returning an Object mock.
            return mock(GenericTypeReflector.erase(paramType), withSettings().defaultAnswer(invoc -> {
                return mockParam(GenericTypeReflector.getExactReturnType(invoc.getMethod(), paramType));
            }));
        }
    }
}
