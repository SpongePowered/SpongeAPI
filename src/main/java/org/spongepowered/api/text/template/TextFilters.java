package org.spongepowered.api.text.template;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.text.Texts;

public class TextFilters {

    static class FiltersPreconditions {

        static <E> ImmutableList<E> size(ImmutableList<E> that, int size) {
            if (that.size() == size) {
                return that;
            } else {
                throw new IllegalArgumentException(
                    "Given parameter " + that + " has size " + that.size() + ", expected size " + size
                );
            }
        }

    }

    private static class IdentityTextFilter<E> extends TextFilter<TextElement<E>, TextElement<E>> {

        @Override
        public TextElement<E> filter(TextElement<E> prev, ImmutableList<String> args) {
            FiltersPreconditions.size(args, 0);
            return prev;
        }

        @Override
        public ImmutableList<String> serializeArgs(TextElement<E> elem) {
            return ImmutableList.of();
        }

    }

    private static class AlwaysTextFilter<E> extends TextFilter<TextElement<?>, TextElements.AlwaysTextElement<E>> {

        @Override
        public TextElements.AlwaysTextElement<E> filter(TextElement<?> prev, ImmutableList<String> args) {
            FiltersPreconditions.size(args, 1);
            return TextElements.always(Texts.of(args.get(0)));
        }

        @Override
        public ImmutableList<String> serializeArgs(TextElements.AlwaysTextElement<E> elem) {
            return ImmutableList.of(Texts.toPlain(elem.result));
        }

    }


}
