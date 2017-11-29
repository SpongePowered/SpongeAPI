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
package org.spongepowered.api.util;

import static com.google.common.base.Preconditions.checkArgument;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector3i;
import org.apache.commons.lang3.Validate;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.type.DyeColor;

import java.util.Optional;

public final class Color implements DataSerializable {

    //16 HTML web colors and CSS orange

    public static final Color WHITE = of(0xFFFFFF);

    public static final Color SILVER = of(0xC0C0C0);

    public static final Color GRAY = of(0x808080);

    public static final Color BLACK = of(0x000000);

    public static final Color RED = of(0xFF0000);

    public static final Color MAROON = of(0x800000);

    public static final Color ORANGE = of(0xFFA500);

    public static final Color YELLOW = of(0xFFFF00);

    public static final Color OLIVE = of(0x808000);

    public static final Color LIME = of(0x00FF00);

    public static final Color GREEN = of(0x008000);

    public static final Color AQUA = of(0x00FFFF);

    public static final Color TEAL = of(0x008080);

    public static final Color BLUE = of(0x0000FF);

    public static final Color NAVY = of(0x000080);

    public static final Color FUCHSIA = of(0xFF00FF);

    public static final Color PURPLE = of(0x800080);

    //Old purple = 0xAA00FF, new purple = 0x800080
    //public static final Color OLD_PURPLE = of(0xAA00FF);

    @Deprecated
    public static final Color MAGENTA = of(0xFF00FF);

    @Deprecated
    public static final Color DARK_CYAN = of(0x008B8B);

    @Deprecated
    public static final Color DARK_GREEN = of(0x006400);

    @Deprecated
    public static final Color DARK_MAGENTA = of(0x8B008B);

    @Deprecated
    public static final Color CYAN = of(0x00FFFF);

    @Deprecated
    public static final Color PINK = of(0xFF00AA);

    //TODO: Are alpha values an error or ignored? What about with #equals and #asJavaColor?

