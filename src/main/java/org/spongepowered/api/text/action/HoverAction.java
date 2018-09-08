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
package org.spongepowered.api.text.action;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * Represents a {@link TextAction} that responds to hovers.
 *
 * @param <R> The type of the result of the action
 */
public interface HoverAction<R> extends TextAction<R>, TextRepresentable {

    @Override
    default void applyTo(Text.Builder builder) {
        builder.onHover(this);
    }

    /**
     * Shows some text.
     */
    interface ShowText extends HoverAction<Text> {

        /**
         * Creates a new builder.
         *
         * @return A new builder
         */
        static Builder builder() {
            return Sponge.getRegistry().createBuilder(Builder.class);
        }

        /**
         * A builder for {@link ShowText} hover actions.
         */
        interface Builder extends ResettableBuilder<ShowText, Builder> {

            /**
             * Sets the text to show.
             *
             * @param text The text
             * @return This builder
             */
            Builder text(Text text);

            /**
             * Builds the action.
             *
             * @return The built action
             */
            ShowText build();
        }
    }

    /**
     * Shows information about an item.
     */
    interface ShowItem extends HoverAction<ItemStackSnapshot> {

        /**
         * Creates a new builder.
         *
         * @return A new builder
         */
        static Builder builder() {
            return Sponge.getRegistry().createBuilder(Builder.class);
        }

        /**
         * A builder for {@link ShowItem} hover actions.
         */
        interface Builder extends ResettableBuilder<ShowItem, Builder> {

            /**
             * Sets the stack to show.
             *
             * @param stack The stack
             * @return This builder
             */
            Builder item(ItemStackSnapshot stack);

            /**
             * Builds the action.
             *
             * @return The built action
             */
            ShowItem build();
        }
    }

    /**
     * Shows information about an entity.
     */
    interface ShowEntity extends HoverAction<ShowEntity.Ref> {

        /**
         * Creates a new builder.
         *
         * @return A new builder
         */
        static Builder builder() {
            return Sponge.getRegistry().createBuilder(Builder.class);
        }

        /**
         * A builder for {@link ShowEntity} hover actions.
         */
        interface Builder extends ResettableBuilder<ShowEntity, Builder> {

            /**
             * Sets the entity to show.
             *
             * @param entity The entity
             * @param name The entity name
             * @return This builder
             */
            Builder entity(Entity entity, String name);

            /**
             * Sets the entity to show.
             *
             * @param ref The ref
             * @return This builder
             */
            Builder entity(Ref ref);

            /**
             * Builds the action.
             *
             * @return The built action
             */
            ShowEntity build();
        }

        /**
         * Represents a reference to an entity, used in the underlying JSON of
         * the show entity action.
         */
        interface Ref extends Identifiable {

            /**
             * Creates a new builder.
             *
             * @return A new builder
             */
            static Builder builder() {
                return Sponge.getRegistry().createBuilder(Builder.class);
            }

            /**
             * Retrieves the UUID that this {@link Ref} refers to.
             *
             * @return The UUID
             */
            @Override
            UUID getUniqueId();

            /**
             * Retrieves the name that this {@link Ref} refers to.
             *
             * @return The name
             */
            String getName();

            /**
             * Retrieves the type that this {@link Ref} refers to, if it exists.
             *
             * @return The type, or {@link Optional#empty()}
             */
            Optional<EntityType> getType();

            /**
             * A {@link Ref} builder.
             */
            interface Builder extends ResettableBuilder<Ref, Builder> {

                /**
                 * Sets the entity unique id.
                 *
                 * @param uniqueId The unique id
                 * @return This builder
                 */
                Builder uniqueId(UUID uniqueId);

                /**
                 * Sets the entity name.
                 *
                 * @param name The name
                 * @return This builder
                 */
                Builder name(String name);

                /**
                 * Sets the entity type.
                 *
                 * @param type The type
                 * @return This builder
                 */
                Builder type(@Nullable EntityType type);

                /**
                 * Builds the ref.
                 *
                 * @return The built ref
                 */
                Ref build();
            }
        }
    }
}
