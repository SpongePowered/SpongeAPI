package org.spongepowered.api.service.pagination;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.text.Text;

/**
 * Handles calculation of text widths, centering text, adding padding, adding
 * spacing, and more.
 */
public interface PaginationCalculator {

    /**
     * Gets the number of lines the specified text flows into.
     *
     * @param text The text to calculate the number of lines for
     * @return The number of lines that this text flows into
     */
    int getLines(Text text);

    /**
     * Calculates the width of a given text as the number of character
     * pixels/columns the line takes up.
     *
     * @param text The text to get the width of
     * @return The amount of character pixels/columns the text takes up
     */
    int getWidth(Text text);

    /**
     * Gets the width of a character with the specified code
     * point, accounting for if its text is bold our not.
     *
     * @param codePoint The code point of the character
     * @param isBold Whether or not the character is bold or not
     * @return The width of the character at the code point
     */
    int getWidth(int codePoint, boolean isBold);

    /**
     * Centers a text within the middle of the chat box.
     *
     * <p>Generally used for titles and footers.</p>
     *
     * <p>To use no heading, pass null to the first argument.</p>
     *
     * @param heading The text to center
     * @param padding A padding character with a width >1
     * @return The centered text, or if too big, the original text
     */
    Text center(@Nullable Text heading, Text padding);
}