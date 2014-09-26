package org.spongepowered.api.service.permissions;

import com.google.common.base.Optional;

import java.util.UUID;

/**
 * Represents a provider for permissions
 * Example:
 *
 * provide
 */
public interface PermissionProvider<GroupType> {
    public static final String SUBJECTS_USER = "user", SUBJECTS_GROUP = "group";

    /**
     * Returns the permissions level that describes users
     * @return
     */
    public SubjectCollection<UUID, GroupType> getUserSubjects();

    /**
     * Returns the collectiono of group subjects available. Implementation of this method is optional.
     * @return
     */
    public SubjectCollection<GroupType, GroupType> getGroupSubjects();

    /**
     * Returns the subject collection with the given identifier.
     * @param identifier
     * @return
     */
    public <I, P> Optional<SubjectCollection<I, P>> getSubjects(String identifier, Class<? extends I> ident, SubjectCollection<P, ?> parentCollection);
}
