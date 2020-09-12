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
package org.spongepowered.api.service;

import org.spongepowered.api.Engine;
import org.spongepowered.api.service.ban.BanService;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.pagination.PaginationService;
import org.spongepowered.api.service.permission.PermissionService;
import org.spongepowered.api.service.whitelist.WhitelistService;

import java.util.Optional;

/**
 * Provides various Sponge services.
 */
public interface ServiceProvider {

    /**
     * Provides the service represented by the supplied {@link Class}.
     *
     * @param serviceClass The class
     * @param <T> The type of service
     * @return The service, if one exists
     */
    <T> Optional<T> provide(Class<T> serviceClass);

    /**
     * Provides the {@link ServiceRegistration} for the supplied {@link Class}.
     *
     * @param serviceClass The class
     * @param <T> The type of service
     * @return The registration, if one exists
     */
    <T> Optional<ServiceRegistration<T>> getRegistration(Class<T> serviceClass);

    /**
     * Provides services that are scoped to a {@link GameScoped} instance.
     */
    interface GameScoped extends ServiceProvider {

        /**
         * Retrieves the {@link PaginationService}.
         *
         * @return The {@link PaginationService}
         */
        PaginationService paginationService();

    }

    /**
     * Provides serivces that are scoped to the {@link ServerScoped} {@link Engine}
     * only.
     */
    interface ServerScoped extends ServiceProvider {

        /**
         * Retrieves the {@link BanService}.
         *
         * @return The {@link BanService}
         */
        BanService banService();

        /**
         * Retrieves the {@link EconomyService}, if it exists.
         *
         * @return The {@link EconomyService}.
         */
        Optional<EconomyService> economyService();

        /**
         * Retrieves the {@link PermissionService}.
         *
         * @return The {@link PermissionService}
         */
        PermissionService permissionService();

        /**
         * Retrieves the {@link WhitelistService}.
         *
         * @return The {@link WhitelistService}
         */
        WhitelistService whitelistService();

    }


}
