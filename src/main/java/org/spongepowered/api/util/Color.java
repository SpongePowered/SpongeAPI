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

import static com.google.common.base.Preconditions.checkArgument;

public final class Color implements DataSerializable {

    // SORTFIELDS: ON

    public static final Color AQUA = ofHex(0x55FFFF);

    public static final Color BLACK = ofHex(0x000000);

    public static final Color BLUE = ofHex(0x5555FF);

    public static final Color DARK_AQUA = ofHex(0x00AAAA);

    public static final Color DARK_BLUE = ofHex(0x0000AA);

    public static final Color DARK_GRAY = ofHex(0x555555);

    public static final Color DARK_GREEN = ofHex(0x00AA00);

    public static final Color DARK_PURPLE = ofHex(0xAA00AA);

    public static final Color DARK_RED = ofHex(0xAA0000);

    public static final Color GOLD = ofHex(0xFFAA00);

    public static final Color GRAY = ofHex(0xAAAAAA);

    public static final Color GREEN = ofHex(0x55FF55);

    public static final Color LIGHT_PURPLE = ofHex(0xFF55FF);

    public static final Color RED = ofHex(0xFF5555);

    public static final Color YELLOW = ofHex(0xFFFF55);

    public static final Color WHITE = ofHex(0xFFFFFF);

    // SORTFIELDS: OFF

    /**
     * Gets a new {@link Color} based on the hexadecimal value
     * for a combined {@code red}, {@code green}, and {@code blue}
     * color. Note that colors do not utilize an alpha modifier
     *
     * @param hex The hexadecimal value of the color
     * @return The color object
     */
    public static Color ofHex(int hex) {
        checkArgument(0 <= hex && hex <= 0xFFFFFF, "hex (%s) must be in range 0 to 0xFFFFFF", hex);
        return new Color(hex, (hex >> 16) & 0xFF, (hex >> 8) & 0xFF, hex & 0xFF);
    }

    /**
     * Gets a new {@link Color} based on the hexadecimal value
     * for a combined {@code red}, {@code green}, and {@code blue}
     * color. Note that colors do not utilize an alpha modifier
     *
     * @param hex The hexadecimal value of the color
     * @return The color object
     */
    @Deprecated
    public static Color ofRgb(int hex) {
        return ofHex(hex);
    }

    /**
     * Gets a new {@link Color} based on the hexadecimal value
     * for a combined {@code red}, {@code green}, and {@code blue}
     * color. Note that colors do not utilize an alpha modifier
     *
     * @param red The red value
     * @param green The green value
     * @param blue The blue value
     * @return The color object
     */
    public static Color ofRgb(int red, int green, int blue) {
        checkArgument(0 <= red && red <= 0xFF, "red (%s) must be in range 0 to 255", red);
        checkArgument(0 <= green && green <= 0xFF, "green (%s) must be in range 0 to 255", green);
        checkArgument(0 <= blue && blue <= 0xFF, "blue (%s) must be in range 0 to 255", blue);
        return new Color((red << 16) | (green << 8) | blue, red, green, blue);
    }

