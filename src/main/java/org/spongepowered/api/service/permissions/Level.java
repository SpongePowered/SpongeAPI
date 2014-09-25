package org.spongepowered.api.service.permissions;

/**
 * Object that holds players, groups, etc. A better name would be good.
 */
public interface Level {
    public Level getParentLevel();

    /**
     * Returns the subject specified. Will not return null.
     *
     * @param identifier
     * @return
     */
    public PermissionSubject getSubject(String identifier);

    /**
     * Returns whether there is any data specified beyond the default
     * @param identifier
     * @return
     */
    public boolean hasRegisteredSubject(String identifier);

    /**
     * Returns all subjects. The callback provided to this method may be run asyncronously
     * @return
     */
    public Iterable<PermissionSubject> getAllSubjects();

}
