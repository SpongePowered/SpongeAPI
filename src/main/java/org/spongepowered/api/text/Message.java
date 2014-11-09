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

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents a rich Message which can be sent to Players. This is an API for
 * Minecraft 1.7 "Json" chat messages features.
 */
public final class Message implements Iterable<MessagePart> {

    /**
     * Builds a Message from zero (empty Message), one or more Parts.
     *
     * @param parts parts of the Message, cannot be null and cannot contain null
     *        elements
     * @return the built Message
     */
    @Nonnull
    public static Message of(@Nonnull final MessagePart... parts) {
        final Message result = new Message();
        for (final MessagePart part : parts) {
            if (part == null) {
                throw new IllegalArgumentException("parts can't contain null elements");
            }
            result.append(part);
        }
        return result;
    }

    /**
     * Builds a Message with a text as first Part.
     *
     * @param string the text
     * @return The built Message
     */
    @Nonnull
    public static Message of(@Nonnull final String string) {
        return Message.of(MessagePart.of(string));
    }

    /**
     * Builds a Message with a localized text as first Part.
     *
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The built Message
     */
    @Nonnull
    public static Message ofLocalized(@Nonnull final String id, @Nonnull final String... parameters) {
        return Message.of(MessagePart.ofLocalized(id, parameters));
    }

    /**
     * Builds a Message with a text as first Part, with one or more lines of
     * hover text.
     *
     * @param text The text
     * @param hoverText the hover text
     * @return The built Message
     */
    @Nonnull
    public static Message of(@Nonnull final String text, @Nonnull final String... hoverText) {
        return Message.of(MessagePart.of(text, hoverText));
    }

    /**
     * Builds a Message with an hover text and a localized text as first Part.
     *
     * @param hoverText the hover text, one or more lines
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The built Message
     */
    @Nonnull
    public static Message ofLocalized(@Nonnull final String[] hoverText, @Nonnull final String id, @Nonnull final String... parameters) {
        return Message.of(MessagePart.ofLocalized(hoverText, id, parameters));
    }

    /**
     * Builds a Message with an ItemStack as first Part.
     *
     * @param item The itemstack
     * @return The built Message
     */
    @Nonnull
    public static Message of(@Nonnull final ItemStack item) {
        return Message.of(MessagePart.of(item));
    }

    /**
     * Builds a Message with a text as first Part, using an ItemStack
     * description as hover text.
     *
     * @param item The itemstack
     * @param text The text
     * @return The built Message
     */
    @Nonnull
    public static Message of(@Nonnull final ItemStack item, @Nonnull final String text) {
        return Message.of(MessagePart.of(item, text));
    }

    /**
     * Builds a Message with a localized text as first Part, using an ItemStack
     * description as hover text.
     *
     * @param item The itemstack
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The built Message
     */
    @Nonnull
    public static Message ofLocalized(@Nonnull final ItemStack item, @Nonnull final String id, @Nonnull final String... parameters) {
        return Message.of(MessagePart.ofLocalized(item, id, parameters));
    }

    /**
     * Builds a Message with an Achievement as first Part.
     *
     * @param achievement The achievement
     * @return The built Message
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static Message of(@Nonnull final Achievement achievement) {
//        return Message.of(MessagePart.of(achievement));
//    }

    /**
     * Builds a Message with a text as first Part, using an Achievement
     * description as hover text.
     *
     * @param achievement The achievement
     * @param text The text
     * @return The built Message
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static Message of(@Nonnull final Achievement achievement, @Nonnull final String text) {
//        return Message.of(MessagePart.of(achievement, text));
//    }

    /**
     * Builds a Message with a localized text as first Part, using an
     * Achievement description as hover text.
     *
     * @param achievement The achievement
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The built Message
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static Message ofLocalized(@Nonnull final Achievement achievement, @Nonnull final String id, @Nonnull final String... parameters) {
//        return Message.of(MessagePart.ofLocalized(achievement, id, parameters));
//    }

    /**
     * Builds a Message with a text as first Part, linking the provided Click
     * action to it.
     *
     * @param clickAction The click action
     * @param text The text
     * @return The built Message
     */
    @Nonnull
    public static Message of(@Nullable final TextClickAction clickAction, @Nonnull final String text) {
        return Message.of(MessagePart.of(clickAction, text));
    }

