package org.spongepowered.api.service.permissions;

/**
 * Object that holds players, groups, etc. A better name would be good.
 */
public interface SubjectCollection<Ident, ParentIdent> {
    public SubjectCollection<ParentIdent, ?> getParentLevel();

    /**
     * Returns the subject specified. Will not return null.
     *
     * @param identifier
     * @return
     */
    public PermissionSubject<Ident, ParentIdent> getSubject(Ident identifier);

    /**
     * Returns whether there is any data specified beyond the default
     * @param identifier
     * @return
     */
    public boolean hasRegisteredSubject(Ident identifier);

    /**
     * Returns all subjects. The callback provided to this method may be run asyncronously
     * @return
     */
    public Iterable<PermissionSubject<Ident, ParentIdent>> getAllSubjects();

}
