package org.spongepowered.api.util;

import com.flowpowered.math.vector.Vectord;

import java.util.Arrays;

/**
 * Contains generic math utilities.
 */
public final class MathUtil {
    private MathUtil() {}

    /**
     * Returns the sum of all values in a double vector.
     *
     * @param vector The vector
     * @return The sum of values in the vector
     */
    public static double sumValues(Vectord vector) {
        return Arrays.stream(vector.toArray()).sum();
    }

}
