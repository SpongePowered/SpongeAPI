package org.spongepowered.api.service.permissions;

/**
 * Represents a provider for permissions
 * Example:
 *
 * provide
 */
public interface PermissionProvider {
    public static final String LEVEL_USER = "user", LEVEL_GROUP = "group";

    /**
     * Returns the permissions level that describes users
     * @return
     */
    public Level getUserLevel();
    public Level getGroupLevel();
    public Level getLevel(String identifier);
    public boolean hasDataForLevel(String identifier);
}
