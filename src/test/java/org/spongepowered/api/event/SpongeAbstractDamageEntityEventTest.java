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
import org.spongepowered.api.event.cause.entity.damage.DamageFunction;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.entity.DamageEntityEvent;

import java.util.List;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

public class SpongeAbstractDamageEntityEventTest {

    private static final double ERROR = 0.03;

    @Test
    public void testParams() {
        Entity targetEntity = mockParam(Entity.class);
        int originalDamage = 5;

        DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(),"none"),
                Lists.newArrayList(), targetEntity, originalDamage);

        assertThat(event.getOriginalDamage(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalDamage(), is(closeTo(originalDamage, ERROR)));

        assertThat(event.getFinalDamage(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getBaseDamage(), is(closeTo(originalDamage, ERROR)));
    }

    @Test
    public void testSetBaseDamage() {
        Entity targetEntity = mockParam(Entity.class);
        int originalDamage = 5;

        DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(),"none"),
                Lists.newArrayList(), targetEntity, originalDamage);

        assertThat(event.getOriginalDamage(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalDamage(), is(closeTo(originalDamage, ERROR)));

        event.setBaseDamage(20);

        assertThat(event.getBaseDamage(), is(closeTo(20, ERROR)));
        assertThat(event.getFinalDamage(), is(closeTo(20, ERROR)));

        assertThat(event.getOriginalDamage(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalDamage(), is(closeTo(originalDamage, ERROR)));
    }

    @Test
    public void testUseModifiers() {
        Entity targetEntity = mockParam(Entity.class);

        final int originalDamage = 1;
        final int originalFinalDamage = 18;

        final int firstModifierDamage = 2;
        final int secondModifierDamage = 15;

        DamageModifier firstModifer = mockParam(DamageModifier.class);
        DamageModifier secondModifier = mockParam(DamageModifier.class);

        List<DamageFunction>
                originalFunctions = Lists.newArrayList(DamageFunction.of(firstModifer, p -> p * 2), DamageFunction.of(secondModifier, p -> p * 5));

        DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(),"none"),
                originalFunctions, targetEntity, originalDamage);

        final List<DamageFunction> originalFunctions1 = event.getOriginalFunctions();
        assertThat(originalFunctions1, is(Matchers.equalTo(originalFunctions)));

        assertThat(event.getOriginalDamage(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalDamage(), is(closeTo(originalFinalDamage, ERROR)));

        Map<DamageModifier, Double> originalDamages = event.getOriginalDamages();

        assertThat(originalDamages.size(), is(originalFunctions.size()));

        assertThat(originalDamages.get(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(originalDamages.get(secondModifier), is(closeTo(secondModifierDamage, ERROR)));

        assertThat(event.getOriginalModifierDamage(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(event.getOriginalModifierDamage(secondModifier), is(closeTo(secondModifierDamage, ERROR)));

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

        DamageModifier firstModifer = mockParam(DamageModifier.class);
        DamageModifier secondModifier = mockParam(DamageModifier.class);

        List<DamageFunction>
                originalFunctions = Lists.newArrayList(DamageFunction.of(firstModifer, p -> p * 2), DamageFunction.of(secondModifier, p -> p * 5));

        DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(),"none"),
                originalFunctions, targetEntity, originalDamage);

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));

        DoubleUnaryOperator newFunction = p -> p;

        event.setDamage(firstModifer, newFunction);

        assertThat(event.getDamage(firstModifer), is(closeTo(firstChangedDamage, ERROR)));
        assertThat(event.getDamage(secondModifier), is(closeTo(secondChangedDamage, ERROR)));

        assertThat(event.getOriginalModifierDamage(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(event.getOriginalModifierDamage(secondModifier), is(closeTo(secondModifierDamage, ERROR)));

        assertThat(event.getOriginalDamage(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalDamage(), is(closeTo(originalFinalDamage, ERROR)));
        assertThat(event.getFinalDamage(), is(closeTo(modifiedFinalDamage, ERROR)));

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));

        assertThat(event.getModifiers(), is(Matchers.equalTo(Lists.newArrayList(DamageFunction.of(firstModifer, newFunction), originalFunctions.get(1)))));
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

        DamageModifier firstModifer = mockParam(DamageModifier.class);
        DamageModifier secondModifier = mockParam(DamageModifier.class);
        DamageModifier thirdModifier = mockParam(DamageModifier.class);

        DoubleUnaryOperator thirdFunction = p -> p;

        List<DamageFunction>
                originalFunctions = Lists.newArrayList(DamageFunction.of(firstModifer, p -> p * 2), DamageFunction.of(secondModifier, p -> p * 5));

        List<DamageFunction> newFunctions = Lists.newArrayList(originalFunctions);
        newFunctions.add(DamageFunction.of(thirdModifier, thirdFunction));

        DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(),"none"),
                originalFunctions, targetEntity, originalDamage);

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));

        assertThat(event.isModifierApplicable(thirdModifier), is(false));

        event.setDamage(thirdModifier, thirdFunction);

        assertThat(event.getDamage(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(event.getDamage(secondModifier), is(closeTo(secondModifierDamage, ERROR)));
        assertThat(event.getDamage(thirdModifier), is(closeTo(thirdDamage, ERROR)));

        assertThat(event.getOriginalModifierDamage(firstModifer), is(closeTo(firstModifierDamage, ERROR)));
        assertThat(event.getOriginalModifierDamage(secondModifier), is(closeTo(secondModifierDamage, ERROR)));

        assertThat(event.getOriginalDamage(), is(closeTo(originalDamage, ERROR)));
        assertThat(event.getOriginalFinalDamage(), is(closeTo(originalFinalDamage, ERROR)));
        assertThat(event.getFinalDamage(), is(closeTo(modifiedFinalDamage, ERROR)));

        assertThat(event.getOriginalFunctions(), is(Matchers.equalTo(originalFunctions)));

        assertThat(event.getModifiers(), is(Matchers.equalTo(newFunctions)));
    }

    @Test
    public void testModifiersApplicable() {
        Entity targetEntity = mockParam(Entity.class);

        DamageModifier firstModifer = mockParam(DamageModifier.class);
        DamageModifier secondModifier = mockParam(DamageModifier.class);

        List<DamageFunction>
                originalFunctions = Lists.newArrayList(DamageFunction.of(firstModifer, p -> p), DamageFunction.of(secondModifier, p -> p));

        DamageEntityEvent event = SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(), "none"), originalFunctions, targetEntity, 0);

        assertThat(event.isModifierApplicable(firstModifer), is(true));
        assertThat(event.isModifierApplicable(secondModifier), is(true));
        assertThat(event.isModifierApplicable(mockParam(DamageModifier.class)), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotApplicableModifer() {
        DamageEntityEvent event =
                SpongeEventFactory.createDamageEntityEvent(Cause.of(EventContext.empty(), "none"), Lists.newArrayList(), mockParam(Entity.class), 0);

        DamageModifier modifier = mockParam(DamageModifier.class);

        assertThat(event.isModifierApplicable(modifier), is(false));

        event.getOriginalModifierDamage(modifier);
    }

    @SuppressWarnings("unchecked")
    private <T> T mockParam(Class<T> clazz) {
        return (T) SpongeEventFactoryTest.mockParam(clazz);
    }

}
