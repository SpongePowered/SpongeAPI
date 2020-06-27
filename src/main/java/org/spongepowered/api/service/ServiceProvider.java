package org.spongepowered.api.service;

import org.spongepowered.api.service.ban.BanService;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.pagination.PaginationService;
import org.spongepowered.api.service.permission.PermissionService;
import org.spongepowered.api.service.rcon.RconService;
import org.spongepowered.api.service.sql.SqlService;
import org.spongepowered.api.service.user.UserStorageService;
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
    <T> Optional<ServiceRegistration<T>> registration(Class<T> serviceClass);

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
     * Retrieves the {@link PaginationService}.
     *
     * @return The {@link PaginationService}
     */
    PaginationService paginationService();

    /**
     * Retrieves the {@link PermissionService}.
     *
     * @return The {@link PermissionService}
     */
    PermissionService permissionService();

    /**
     * Retrieves the {@link SqlService}.
     *
     * @return The {@link SqlService}
     */
    SqlService sqlService();

    /**
     * Retrieves the {@link UserStorageService}.
     *
     * @return The {@link UserStorageService}
     */
    UserStorageService userStorageService();

    /**
     * Retrieves the {@link WhitelistService}.
     *
     * @return The {@link WhitelistService}
     */
    WhitelistService whitelistService();

}
