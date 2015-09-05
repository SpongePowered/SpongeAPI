package org.spongepowered.api.text.template;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class TextArgs {

    private final ImmutableList.Builder<?> positionedArgsBuilder;
    private ImmutableList<?> positionedArgs = null;
    private final ImmutableMap.Builder<String, ?> namedArgsBuilder;
    private  ImmutableMap<String, ?> namedArgs = null;

    TextArgs(ImmutableList.Builder<?> positionedArgs, ImmutableMap.Builder<String, ?> namedArgs) {
        this.positionedArgsBuilder = positionedArgs;
        this.namedArgsBuilder = namedArgs;
    }

    public TextArgs add(Object arg) {
        return new TextArgs(positionedArgsBuilder, namedArgsBuilder);
    }

    public TextArgs with(String name, Object arg) {
        return new TextArgs(positionedArgsBuilder, namedArgsBuilder);
    }

    public Object getPositionedArg(int position) throws IndexOutOfBoundsException {
        if (positionedArgs == null) {
            positionedArgs = positionedArgsBuilder.build();
        }
        return positionedArgs.get(position);
    }

    public Object getNamedArg(String name) throws IllegalArgumentException {
        if (namedArgs == null) {
            namedArgs = namedArgsBuilder.build();
        }
        if (namedArgs.containsKey(name)) {
            throw new IllegalArgumentException("Named arg " + name + " not found");
        }
        return namedArgs.get(name);
    }

}
