package org.spongepowered.api.text.template;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.translation.Translatable;

import java.util.Iterator;

public final class TextArgs {

    public static Text DEFAULT_SEPARATOR = Texts.of(", ");

    public static TextArg<Text> identity() {
        return new TextArg<Text>() {
            @Override
            public Text create(Text value) {
                return value;
            }
        };
    }

    public static <T> TextArg<T> always(final Text text) {
        return new TextArg<T>() {
            @Override
            public Text create(T value) {
                return text;
            }
        };
    }

    public static <T> TextArg<T> function(final Function<T, Text> function) {
        return new TextArg<T>() {
            @Override
            public Text create(T value) {
                return Preconditions.checkNotNull(function.apply(value));
            }
        };
    }

    public static <E> TextArg<Optional<E>> optional(final TextArg<E> singleArg) {
        return new TextArg<Optional<E>>() {
            @Override
            public Text create(Optional<E> value) {
                if (value.isPresent()) {
                    return singleArg.create(value.get());
                } else {
                    return Texts.of();
                }
            }
        };
    }

    public static <E> TextArg<Iterator<E>> iterator(final TextArg<E> singleArg, final Text separator) {
        return new TextArg<Iterator<E>>() {
            @Override
            public Text create(Iterator<E> iterator) {
                TextBuilder builder = Texts.builder();
                boolean first = true;
                while (iterator.hasNext()) {
                    Text next = singleArg.create(iterator.next());
                    if (!next.isEmpty()) {
                        if (!first) {
                            builder.append(separator);
                        }
                        first = false;
                        builder.append(next);
                    }
                }
                return builder.build();
            }
        };
    }

    public static <E> TextArg<Iterator<E>> iterator(final TextArg<E> singleArg) {
        return iterator(singleArg, DEFAULT_SEPARATOR);
    }

    public static <E> TextArg<Iterable<E>> iterable(final TextArg<E> singleArg, final Text separator) {
        return new TextArg<Iterable<E>>() {
            @Override
            public Text create(Iterable<E> value) {
                return iterator(singleArg, separator).create(value.iterator());
            }
        };
    }

    public static <E> TextArg<Iterable<E>> iterable(final TextArg<E> singleArg) {
        return iterable(singleArg, DEFAULT_SEPARATOR);
    }

    public static <T> TextArg<T> fallback(final TextArg<T> thatArg, final TextArg<T> fallbackArg) {
        return new TextArg<T>() {
            @Override
            public Text create(T value) {
                Text result = thatArg.create(value);
                if (result.isEmpty()) {
                    return fallbackArg.create(value);
                } else {
                    return result;
                }
            }
        };
    }

    public static <T> TextArg<T> fallback(final TextArg<T> thatArg, final Text fallback) {
        return new TextArg<T>() {
            @Override
            public Text create(T value) {
                Text result = thatArg.create(value);
                if (result.isEmpty()) {
                    return fallback;
                } else {
                    return result;
                }
            }
        };
    }

    public static <T extends Translatable> TextArg<T> translatable() {
        return new TextArg<T>() {
            @Override
            public Text create(T value) {
                return Texts.of(value);
            }
        };
    }

    public static TextArg<Player> playerDisplayName() {
        return new TextArg<Player>() {
            @Override
            public Text create(Player player) {
                return player.get(Keys.DISPLAY_NAME).or(Texts.of());
            }
        };
    }

}
