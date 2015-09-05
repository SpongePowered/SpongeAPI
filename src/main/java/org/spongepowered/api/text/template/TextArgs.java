package org.spongepowered.api.text.template;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public final class TextArgs {

    private ImmutableList.Builder<Object> positionedArgsBuilder;
    private ImmutableList<Object> positionedArgs = null;
    private ImmutableMap.Builder<String, Object> namedArgsBuilder;
    private ImmutableMap<String, Object> namedArgs = null;

    private TextArgs(ImmutableList.Builder<Object> positionedArgsBuilder,
                     ImmutableMap.Builder<String, Object> namedArgsBuilder) {
        this.positionedArgsBuilder = positionedArgsBuilder;
        this.namedArgsBuilder = namedArgsBuilder;
    }

    public TextArgs add(Object arg) {
        if (positionedArgsBuilder == null) {
            throw new IllegalArgumentException("Positioned arguments were already accessed, to add" +
                "more arguments use TextArgs.copy()");
        }
        positionedArgsBuilder.add(arg);
        return this;
    }

    public TextArgs add(Object... args) {
        if (positionedArgsBuilder == null) {
            throw new IllegalArgumentException("Positioned arguments were already accessed, to add" +
                "more arguments use TextArgs.copy()");
        }
        positionedArgsBuilder.add(args);
        return this;
    }

    public TextArgs with(String name, Object arg) {
        if (positionedArgsBuilder == null) {
            throw new IllegalArgumentException("Named arguments were already accessed, to add" +
                "more arguments use TextArgs.copy()");
        }
        namedArgsBuilder.put(name, arg);
        return this;
    }

    public TextArgs copy() {
        ImmutableList.Builder<Object> newPositionedBuilder = ImmutableList.builder();
        if (positionedArgs == null) {
            newPositionedBuilder.addAll(positionedArgsBuilder.build());
        } else {
            newPositionedBuilder.addAll(positionedArgs);
        }
        ImmutableMap.Builder<String, Object> newNamedBuilder = ImmutableMap.builder();
        if (namedArgs == null) {
            newNamedBuilder.putAll(namedArgsBuilder.build());
        } else {
            newNamedBuilder.putAll(namedArgs);
        }
        return new TextArgs(newPositionedBuilder, newNamedBuilder);
    }

    public Object getPositionedArg(int position) throws IndexOutOfBoundsException {
        if (positionedArgs == null) {
            positionedArgs = positionedArgsBuilder.build();
            positionedArgsBuilder = null;
        }
        return positionedArgs.get(position);
    }

    public Object getNamedArg(String name) throws IllegalArgumentException {
        if (namedArgs == null) {
            namedArgs = namedArgsBuilder.build();
            namedArgsBuilder = null;
        }
        if (namedArgs.containsKey(name)) {
            throw new IllegalArgumentException("Named arg " + name + " not found");
        }
        return namedArgs.get(name);
    }

    public static TextArgs create() {
        return new TextArgs(ImmutableList.builder(), ImmutableMap.<String, Object>builder());
    }

    public static TextArgs of(Object... args) {
        return create().add(args);
    }

}
