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
package org.spongepowered.api.world.volume.stream;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.math.vector.Vector3i;

public interface StreamOptions {

    public static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    public static StreamOptions lazily() {
        return StreamOptions.builder().setCarbonCopy(false).setLoadingStyle(LoadingStyle.LAZILY_UNGENERATED).build();
    }

    public static StreamOptions forceLoadedAndCopied() {
        return StreamOptions.builder().setCarbonCopy(true).setLoadingStyle(LoadingStyle.FORCED_GENERATED).build();
    }

    enum LoadingStyle {
        /**
         * Forces the loading of the entire area to calculate the exact
         * available sections to fetch the predefined stream of elements
         * to populate the {@link VolumeStream}. This will incur an initial
         * cost of {@link World#loadChunk(Vector3i, boolean)}
         * with {@code shouldGenerate = }{@link #generateArea()}.
         */
        FORCED_GENERATED {
            @Override
            public boolean generateArea() {
                return true;
            }

            @Override
            public boolean immediateLoading() {
                return true;
            }
        },
        /**
         * Forces the loading of the entire area to calculate the exact
         * available sections to fetch the predefined stream of elements
         * to populate the {@link VolumeStream}. This will incur an initial
         * cost of {@link World#loadChunk(Vector3i, boolean)}
         * with {@code shouldGenerate = }{@link #generateArea()}.
         */
        FORCED_UNGENERATED {
            @Override
            public boolean generateArea() {
                return false;
            }

            @Override
            public boolean immediateLoading() {
                return true;
            }
        },
        /**
         * Ensures that sections within the area are loaded during stream
         * execution, but unlike {@link #FORCED_GENERATED}, sections will only be
         * loaded during {@link VolumeStream} execution if and when the
         * section is iterated over, and not pre-loaded beforehand.
         *
         * <p>In the case of a {@link World},
         * this will still issue a request for a {@link World#loadChunk(int, int, int, boolean)}
         * with {@code shouldGenerate = }{@link #generateArea()}.
         */
        LAZILY_UNGENERATED {
            @Override
            public boolean generateArea() {
                return false;
            }

            @Override
            public boolean immediateLoading() {
                return false;
            }
        },
        /**
         * Ensures that sections within the area are loaded during stream
         * execution, but unlike {@link #FORCED_GENERATED}, sections will only be
         * loaded during {@link VolumeStream} execution if and when the
         * section is iterated over, and not pre-loaded beforehand.
         *
         * <p>In the case of a {@link World},
         * this will still issue a request for a {@link World#loadChunk(int, int, int, boolean)}
         * with {@code shouldGenerate = }{@link #generateArea()}.
         */
        LAZILY_GENERATED {
            @Override
            public boolean generateArea() {
                return true;
            }

            @Override
            public boolean immediateLoading() {
                return false;
            }
        },
        /**
         * Only requests the available sections of the {@link Volume}
         * without incurring any loading of sections costs, useful for
         * building streams of available elements.
         */
        NONE {
            @Override
            public boolean generateArea() {
                return false;
            }

            @Override
            public boolean immediateLoading() {
                return false;
            }
        },
        ;
        /**
         * Whether areas are to be requested to be generated prior to streaming
         * over them, somewhat in tandem with {@link LoadingStyle}, a section can
         * potentially be un-generated and having never been visited before, may
         * be requested to be generated in order for the stream's element type to
         * be operated on. This should incur an additional cost of the stream setup,
         * based on the {@link LoadingStyle}'s request such as {@link LoadingStyle#FORCED_GENERATED},
         * or {@link LoadingStyle#LAZILY_GENERATED}.
         *
         * @return Whether sections that are previously empty, should be generated
         */
        public abstract boolean generateArea();
        public abstract boolean immediateLoading();
    }

    /**
     * Whether a carbon copy of the area requested for the stream will be
     * offloaded into a separated {@link Volume} such that the stream would
     * be unaffected by other operations being performed in the targeted
     * {@link Volume} (like block replacements). This may be expensive to
     * perform overall on a larger scale, but effectively can be safer to
     * perform sensitive filtering operations.
     *
     * @return True if a copy of the volume's stream targets will be made
     */
    boolean carbonCopy();

    /**
     * Determines the loading style of sections to populate elements for a Stream,
     * such that the area may be pre-calculated or the elements precalculated based
     *
     * refer
     * @return
     */
    LoadingStyle loadingStyle();

    interface Builder extends ResettableBuilder<StreamOptions, Builder> {

        Builder setCarbonCopy(boolean copies);

        Builder setLoadingStyle(LoadingStyle style);

        StreamOptions build();

    }
}
