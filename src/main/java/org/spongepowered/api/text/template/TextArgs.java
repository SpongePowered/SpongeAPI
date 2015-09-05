package org.spongepowered.api.text.template;

import com.google.common.base.Optional;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.translation.Translatable;

import java.util.Iterator;

public final class TextArgs {

    public static Text DEFAULT_SEPARATOR = Texts.of(", ");

    public static <T extends Translatable> TextArg<T> translatable() {
        return new TextArg<T>() {
            @Override
            public Optional<? extends Text> create(T value) {
                return Optional.of(Texts.of(value));
            }
        };
    }

    public static <T extends Text> TextArg<T> identity() {
        return new TextArg<T>() {
            @Override
            public Optional<? extends Text> create(T value) {
                return Optional.of(value);
            }
        };
    }

    public static TextArg<Player> playerDisplayName() {
        return new TextArg<Player>() {
            @Override
            public Optional<? extends Text> create(Player player) {
                return player.get(Keys.DISPLAY_NAME);
            }
        };
    }

    public static <E> TextArg<Optional<E>> optional(final TextArg<E> singleArg) {
        return new TextArg<Optional<E>>() {
            @Override
            public Optional<? extends Text> create(Optional<E> value) {
                if (value.isPresent()) {
                    return singleArg.create(value.get());
                } else {
                    return Optional.absent();
                }
            }
        };
    }

    public static <E> TextArg<Iterator<E>> iterator(final TextArg<E> singleArg, final Text separator) {
        return new TextArg<Iterator<E>>() {
            @Override
            public Optional<? extends Text> create(Iterator<E> iterator) {
                TextBuilder builder = Texts.builder();
                boolean first = true;
                while (iterator.hasNext()) {
                    Optional<? extends Text> textOpt = singleArg.create(iterator.next());
                    if (textOpt.isPresent()) {
                        if (!first) {
                            builder.append(separator);
                        }
                        first = false;
                        builder.append(textOpt.get());
                    }
                }
                return Optional.of(builder.build());
            }
        };
    }

    public static <E> TextArg<Iterator<E>> iterator(final TextArg<E> singleArg) {
        return iterator(singleArg, DEFAULT_SEPARATOR);
    }

    public static <E> TextArg<Iterable<E>> iterable(final TextArg<E> singleArg, final Text separator) {
        return new TextArg<Iterable<E>>() {
            @Override
            public Optional<? extends Text> create(Iterable<E> value) {
                return iterator(singleArg, separator).create(value.iterator());
            }
        };
    }

    public static <E> TextArg<Iterable<E>> iterable(final TextArg<E> singleArg) {
        return iterable(singleArg, DEFAULT_SEPARATOR);
    }

}
