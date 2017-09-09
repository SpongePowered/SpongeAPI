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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.util.test.TestHooks;

import java.util.Optional;

public class SimpleServiceManagerTest {

    private PluginManager manager;
    private Object testPlugin = new Object();
    private PluginContainer testPluginContainer;

    @Before
    public void mockEventManager() throws Exception {
        this.manager = mock(PluginManager.class);
        this.testPluginContainer = mock(PluginContainer.class);
        when(this.testPluginContainer.getId()).thenReturn("TestPlugin");
        when(this.manager.fromInstance(this.testPlugin)).thenReturn(Optional.of(this.testPluginContainer));

        Game game = mock(Game.class);
        TestHooks.setInstance("eventManager", mock(EventManager.class));
        when(game.getEventManager()).thenReturn(mock(EventManager.class));
        CauseStackManager csm = mock(CauseStackManager.class);
        when(game.getCauseStackManager()).thenReturn(csm);
        when(csm.pushCause(null)).thenReturn(csm);
        when(csm.popCause()).thenReturn(null);
        when(csm.getCurrentCause()).thenReturn(Cause.of(EventContext.empty(), this));
        TestHooks.setGame(game);
        TestHooks.setInstance("causeStackManager", csm);
    }

    @Test
    public void testRegisterService() {
        SimpleServiceManager serviceManager = new SimpleServiceManager(this.manager);

        serviceManager.setProvider(this.testPlugin, TestInterface.class, new TestImplCow());

        Optional<TestInterface> returned = serviceManager.provide(TestInterface.class);
        assertTrue(returned.isPresent());

        assertEquals("moo", returned.get().bark());
        assertEquals("moo", serviceManager.provideUnchecked(TestInterface.class).bark());
    }

    @Test
    public void testDuplicateRegistrationAllowed() {
        SimpleServiceManager serviceManager = new SimpleServiceManager(this.manager);
        serviceManager.setProvider(this.testPlugin, TestInterface.class, new TestImplCow());
        serviceManager.setProvider(this.testPlugin, TestInterface.class, new TestImplDog());

        assertEquals("woof", serviceManager.provideUnchecked(TestInterface.class).bark());
    }

    @Test
    public void testGetProviderRegistration() {
        TestImplCow testImplCow = new TestImplCow();

        SimpleServiceManager serviceManager = new SimpleServiceManager(this.manager);
        serviceManager.setProvider(this.testPlugin, TestInterface.class, testImplCow);

        ProviderRegistration<TestInterface> registration = serviceManager.getRegistration(TestInterface.class).get();

        assertEquals(TestInterface.class, registration.getService());
        assertEquals(testImplCow, registration.getProvider());
        assertEquals(this.testPluginContainer, registration.getPlugin());
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
