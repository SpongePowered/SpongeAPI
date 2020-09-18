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
package org.spongepowered.api.command.parameter.managed;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Represents a flag on a {@link Command}
 *
 * <p>A flag is a parameter is either:</p>
 *
 * <ul>
 *     <li>a single dash, follows by a single character (e.g. {@code -a}, or
 *     </li>
 *     <li>two dashes, followed by multiple characters (e.g. {@code --all}).</li>
 * </ul>
 *
 * <p>In both cases, a flag may have an execution requirement upon them
 * restricting who may use the flag (typically a permission) and/or an
 * associated {@link Parameter} that occurs after the flag definition, which
 * may or may not be optional. Flags may be specified more than once in a
 * command string, but may only appear at the beginning of a {@link Command}.
 * For {@link Parameter.Subcommand}s, this is directly after the literal which
 * starts that subcommand.</p>
 *
 * <p>To check whether the flag was specified in the command, call
 * {@link CommandContext#getFlagInvocationCount(String)}, where the string is a
 * flag's alias without the preceding dashes.</p>
 */
public interface Flag {

    /**
     * Gets a {@link Builder} for creating a {@link Flag}
     *
     * @return A {@link Builder}
     */
    static Flag.Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Flag.Builder.class);
    }

    /**
     * Create a new, parameter-less {@link Flag} with the supplied aliases.
     *
     * @param aliases Flag aliases
     * @return A new {@link Flag}
     */
    static Flag of(final String... aliases) {
        return Flag.builder().aliases(aliases).build();
    }

    /**
     * Create a new {@link Flag} with the supplied parameter and aliases.
     *
     * @param parameter The parameter to parse after this flag
     * @param aliases Flag aliases
     * @return A new {@link Flag}
     */
    static Flag of(final Parameter parameter, final String... aliases) {
        return Flag.builder().aliases(aliases).setParameter(parameter).build();
    }

    /**
     * Gets the aliases that were supplied to this flag.
     *
     * <p>Aliases returned here will <strong>not</strong> be prefixed with the
     * appropriate dashes.</p>
     */
    Collection<String> getUnprefixedAliases();

    /**
     * Gets the aliases that this flag will act upon.
     *
     * <p>Aliases returned here <strong>will</strong> be prefixed with the
     * appropriate dashes.</p>
     *
     * @return The aliases.
     */
    Collection<String> getAliases();

    /**
     * Gets the {@link Predicate} that will be checked in order for this flag
     * to be usable by a {@link CommandCause}
     *
     * @return The {@link Predicate}
     */
    Predicate<CommandCause> getRequirement();

    /**
     * Gets the {@link Parameter} that should be parsed if this flag is
     * invoked.
     *
     * <p>This parameter may be optional if it exists.</p>
     *
     * @return The {@link Parameter}, if it exists.
     */
    Optional<Parameter> getAssociatedParameter();

    /**
     * A builder for creating {@link Flag}s.
     */
    interface Builder extends ResettableBuilder<Flag, Builder> {

        /**
         * Specifies an alias for this flag. The alias must not start with a
         * dash, this will be handled by the builder.
         *
         * <p>If the alias is a single character, a single dash will be prefixed
         * to the alias (e.g. an alias of {@code a} will become {@code -a} upon
         * invocation. Otherwise, two dashes will be prefixed to the alias (e.g.
         * {@code all} will become {@code --all}.</p>
         *
         * @param alias The alias that this flag will have
         * @return This builder, for chaining
         */
        Builder alias(String alias);

        /**
         * Specify multiple aliases at once for this flag.
         *
         * <p>The requirements for each alias are described
         * in {@link #alias(String)}</p>
         *
         * @param aliases The aliases to add
         * @return This builder, for chaining
         */
        default Builder aliases(final String... aliases) {
            return this.aliases(Arrays.asList(aliases));
        }

        /**
         * Specify multiple aliases at once for this flag.
         *
         * <p>The requirements for each alias are described
         * in {@link #alias(String)}</p>
         *
         * @param aliases The aliases to add
         * @return This builder, for chaining
         */
        Builder aliases(Iterable<String> aliases);

        /**
         * Specifies the permission required to use this flag. A null permission
         * indicates that anyone will be able to use the flag.
         *
         * <p>This will overwrite anything provided in
         * {@link #setRequirement(Predicate)}</p>
         *
         * @param permission The permission to check for
         * @return This builder, for chaining
         */
        Builder setPermission(@Nullable String permission);

        /**
         * Specifies the requirement to use this flag. A null requirement
         * indicates that anyone will be able to use the flag.
         *
         * <p>This will overwrite anything provided in
         * {@link #setPermission(String)}</p>
         *
         * @param requirement A {@link Predicate} that checks whether a
         *      {@link CommandCause} meets the requirement for invocation.
         * @return This builder, for chaining
         */
        Builder setRequirement(@Nullable Predicate<CommandCause> requirement);

        /**
         * Sets a {@link Parameter} that may be executed after the flag.
         *
         * <p>This will allow you to set a parameter that is conditional on
         * this flag being specified. It is always required directly after the
         * flag, separated by a space. Thus, setting this on a flag will result
         * in the usage of form:</p>
         *
         * <pre>--flag &lt;parameter&gt;</pre>
         *
         * <p>The {@link Parameter} may be optional and may have its own
         * requirements like any standard parameter. It is important to note,
         * however, that as a flag may be invoked more than once, a
         * {@link CommandContext} may also have more than one entry under the
         * given {@link Parameter.Key}.</p>
         *
         * @param parameter The parameter to parse after this flag
         * @return This builder, for chaining
         */
        Builder setParameter(@Nullable Parameter parameter);

        /**
         * Validates this builder and builds this {@link Flag}.
         *
         * @return A {@link Flag}
         * @throws IllegalStateException if no key or no alias is specified
         */
        Flag build() throws IllegalStateException;

    }

}
