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
package org.spongepowered.api.text.serializer;

import static org.spongepowered.api.data.Queries.TEXT_AUTHOR;
import static org.spongepowered.api.data.Queries.TEXT_PAGE_LIST;
import static org.spongepowered.api.data.Queries.TEXT_TITLE;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.text.BookView;
import org.spongepowered.api.text.Text;

import java.util.List;
import java.util.Optional;

/**
 * An implementation of {@link AbstractDataBuilder} for {@link BookView}.
 */
public class BookViewDataBuilder extends AbstractDataBuilder<BookView> {

    public BookViewDataBuilder() {
        super(BookView.class, 1);
    }

    private Text getText(Object textView) {
        if (!(textView instanceof DataView)) {
            throw new InvalidDataException("Expected DataView");
        }
        return Sponge.getDataManager().deserialize(Text.class, (DataView) textView).get();
    }

    private Optional<Text> findText(DataView container, DataQuery query) {
        if (container.contains(query)) {
            return Optional.of(getText(container.get(query).get()));
        }
        return Optional.empty();
    }

    @Override
    protected Optional<BookView> buildContent(DataView container) throws InvalidDataException {
        BookView.Builder builder = BookView.builder();
        findText(container, TEXT_TITLE).ifPresent(builder::title);
        findText(container, TEXT_AUTHOR).ifPresent(builder::author);
        if (container.contains(TEXT_PAGE_LIST)) {
            Object pageList = container.get(TEXT_PAGE_LIST).get();
            if (!(pageList instanceof List)) {
                throw new InvalidDataException("Expected List");
            }
            ((List<?>) pageList).forEach(textView -> builder.addPage(getText(textView)));
        }
        return Optional.of(builder.build());
    }

}
