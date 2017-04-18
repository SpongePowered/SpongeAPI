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
package org.spongepowered.api.util.test;

import static org.mockito.Mockito.mock;

import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class TestHooks {

    private static Field gameField;

    private TestHooks() {
    }

    public static void setInstance(String name, Object instance)  throws NoSuchFieldException, IllegalAccessException {
        Field field = Sponge.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(null, instance);
    }

    public static void setGame(Game game) throws NoSuchFieldException, IllegalAccessException {
        if (gameField == null) {
            gameField = Sponge.class.getDeclaredField("game");
            gameField.setAccessible(true);
        }

        gameField.set(null, game);
    }

    public static void setCatalogElement(Class<?> catalog, String name, Object value) throws NoSuchFieldException, IllegalAccessException {
        setStaticFinalField(catalog.getDeclaredField(name), value);
    }

    private static void removeFinal(Field field) throws NoSuchFieldException, IllegalAccessException {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    }

    public static void setStaticFinalField(Field field, Object value) throws NoSuchFieldException, IllegalAccessException {
        removeFinal(field);
        field.set(null, value);
    }

    public static void mockFields(Class<?> catalogClass, Class<?> iface) throws ReflectiveOperationException {
        for (Field field : catalogClass.getFields()) {
            if (field.getType() != iface
                    || !Modifier.isPublic(field.getModifiers())
                    || !Modifier.isStatic(field.getModifiers())
                    || !Modifier.isFinal(field.getModifiers())
                    || field.get(null) != null) {
                continue;
            }

            setStaticFinalField(field, mock(iface));
        }
    }

}
