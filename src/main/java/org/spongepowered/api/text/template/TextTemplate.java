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
package org.spongepowered.api.text.template;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.action.TextAction;
import org.spongepowered.api.text.format.*;
import org.spongepowered.api.text.selector.Selector;
import org.spongepowered.api.text.translation.Translation;

import javax.annotation.Nullable;

public abstract class TextTemplate {

    public abstract Text build(TextArgs args);

    private static class Full extends TextTemplate {
        @Nullable private final TextTemplate previous;
        private final TextArgsElement<?> nodeArgumentElement;

        private final TextFormat nodeFormat;
        @Nullable private final HoverAction<?> nodeHoverAction;
        @Nullable private final ClickAction<?> nodeClickAction;
        @Nullable private final ShiftClickAction<?> nodeShiftClickAction;

        private Full(TextTemplate previous, TextArgsElement<?> nodeArgumentElement, TextFormat nodeFormat,
                             HoverAction<?> nodeHoverAction, ClickAction<?> nodeClickAction, ShiftClickAction<?> nodeShiftClickAction) {
            this.nodeFormat = nodeFormat;
            this.previous = previous;
            this.nodeArgumentElement = nodeArgumentElement;
            this.nodeHoverAction = nodeHoverAction;
            this.nodeClickAction = nodeClickAction;
            this.nodeShiftClickAction = nodeShiftClickAction;
        }

        @Override
        public Text build(TextArgs args) {
            TextBuilder argumentBuilder = nodeArgumentElement.lookup(args).builder();
            argumentBuilder.format(nodeFormat);

            if (nodeHoverAction != null) {
                argumentBuilder.onHover(nodeHoverAction);
            }
            if (nodeClickAction != null) {
                argumentBuilder.onClick(nodeClickAction);
            }
            if (nodeShiftClickAction != null) {
                argumentBuilder.onShiftClick(nodeShiftClickAction);
            }

            return Texts.builder()
                .append(previous.build(args))
                .append(argumentBuilder.build())
                .build();
        }

    }

    private static class Constant extends TextTemplate {

        private final Text result;

        private Constant(Text result) {
            this.result = result;
        }

        @Override
        public Text build(TextArgs args) {
            return result;
        }
    }

    public static TextTemplate of(Object... objects) {
        TextTemplate accumulator = null;
        TextBuilder builder = Texts.builder();
        TextFormat format = TextFormat.empty();
        HoverAction<?> hoverAction = null;
        ClickAction<?> clickAction = null;
        ShiftClickAction<?> shiftClickAction = null;

        for (Object obj : objects) {
            if (obj instanceof TextFormat) {
                format = (TextFormat) obj;
            } else if (obj instanceof TextColor) {
                format = format.color((TextColor) obj);
            } else if (obj instanceof TextStyle) {
                format = format.style(obj.equals(TextStyles.RESET) ? TextStyles.NONE : format.getStyle().and((TextStyle) obj));
            } else if (obj instanceof TextAction) {
                if (obj instanceof HoverAction) {
                    hoverAction = (HoverAction<?>) obj;
                } else if (obj instanceof ClickAction) {
                    clickAction = (ClickAction<?>) obj;
                } else if (obj instanceof ShiftClickAction) {
                    shiftClickAction = (ShiftClickAction<?>) obj;
                } else {
                    throw new IllegalArgumentException("Unsupported type of TextAction supplied to Texts.of");
                }
            } else if (obj instanceof TextElement) {
                throw new IllegalArgumentException("TextTemplate.of does not support taking text elements, " +
                    "convert the element into an argument element with TextElement#name or TextElement#pos");
            } else if (obj instanceof TextArgsElement) {
                TextTemplate previous = (accumulator == null) ? new Constant(builder.build()) : accumulator;
                accumulator = new Full(
                    previous, (TextArgsElement<?>) obj,
                    format, hoverAction, clickAction, shiftClickAction);
            } else {
                TextBuilder childBuilder;

                if (obj instanceof String) {
                    childBuilder = Texts.builder((String) obj);
                } else if (obj instanceof Translation) {
                    childBuilder = Texts.builder((Translation) obj);
                } else if (obj instanceof Selector) {
                    childBuilder = Texts.builder((Selector) obj);
                } else if (obj instanceof Score) {
                    childBuilder = Texts.builder((Score) obj);
                } else {
                    childBuilder = Texts.builder(String.valueOf(obj));
                }

                if (hoverAction != null) {
                    builder.onHover(hoverAction);
                }
                if (clickAction != null) {
                    builder.onClick(clickAction);
                }
                if (shiftClickAction != null) {
                    builder.onShiftClick(shiftClickAction);
                }

                builder.append(childBuilder.format(format).build());
            }
        }

        if (accumulator == null) {
            return new Constant(builder.build());
        }
        return accumulator;
    }

//    public static void main(String[] args) {
//        TextTemplate template = TextTemplate.of("hi", TextElements.iterable(TextElements.string()).name("iter"));
//        Text other = Texts.of("hi");
//        Text tFinal = template.build(TextArgs.of().with("iter", ImmutableList.of("a", "b", "c")));
//        System.out.println(template);
//    }

}
