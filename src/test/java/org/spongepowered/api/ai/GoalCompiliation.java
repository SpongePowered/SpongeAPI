package org.spongepowered.api.ai;

import org.spongepowered.api.ai.goal.agent.SwimmingGoal;
import org.spongepowered.api.ai.goal.agent.WatchClosestGoal;
import org.spongepowered.api.ai.goal.agent.creature.AttackLivingGoal;
import org.spongepowered.api.entity.living.animal.Fox;
import org.spongepowered.api.event.cause.entity.damage.source.EntityDamageSource;
import org.spongepowered.api.event.cause.entity.damage.source.IndirectEntityDamageSource;
import org.spongepowered.api.event.cause.entity.damage.source.common.AbstractIndirectEntityDamageSource;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public class GoalCompiliation {
    public void work() {
        Fox fox = DummyObjectProvider.createFor(Fox.class, "fox");
        SwimmingGoal<Fox> swimmingGoal = SwimmingGoal.<Fox>builder().swimChance(0.3f).build(fox);
        WatchClosestGoal<Fox> watchClosestGoal = builderForFox().maxDistance(30).chance(.7f).build(fox);
//        WatchClosestGoal<Fox> otherGoal = WatchClosestGoal.builder().maxDistance(30).chance(.7f).build(fox);
        AttackLivingGoal<Fox> goal = AttackLivingGoal.builder(fox).build(fox);

        IndirectEntityDamageSource indirectEntityDamageSource = IndirectEntityDamageSource.builder().entity(fox).build();
        EntityDamageSource damageSource = EntityDamageSource.builder().entity(fox).build();
    }

    <B extends WatchClosestGoal.Builder<Fox, WatchClosestGoal<Fox>, B>> B builderForFox() {
        return WatchClosestGoal.builder();
    }
}
