package org.spongepowered.api.service.context;

import com.google.common.base.Preconditions;

import java.util.Comparator;

/**
 * An extension of {@link Context} that allows applying weights to contexts. Weights should be used to determine the priority of contexts, where
 * the priority of a set of contexts is the sum of the weights of its elements.
 */
public class WeightedContext extends Context implements Comparable<WeightedContext> {
    private final int weight;

    /**
     * Create a new context instance
     *  @param type Context type. Must not be null.
     * @param name Context name. Must not be null.
     */
    public WeightedContext(String type, String name, int weight) {
        super(type, name);
        this.weight = weight;
        Preconditions.checkArgument(weight >= 1, "Weight must be at least 1");
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(WeightedContext other) {
        return Integer.compare(weight, other.weight);
    }


    /**
     * This {@link java.util.Comparator} implementation can be used to sort a collection of {@link Context}s that do not necessarily provide their
     * own
     */
    public static class Comparator implements java.util.Comparator<Context> {

        @Override
        public int compare(Context a, Context b) {
            int weightA = a instanceof WeightedContext ? ((WeightedContext) a).getWeight() : 1;
            int weightB = b instanceof WeightedContext ? ((WeightedContext) b).getWeight() : 1;
            return Integer.compare(weightA, weightB);
        }
    }
}
