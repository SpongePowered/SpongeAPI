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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.entity.damage.DamageFunction;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.entity.DamageEntityEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.DoubleUnaryOperator;

class SpongeAbstractDamageEntityEventTest {

    private static final double ERROR = 0.03;

    @Test
    void testParams() {
        final Entity targetEntity = this.mockParam(Entity.class);
        final int originalDamage = 5;

        final DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(), "none"),
            targetEntity, new ArrayList<>(), originalDamage);

        Assertions.assertEquals(event.originalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.originalFinalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.finalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.baseDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
    }

    @Test
    void testSetBaseDamage() {
        final Entity targetEntity = this.mockParam(Entity.class);
        final int originalDamage = 5;

        final DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(), "none"),
            targetEntity, new ArrayList<>(), originalDamage);

        Assertions.assertEquals(event.originalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.originalFinalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        event.setBaseDamage(20);

        Assertions.assertEquals(event.baseDamage(), 20, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.finalDamage(), 20, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.originalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.originalFinalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
    }

    @Test
    void testUseModifiers() {
        final Entity targetEntity = this.mockParam(Entity.class);

        final int originalDamage = 1;
        final int originalFinalDamage = 18;

        final int firstModifierDamage = 2;
        final int secondModifierDamage = 15;

        final DamageModifier firstModifer = this.mockParam(DamageModifier.class);
        final DamageModifier secondModifier = this.mockParam(DamageModifier.class);

        final List<DamageFunction> originalFunctions = Arrays.asList(DamageFunction.of(firstModifer, p -> p * 2),
            DamageFunction.of(secondModifier, p -> p * 5));

        final DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(), "none"),
            targetEntity, originalFunctions, originalDamage);

        final List<DamageFunction> originalFunctions1 = event.originalFunctions();
        Assertions.assertEquals(originalFunctions1, originalFunctions);

        Assertions.assertEquals(event.originalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.originalFinalDamage(), originalFinalDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        final Map<DamageModifier, Double> originalDamages = event.originalDamages();

        Assertions.assertEquals(originalDamages.size(), originalFunctions.size());

        Assertions.assertEquals(originalDamages.get(firstModifer), firstModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(originalDamages.get(secondModifier), secondModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.originalModifierDamage(firstModifer), firstModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.originalModifierDamage(secondModifier), secondModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.originalFunctions(), originalFunctions);
    }

    @Test
    void testSetModifiers() {
        final Entity targetEntity = this.mockParam(Entity.class);

        final int originalDamage = 1;
        final int originalFinalDamage = 18;

        final int firstModifierDamage = 2;
        final int secondModifierDamage = 15;

        final int firstChangedDamage = 1;
        final int secondChangedDamage = 10;

        final int modifiedFinalDamage = 12;

        final DamageModifier firstModifer = this.mockParam(DamageModifier.class);
        final DamageModifier secondModifier = this.mockParam(DamageModifier.class);

        final List<DamageFunction> originalFunctions = Arrays.asList(DamageFunction.of(firstModifer, p -> p * 2), DamageFunction.of(secondModifier,
            p -> p * 5));

        final DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(), "none"),
            targetEntity, originalFunctions, originalDamage);

        Assertions.assertEquals(event.originalFunctions(), originalFunctions);

        final DoubleUnaryOperator newFunction = p -> p;

        event.setDamage(firstModifer, newFunction);

        Assertions.assertEquals(event.damage(firstModifer), firstChangedDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.damage(secondModifier), secondChangedDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.originalModifierDamage(firstModifer), firstModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.originalModifierDamage(secondModifier), secondModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.originalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.originalFinalDamage(), originalFinalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.finalDamage(), modifiedFinalDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.originalFunctions(), originalFunctions);

        Assertions.assertEquals(event.modifiers(), Arrays.asList(DamageFunction.of(firstModifer, newFunction), originalFunctions.get(1)));
    }

    @Test
    void testAddModifier() {
        final Entity targetEntity = this.mockParam(Entity.class);

        final int originalDamage = 1;
        final int originalFinalDamage = 18;

        final int firstModifierDamage = 2;
        final int secondModifierDamage = 15;

        final int modifiedFinalDamage = 36;

        final int thirdDamage = 18;

        final DamageModifier firstModifier = this.mockParam(DamageModifier.class);
        final DamageModifier secondModifier = this.mockParam(DamageModifier.class);
        final DamageModifier thirdModifier = this.mockParam(DamageModifier.class);

        final DoubleUnaryOperator thirdFunction = p -> p;

        final List<DamageFunction>
            originalFunctions = Arrays.asList(DamageFunction.of(firstModifier, p -> p * 2), DamageFunction.of(secondModifier, p -> p * 5));

        final List<DamageFunction> newFunctions = new ArrayList<>(originalFunctions);
        newFunctions.add(DamageFunction.of(thirdModifier, thirdFunction));

        final DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(), "none"), targetEntity,
            originalFunctions, originalDamage);

        Assertions.assertEquals(event.originalFunctions(), originalFunctions);

        Assertions.assertFalse(event.isModifierApplicable(thirdModifier));

        event.setDamage(thirdModifier, thirdFunction);

        Assertions.assertEquals(event.damage(firstModifier), firstModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.damage(secondModifier), secondModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.damage(thirdModifier), thirdDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.originalModifierDamage(firstModifier), firstModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.originalModifierDamage(secondModifier), secondModifierDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.originalDamage(), originalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.originalFinalDamage(), originalFinalDamage, SpongeAbstractDamageEntityEventTest.ERROR);
        Assertions.assertEquals(event.finalDamage(), modifiedFinalDamage, SpongeAbstractDamageEntityEventTest.ERROR);

        Assertions.assertEquals(event.originalFunctions(), originalFunctions);

        Assertions.assertEquals(event.modifiers(), newFunctions);
    }

    @Test
    void testModifiersApplicable() {
        final Entity targetEntity = this.mockParam(Entity.class);

        final DamageModifier firstModifer = this.mockParam(DamageModifier.class);
        final DamageModifier secondModifier = this.mockParam(DamageModifier.class);

        final List<DamageFunction>
            originalFunctions = Arrays.asList(DamageFunction.of(firstModifer, p -> p), DamageFunction.of(secondModifier, p -> p));

        final DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(), "none"), targetEntity,
            originalFunctions, 0);

        Assertions.assertTrue(event.isModifierApplicable(firstModifer));
        Assertions.assertTrue(event.isModifierApplicable(secondModifier));
        Assertions.assertFalse(event.isModifierApplicable(this.mockParam(DamageModifier.class)));
    }

    @Test
    void testNotApplicableModifer() {
        final DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(), "none"), this.mockParam(Entity.class),
            new ArrayList<>(), 0);

        final DamageModifier modifier = this.mockParam(DamageModifier.class);

        Assertions.assertFalse(event.isModifierApplicable(modifier));

        Assertions.assertThrows(IllegalArgumentException.class, () -> event.originalModifierDamage(modifier));
    }

    @SuppressWarnings("unchecked")
    private <T> T mockParam(Class<T> clazz) {
        return (T) Objects.requireNonNull(SpongeEventFactoryTest.mockParam(clazz));
    }

}