    /**
     * Converts the provided {@link Vector3i} into a {@link Color} object.
     *
     * @param vector3i The vector of three integers representing color
     * @return The color object
     */
    public static Color of(Vector3i vector3i) {
        return ofRgb(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    /**
     * converts the provided {@link Vector3f} into a {@link Color} object.
     *
     * @param vector3f The vector of three floats representing color
     * @return The color object
     */
    @Deprecated
    public static Color of(Vector3f vector3f) {
        return of(vector3f.round().toInt());
    }

    /**
     * converts the provided {@link Vector3d} into a {@link Color} object.
     *
     * @param vector3d The vector of three doubles representing color
     * @return The color object
     * @deprecated Use #of(vector3d.toInt())
     */
    @Deprecated
    public static Color of(Vector3d vector3d) {
        return of(vector3d.round().toInt());
    }

    /**
     * Converts the provided {@link java.awt.Color} object into a valid
     * {@link Color} object to be used throughout the API.
     *
     * @param color The java color object
     * @return The converted color object
     */
    public static Color of(java.awt.Color color) {
        return ofRgb(color.getRed(), color.getGreen(), color.getBlue());
    }

    //TODO: Use same formula for mixing a dyeing? https://minecraft.gamepedia.com/Dye#Dyeing_armor

    /**
     * Creates a new {@link Color} combining the provided {@link Color}
     * objects, their summation and average is taken into effect
     * to properly mix the colors together.
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
        return ofRgb(averageRed, averageGreen, averageBlue);
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

    private final int hex;
    private final int red;
    private final int green;
    private final int blue;

    private Color(int hex, int red, int green, int blue) {
        this.hex = hex;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Gets the {@code hex} value of this {@link Color}.
     *
     * @return The color in hexadecimal
     */
    public int getHex() {
        return this.hex;
    }

    /**
     * Gets the {@code red green blue} representation of this color in
     * a "hexadecimal" format.
     *
     * @return The current color value in a hexadecimal format
     */
    @Deprecated
    public int getRgb() {
        return this.hex;
    }

    /**
     * Gets the {@code red} value of this {@link Color}.
     *
     * @return The red value
     */
    public int getRed() {
        return this.red;
    }

    /**
     * Gets the {@code red} value of this {@link Color}.
     *
     * @return The red value
     */
    public int getGreen() {
        return this.green;
    }

    /**
     * Gets the current {@code blue} value of this {@link Color}.
     *
     * @return The blue value
     */
    public int getBlue() {
        return this.blue;
    }

    /**
     * Creates a new {@link Color} by using the provided
     * {@code red} color, while retaining the current {@link #getGreen()}
     * and {@link #getBlue()} values.
     *
     * @param red The red value to use
     * @return The new color object
     */
    public Color withRed(int red) {
        return ofRgb(red, this.green, this.blue);
    }

    /**
     * Creates a new {@link Color} by using the provided
     * {@code green} color, while retaining the current {@link #getRed()}
     * and {@link #getBlue()} values.
     *
     * @param green The green value to use
     * @return The new color object
     */
    public Color withGreen(int green) {
        return ofRgb(this.red, green, this.blue);
    }

    /**
     * Creates a new {@link Color} by using the provided
     * {@code blue} color, while retaining the current {@link #getGreen()}
     * and {@link #getRed()} ()} values.
     *
     * @param blue The blue value to use
     * @return The new color object
     */
    public Color withBlue(int blue) {
        return ofRgb(this.blue, this.green, blue);
    }

    /**
     * Converts this {@link Color} into a {@link Vector3i} object. The x, y, and
     * z components refer to red, green, and blue values respectively.
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
        return new java.awt.Color(hex);
    }

    /**
     * Creates a new color with the provided {@code Colors}.
     *
     * @param colors The provided colors to mix
     * @return The new color
     */
    public Color mixWithColors(Color... colors) {
        Color[] newColorArray = new Color[colors.length + 1];
        newColorArray[0] = this;
        System.arraycopy(colors, 0, newColorArray, 1, colors.length);
        return mixColors(newColorArray);
    }

    /**
     * Similar to {@link #mixWithColors(Color...)}, mixes the
     * provided {@link DyeColor}s with this {@link Color}.
     *
     * @param dyeColors The dye colors to mix
     * @return The new color
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
        return this.hex;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && this.hex == ((Color) obj).hex;
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("hex", this.getHex())
                .add("red", this.getRed())
                .add("green", this.getGreen())
                .add("blue", this.getBlue())
                .toString();
    }

    public static final class Builder extends AbstractDataBuilder<Color> {

        /**
         * Creates a new {@link Builder} for building {@link Color} objects, either
         * from {@link DataView}s, or otherwise.
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
                return Optional.of(ofRgb(red, green, blue));
            } catch (Exception e) {
                throw new InvalidDataException("Could not parse some data.", e);
            }
        }

    }

}