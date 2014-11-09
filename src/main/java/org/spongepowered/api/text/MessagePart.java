/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.text;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents a part of a {@link Message}, a simple or localized String which
 * may have a {@link TextClickAction} and/or a {@link TextHover} attached to it.
 * Any unsupported {@link TextHover} and {@link TextClickAction} feature will be
 * ignored.
 * <p>
 * Reasons why a feature may be ignored:
 * </p>
 * <ul>
 * <li>Not supported by the server or client</li>
 * <li>Not meant to be transferred</li>
 * <li>Not applicable to target context (ex.
 * {@link TextClickAction.Type#CHANGE_PAGE} in default chats)</li>
 * <ul>
 */
public final class MessagePart {

    /**
     * Builds a message part consisting of text. The text may contain
     * {@link TextFormatting}s as chars.
     *
     * @param text The text that should be displayed by this part
     * @return The part consisting of the given text
     */
    @Nonnull
    public static MessagePart of(@Nonnull final String text) {
        return new MessagePart().setText(text);
    }

    /**
     * Builds a message part consisting of a localized text and localized text
     * parameters, if any.
     *
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The part consisting of the given localized text
     */
    @Nonnull
    public static MessagePart ofLocalized(@Nonnull final String id, @Nonnull final String... parameters) {
        return new MessagePart().setLocalizedText(id, parameters);
    }

    /**
     * Builds a message part consisting of text, which shows another text when
     * hovered. The text and the hover text may contain {@link TextFormatting}s
     * as chars.
     *
     * @param text The text that should be displayed by this part
     * @param hoverText The text that should be displayed by this part when
     *        hovered, cannot be null or empty
     * @return The hoverable part consisting of the given text and the hover
     *         text
     */
    @Nonnull
    public static MessagePart of(@Nonnull final String text, @Nonnull final String... hoverText) {
        return new MessagePart().setText(text).setHover(TextHover.of(hoverText));
    }

    /**
     * Builds a message part consisting of a localized text and localized text
     * parameters, if any, which shows another text when hovered and executes
     * the given {@link TextClickAction} when clicked. The hover text may
     * contain {@link TextFormatting}s as chars.
     *
     * @param hoverText The text that should be displayed by this part when
     *        hovered, cannot be null or empty
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The hoverable part consisting of the given localized text and the
     *         hover text
     */
    @Nonnull
    public static MessagePart ofLocalized(@Nonnull final String[] hoverText, @Nonnull final String id, @Nonnull final String... parameters) {
        return new MessagePart().setHover(TextHover.of(hoverText)).setLocalizedText(id, parameters);
    }

    /**
     * Builds a message part consisting of an {@link ItemStack}. The name of the
     * item can be hovered to show the item details.
     *
     * @param item The item that should be displayed by this part, cannot be
     *        null
     * @return The hoverable part consisting of the given item
     */
    @Nonnull
    public static MessagePart of(@Nonnull final ItemStack item) {
        return new MessagePart().setHover(TextHover.of(item));
    }

    /**
     * Builds a message part consisting of text, which shows the given item when
     * hovered. The text may contain {@link TextFormatting}s as chars.
     *
     * @param item The item that should be displayed by this part when hovered,
     *        cannot be null
     * @param text The text that should be displayed by this part
     * @return The hoverable part consisting of the given text and the hover
     *         item
     */
    @Nonnull
    public static MessagePart of(@Nonnull final ItemStack item, @Nonnull final String text) {
        return new MessagePart().setHover(TextHover.of(item)).setText(text);
    }

    /**
     * Builds a message part consisting of localized text, which shows the given
     * item when hovered.
     *
     * @param item The item that should be displayed by this part when hovered,
     *        cannot be null
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The hoverable part consisting of the given localized text and the
     *         hover item
     */
    @Nonnull
    public static MessagePart ofLocalized(@Nonnull final ItemStack item, @Nonnull final String id, @Nonnull final String... parameters) {
        return new MessagePart().setHover(TextHover.of(item)).setLocalizedText(id, parameters);
    }

    /**
     * Builds a message part consisting of an {@link Achievement}. The name of
     * the achievement can be hovered to show the achievement details.
     *
     * @param achievement The achievement that should be displayed by this part,
     *        cannot be null
     * @return The hoverable part consisting of the given achievement
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static MessagePart of(@Nonnull final Achievement achievement) {
//        return new MessagePart().setHover(TextHover.of(achievement));
//    }

    /**
     * Builds a message part consisting of text, which shows the given
     * achievement when hovered. The text may contain {@link TextFormatting}s as
     * chars.
     *
     * @param achievement The achievement that should be displayed by this part
     *        when hovered, cannot be null
     * @param text The text that should be displayed by this part
     * @return The hoverable part consisting of the given text and the hover
     *         achievement
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static MessagePart of(@Nonnull final Achievement achievement, @Nonnull final String text) {
//        return new MessagePart().setHover(TextHover.of(achievement)).setText(text);
//    }

    /**
     * Builds a message part consisting of localized text, which shows the given
     * achievement when hovered.
     *
     * @param achievement The achievement that should be displayed by this part
     *        when hovered, cannot be null
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The hoverable part consisting of the given localized text and the
     *         hover achievement
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static MessagePart ofLocalized(@Nonnull final Achievement achievement, @Nonnull final String id, @Nonnull final String... parameters) {
//        return new MessagePart().setHover(TextHover.of(achievement)).setLocalizedText(id, parameters);
//    }

    /**
     * Builds a message part consisting of text, which executes the given
     * {@link TextClickAction} when clicked. The text may contain
     * {@link TextFormatting}s as chars.
     *
     * @param clickAction The action that should be performed when the text is
     *        clicked
     * @param text The text that should be displayed by this part
     * @return The clickable part consisting of the given text
     */
    @Nonnull
    public static MessagePart of(@Nullable final TextClickAction clickAction, @Nonnull final String text) {
        return new MessagePart().setClickAction(clickAction).setText(text);
    }

    /**
     * Builds a message part consisting of a localized text and localized text
     * parameters, if any, which executes the given {@link TextClickAction}
     * action when clicked.
     *
     * @param clickAction The action that should be performed when the text is
     *        clicked
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The clickable part consisting of the given localized text
     */
    @Nonnull
    public static MessagePart ofLocalized(@Nullable final TextClickAction clickAction, @Nonnull final String id, @Nonnull final String... parameters) {
        return new MessagePart().setClickAction(clickAction).setLocalizedText(id, parameters);
    }

    /**
     * Builds a message part consisting of text, which shows another text when
     * hovered and executes the given {@link TextClickAction} when clicked. The
     * text and the hover text may contain {@link TextFormatting}s as chars.
     *
     * @param clickAction The action that should be performed when the text is
     *        clicked
     * @param text The text that should be displayed by this part
     * @param hoverText The text that should be displayed by this part when
     *        hovered, cannot be null or empty
     * @return The hoverable and clickable part consisting of the given text and
     *         the hover text
     */
    @Nonnull
    public static MessagePart of(@Nullable final TextClickAction clickAction, @Nonnull final String text, @Nonnull final String... hoverText) {
        return new MessagePart().setClickAction(clickAction).setText(text).setHover(TextHover.of(hoverText));
    }

    /**
     * Builds a message part consisting of a localized text and localized text
     * parameters, if any, which shows another text when hovered and executes
     * the given {@link TextClickAction} when clicked. The hover text may
     * contain {@link TextFormatting}s as chars.
     *
     * @param clickAction The action that should be performed when the text is
     *        clicked
     * @param hoverText The text that should be displayed by this part when
     *        hovered, cannot be null or empty
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The hoverable and clickable part consisting of the given
     *         localized text and the hover text
     */
    @Nonnull
    public static MessagePart ofLocalized(@Nullable final TextClickAction clickAction, @Nonnull final String[] hoverText, @Nonnull final String id, @Nonnull final String... parameters) {
        return new MessagePart().setClickAction(clickAction).setHover(TextHover.of(hoverText)).setLocalizedText(id, parameters);
    }

    /**
     * Builds a message part consisting of an {@link ItemStack}. The name of the
     * item can be hovered to show the item details and executes the given
     * {@link TextClickAction} when clicked.
     *
     * @param clickAction The action that should be performed when the item's
     *        name is clicked
     * @param item The item that should be displayed by this part, cannot be
     *        null
     * @return The hoverable and clickable part consisting of the given item
     */
    @Nonnull
    public static MessagePart of(@Nullable final TextClickAction clickAction, @Nonnull final ItemStack item) {
        return new MessagePart().setClickAction(clickAction).setHover(TextHover.of(item));
    }

    /**
     * Builds a message part consisting of text, which shows the given item when
     * hovered and executes the given {@link TextClickAction} when clicked. The
     * text may contain {@link TextFormatting}s as chars.
     *
     * @param clickAction The action that should be performed when the text is
     *        clicked
     * @param item The item that should be displayed by this part when hovered,
     *        cannot be null
     * @param text The text that should be displayed by this part
     * @return The hoverable and clickable part consisting of the given text and
     *         the hover item
     */
    @Nonnull
    public static MessagePart of(@Nullable final TextClickAction clickAction, @Nonnull final ItemStack item, @Nonnull final String text) {
        return new MessagePart().setClickAction(clickAction).setHover(TextHover.of(item)).setText(text);
    }

    /**
     * Builds a message part consisting of localized text, which shows the given
     * item when hovered and executes the given {@link TextClickAction} when
     * clicked.
     *
     * @param clickAction The action that should be performed when the text is
     *        clicked
     * @param item The item that should be displayed by this part when hovered,
     *        cannot be null
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The hoverable and clickable part consisting of the given
     *         localized text and the hover item
     */
    @Nonnull
    public static MessagePart ofLocalized(@Nullable final TextClickAction clickAction, @Nonnull final ItemStack item, @Nonnull final String id, @Nonnull final String... parameters) {
        return new MessagePart().setClickAction(clickAction).setHover(TextHover.of(item)).setLocalizedText(id, parameters);
    }

    /**
     * Builds a message part consisting of an {@link Achievement}. The name of
     * the achievement can be hovered to show the achievement details and
     * executes the given {@link TextClickAction} when clicked.
     *
     * @param clickAction The action that should be performed when the
     *        achievement's name is clicked
     * @param achievement The achievement that should be displayed by this part,
     *        cannot be null
     * @return The hoverable and clickable part consisting of the given
     *         achievement
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static MessagePart of(@Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement) {
//        return new MessagePart().setClickAction(clickAction).setHover(TextHover.of(achievement));
//    }

    /**
     * Builds a message part consisting of text, which shows the given
     * achievement when hovered and executes the given {@link TextClickAction}
     * action when clicked. The text may contain {@link TextFormatting}s as
     * chars.
     *
     * @param clickAction The action that should be performed when the text is
     *        clicked
     * @param achievement The achievement that should be displayed by this part
     *        when hovered, cannot be null
     * @param text The text that should be displayed by this part
     * @return The hoverable and clickable part consisting of the given text and
     *         the hover achievement
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static MessagePart of(@Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement, @Nonnull final String text) {
//        return new MessagePart().setClickAction(clickAction).setHover(TextHover.of(achievement)).setText(text);
//    }

    /**
     * Builds a message part consisting of localized text, which shows the given
     * achievement when hovered and executes the given {@link TextClickAction}
     * action when clicked.
     *
     * @param clickAction The action that should be performed when the text is
     *        clicked
     * @param achievement The achievement that should be displayed by this part
     *        when hovered, cannot be null
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The hoverable and clickable part consisting of the given
     *         localized text and the hover achievement
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static MessagePart ofLocalized(@Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement, @Nonnull final String id, @Nonnull final String... parameters) {
//        return new MessagePart().setClickAction(clickAction).setHover(TextHover.of(achievement)).setLocalizedText(id, parameters);
//    }

    /**
     * A String or a localized String identifier if {@link #isLocalizedText()}
     * is true
     */
    private String text;

    /**
     * Determines what is stored in {@link #getText()}, a localized String
     * identifier if true, a simple String otherwise.
     */
    private boolean localizedText;

    /**
     * Parameters for this localized String
     */
    private String[] localizedTextParameters;

    /**
     * The Hover effect for this Part, if any
     */
    private TextHover hover;

    /**
     * The Click action for this Part, if any
     */
    private TextClickAction clickAction;

    /**
     * The extra data for this Part, if any. May only contain JSON compatible
     * stuff.
     */
    private List<Object> extraData;

    /**
     * Text that will be inserted to the chat on shift clicking this part, if
     * any. (Since 1.8)
     */
    private String insertion;

    /**
     * Private constructor, Part instances should be built using available
     * static constructors.
     */
    private MessagePart() {}

    /**
     * Gets the text of this Part.
     * <p>
     * May be a simple String or a localized String identifier. Check
     * {@link #isLocalizedText()}.
     *
     * @return The text of this Part
     */
    @Nullable
    public String getText() {
        return this.text;
    }

    /**
     * Sets the text of this Part.
     *
     * @param text The new text of this Part
     * @return This Part for chain calls
     * @see #setLocalizedText(String, String...)
     */
    @Nonnull
    public MessagePart setText(@Nonnull final String text) {
        this.text = text;
        this.localizedText = false;
        return this;
    }

    /**
     * Checks if this Part contains a localized text.
     *
     * @return True if this Part contains a localized text, false otherwise
     */
    public boolean isLocalizedText() {
        return this.localizedText;
    }

    /**
     * Sets the localized text identifier and eventual parameters of this Part.
     *
     * @param id The localized text identifier
     * @param parameters The localized text parameters
     * @return This Part for chain calls
     */
    @Nonnull
    public MessagePart setLocalizedText(@Nonnull final String id, @Nonnull final String... parameters) {
        this.text = id;
        this.localizedText = true;
        this.setLocalizedTextParameters(parameters);
        return this;
    }

    /**
     * Gets this Part's localized text's parameters.
     *
     * @return This Part's localized text's parameters
     */
    @Nullable
    public String[] getLocalizedTextParameters() {
        return this.localizedTextParameters;
    }

    /**
     * Sets this Part's localized text's parameters.
     *
     * @param parameters This Part's new localized text's parameters
     * @return This Part for chain calls
     */
    @Nonnull
    public MessagePart setLocalizedTextParameters(@Nullable final String... parameters) {
        this.localizedTextParameters = parameters == null || parameters.length == 0 ? null : parameters;
        return this;
    }

    /**
     * Gets this Part's Hover effect.
     *
     * @return This Part's Hover effect
     */
    @Nullable
    public TextHover getHover() {
        return this.hover;
    }

    /**
     * Sets this Part's Hover effect.
     *
     * @param hover this Part's new Hover effect
     * @return This Part for chain calls
     */
    @Nonnull
    public MessagePart setHover(@Nullable final TextHover hover) {
        this.hover = hover;
        return this;
    }

    /**
     * Gets this Part's Click action.
     *
     * @return This Part's Click action
     */
    @Nullable
    public TextClickAction getClickAction() {
        return this.clickAction;
    }

    /**
     * Sets this Part's Click action.
     *
     * @param clickAction This Part's new Click action
     * @return This Part for chain calls
     */
    @Nonnull
    public MessagePart setClickAction(@Nullable final TextClickAction clickAction) {
        this.clickAction = clickAction;
        return this;
    }

    /**
     * Get this Part's extra data.
     * 
     * @return This Part's extra data.
     */
    public final List<Object> getExtraData() {
        return extraData;
    }

    /**
     * Sets this Part's extra data.
     *
     * @param extraData This Part's new extra data.
     * @return This Part for chain calls
     */
    public final MessagePart setExtraData(List<Object> extraData) {
        this.extraData = extraData;
        return this;
    }

    /**
     * Get this Part's text insertion. The text that will be inserted to the
     * chat on shift clicking this part's text.
     * 
     * @return This Part's text insertion.
     */
    public final String getInsertion() {
        return insertion;
    }

    /**
     * Sets this Part's text insertion. The text that will be inserted to the
     * chat on shift clicking this part's text.
     *
     * @param insertion This Part's new text insertion.
     * @return This Part for chain calls
     */
    public final MessagePart setInsertion(String insertion) {
        this.insertion = insertion;
        return this;
    }

    /**
     * This implementation of toString is used to send Message to non-Player
     * CommandSender, like ConsoleCommandSender.
     *
     * @return A String representation of this Part
     */
    @SuppressWarnings("null")
    @Override
    @Nonnull
    public String toString() {
        if (this.text == null) {
            // text can be null only if the text is inferred from hover
            if (this.hover == null) {
                return "Invalid Message!";
            } else {
                return this.hover.toString();
            }
        } else {
            return this.text;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final MessagePart part = (MessagePart) o;

        if (localizedText != part.localizedText) {
            return false;
        }
        if (clickAction != null ? !clickAction.equals(part.clickAction) : part.clickAction != null) {
            return false;
        }
        if (hover != null ? !hover.equals(part.hover) : part.hover != null) {
            return false;
        }
        if (!Arrays.equals(localizedTextParameters, part.localizedTextParameters)) {
            return false;
        }
        if (text != null ? !text.equals(part.text) : part.text != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (localizedText ? 1 : 0);
        result = 31 * result + (localizedTextParameters != null ? Arrays.hashCode(localizedTextParameters) : 0);
        result = 31 * result + (hover != null ? hover.hashCode() : 0);
        result = 31 * result + (clickAction != null ? clickAction.hashCode() : 0);
        return result;
    }

    @Override
    @Nonnull
    public MessagePart clone() {
        final MessagePart part = new MessagePart();
        part.clickAction = clickAction;
        part.hover = hover;
        part.localizedText = localizedText;
        part.localizedTextParameters = localizedTextParameters == null ? null : localizedTextParameters.clone();
        part.text = text;
        return part;
    }

}