    /**
     * Builds a Message with a localized text as first Part, linking the
     * provided Click action to it.
     *
     * @param clickAction The click action
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The built Message
     */
    @Nonnull
    public static Message ofLocalized(@Nullable final TextClickAction clickAction, @Nonnull final String id, @Nonnull final String... parameters) {
        return Message.of(MessagePart.ofLocalized(clickAction, id, parameters));
    }

    /**
     * Builds a Message with a text as first Part, with one or more lines of
     * hover text, linking the provided Click action to it.
     *
     * @param clickAction The click action
     * @param text The text
     * @param hoverText the hover text
     * @return The built Message
     */
    @Nonnull
    public static Message of(@Nullable final TextClickAction clickAction, @Nonnull final String text, @Nonnull final String... hoverText) {
        return Message.of(MessagePart.of(clickAction, text, hoverText));
    }

    /**
     * Builds a Message with a localized text as first Part, with one or more
     * lines of hover text, linking the provided Click action to it.
     *
     * @param clickAction The click action
     * @param hoverText the hover text, one or more lines
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The built Message
     */
    @Nonnull
    public static Message ofLocalized(@Nullable final TextClickAction clickAction, @Nonnull final String[] hoverText, @Nonnull final String id, @Nonnull final String... parameters) {
        return Message.of(MessagePart.ofLocalized(clickAction, hoverText, id, parameters));
    }

    /**
     * Builds a Message with an ItemStack as first Part, linking the provided
     * Click action to it.
     *
     * @param clickAction The click action
     * @param item The itemstack
     * @return The built Message
     */
    @Nonnull
    public static Message of(@Nullable final TextClickAction clickAction, @Nonnull final ItemStack item) {
        return Message.of(MessagePart.of(clickAction, item));
    }

    /**
     * Builds a Message with a text as first Part, using an ItemStack as hover
     * text, linking the provided Click action to it.
     *
     * @param clickAction The click action
     * @param item The itemstack
     * @param text The text
     * @return The built Message
     */
    @Nonnull
    public static Message of(@Nullable final TextClickAction clickAction, @Nonnull final ItemStack item, @Nonnull final String text) {
        return Message.of(MessagePart.of(clickAction, item, text));
    }

    /**
     * Builds a Message with a localized text as first Part, using an ItemStack
     * as hover text, linking the provided Click action to it.
     *
     * @param clickAction The click action
     * @param item The itemstack
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The built Message
     */
    @Nonnull
    public static Message ofLocalized(@Nullable final TextClickAction clickAction, @Nonnull final ItemStack item, @Nonnull final String id, @Nonnull final String... parameters) {
        return Message.of(MessagePart.ofLocalized(clickAction, item, id, parameters));
    }

    /**
     * Builds a Message with an Achievement as first Part, linking the provided
     * Click action to it.
     *
     * @param clickAction The click action
     * @param achievement The achievement
     * @return The built Message
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static Message of(@Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement) {
//        return Message.of(MessagePart.of(clickAction, achievement));
//    }

    /**
     * Builds a Message with a text as first Part, using an Achievement as hover
     * text, linking the provided Click action to it.
     *
     * @param clickAction The click action
     * @param achievement The achievement
     * @param text The text
     * @return The built Message
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static Message of(@Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement, @Nonnull final String text) {
//        return Message.of(MessagePart.of(clickAction, achievement, text));
//    }

    /**
     * Builds a Message with a localized text as firstPart, using an Achievement
     * as hover text, linking the provided Click action to it.
     *
     * @param clickAction The click action
     * @param achievement The achievement
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return The built Message
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static Message ofLocalized(@Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement, @Nonnull final String id, @Nonnull final String... parameters) {
//        return Message.of(MessagePart.ofLocalized(clickAction, achievement, id, parameters));
//    }

    /**
     * The Parts of this Message
     */
    private final List<MessagePart> parts;

