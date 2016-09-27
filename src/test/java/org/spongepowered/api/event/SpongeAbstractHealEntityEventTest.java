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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.entity.health.HealthFunction;
import org.spongepowered.api.event.cause.entity.health.HealthModifier;
import org.spongepowered.api.event.entity.HealEntityEvent;

import java.util.List;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

public class SpongeAbstractHealEntityEventTest {

    private static final double ERROR = 0.03;

    @Test
    public void testParams() {
        Entity targetEntity = mockParam(Entity.class);
        int originalDamage = 5;

        HealEntityEvent event = SpongeEventFactory.createHealEntityEvent(Cause.of(EventContext.empty(),"none"),
                Lists.newArrayList(), targetEntity, originalDamage);

        assertThat(event.getOriginalHealAmount(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalHealAmount(), is(closeTo(originalDamage, ERROR)));

        assertThat(event.getFinalHealAmount(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getBaseHealAmount(), is(closeTo(originalDamage, ERROR)));
    }

    @Test
    public void testSetBaseHealAmount() {
        Entity targetEntity = mockParam(Entity.class);
        int originalDamage = 5;

        HealEntityEvent event = SpongeEventFactory.createHealEntityEvent(Cause.of(EventContext.empty(),"none"),
                Lists.newArrayList(), targetEntity, originalDamage);

        assertThat(event.getOriginalHealAmount(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalHealAmount(), is(closeTo(originalDamage, ERROR)));

        event.setBaseHealAmount(20);

        assertThat(event.getBaseHealAmount(), is(closeTo(20, ERROR)));
        assertThat(event.getFinalHealAmount(), is(closeTo(20, ERROR)));

        assertThat(event.getOriginalHealAmount(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalHealAmount(), is(closeTo(originalDamage, ERROR)));
    }

    @Test
    public void testUseModifiers() {
        Entity targetEntity = mockParam(Entity.class);

        final int originalDamage = 1;
        final int originalFinalDamage = 18;

        final int firstModifierDamage = 2;
        final int secondModifierDamage = 15;

        HealthModifier firstModifer = mockParam(HealthModifier.class);
        HealthModifier secondModifier = mockParam(HealthModifier.class);

        List<HealthFunction>
                originalFunctions = Lists.newArrayList(HealthFunction.of(firstModifer, p -> p * 2), HealthFunction.of(secondModifier, p -> p * 5));

        HealEntityEvent event = SpongeEventFactory.createHealEntityEvent(Cause.of(EventContext.empty(), "none"), originalFunctions, targetEntity,
                originalDamage);

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));

        assertThat(event.getOriginalHealAmount(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalHealAmount(), is(closeTo(originalFinalDamage, ERROR)));

        Map<HealthModifier, Double> originalDamages = event.getOriginalHealingAmounts();

        assertThat(originalDamages.size(), is(originalFunctions.size()));

        assertThat(originalDamages.get(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(originalDamages.get(secondModifier), is(closeTo(secondModifierDamage, ERROR)));

        assertThat(event.getOriginalHealingModifierAmount(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(event.getOriginalHealingModifierAmount(secondModifier), is(closeTo(secondModifierDamage, ERROR)));

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));
    }

    @Test
    public void testSetModifiers() {
        Entity targetEntity = mockParam(Entity.class);

        final int originalDamage = 1;
        final int originalFinalDamage = 18;

        final int firstModifierDamage = 2;
        final int secondModifierDamage = 15;

        final int firstChangedDamage = 1;
        final int secondChangedDamage = 10;

        final int modifiedFinalDamage = 12;

        HealthModifier firstModifer = mockParam(HealthModifier.class);
        HealthModifier secondModifier = mockParam(HealthModifier.class);

        List<HealthFunction>
                originalFunctions = Lists.newArrayList(HealthFunction.of(firstModifer, p -> p * 2), HealthFunction.of(secondModifier, p -> p * 5));

        HealEntityEvent event = SpongeEventFactory.createHealEntityEvent(Cause.of(EventContext.empty(), "none"), originalFunctions, targetEntity,
                originalDamage);

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));

        DoubleUnaryOperator newFunction = p -> p;

        event.setHealAmount(firstModifer, newFunction);

        assertThat(event.getHealAmount(firstModifer), is(closeTo(firstChangedDamage, ERROR)));
        assertThat(event.getHealAmount(secondModifier), is(closeTo(secondChangedDamage, ERROR)));

        assertThat(event.getOriginalHealingModifierAmount(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(event.getOriginalHealingModifierAmount(secondModifier), is(closeTo(secondModifierDamage, ERROR)));

        assertThat(event.getOriginalHealAmount(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalHealAmount(), is(closeTo(originalFinalDamage, ERROR)));
        assertThat(event.getFinalHealAmount(), is(closeTo(modifiedFinalDamage, ERROR)));

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));

        assertThat(event.getModifiers(), is(Matchers.equalTo(Lists.newArrayList(HealthFunction.of(firstModifer, newFunction), originalFunctions.get(1)))));
    }

    @Test
    public void testAddModifier() {
        Entity targetEntity = mockParam(Entity.class);

        final int originalDamage = 1;
        final int originalFinalDamage = 18;

        final int firstModifierDamage = 2;
        final int secondModifierDamage = 15;

        final int modifiedFinalDamage = 36;

        final int thirdDamage = 18;

        HealthModifier firstModifer = mockParam(HealthModifier.class);
        HealthModifier secondModifier = mockParam(HealthModifier.class);
        HealthModifier thirdModifier = mockParam(HealthModifier.class);

        DoubleUnaryOperator thirdFunction = p -> p;

        List<HealthFunction>
                originalFunctions = Lists.newArrayList(HealthFunction.of(firstModifer, p -> p * 2), HealthFunction.of(secondModifier, p -> p * 5));

        List<HealthFunction> newFunctions = Lists.newArrayList(originalFunctions);
        newFunctions.add(HealthFunction.of(thirdModifier, thirdFunction));

        HealEntityEvent event = SpongeEventFactory.createHealEntityEvent(Cause.of(EventContext.empty(), "none"), originalFunctions, targetEntity,
                originalDamage);

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));

        assertThat(event.isModifierApplicable(thirdModifier), is(false));

        event.setHealAmount(thirdModifier, thirdFunction);

        assertThat(event.getHealAmount(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(event.getHealAmount(secondModifier), is(closeTo(secondModifierDamage, ERROR)));
        assertThat(event.getHealAmount(thirdModifier), is(closeTo(thirdDamage, ERROR)));

        assertThat(event.getOriginalHealingModifierAmount(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(event.getOriginalHealingModifierAmount(secondModifier), is(closeTo(secondModifierDamage, ERROR)));

        assertThat(event.getOriginalHealAmount(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalHealAmount(), is(closeTo(originalFinalDamage, ERROR)));
        assertThat(event.getFinalHealAmount(), is(closeTo(modifiedFinalDamage, ERROR)));

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));

        assertThat(event.getModifiers(), is(Matchers.equalTo(newFunctions)));
    }

    @Test
    public void testModifiersApplicable() {
        Entity targetEntity = mockParam(Entity.class);

        HealthModifier firstModifer = mockParam(HealthModifier.class);
        HealthModifier secondModifier = mockParam(HealthModifier.class);

        List<HealthFunction>
                originalFunctions = Lists.newArrayList(HealthFunction.of(firstModifer, p -> p), HealthFunction.of(secondModifier, p -> p));

        HealEntityEvent event = SpongeEventFactory.createHealEntityEvent(Cause.of(EventContext.empty(), "none"), originalFunctions, targetEntity, 0);

        assertThat(event.isModifierApplicable(firstModifer), is(true));
        assertThat(event.isModifierApplicable(secondModifier), is(true));
        assertThat(event.isModifierApplicable(mockParam(HealthModifier.class)), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotApplicableModifer() {
        HealEntityEvent event = SpongeEventFactory.createHealEntityEvent(Cause.of(EventContext.empty(), "none"), Lists.newArrayList(),
                mockParam(Entity.class), 0);

        HealthModifier modifier = mockParam(HealthModifier.class);

        assertThat(event.isModifierApplicable(modifier), is(false));

        event.getOriginalHealingModifierAmount(modifier);
    }

    @SuppressWarnings("unchecked")
    private <T> T mockParam(Class<T> clazz) {
        return (T) SpongeEventFactoryTest.mockParam(clazz);
    }

}