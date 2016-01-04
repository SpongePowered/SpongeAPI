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
package org.spongepowered.gradle

import com.google.common.io.Files
import org.gradle.api.DefaultTask
import org.gradle.api.InvalidUserDataException
import org.gradle.api.tasks.SourceSet

import java.io.File
import java.io.ObjectInputStream.ValidationList
import java.nio.charset.Charset
import java.util.Map
import java.util.Map.Entry
 
class TaskSortClassMembers extends DefaultTask {
    
    def newline = sprintf("%n")
    def modifiers = ~/^\s*((public|protected|private|static|abstract|final|synchronized|transient|native|volatile)\s+)+/
    def identifier = ~/^(.*?\s)(\p{javaJavaIdentifierStart}\p{javaJavaIdentifierPart}*\s*)$/
    def semaphores = ~/\/\/\s*SORTFIELDS\s*:\s*(ON|OFF)/
    
    class Field implements Comparable<Field> {
        static int nextIndex
        
        def comment = []
        def modifiers = ""
        def type = ""
        def name = ""
        def initialiser = ""
        def index
        
        Field() {
            this.index = Field.nextIndex++
        }
        
        boolean isValid() {
            modifiers != "" && type != "" && name != "" && initialiser != ""
        }
        
        String flush() {
            String commentBlock = ""
            for (commentLine in comment) {
                commentBlock <<= commentLine << newline
            }
            commentBlock
        }
        
        @Override
        String toString() {
            this.flush() << modifiers << type << name << initialiser
        }
        
        @Override
        int compareTo(Field other) {
            int diff = this.name.compareTo(other.name)
            return (diff == 0) ? this.index - other.index : diff 
        }
    }
    
    void process(String resourceName) {
        this.process("main", resourceName)
    }
    
    void process(String sourceSetName, String resourceName) {
        SourceSet sourceSet = project.sourceSets.findByName(sourceSetName)
        if (!sourceSet) {
            throw new InvalidUserDataException("Could not find specified sourceSet '${sourceSetName} for task")
        }
        this.process(sourceSet, resourceName)
    }
    
    void process(SourceSet sourceSet, String resourceName) {
        if (!sourceSet instanceof SourceSet) {
            throw new InvalidUserDataException("${sourceSet} is not a SourceSet")
        }
        
        if (!resourceName) {
            throw new InvalidUserDataException("${resourceName} is not a valid resource name")
        }

        def foundResource = false        
        def resourceFileName = sprintf("%s.java", resourceName.replace(".", File.separator))
        
        sourceSet.allJava.srcDirs.each { srcDir ->
            def sourceFile = new File(srcDir, resourceFileName)
            if (sourceFile.exists()) {
                foundResource = true
                this.sortMembers(sourceFile)
            } 
        }
        
        if (!foundResource) {
            throw new InvalidUserDataException("${resourceName} could not be found")
        }
    }
    
    void sortMembers(File file) {
        project.logger.lifecycle "Sorting members in {}", file
        
        def active = false
        def output = ""
        def fields = new TreeSet<Field>()
        def current = new Field()
        
        for (String line : Files.readLines(file, Charset.defaultCharset())) {
            def semaphore = line =~ semaphores
            if (semaphore) {
                if ("OFF" == semaphore.group(1) && active) {
                    for (field in fields) {
                        output <<= newline << field << newline
                    }
                    if (fields.size()) {
                        output <<= newline
                    }
                    fields.clear()
                }
                active = "ON" == semaphore.group(1)
                output <<= line << newline
                continue
            }
            if (!active) {
                output <<= line << newline
                continue
            } else if (!line) {
                continue
            }
            
            def match = line =~ modifiers
            if (match) {
                current.modifiers = match.group()
                def assignmentPos = line.indexOf("=")
                def typeAndName = line.substring(current.modifiers.length(), assignmentPos)
                current.initialiser = line.substring(assignmentPos)
                def idMatch = typeAndName =~ identifier
                if (idMatch) {
                    current.type = idMatch.group(1)
                    current.name = idMatch.group(2)
                    fields += current
                } else {
                    output << current.flush()
                }
                current = new Field()
            } else {
                current.comment += line
            }
        }
        
        Files.write(output, file, Charset.defaultCharset())
    }

}
