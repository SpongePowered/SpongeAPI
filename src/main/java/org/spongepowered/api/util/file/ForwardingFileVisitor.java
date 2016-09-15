package org.spongepowered.api.util.file;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public abstract class ForwardingFileVisitor<T> implements FileVisitor<T> {

    private final FileVisitor<T> visitor;

    protected ForwardingFileVisitor(FileVisitor<T> visitor) {
        this.visitor = checkNotNull(visitor, "visitor");
    }

    @Override
    public FileVisitResult preVisitDirectory(T dir, BasicFileAttributes attrs) throws IOException {
        return this.visitor.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(T file, BasicFileAttributes attrs) throws IOException {
        return this.visitor.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(T file, IOException exc) throws IOException {
        return this.visitor.visitFileFailed(file, exc);
    }

    @Override
    public FileVisitResult postVisitDirectory(T dir, IOException exc) throws IOException {
        return this.visitor.postVisitDirectory(dir, exc);
    }

}
