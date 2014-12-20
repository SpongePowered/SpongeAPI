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
package org.spongepowered.api.service.sql;

import com.google.common.base.Optional;

import java.sql.SQLException;

import javax.annotation.concurrent.ThreadSafe;
import javax.sql.DataSource;

/**
 * This service provides the basics for an abstraction over SQL connections.
 *
 * Implementations of this service are expected to be thread-safe
 */
@ThreadSafe
public interface SQLService {
    /**
     * Returns a data source for the provided JDBC connection string or an alias
     *
     * A jdbc connection url is expected to be of the form:
     * jdbc:&lt;engine&gt;://[&lt;username&gt;[:&lt;password&gt;]@]&lt;host&gt;/&lt;database&gt;
     *
     * or an alias (available aliases are known only by the service provider)
     *
     * @param jdbcConnection The jdbc url or connection alias
     * @return A data source providing connections to the given URL.
     * @throws java.sql.SQLException if a connection to the given database could not be established
     */
    public DataSource getDataSource(String jdbcConnection) throws SQLException;

    /**
     * Returns a possible connection URL for a given alias.
     *
     * @param alias The alias to check
     * @return The connection url as a String if it exists,
     *          or {@link Optional#absent()}
     */
    public Optional<String> getConnectionURLFromAlias(String alias);
}