    /**
     * Private constructor, Message instances should be built using available
     * static constructors.
     */
    private Message() {
        this.parts = new ArrayList<MessagePart>();
    }

    /**
     * Appends all Parts of the provided Message to this Message.
     *
     * @param message another Message
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nonnull final Message message) {
        this.parts.addAll(message.parts);
        return this;
    }

    /**
     * Appends the provided Part to this Message.
     *
     * @param part The Part
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nonnull final MessagePart part) {
        this.parts.add(part);
        return this;
    }

    /**
     * Appends a Part built from the provided text.
     *
     * @param text The text
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nonnull final String text) {
        append(MessagePart.of(text));
        return this;
    }

    /**
     * Appends a Part built from the provided localized text.
     *
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     */
    @Nonnull
    public Message appendLocalized(@Nonnull final String id, @Nonnull final String... parameters) {
        append(MessagePart.ofLocalized(id, parameters));
        return this;
    }

    /**
     * Appends a Part built from the provided text and hover text.
     *
     * @param text The text
     * @param hoverText the hover text
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nonnull final String text, @Nonnull final String... hoverText) {
        append(MessagePart.of(text, hoverText));
        return this;
    }

    /**
     * Appends a Part built from the provided localized text and hover text.
     *
     * @param hoverText the hover text, one or more lines
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     */
    @Nonnull
    public Message appendLocalized(@Nonnull final String[] hoverText, @Nonnull final String id, @Nonnull final String... parameters) {
        append(MessagePart.ofLocalized(hoverText, id, parameters));
        return this;
    }

    /**
     * Appends a Part built from the provided ItemStack.
     *
     * @param item The itemstack
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nonnull final ItemStack item) {
        append(MessagePart.of(item));
        return this;
    }

    /**
     * Appends a Part built from the provided text, using the provided ItemStack
     * description as hover text.
     *
     * @param item The itemstack
     * @param text The text
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nonnull final ItemStack item, @Nonnull final String text) {
        append(MessagePart.of(item, text));
        return this;
    }

    /**
     * Appends a Part built from the provided localized text, using the provided
     * ItemStack description as hover text.
     *
     * @param item The itemstack
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     */
    @Nonnull
    public Message appendLocalized(@Nonnull final ItemStack item, @Nonnull final String id, @Nonnull final String... parameters) {
        append(MessagePart.ofLocalized(item, id, parameters));
        return this;
    }

    /**
     * Appends a Part built from the provided Achievement.
     *
     * @param achievement The achievement
     * @return This Message for chain calls
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message append(@Nonnull final Achievement achievement) {
//        append(MessagePart.of(achievement));
//        return this;
//    }

    /**
     * Appends a Part built from the provided text, using the provided
     * Achievement description as hover text.
     *
     * @param achievement The achievement
     * @param text The text
     * @return This Message for chain calls
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message append(@Nonnull final Achievement achievement, @Nonnull final String text) {
//        append(MessagePart.of(achievement, text));
//        return this;
//    }

    /**
     * Appends a Part built from the provided localized text, using the provided
     * Achievement description as hover text.
     *
     * @param achievement The achievement
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message appendLocalized(@Nonnull final Achievement achievement, @Nonnull final String id, @Nonnull final String... parameters) {
//        append(MessagePart.ofLocalized(achievement, id, parameters));
//        return this;
//    }

    /**
     * Appends a Part built from the provided text, linking the provided Click
     * action to it.
     *
     * @param clickAction The click action
     * @param text The text
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nullable final TextClickAction clickAction, @Nonnull final String text) {
        append(MessagePart.of(clickAction, text));
        return this;
    }

    /**
     * Appends a Part built from the provided localized text, linking the
     * provided Click action to it.
     *
     * @param clickAction The click action
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     */
    @Nonnull
    public Message appendLocalized(@Nullable final TextClickAction clickAction, @Nonnull final String id, @Nonnull final String... parameters) {
        append(MessagePart.ofLocalized(clickAction, id, parameters));
        return this;
    }

