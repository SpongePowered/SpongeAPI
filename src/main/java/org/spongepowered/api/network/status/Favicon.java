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
package org.spongepowered.api.network.status;

import org.spongepowered.api.Sponge;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;

/**
 * Represents an icon for the server sent in the {@link StatusResponse}.
 */
public interface Favicon {

    /**
     * Loads a {@link Favicon} from the specified encoded string. The format of
     * the input depends on the implementation.
     *
     * @param raw The encoded favicon
     * @return The loaded favicon
     * @throws IOException If the favicon couldn't be loaded
     */
    static Favicon load(String raw) throws IOException {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).load(raw);
    }

    /**
     * Loads a favicon from a specified {@link Path}.
     *
     * @param path The path to the favicon
     * @return The loaded favicon from the file
     * @throws IOException If the favicon couldn't be loaded
     * @throws FileNotFoundException If the file doesn't exist
     */
    static Favicon load(Path path) throws IOException {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).load(path);
    }

    /**
     * Loads a favicon from a specified {@link URL}.
     *
     * @param url The favicon URL
     * @return The loaded favicon from the URL
     * @throws IOException If the favicon couldn't be loaded
     */
    static Favicon load(URL url) throws IOException {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).load(url);
    }

    /**
     * Loads a favicon from a specified {@link InputStream}.
     *
     * @param in The favicon input stream
     * @return The loaded favicon from the input stream
     * @throws IOException If the favicon couldn't be loaded
     */
    static Favicon load(InputStream in) throws IOException {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).load(in);
    }

    /**
     * Loads a favicon from a specified {@link BufferedImage}.
     *
     * @param image The favicon image
     * @return The loaded favicon from the image
     * @throws IOException If the favicon couldn't be loaded
     */
    static Favicon load(BufferedImage image) throws IOException {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).load(image);
    }

    /**
     * Gets the decoded image of this favicon.
     *
     * @return The decoded image
     */
    BufferedImage getImage();

    interface Factory {

        Favicon load(String raw);

        Favicon load(Path path);

        Favicon load(URL url);

        Favicon load(InputStream in);

        Favicon load(BufferedImage image);
    }
}
