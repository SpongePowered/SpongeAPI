package org.spongepowered.api.advancement.criteria.numerical;

import java.util.Optional;

/**
 * NumericalBounds is an interface that represents a predetermined bound for use with
 * serializable predicates. These predicates are traditionally fixed within a bounds.
 *
 * @param <T> The type of {@link Number}
 */
public interface NumericalBounds<T extends Number> {

    /**
     * Retrieves the minimal value, if available. If not available, refer to
     * {@link #max()} or {@link #isAny()} to be sure of bounds.
     *
     * @return The optional value of min
     */
    Optional<T> min();

    /**
     * Retrieves the maximal value, if available. If not available, refer to
     * {@link #min()} or {@link #isAny()} to be sure of bounds.
     *
     * @return The optional value of max
     */
    Optional<T> max();

    /**
     * Gets whether this bound will match any number.
     *
     * @return True if any number will match
     */
    default boolean isAny() {
        return this.min().isEmpty() && this.max().isEmpty();
    }

    interface Ints extends NumericalBounds<Integer> {

         boolean matches(int in);

         boolean matchesSquare(int in);

         interface Factory {

             Ints any();

             Ints exactly(int in);

             Ints between(int min, int max);

             Ints atLeast(int in);

             Ints atMost(int in);

         }

    }

    interface Doubles extends NumericalBounds<Double> {
        boolean matches(double in);
        boolean matchesSquare(double in);

        interface Factory {

            Doubles any();

            Doubles exactly(double in);
            Doubles between(double min, double max);
            Doubles atLeast(double in);
            Doubles atMost(double in);

        }
    }
}