    /**
     * Appends a Part built from the provided text and hover text, linking the
     * provided Click action to it.
     *
     * @param clickAction The click action
     * @param text The text
     * @param hoverText the hover text
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nullable final TextClickAction clickAction, @Nonnull final String text, @Nonnull final String... hoverText) {
        append(MessagePart.of(clickAction, text, hoverText));
        return this;
    }

    /**
     * Appends a Part built from the provided localized text and hover text,
     * linking the provided Click action to it.
     *
     * @param clickAction The click action
     * @param hoverText the hover text, one or more lines
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     */
    @Nonnull
    public Message appendLocalized(@Nullable final TextClickAction clickAction, @Nonnull final String[] hoverText, @Nonnull final String id, @Nonnull final String... parameters) {
        append(MessagePart.ofLocalized(clickAction, hoverText, id, parameters));
        return this;
    }

    /**
     * Appends a Part built from the provided ItemStack, linking the provided
     * Click action to it.
     *
     * @param clickAction The click action
     * @param item The itemstack
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nullable final TextClickAction clickAction, @Nonnull final ItemStack item) {
        append(MessagePart.of(clickAction, item));
        return this;
    }

    /**
     * Appends a Part built from the provided text, using the provided ItemStack
     * description as hover text, linking the provided Click action to it.
     *
     * @param clickAction The click action
     * @param item The itemstack
     * @param text The text
     * @return This Message for chain calls
     */
    @Nonnull
    public Message append(@Nullable final TextClickAction clickAction, @Nonnull final ItemStack item, @Nonnull final String text) {
        append(MessagePart.of(clickAction, item, text));
        return this;
    }

    /**
     * Appends a Part built from the provided localized text, using the provided
     * ItemStack description as hover text, linking the provided Click action to
     * it.
     *
     * @param clickAction The click action
     * @param item The itemstack
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     */
    @Nonnull
    public Message appendLocalized(@Nullable final TextClickAction clickAction, @Nonnull final ItemStack item, @Nonnull final String id, @Nonnull final String... parameters) {
        append(MessagePart.ofLocalized(clickAction, item, id, parameters));
        return this;
    }

