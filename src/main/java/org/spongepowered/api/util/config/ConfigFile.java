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

package org.spongepowered.api.util.config;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.io.Closer;
import com.google.common.io.Files;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigList;
import com.typesafe.config.ConfigMergeable;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigOrigin;
import com.typesafe.config.ConfigRenderOptions;
import com.typesafe.config.ConfigResolveOptions;
import com.typesafe.config.ConfigValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * A representation of a configuration file that exists on disk, backed by
 * the Typesafe Config library. Instances are immutable, to mirror the
 * behavior of {@link Config}. Convenience methods are provided to save the
 * configuration back to disk.
 *
 * <p>Defaults can be provided by calling
 * {@link #withFallback(ConfigMergeable)}, which will return a new
 * instance combining the loaded configuration and the fallback configuration.
 * Calling a save method on this new instance will save the combined
 * configuration to disk, which means that defaults can be written to
 * the configuration file that the user would edit.</p>
 *
 * <p>Comments on configuration entries are fully supported, which are to
 * appear before each configuration entry on the line prior. These comments
 * persist even after write and read cycles. Comments from the fallback
 * configurations (if any) will also carry over, although they will not
 * override any comments that the user may have written his or herself.</p>
 *
 * <p>Instances can be constructed using {@link #parseFile(File)}.</p>
 */
public final class ConfigFile implements Config {

    private static final Logger log = LoggerFactory.getLogger(ConfigFile.class);

    private static final Charset CHARSET = Charset.forName("UTF-8");
    private static final ConfigRenderOptions DEFAULT_OPTIONS = ConfigRenderOptions.defaults()
            .setComments(true)
            .setFormatted(true)
            .setJson(false)
            .setOriginComments(false);

    private final File file;
    private final Config config;

    /**
     * Create a new instance.
     *
     * @param file The file
     * @param config The configuration
     */
    private ConfigFile(File file, Config config) {
        checkNotNull(file);
        checkNotNull(config);
        
        this.file = file;
        this.config = config;
    }

    /**
     * Render the configuration as HOCON.
     *
     * @return The rendered HOCON
     */
    protected String render() {
        return config.root().render(DEFAULT_OPTIONS);
    }

    /**
     * Helper method to clone this object with a new configuration.
     *
     * @param config The new configuration
     * @return A new instance
     */
    protected ConfigFile withConfig(Config config) {
        return new ConfigFile(file, config);
    }

    /**
     * Save the combined configuration (fallback configuration + loaded from
     * disk) to disk.
     *
     * <p>If {@code onlyIfChanged} is true, then the configuration will
     * only be written to disk if changes are detected. A "best effort" attempt
     * will be made to detect whether changes have been made to the
     * configuration, but there is no guarantee that a save will not occur if
     * are no changes were made. However, if changes were made, then it is
     * guaranteed that the configuration data will be written to disk.</p>
     *
     * <p>Any parent directories that do not yet exist will be created
     * automatically.</p>
     *
     * @param onlyIfChanged True to not write if no changes are detected
     * @throws IOException Thrown on write error
     * @see #save(boolean) Convenience method to ignore errors
     */
    private void write(boolean onlyIfChanged) throws IOException {
        String renderedString = render();

        if (onlyIfChanged && file.exists()) {
            List<String> original = Files.readLines(file, CHARSET);
            List<String> rendered = Arrays.asList(renderedString.split("[\r\n]"));

            if (!listEquals(original, rendered)) {
                write(renderedString);
            }
        } else {
            write(renderedString);
        }
    }

    /**
     * Save the combined configuration (fallback configuration + loaded from
     * disk) to disk.
     *
     * <p>If {@code onlyIfChanged} is true, then the configuration will
     * only be written to disk if changes are detected. A "best effort" attempt
     * will be made to detect whether changes have been made to the
     * configuration, but there is no guarantee that a save will not occur if
     * are no changes were made. However, if changes were made, then it is
     * guaranteed that the configuration data will be written to disk.</p>
     *
     * <p>Errors that occur will be written to the log and not throw an
     * exception.</p>
     *
     * <p>Any parent directories that do not yet exist will be created
     * automatically.</p>
     *
     * @param onlyIfChanged True to not write if no changes are detected
     * @see #write(boolean) Exceptions are thrown on error
     */
    public void save(boolean onlyIfChanged) {
        try {
            write(onlyIfChanged);
        } catch (IOException e) {
            log.warn("Failed to write configuration", e);
        }
    }

    /**
     * Write the given data to the file.
     *
     * <p>Any parent directories that do not yet exist will be created
     * automatically.</p>
     *
     * @param renderedString The data
     * @throws IOException On write error
     */
    private void write(String renderedString) throws IOException {
        //noinspection ResultOfMethodCallIgnored
        file.getParentFile().mkdirs();

        Closer closer = Closer.create();
        try {
            BufferedWriter bw = closer.register(Files.newWriter(file, CHARSET));
            bw.write(renderedString);
        } finally {
            closer.close();
        }
    }

    /**
     * Compare two lists to see whether they are equal, using a shallow check
     * between entries using {@link Object#equals(Object)}.
     *
     * @param list1 The first list
     * @param list2 The second list
     * @return True if the two lists are equal
     */
    private static boolean listEquals(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        } else {
            Iterator<String> it2 = list2.iterator();
            for (String compare : list1) {
                if (!compare.equals(it2.next())) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * Parse a file and create a new instance.
     *
     * @param file The file
     * @return A new instance
     */
    public static ConfigFile parseFile(File file) {
        checkNotNull(file);
        Config config = ConfigFactory.parseFile(file);
        return new ConfigFile(file, config);
    }

    @Override
    public ConfigObject root() {
        return config.root();
    }

    @Override
    public ConfigOrigin origin() {
        return config.origin();
    }

    @Override
    public ConfigFile withFallback(ConfigMergeable other) {
        return withConfig(config.withFallback(other));
    }

    public ConfigFile withFallback(URL url) {
        return withFallback(ConfigFactory.parseURL(url));
    }

    @Override
    public ConfigFile resolve() {
        return withConfig(config.resolve());
    }

    @Override
    public ConfigFile resolve(ConfigResolveOptions options) {
        return withConfig(config.resolve(options));
    }

    @Override
    public boolean isResolved() {
        return config.isResolved();
    }

    @Override
    public ConfigFile resolveWith(Config source) {
        return withConfig(config.resolveWith(source));
    }

    @Override
    public ConfigFile resolveWith(Config source, ConfigResolveOptions options) {
        return withConfig(config.resolveWith(source, options));
    }

    @Override
    public void checkValid(Config reference, String... restrictToPaths) {
        config.checkValid(reference, restrictToPaths);
    }

    @Override
    public boolean hasPath(String path) {
        return config.hasPath(path);
    }

    @Override
    public boolean isEmpty() {
        return config.isEmpty();
    }

    @Override
    public Set<Entry<String, ConfigValue>> entrySet() {
        return config.entrySet();
    }

    @Override
    public boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    @Override
    public Number getNumber(String path) {
        return config.getNumber(path);
    }

    @Override
    public int getInt(String path) {
        return config.getInt(path);
    }

    @Override
    public long getLong(String path) {
        return config.getLong(path);
    }

    @Override
    public double getDouble(String path) {
        return config.getDouble(path);
    }

    @Override
    public String getString(String path) {
        return config.getString(path);
    }

    @Override
    public ConfigObject getObject(String path) {
        return config.getObject(path);
    }

    @Override
    public Config getConfig(String path) {
        return config.getConfig(path);
    }

    @Override
    public Object getAnyRef(String path) {
        return config.getAnyRef(path);
    }

    @Override
    public ConfigValue getValue(String path) {
        return config.getValue(path);
    }

    @Override
    public Long getBytes(String path) {
        return config.getBytes(path);
    }

    @Override
    @Deprecated
    public Long getMilliseconds(String path) {
        return config.getMilliseconds(path);
    }

    @Override
    @Deprecated
    public Long getNanoseconds(String path) {
        return config.getNanoseconds(path);
    }

    @Override
    public long getDuration(String path, TimeUnit unit) {
        return config.getDuration(path, unit);
    }

    @Override
    public ConfigList getList(String path) {
        return config.getList(path);
    }

    @Override
    public List<Boolean> getBooleanList(String path) {
        return config.getBooleanList(path);
    }

    @Override
    public List<Number> getNumberList(String path) {
        return config.getNumberList(path);
    }

    @Override
    public List<Integer> getIntList(String path) {
        return config.getIntList(path);
    }

    @Override
    public List<Long> getLongList(String path) {
        return config.getLongList(path);
    }

    @Override
    public List<Double> getDoubleList(String path) {
        return config.getDoubleList(path);
    }

    @Override
    public List<String> getStringList(String path) {
        return config.getStringList(path);
    }

    @Override
    public List<? extends ConfigObject> getObjectList(String path) {
        return config.getObjectList(path);
    }

    @Override
    public List<? extends Config> getConfigList(String path) {
        return config.getConfigList(path);
    }

    @Override
    public List<? extends Object> getAnyRefList(String path) {
        return config.getAnyRefList(path);
    }

    @Override
    public List<Long> getBytesList(String path) {
        return config.getBytesList(path);
    }

    @Override
    @Deprecated
    public List<Long> getMillisecondsList(String path) {
        return config.getMillisecondsList(path);
    }

    @Override
    @Deprecated
    public List<Long> getNanosecondsList(String path) {
        return config.getNanosecondsList(path);
    }

    @Override
    public List<Long> getDurationList(String path, TimeUnit unit) {
        return config.getDurationList(path, unit);
    }

    @Override
    public Config withOnlyPath(String path) {
        return config.withOnlyPath(path);
    }

    @Override
    public Config withoutPath(String path) {
        return config.withoutPath(path);
    }

    @Override
    public Config atPath(String path) {
        return config.atPath(path);
    }

    @Override
    public Config atKey(String key) {
        return config.atKey(key);
    }

    @Override
    public ConfigFile withValue(String path, ConfigValue value) {
        return withConfig(config.withValue(path, value));
    }

}