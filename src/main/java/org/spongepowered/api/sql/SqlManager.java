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
package org.spongepowered.api.sql;

import org.spongepowered.plugin.PluginContainer;

import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

/**
 * This manager provides the basics for an abstraction over SQL connections.
 */
public interface SqlManager {

    /**
     * Returns a data source for the provided JDBC connection string or
     * an alias.
     *
     * <p>A jdbc connection url is expected to be of the form:
     * jdbc:&lt;engine&gt;://[&lt;username&gt;[:&lt;password&gt;]@]&lt;host
     * &gt;/&lt;database&gt; or an alias (available aliases are known only by
     * the service provider)</p>
     *
     * @param jdbcConnection The jdbc url or connection alias
     * @return A data source providing connections to the given URL.
     * @throws SQLException if a connection to the given database could not
     *     be established
     */
    DataSource getDataSource(String jdbcConnection) throws SQLException;

    /**
     * Returns a data source for the provided JDBC connection string or an
     * alias.
     *
     * <p>A jdbc connection url is expected to be of the form:
     * jdbc:&lt;engine&gt;://[&lt;username&gt;[:&lt;password&gt;]@]
     * &lt;host&gt;/&lt;database&gt;
     * or an alias (available aliases are known only by the service
     * provider)</p>
     *
     * @param plugin The plugin to lookup databases relative to (primarily
     *     applying to file-backed databases)
     * @param jdbcConnection The jdbc url or connection alias
     * @return A data source providing connections to the given URL.
     * @throws SQLException if a connection to the given database could not
     *     be established
     */
    DataSource getDataSource(PluginContainer plugin, String jdbcConnection) throws SQLException;

    /**
     * Returns a possible connection URL for a given alias.
     *
     * @param alias The alias to check
     * @return The connection url as a String if it exists,
     *          or {@link Optional#empty()}
     */
    Optional<String> getConnectionUrlFromAlias(String alias);
}
