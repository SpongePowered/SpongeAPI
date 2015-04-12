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
package org.spongepowered.api.service.command;


import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.ArgumentParseException;
import org.spongepowered.api.util.command.args.CommandArgs;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.args.CommandElement;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

public class GameArguments {
    private GameArguments() {}

    private static Text t(String input) {
        return Texts.of(input);
    }

    /**
     * Expect an argument to represent an online player.
     *
     * @param key The key to store under
     * @param game The game to find players in
     * @return the argument
     */
    public static CommandElement player(Text key, Game game) {
        return new PlayerCommandElement(key, game);
    }

    private static class PlayerCommandElement extends CommandElement {
        private final Game game;

        protected PlayerCommandElement(Text key, Game game) {
            super(key);
            this.game = game;
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            // TODO: Make player name resolution better -- support selectors, etc
            final String playerName = args.next();
            Optional<Player> ret;
            try {
                UUID playerUuid = UUID.fromString(playerName);
                ret = this.game.getServer().getPlayer(playerUuid);
            } catch (IllegalArgumentException ex) {
                ret = this.game.getServer().getPlayer(playerName);
            }
            if (!ret.isPresent()) {
                throw args.createError(t("No matching players found!"));
            } else {
                return ret.get();
            }
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Iterable<String> players = Iterables.transform(this.game.getServer().getOnlinePlayers(), new Function<Player, String>() {
                @Nullable
                @Override
                public String apply(@Nullable Player input) {
                    return input == null ? null : input.getName();
                }
            });
            final Optional<String> nextArg = args.nextIfPresent();
            if (nextArg.isPresent()) {
                players = Iterables.filter(players, new StartsWithPredicate(nextArg.get()));
            }
            return ImmutableList.copyOf(players);
        }
    }

    /**
     * Expect an argument to represent a world.
     *
     * @param key The key to store under
     * @param game The game to find worlds from
     * @return the argument
     */
    public static CommandElement world(Text key, Game game) {
        return new WorldCommandElement(key, game);
    }

    private static class WorldCommandElement extends CommandElement {
        private final Game game;

        protected WorldCommandElement(Text key, Game game) {
            super(key);
            this.game = game;
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return null;
        }
    }

    /**
     * Expect an argument to represent a {@link Vector3d}.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement vector3d(Text key) {
        return new Vector3dCommandElement(key);
    }

    private static class Vector3dCommandElement extends CommandElement {

        protected Vector3dCommandElement(Text key) {
            super(key);
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return null;
        }
    }

    /**
     * Expect an argument to represent a location.
     *
     * @param key The key to store under
     * @param game The game to find worlds from
     * @return the argument
     */
    public static CommandElement location(Text key, Game game) {
        return new LocationCommandElement(key, game);
    }

    private static class LocationCommandElement extends CommandElement {
        private final Game game;

        protected LocationCommandElement(Text key, Game game) {
            super(key);
            this.game = game;
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return null;
        }
    }

    /**
     * Expect an argument that is a member of the specified catalog type.
     *
     * @param key The key to store the resolved value under
     * @param game The game to get the registry from
     * @param catalogType The type expected
     * @param <T> The type to return
     * @return the argument
     */
    public static <T extends CatalogType> CommandElement catalogedElement(Text key, Game game, Class<T> catalogType) {
        return new CatalogedTypeCommandElement<T>(key, game, catalogType);
    }

    private static class CatalogedTypeCommandElement<T extends CatalogType> extends CommandElement {
        private final Game game;
        private final Class<T> catalogType;

        protected CatalogedTypeCommandElement(Text key, Game game, Class<T> catalogType) {
            super(key);
            this.game = game;
            this.catalogType = catalogType;
        }

        @Override
        protected T parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Optional<T> potentialRet = this.game.getRegistry().getType(this.catalogType, args.next());
            if (!potentialRet.isPresent()) {
                throw args.createError(t(""));
            }
            return potentialRet.get();
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Iterable<String> ret = Iterables.transform(this.game.getRegistry().getAllOf(this.catalogType), new Function<T, String>() {
                @Nullable
                @Override
                public String apply(@Nullable T input) {
                    return input == null ? null : input.getId(); // TODO: ids or names?
                }
            });
            final Optional<String> next = args.nextIfPresent();
            if (next.isPresent()) {
                ret = Iterables.filter(ret, new StartsWithPredicate(next.get()));
            }
            return ImmutableList.copyOf(ret);
        }
    }

}
