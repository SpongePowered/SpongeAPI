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
package org.spongepowered.api.asset;

import com.google.common.io.Resources;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.builtin.jvm.Plugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 * Represents an {@link Asset} within Sponge that belongs to a {@link Plugin}.
 */
public interface Asset {

    /**
     * The default {@link Charset} that is used for reading {@link Asset}s.
     */
    Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    /**
     * Returns the original {@link PluginContainer plugin} owner of this Asset.
     *
     * @return Original owner of asset
     */
    PluginContainer owner();

    /**
     * Returns the {@link URL} to this Asset.
     *
     * @return URL to asset
     */
    URL url();

    /**
     * Copies this Asset to the specified 'output' {@link Path}.
     *
     * @param output Path to copy to
     * @throws IOException If any file exception is thrown
     */
    default void copyToFile(Path output) throws IOException {
        this.copyToFile(output, false);
    }

    /**
     * Copies this Asset to the specified 'output' {@link Path}.
     *
     * @param output Path to copy to
     * @param overwrite If the file should be overwritten if it exists
     * @throws IOException File exception
     */
    default void copyToFile(Path output, boolean overwrite) throws IOException {
        this.copyToFile(output, overwrite, true);
    }

    /**
     * Copies this Asset to the specified 'output' {@link Path}.
     *
     * @param output Path to copy to
     * @param overwrite If the file should be overwritten if it exists
     * @param onlyIfAbsent If the file should only be copied if absent
     * @throws IOException File exception
     */
    default void copyToFile(Path output, boolean overwrite, boolean onlyIfAbsent) throws IOException {
        Objects.requireNonNull(output, "output");
        if (Files.exists(output)) {
            if (overwrite) {
                Files.delete(output);
            } else if (onlyIfAbsent) {
                return;
            }
        }
        try (InputStream in = this.url().openStream()) {
            Files.copy(in, output);
        }
    }

    /**
     * Copies this Asset to the specified 'outputDirectory' {@link Path}.
     *
     * @param outputDirectory The directory to copy to
     * @throws IOException If any file exception is thrown
     */
    default void copyToDirectory(Path outputDirectory) throws IOException {
        this.copyToDirectory(outputDirectory, false);
    }

    /**
     * Copies this Asset to the specified 'outputDirectory' {@link Path}.
     *
     * @param outputDirectory The directory to copy to
     * @param overwrite If the file should be overwritten if it exists
     * @throws IOException File exception
     */
    default void copyToDirectory(Path outputDirectory, boolean overwrite) throws IOException {
        this.copyToDirectory(outputDirectory, overwrite, true);
    }

    /**
     * Copies this Asset to the specified 'outputDirectory' {@link Path}.
     *
     * @param outputDirectory The directory to copy to
     * @param overwrite If the file should be overwritten if it exists
     * @param onlyIfAbsent If the file should only be copied if absent
     * @throws IOException File exception
     */
    default void copyToDirectory(Path outputDirectory, boolean overwrite, boolean onlyIfAbsent) throws IOException {
        Objects.requireNonNull(outputDirectory, "outputDirectory");
        Files.createDirectories(outputDirectory);
        this.copyToFile(outputDirectory.resolve(this.fileName()), overwrite, onlyIfAbsent);
    }

    /**
     * Returns the the last portion of the Asset URL, e.g. the file name.
     *
     * @return The file name
     */
    default String fileName() {
        final String path = this.url().getPath();
        //We don't need to worry about file system specific file separators as we are dealing with a substring of URL
        final int end = path.lastIndexOf('/');
        if (end < 0) {
            return path;
        }

        return path.substring(end + 1);
    }

    /**
     * Reads this Asset in it's entirety as a {@link String} and returns the
     * result.
     *
     * @return String representation of Asset
     * @throws IOException If any file exception is thrown
     */
    default String readString() throws IOException {
        return this.readString(Asset.DEFAULT_CHARSET);
    }

    /**
     * Reads this Asset in it's entirety as a {@link String} and returns the
     * result.
     *
     * @param charset The charset to read the asset with
     * @return String representation of Asset
     * @throws IOException If any file exception is thrown
     */
    default String readString(Charset charset) throws IOException {
        Objects.requireNonNull(charset, "charset");
        return Resources.toString(this.url(), charset);
    }

    /**
     * Reads all lines from the asset and returns the result.
     *
     * @return The lines read from the asset
     * @throws IOException If any file exception is thrown
     */
    default List<String> readLines() throws IOException {
        return this.readLines(Asset.DEFAULT_CHARSET);
    }

    /**
     * Reads all lines from the asset and returns the result.
     *
     * @param charset The charset to read the asset with
     * @return An immutable list of the lines read from the asset
     * @throws IOException If any file exception is thrown
     */
    default List<String> readLines(Charset charset) throws IOException {
        Objects.requireNonNull(charset, "charset");
        return Resources.asCharSource(this.url(), charset).readLines();
    }

    /**
     * Reads this Asset in it's entirety as a byte array and returns the
     * result.
     *
     * @return Byte array representation of Asset
     * @throws IOException If any file exception is thrown
     */
    default byte[] readBytes() throws IOException {
        return Resources.toByteArray(this.url());
    }

}
