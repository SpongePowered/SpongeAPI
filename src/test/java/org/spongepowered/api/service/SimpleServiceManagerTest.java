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
package org.spongepowered.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleServiceManagerTest {

    private static final PluginManager manager = Mockito.mock(PluginManager.class);
    private static final Object testPlugin = new Object();
    private static final PluginContainer testPluginContainer = Mockito.mock(PluginContainer.class);

    {
        Mockito.when(testPluginContainer.getId()).thenReturn("TestPlugin");
        Mockito.when(manager.fromInstance(testPlugin)).thenReturn(Optional.of(testPluginContainer));
    }

    @Test
    public void testRegisterService() throws ProviderExistsException {
        SimpleServiceManager serviceManager = new SimpleServiceManager(manager);

        serviceManager.setProvider(testPlugin, TestInterface.class, new TestImplCow());

        Optional<TestInterface> returned = serviceManager.provide(TestInterface.class);
        assertTrue(returned.isPresent());

        assertEquals("moo", returned.get().bark());
        assertEquals("moo", serviceManager.provideUnchecked(TestInterface.class).bark());
    }

    @Test(expected = ProviderExistsException.class)
    public void testDuplicateRegistrationForbidden() throws ProviderExistsException {
        SimpleServiceManager serviceManager = new SimpleServiceManager(manager);
        serviceManager.setProvider(testPlugin, TestInterface.class, new TestImplCow());
        serviceManager.setProvider(testPlugin, TestInterface.class, new TestImplDog());
    }

    @Test
    public void testFutureProvide() throws ProviderExistsException {
        SimpleServiceManager serviceManager = new SimpleServiceManager(manager);

        ServiceReference<TestInterface> futureRef = serviceManager.potentiallyProvide(TestInterface.class);
        assertFalse(futureRef.ref().isPresent());

        serviceManager.setProvider(testPlugin, TestInterface.class, new TestImplCow());

        assertTrue(futureRef.ref().isPresent());
        assertEquals("moo", futureRef.ref().get().bark());

    }

    @Test
    public void testPerformActionOnProvide() throws ProviderExistsException {
        SimpleServiceManager serviceManager = new SimpleServiceManager(manager);

        final AtomicBoolean ran = new AtomicBoolean(false);
        ServiceReference<TestInterface> futureRef = serviceManager.potentiallyProvide(TestInterface.class);
        futureRef.executeWhenPresent(new Predicate<TestInterface>() {
            @Override
            public boolean apply(TestInterface input) {
                ran.set(true);
                return true;
            }
        });
        assertFalse(ran.get());
        assertFalse(futureRef.ref().isPresent());

        serviceManager.setProvider(testPlugin, TestInterface.class, new TestImplCow());
        assertEquals(true, ran.get());

        assertTrue(futureRef.ref().isPresent());
        assertEquals("moo", futureRef.ref().get().bark());
    }

    @Test
    public void testSharedReferences() throws ProviderExistsException {
        SimpleServiceManager serviceManager = new SimpleServiceManager(manager);

        final ServiceReference<TestInterface> firstRef = serviceManager.potentiallyProvide(TestInterface.class);
        final ServiceReference<TestInterface> secondRef = serviceManager.potentiallyProvide(TestInterface.class);

        assertEquals(firstRef, secondRef);

        serviceManager.setProvider(testPlugin, TestInterface.class, new TestImplCow());

        final ServiceReference<TestInterface> thirdRef = serviceManager.potentiallyProvide(TestInterface.class);
        assertNotEquals(firstRef, thirdRef);

    }

    public interface TestInterface {

        String bark();
    }

    public class TestImplCow implements TestInterface {

        @Override
        public String bark() {
            return "moo";
        }
    }

    public class TestImplDog implements TestInterface {

        @Override
        public String bark() {
            return "woof";
        }
    }

}
