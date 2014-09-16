/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.command;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImmutableCommandMappingTest {

    @Test
    public void testGetPrimaryAlias() throws Exception {
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "test").getPrimaryAlias(), is("test"));
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "tEst").getPrimaryAlias(), is("tEst"));
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "test", "example").getPrimaryAlias(), is("test"));
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "tEst", "example").getPrimaryAlias(), is("tEst"));
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "test", "test").getPrimaryAlias(), is("test"));
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "tEst", "test").getPrimaryAlias(), is("tEst"));
    }

    @Test
    public void testGetAllAliases() throws Exception {
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "test").getAllAliases(), hasItems("test"));
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "test", "dudu").getAllAliases(), hasItems("test", "dudu"));
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "test", "dudu", "TeSt").getAllAliases(), hasItems("test", "dudu", "TeSt"));
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "test", "test").getAllAliases(), hasItems("test"));
    }

    @Test
    public void testGetCallable() throws Exception {
        CommandCallable test = mock(CommandCallable.class);
        assertThat(new ImmutableCommandMapping(test, "example").getCallable(), sameInstance(test));
        assertThat(new ImmutableCommandMapping(mock(CommandCallable.class), "example").getCallable(), not(sameInstance(test)));
    }

    @Test
    public void testGetDescription() throws Exception {
        CommandCallable callable1 = mock(CommandCallable.class);
        Description desc1 = mock(Description.class);
        Description desc2 = mock(Description.class);
        when(callable1.getDescription()).thenReturn(desc1);

        assertThat(new ImmutableCommandMapping(callable1, "example").getDescription(), sameInstance(desc1));
        assertThat(new ImmutableCommandMapping(callable1, "example").getDescription(), not(sameInstance(desc2)));
    }

}