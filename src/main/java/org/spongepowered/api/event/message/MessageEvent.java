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
package org.spongepowered.api.event.message;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.spongepowered.api.text.TextTemplate.arg;
import static org.spongepowered.api.text.TextTemplate.of;

import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.impl.AbstractMessageEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.transform.FixedPartitionedTextFormatter;
import org.spongepowered.api.text.transform.SimpleTextFormatter;
import org.spongepowered.api.text.transform.SimpleTextTemplateApplier;
import org.spongepowered.api.text.transform.TextTemplateApplier;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

/**
 * Describes events when a involving a {@link Text} message.
 */
@ImplementedBy(value = AbstractMessageEvent.class)
public interface MessageEvent extends Event {

    /**
     * Parameter for header section in header partition.
     */
    String PARAM_MESSAGE_HEADER = "header";

    /**
     * Parameter for body section in body partition.
     */
    String PARAM_MESSAGE_BODY = "body";

    /**
     * Parameter for footer section in footer partition.
     */
    String PARAM_MESSAGE_FOOTER = "footer";

    /**
     * Gets the original {@link Text} message.
     *
     * @return The message
     */
    @PropertySettings(requiredParameter = false)
    Text getOriginalMessage();

    /**
     * Returns true if the {@link Text} returned by
     * {@link #getMessage()} should not be sent.
     *
     * @return True if message should not be sent
     */
    boolean isMessageCancelled();

    /**
     * Sets whether the {@link Text} returned by
     * {@link #getMessage()} should be sent.
     *
     * @param cancelled True if should not be sent
     */
    void setMessageCancelled(boolean cancelled);

    /**
     * Returns the {@link MessageFormatter} used to mutate the event's message.
     *
     * @return MessageFormatter of event
     */
    MessageFormatter getFormatter();

    /**
     * Returns the formatted message.
     *
     * @return Message
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    default Text getMessage() {
        return getFormatter().format();
    }

    /**
     * Clears the currently set message and returns the empty formatter.
     *
     * @return Empty {@link MessageFormatter}
     */
    default MessageFormatter clearMessage() {
        MessageFormatter formatter = getFormatter();
        formatter.clear();
        return formatter;
    }

    /**
     * Clears any existing components and sets the header, body, and footer
     * respectively.
     *
     * @param header Header value
     * @param body Body value
     * @param footer Footer value
     */
    default void setMessage(TextRepresentable header, TextRepresentable body, TextRepresentable footer) {
        checkNotNull(header, "header");
        checkNotNull(body, "body");
        checkNotNull(footer, "footer");
        MessageFormatter formatter = clearMessage();
        formatter.setHeader(header);
        formatter.setBody(body);
        formatter.setFooter(footer);
    }

    /**
     * Clears any existing components and sets the header and body
     * respectively.
     *
     * @param header Header value
     * @param body Body value
     */
    default void setMessage(TextRepresentable header, TextRepresentable body) {
        checkNotNull(header, "header");
        checkNotNull(body, "body");
        MessageFormatter formatter = clearMessage();
        formatter.setHeader(header);
        formatter.setBody(body);
    }

    /**
     * Clears any existing components and sets the body.
     *
     * @param body Body value
     */
    default void setMessage(TextRepresentable body) {
        checkNotNull(body, "body");
        MessageFormatter formatter = clearMessage();
        formatter.setBody(body);
    }

    /**
     * Formatter used for formatting messages within this event. This formatter
     * is partitioned into three sections: header, body, and footer. This is in
     * an effort to make formatting messages much more flexible and modular for
     * developers allowing for appending/inserting prefixes, adding suffixes,
     * etc.
     */
    class MessageFormatter extends FixedPartitionedTextFormatter {

        public MessageFormatter() {
            super(3);
        }

        public MessageFormatter(Text header, Text body) {
            this();
            checkNotNull(header, "header");
            checkNotNull(body, "body");
            getHeader().add(new DefaultHeaderApplier(header));
            getBody().add(new DefaultBodyApplier(body));
        }

        public MessageFormatter(Text body) {
            this();
            checkNotNull(body, "body");
            getBody().add(new DefaultBodyApplier(body));
        }

        /**
         * Returns the header partition within this formatter.
         *
         * @return Header partition
         */
        public SimpleTextFormatter getHeader() {
            return get(0);
        }

        /**
         * Clears any existing components within the header partition and adds
         * a new {@link TextTemplateApplier} to the partition with the
         * specified value.
         *
         * @param header Header value
         */
        public void setHeader(TextRepresentable header) {
            set(0, PARAM_MESSAGE_HEADER, header);
        }

        /**
         * Returns the body partition within this formatter.
         *
         * @return Body partition
         */
        public SimpleTextFormatter getBody() {
            return get(1);
        }

        /**
         * Clears any existing components within the body partition and adds
         * a new {@link TextTemplateApplier} to the partition with the
         * specified value.
         *
         * @param body Body value
         */
        public void setBody(TextRepresentable body) {
            set(1, PARAM_MESSAGE_BODY, body);
        }

        /**
         * Returns the footer partition within this formatter.
         *
         * @return Footer partition
         */
        public SimpleTextFormatter getFooter() {
            return get(2);
        }

        /**
         * Clears any existing components within the footer partition and adds
         * a new {@link TextTemplateApplier} to the partition with the
         * specified value.
         *
         * @param footer Footer value
         */
        public void setFooter(TextRepresentable footer) {
            set(2, PARAM_MESSAGE_FOOTER, footer);
        }

        private void set(int i, String key, TextRepresentable value) {
            checkNotNull(value, "value");
            SimpleTextFormatter partition = get(i);
            partition.clear();
            SimpleTextTemplateApplier applier = new SimpleTextTemplateApplier(of(arg(key)));
            applier.setParameter(key, value);
            partition.add(applier);
        }

    }

    /**
     * Represents the initial header set by the implementation before the event
     * is posted.
     */
    final class DefaultHeaderApplier extends SimpleTextTemplateApplier {

        public DefaultHeaderApplier(TextRepresentable value) {
            super(of('<', arg(PARAM_MESSAGE_HEADER), "> "));
            checkNotNull(value, "value");
            setParameter(PARAM_MESSAGE_HEADER, value);
        }

    }

    /**
     * Represents the initial body set by the implementation before the event
     * is posted.
     */
    final class DefaultBodyApplier extends SimpleTextTemplateApplier {

        public DefaultBodyApplier(TextRepresentable value) {
            super(of(arg(PARAM_MESSAGE_BODY)));
            checkNotNull(value, "value");
            setParameter(PARAM_MESSAGE_BODY, value);
        }

    }

}
