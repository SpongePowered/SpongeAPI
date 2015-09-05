package org.spongepowered.api.text.template;

import org.spongepowered.api.text.Text;

public abstract class TextArg<T> {

    protected final TextElement<T> element;

    public TextArg(TextElement<T> element) {
        this.element = element;
    }

    public TextElement<T> getElement() {
        return this.element;
    }

    public abstract Text lookup(TextArgs args);

    static final class Named<T> extends TextArg<T> {

        private final String name;

        public Named(String name, TextElement<T> element) {
            super(element);
            this.name = name;
        }

        @Override
        public Text lookup(TextArgs args) {
            @SuppressWarnings("unchecked") T arg = (T) args.getNamedArg(name);
            return element.create(arg);
        }

    }

    static final class Pos<T> extends TextArg<T> {

        private final int position;

        public Pos(int position, TextElement<T> element) {
            super(element);
            this.position = position;
        }

        @Override
        public Text lookup(TextArgs args) {
            @SuppressWarnings("unchecked") T arg = (T) args.getPositionedArg(position);
            return element.create(arg);
        }

    }
}