    /**
     * Appends a Part built from the provided Achievement, linking the provided
     * Click action to it.
     *
     * @param clickAction The click action
     * @param achievement The achievement
     * @return This Message for chain calls
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message append(@Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement) {
//        append(MessagePart.of(clickAction, achievement));
//        return this;
//    }

    /**
     * Appends a Part built from the provided text, using the provided
     * Achievement description as hover text, linking the provided Click action
     * to it.
     *
     * @param clickAction The click action
     * @param achievement The achievement
     * @param text The text
     * @return This Message for chain calls
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message append(@Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement, @Nonnull final String text) {
//        append(MessagePart.of(clickAction, achievement, text));
//        return this;
//    }

    /**
     * Appends a Part built from the provided localized text, using the provided
     * Achievement description as hover text, linking the provided Click action
     * to it.
     *
     * @param clickAction The click action
     * @param achievement The achievement
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message appendLocalized(@Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement, @Nonnull final String id, @Nonnull final String... parameters) {
//        append(MessagePart.ofLocalized(clickAction, achievement, id, parameters));
//        return this;
//    }

    /**
     * Inserts a Part at the provided position in this Message.
     *
     * @param pos The position
     * @param part The Part
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insert(final int pos, @Nonnull final MessagePart part) {
        this.parts.add(pos, part);
        return this;
    }

    /**
     * Inserts a Part built from the provided text at the provided position in
     * this Message.
     *
     * @param pos The position
     * @param text The text
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insert(final int pos, @Nonnull final String text) {
        insert(pos, MessagePart.of(text));
        return this;
    }

    /**
     * Inserts a Part built from the provided localized text at the provided
     * position in this Message.
     *
     * @param pos The position
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insertLocalized(final int pos, @Nonnull final String id, @Nonnull final String... parameters) {
        insert(pos, MessagePart.ofLocalized(id, parameters));
        return this;
    }

    /**
     * Inserts a Part built from the provided text and hover text at the
     * provided position in this Message.
     *
     * @param pos The position
     * @param text The text
     * @param hoverText the hover text
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insert(final int pos, @Nonnull final String text, @Nonnull final String... hoverText) {
        insert(pos, MessagePart.of(text, hoverText));
        return this;
    }

    /**
     * Inserts a Part built from the provided localized text and hover text at
     * the provided position in this Message.
     *
     * @param pos The position
     * @param hoverText the hover text, one or more lines
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insertLocalized(final int pos, @Nonnull final String[] hoverText, @Nonnull final String id, @Nonnull final String... parameters) {
        insert(pos, MessagePart.ofLocalized(hoverText, id, parameters));
        return this;
    }

    /**
     * Inserts a Part built from the provided ItemStack at the provided position
     * in this Message.
     *
     * @param pos The position
     * @param item The itemstack
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insert(final int pos, @Nonnull final ItemStack item) {
        insert(pos, MessagePart.of(item));
        return this;
    }

    /**
     * Inserts a Part built from the provided text, using the provided ItemStack
     * description as hover text, at the provided position in this Message.
     *
     * @param pos The position
     * @param item The itemstack
     * @param text The text
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insert(final int pos, @Nonnull final ItemStack item, @Nonnull final String text) {
        insert(pos, MessagePart.of(item, text));
        return this;
    }

    /**
     * Inserts a Part built from the provided localized text, using the provided
     * ItemStack description as hover text, at the provided position in this
     * Message.
     *
     * @param pos The position
     * @param item The itemstack
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insertLocalized(final int pos, @Nonnull final ItemStack item, @Nonnull final String id, @Nonnull final String... parameters) {
        insert(pos, MessagePart.ofLocalized(item, id, parameters));
        return this;
    }

    /**
     * Inserts a Part built from the provided Achievement at the provided
     * position in this Message.
     *
     * @param pos The position
     * @param achievement The achievement
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message insert(final int pos, @Nonnull final Achievement achievement) {
//        insert(pos, MessagePart.of(achievement));
//        return this;
//    }

    /**
     * Inserts a Part built from the provided text, using the provided
     * Achievement description as hover text, at the provided position in this
     * Message.
     *
     * @param pos The position
     * @param achievement The achievement
     * @param text The text
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message insert(final int pos, @Nonnull final Achievement achievement, @Nonnull final String text) {
//        insert(pos, MessagePart.of(achievement, text));
//        return this;
//    }

    /**
     * Inserts a Part built from the provided localized text, using the provided
     * Achievement description as hover text, at the provided position in this
     * Message.
     *
     * @param pos The position
     * @param achievement The achievement
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message insertLocalized(final int pos, @Nonnull final Achievement achievement, @Nonnull final String id, @Nonnull final String... parameters) {
//        insert(pos, MessagePart.ofLocalized(achievement, id, parameters));
//        return this;
//    }

    /**
     * Inserts a Part built from the provided text, linking the provided Click
     * action to it, at the provided position in this Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param text The text
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insert(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final String text) {
        insert(pos, MessagePart.of(clickAction, text));
        return this;
    }

    /**
     * Inserts a Part built from the provided localized text, linking the
     * provided Click action to it, at the provided position in this Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insertLocalized(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final String id, @Nonnull final String... parameters) {
        insert(pos, MessagePart.ofLocalized(clickAction, id, parameters));
        return this;
    }

    /**
     * Inserts a Part built from the provided text and hover text, linking the
     * provided Click action to it, at the provided position in this Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param text The text
     * @param hoverText the hover text
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insert(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final String text, @Nonnull final String... hoverText) {
        insert(pos, MessagePart.of(clickAction, text, hoverText));
        return this;
    }

    /**
     * Inserts a Part built from the provided localized text and hover text,
     * linking the provided Click action to it, at the provided position in this
     * Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param hoverText the hover text, one or more lines
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insertLocalized(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final String[] hoverText, @Nonnull final String id, @Nonnull final String... parameters) {
        insert(pos, MessagePart.ofLocalized(clickAction, hoverText, id, parameters));
        return this;
    }

    /**
     * Inserts a Part built from the provided ItemStack, linking the provided
     * Click action to it, at the provided position in this Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param item The itemstack
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insert(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final ItemStack item) {
        insert(pos, MessagePart.of(clickAction, item));
        return this;
    }

    /**
     * Inserts a Part built from the provided text, using the provided ItemStack
     * description as hover text, linking the provided Click action to it, at
     * the provided position in this Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param item The itemstack
     * @param text The text
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insert(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final ItemStack item, @Nonnull final String text) {
        insert(pos, MessagePart.of(clickAction, item, text));
        return this;
    }

    /**
     * Inserts a Part built from the provided localized text, using the provided
     * ItemStack description as hover text, linking the provided Click action to
     * it, at the provided position in this Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param item The itemstack
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
    @Nonnull
    public Message insertLocalized(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final ItemStack item, @Nonnull final String id, @Nonnull final String... parameters) {
        insert(pos, MessagePart.ofLocalized(clickAction, item, id, parameters));
        return this;
    }

    /**
     * Inserts a Part built from the provided Achievement, linking the provided
     * Click action to it, at the provided position in this Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param achievement The achievement
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message insert(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement) {
//        insert(pos, MessagePart.of(clickAction, achievement));
//        return this;
//    }

    /**
     * Inserts a Part built from the provided text, using the provided
     * Achievement description as hover text, linking the provided Click action
     * to it, at the provided position in this Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param achievement The achievement
     * @param text The text
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message insert(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement, @Nonnull final String text) {
//        insert(pos, MessagePart.of(clickAction, achievement, text));
//        return this;
//    }

    /**
     * Inserts a Part built from the provided localized text, using the provided
     * Achievement description as hover text, linking the provided Click action
     * to it, at the provided position in this Message.
     *
     * @param pos The position
     * @param clickAction The click action
     * @param achievement The achievement
     * @param id The localized text identifier
     * @param parameters The localized text parameters, if any
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the position is out of range (
     *             <tt>pos &lt; 0 || pos &gt; {@link #size()}</tt>)
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public Message insertLocalized(final int pos, @Nullable final TextClickAction clickAction, @Nonnull final Achievement achievement, @Nonnull final String id, @Nonnull final String... parameters) {
//        insert(pos, MessagePart.ofLocalized(clickAction, achievement, id, parameters));
//        return this;
//    }

    /**
     * Gets the Part at the specified position in this Message's Parts list.
     *
     * @param index The index of the wanted Part
     * @return The Part at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (
     *             <tt>index &lt; 0 || index &gt;= {@link #size()}</tt>)
     */
    @SuppressWarnings("null")
    @Nonnull
    public MessagePart get(final int index) {
        return this.parts.get(index);
    }

