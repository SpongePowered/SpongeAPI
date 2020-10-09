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
package org.spongepowered.api.util.file;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/**
 * Represents a {@link FileVisitor} which will create a copy of a directory
 * and its contents.
 *
 * <p>Example usage:<br>
 * {@code Files.walkFileTree(dir, new CopyFileVisitor(target);}</p>
 */
public final class CopyFileVisitor extends SimpleFileVisitor<Path> {

    private final Path target;
    private final CopyOption[] options;
    @Nullable private Path source;

    /**
     * Constructs a new {@link CopyFileVisitor} which will copy the visited
     * file paths to the specified target directory.
     *
     * <p><b>Note:</b> The target directory must not exist since the visitor
     * will also copy the root directory to the specified location.</p>
     *
     * @param target The path to copy the visited files to
     * @param options Optional options for the copy operations
     */
    public CopyFileVisitor(Path target, CopyOption... options) {
        this.target = Objects.requireNonNull(target, "target");
        this.options = Objects.requireNonNull(options, "options");
    }

    private void copy(Path source, Path dest) throws IOException {
        Files.copy(source, dest, this.options);
    }

    private void copy(Path sourcePath) throws IOException {
        copy(sourcePath, this.target.resolve(this.source.relativize(sourcePath)));
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        // Don't copy target folder itself if it is part of the source folder
        if (this.target.equals(dir)) {
            return FileVisitResult.SKIP_SUBTREE;
        }

        if (this.source == null) {
            this.source = dir;
            copy(dir, this.target);
        } else {
            copy(dir);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        copy(file);
        return FileVisitResult.CONTINUE;
    }

}