    /**
     * Creates a new {@link Color} based on the red-green-blue (rgb) value for
     * the color. Colors do not utilize an alpha modifier.
     *
     * @param rgb The red-green-blue value
     * @return The color object
     */
    public static Color of(int rgb) {
        checkArgument(0 <= rgb && rgb <= 0xFFFFFF, "rgb value %s (%s) must be in range 0 to 0xFFFFFF (16777215", Integer.toHexString(rgb), rgb);
        return new Color(rgb, (rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF);
    }

    /**
     * Creates a new {@link Color} based on the red-green-blue (rgb) value for
     * the color. Colors do not utilize an alpha modifier.
     *
     * @param rgb The red-green-blue value
     * @return The color object
     * @deprecated in favor of {@link #of(int)}
     */
    @Deprecated
    public static Color ofRgb(int rgb) {
        return of(rgb);
    }

    /**
     * Creates a new {@link Color} based on the red, green, and blue values.
     *
     * @param red The red value
     * @param green The green value
     * @param blue The blue value
     * @return The color object
     */
    public static Color of(int red, int green, int blue) {
        //TODO: Remove checkArguments and use (red & 0xFF)?
        checkArgument(0 <= red && red <= 0xFF, "red value %s (%s) must be in range 0 to 0xFF (255)", Integer.toHexString(red), red);
        checkArgument(0 <= green && green <= 0xFF, "green value %s (%s) must be in range 0 to 0xFF (255)", Integer.toHexString(green), green);
        checkArgument(0 <= blue && blue <= 0xFF, "blue value %s (%) must be in range 0 to 0xFF (255)", Integer.toHexString(blue), blue);
        return new Color((red << 16) | (green << 8) | blue, red, green, blue);
    }

    /**
     * Creates a new {@link Color} based on the red, green, and blue values.
     *
     * @param red The red value
     * @param green The green value
     * @param blue The blue value
     * @return The color object
     * @deprecated in favor of {@link #of(int, int, int)}
     */
    @Deprecated
    public static Color ofRgb(int red, int green, int blue) {
        return of(red, green, blue);
    }

    /**
     * Creates a new {@link Color} based on the x (red), y (green), and z (blue)
     * values of the vector.
     *
     * @param vector3i The vector of three integers representing color
     * @return The color object
     */
    public static Color of(Vector3i vector3i) {
        return of(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    /**
     * Creates a new {@link Color} based on the x (red), y (green), and z (blue)
     * values of the vector. Values are rounded to the nearest whole number.
     *
     * @param vector3f The vector of three floats representing color
     * @return The color object
     * @deprecated Use {@code #of(vector3f.round().toInt())}
     */
    @Deprecated
    public static Color of(Vector3f vector3f) {
        return of(vector3f.round().toInt());
    }

    /**
     * Creates a new {@link Color} based on the x (red), y (green), and z (blue)
     * values of the vector. Values are rounded to the nearest whole number.
     *
     * @param vector3d The vector of three doubles representing color
     * @return The color object
     * @deprecated Use {@code #of(vector3d.round().toInt())}
     */
    @Deprecated
    public static Color of(Vector3d vector3d) {
        return of(vector3d.round().toInt());
    }

    /**
     * Creates a new {@link Color} from a {@link java.awt.Color} for use in the
     * Sponge API.
     *
     * @param color The java color object
     * @return The converted color object
     */
    public static Color of(java.awt.Color color) {
        return of(color.getRed(), color.getGreen(), color.getBlue());
    }

    //TODO: Deprecate the mix methods as they're not used in Sponge?
    //TODO: Use same formula for mixing as dyeing? https://minecraft.gamepedia.com/Dye#Dyeing_armor

    /**
     * Creates a new {@link Color} combining the provided {@link Color} objects,
     * their summation and average is taken into effect to properly mix the
     * colors together.
     *
     * @param colors The colors to mix
     * @return The final output mixed color
     */
    public static Color mixColors(Color... colors) {
        Validate.noNullElements(colors, "No null colors allowed!");
        checkArgument(colors.length > 0, "Cannot have an empty color array!");
        if (colors.length == 1) {
            return colors[0];
        }
        int red = colors[0].getRed();
        int green = colors[0].getGreen();
        int blue = colors[0].getBlue();
        for (int i = 1; i < colors.length; i++) {
            red += colors[i].getRed();
            green += colors[i].getGreen();
            blue += colors[i].getBlue();
        }
        int averageRed = Math.round((float) red / colors.length);
        int averageGreen = Math.round((float) green / colors.length);
        int averageBlue = Math.round((float) blue / colors.length);
        return of(averageRed, averageGreen, averageBlue);
    }

    /**
     * Creates a new {@link Color} combining the provided {@link DyeColor}
     * objects. Since {@link DyeColor}s can be converted into {@link Color}
     * objects themselves, their summation and average is taken into effect
     * to properly mix the colors together.
     *
     * @param colors The colors to mix
     * @return The final output mixed color
     */
    public static Color mixDyeColors(DyeColor... colors) {
        Validate.noNullElements(colors, "No nulls allowed!");
        final Color[] actualColors = new Color[colors.length];
        for (int i = 0; i < colors.length; i++) {
            actualColors[i] = colors[i].getColor();
        }

        return mixColors(actualColors);
    }

    private final int rgb;
    private final int red;
    private final int green;
    private final int blue;

    private Color(int rgb, int red, int green, int blue) {
        this.rgb = rgb;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Gets the {@link #rgb} value of this {@link Color}
     *
     * @return The rgb value
     */
    public int getRgb() {
        return this.rgb;
    }

    /**
     * Gets the {@link #red} value of this {@link Color}.
     *
     * @return The red value
     */
    public int getRed() {
        return this.red;
    }

    /**
     * Creates a new {@link Color} by using the provided {@param red} value
     * while retaining the current {@link #green} and {@link #blue} values.
     *
     * @param red The red value to use
     * @return The new color object
     */
    public Color withRed(int red) {
        return of(red, this.green, this.blue);
    }

    /**
     * Gets the {@link #green} value of this {@link Color}.
     *
     * @return The green value
     */
    public int getGreen() {
        return this.green;
    }

    /**
     * Creates a new {@link Color} by using the provided {@param green} value
     * while retaining the current {@link #red} and {@link #blue} values.
     *
     * @param green The green value to use
     * @return The new color object
     */
    public Color withGreen(int green) {
        return of(this.red, green, this.blue);
    }

    /**
     * Gets the current {@link #blue} value of this {@link Color}.
     *
     * @return The blue value
     */
    public int getBlue() {
        return this.blue;
    }

    /**
     * Creates a new {@link Color} by using the provided {@param green} value
     * while retaining the current {@link #green} and {@link #blue} values.
     *
     * @param blue The blue value to use
     * @return The new color object
     */
    public Color withBlue(int blue) {
        return of(this.red, this.green, blue);
    }

    /**
     * Converts this {@link Color} into a {@link Vector3i} object of red (x),
     * green (y), and blue (z) values.
     *
     * @return The vector rgb color
     */
    public Vector3i asVector3i() {
        return new Vector3i(this.red, this.green, this.blue);
    }

    /**
     * Converts this {@link Color} into a {@link java.awt.Color} object for use
     * in other APIs.
     *
     * @return The java awt color object
     */
    public java.awt.Color asJavaColor() {
        return new java.awt.Color(rgb);
    }

    /**
     * Creates a new {@link Color} by averaging the red, green, and blue values
     * of each color in {@param colors}.
     *
     * @param colors The colors to mix
     * @return The new color
     * @see #mixColors(Color...)
     */
    public Color mixWithColors(Color... colors) {
        Color[] newColorArray = new Color[colors.length + 1];
        newColorArray[0] = this;
        System.arraycopy(colors, 0, newColorArray, 1, colors.length);
        return mixColors(newColorArray);
    }

    /**
     * Creates a new {@link Color} by averaging the red, green, and blue values
     * of each color in {@param colors}.
     *
     * @param dyeColors The dye colors to mix
     * @return The new color
     * @see #mixColors(Color...)
     */
    public Color mixWithDyes(DyeColor... dyeColors) {
        Color[] newColorArray = new Color[dyeColors.length + 1];
        newColorArray[0] = this;
        for (int i = 0; i < dyeColors.length; i++) {
            newColorArray[i + 1] = dyeColors[i].getColor();
        }
        return mixColors(newColorArray);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew()
                .set(Queries.CONTENT_VERSION, this.getContentVersion())
                .set(Queries.COLOR_RED, this.getRed())
                .set(Queries.COLOR_GREEN, this.getGreen())
                .set(Queries.COLOR_BLUE, this.getBlue());
    }

    @Override
    public int hashCode() {
        return this.rgb;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && this.rgb == ((Color) obj).rgb;
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("rgb", this.rgb)
                .add("red", this.red)
                .add("green", this.green)
                .add("blue", this.blue)
                .toString();
    }

    public static final class Builder extends AbstractDataBuilder<Color> {

        /**
         * Creates a new {@link Builder} for building {@link Color} objects,
         * either from {@link DataView}s, or otherwise.
         */
        public Builder() {
            super(Color.class, 1);
        }

        @Override
        protected Optional<Color> buildContent(DataView container) throws InvalidDataException {
            if (!container.contains(Queries.COLOR_RED, Queries.COLOR_GREEN, Queries.COLOR_BLUE)) {
                return Optional.empty();
            }
            try {
                final int red = container.getInt(Queries.COLOR_RED).get();
                final int green = container.getInt(Queries.COLOR_GREEN).get();
                final int blue = container.getInt(Queries.COLOR_BLUE).get();
                return Optional.of(of(red, green, blue));
            } catch (Exception e) {
                throw new InvalidDataException("Could not parse some data.", e);
            }
        }

    }

}