    /**
     * Gets the current number of {@link MessagePart}s in this message.
     * 
     * @return the current number of {@link MessagePart}s in this message
     */
    public int size() {
        return this.parts.size();
    }

    /**
     * Sets the Part at the specified position in this Message's Parts list.
     *
     * @param index The index
     * @param part The Part
     * @return This Message for chain calls
     * @throws IndexOutOfBoundsException if the index is out of range (
     *             <tt>index &lt; 0 || index &gt;= {@link #size()}</tt>)
     */
    @Nonnull
    public Message set(final int index, @Nonnull final MessagePart part) {
        this.parts.set(index, part);
        return this;
    }

    @SuppressWarnings("null")
    @Override
    @Nonnull
    public ListIterator<MessagePart> iterator() {
        return this.parts.listIterator();
    }

    /**
     * This implementation of toString is used to send Message to non-Player
     * CommandSender, like ConsoleCommandSender.
     *
     * @return A String representation of this Message
     */
    @SuppressWarnings("null")
    @Override
    @Nonnull
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (final MessagePart p : this.parts) {
            builder.append(p.toString());
        }
        return builder.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Message parts1 = (Message) o;

        if (!parts.equals(parts1.parts)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return parts.hashCode();
    }

    @Override
    @Nonnull
    public Message clone() {
        final Message message = new Message();
        for (final MessagePart part : parts) {
            message.append(part.clone());
        }
        return message;
    }

}
