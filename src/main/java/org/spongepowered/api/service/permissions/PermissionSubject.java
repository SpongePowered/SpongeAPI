package org.spongepowered.api.service.permissions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * Represents a single user/group/to-be-named abstraction above those
 * This could possibly be used as a component in an ECS/be implemented in Player.
 */
public interface PermissionSubject {
    /**
     * Returns the identifier associated with this subject
     * @return
     */
    public String getIdentifier();

    /**
     * Return all permissions associated with this data object
     * TODO: create permissions tree data structure that is used for all these methods rather than List&lt;String>
     * @return
     */
    public Map<Context, List<String>> getAllPermissions();

    /**
     * set permissions in context to the given permissions. Null unsets.
     * @param context
     * @param permissions
     */
    public void setPermissions(Context context, List<String> permissions);

    // TODO: Keep both of these? Parents is more commonly stored directly, but children in a lot of cases makes sense to expose via API.
    public List<String> getChildNames();

    /**
     * Return all registered parent names for all contexts
     * @return
     */
    public Map<Context, List<String>> getAllParentNames();

    /**
     *
     * @return names of parents valid for the current context
     */
    public List<String> getParentNames();

    /**
     *
     * @param context The context to check
     * @return names of parents valid in the given context
     */
    public List<String> getParentNames(Context context);

    public void setParentNames(Context context, List<String> names);

    /**
     *
     * @param context
     * @param permission
     * @return
     */
    public boolean hasPermission(@Nonnull Context context, @Nonnull String permission);

    /**
     * Does the player have a permission?
     * @param permission
     * @return
     */
    public boolean hasPermission(@Nonnull String permission);

    /**
     * Returns the context currently applicable for the permission subject
     * @return
     */
    public @Nullable Context getActiveContext();
}
