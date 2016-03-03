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
package org.spongepowered.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

import java.util.Optional;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Sponge.class)
public class SimpleServiceManagerTest {

    private final PluginManager manager = Mockito.mock(PluginManager.class);
    private final Object testPlugin = new Object();
    private final PluginContainer testPluginContainer = Mockito.mock(PluginContainer.class);
    private final EventManager testEventManager = Mockito.mock(EventManager.class);

    {
        Mockito.when(this.testPluginContainer.getId()).thenReturn("TestPlugin");
        Mockito.when(this.manager.fromInstance(this.testPlugin)).thenReturn(Optional.of(this.testPluginContainer));
    }

    @Test
    public void testRegisterService() {
        PowerMockito.mockStatic(Sponge.class);
        PowerMockito.when(Sponge.getEventManager()).thenReturn(this.testEventManager);

        SimpleServiceManager serviceManager = new SimpleServiceManager(this.manager);

        serviceManager.setProvider(this.testPlugin, TestInterface.class, new TestImplCow());

        Optional<TestInterface> returned = serviceManager.provide(TestInterface.class);
        assertTrue(returned.isPresent());

        assertEquals("moo", returned.get().bark());
        assertEquals("moo", serviceManager.provideUnchecked(TestInterface.class).bark());
    }

    @Test
    public void testDuplicateRegistrationAllowed() {
        PowerMockito.mockStatic(Sponge.class);
        PowerMockito.when(Sponge.getEventManager()).thenReturn(this.testEventManager);

        SimpleServiceManager serviceManager = new SimpleServiceManager(this.manager);
        serviceManager.setProvider(this.testPlugin, TestInterface.class, new TestImplCow());
        serviceManager.setProvider(this.testPlugin, TestInterface.class, new TestImplDog());

        assertEquals("woof", serviceManager.provideUnchecked(TestInterface.class).bark());
    }

    @Test
    public void testGetProviderRegistration() {
        PowerMockito.mockStatic(Sponge.class);
        PowerMockito.when(Sponge.getEventManager()).thenReturn(this.testEventManager);

        TestImplCow testImplCow = new TestImplCow();

        SimpleServiceManager serviceManager = new SimpleServiceManager(this.manager);
        serviceManager.setProvider(this.testPlugin, TestInterface.class, testImplCow);

        ProviderRegistration<TestInterface> registration = serviceManager.getRegistration(TestInterface.class).get();

        assertEquals(TestInterface.class, registration.getService());
        assertEquals(testImplCow, registration.getProvider());
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
