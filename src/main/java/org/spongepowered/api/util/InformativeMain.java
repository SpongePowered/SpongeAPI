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

package org.spongepowered.api.util;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

/**
 * A class containing a main method which throws an Exception to cleanly
 * indicate to the user than running the jar file was a bad idea.
 */
public class InformativeMain {

    private static final String ERROR = "\n\nOh dear... You have just attempted to run the SpongeAPI jar file.\n\nPlease Note: This is the binary for"
                                        + " the API **ONLY** and running it has absolutely no\npurpose nor effect. If you wish to use Sponge you will"
                                        + " need to locate the correct\nimplementation for the platform you wish to run Sponge on.\n\nFor information"
                                        + " on the correct process for running sponge please see the documentation:\n\n\t\tSponge Documentation: http"
                                        + "s://docs.spongepowered.org/\n\nFor more general information on the Sponge project please see the FAQ:\n\n"
                                        + "\t\tSponge FAQ: https://docs.spongepowered.org/en/faq.html\n";

    /**
     * The main method which throws a {@link PEBKACException} with some basic
     * information on how sponge works.
     * 
     * @param args The program args
     * @throws PEBKACException always
     */
    public static void main(String[] args) throws PEBKACException {
        if (!GraphicsEnvironment.isHeadless()) {
            JOptionPane.showMessageDialog(null, ERROR, "PEBKACException!", JOptionPane.ERROR_MESSAGE);
        } else {
            throw new PEBKACException(ERROR);
        }
    }

}
