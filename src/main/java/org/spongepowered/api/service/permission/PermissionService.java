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
package org.spongepowered.api.service.permission;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.context.ContextualService;
import org.spongepowered.plugin.PluginContainer;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Represents a provider of permissions data.
 *
 * <p>This is the interface that a permissions plugin must implement and
 * register to provide permissions for users on the server. Subject related
 * method calls on Players and Users are redirected to the active permission
 * service.</p>
 *
 * <p>Implementations of PermissionService are expected to be thread-safe.</p>
 *
 * <p>Distinctions are made throughout the service between data which is
 * currently available, and data which may exist, but is not currently
 * loaded.</p>
 *
 * <p>Methods prefixed with "get" will typically only return data if it is
 * already loaded into memory. Methods prefixed with "load" however will load
 * data into memory if necessary.</p>
 *
 * <p>{@link CompletableFuture}s are used throughout the service in situations
 * where it is possible that calls may take a considerable time to execute.
 * {@link CompletableFuture#thenAcceptAsync(Consumer, Executor)} can be used to
 * run a callback once the method has completed. Alternatively,
 * {@link CompletableFuture#join()} can be used, but care should be taken to
 * avoid blocking the server thread.</p>
 */
public interface PermissionService extends ContextualService {

    /**
     * The standard identifier for the collection which stores users.
     */
    String SUBJECTS_USER = "user";

    /**
     * The standard identifier for the collection which stores groups.
     */
    String SUBJECTS_GROUP = "group";

    /**
     * The standard identifier for the collection which stores "system"
     * subjects.
     *
     * <p>These are subjects which store data for objects within the
     * server. For example, the server "console".</p>
     */
    String SUBJECTS_SYSTEM = "system";

    /**
     * The standard identifier for the collection which stores default subjects.
     *
     * <p>By convention, the {@link #defaults()} subject is stored in this
     * collection under the name "default", and each {@link SubjectCollection}s
     * {@link SubjectCollection#defaults()} subject is stored in this
     * collection with the same identifier as the parent collection.</p>
     */
    String SUBJECTS_DEFAULT = "defaults";

    /**
     * The standard identifier for the collection which stores command block
     * subjects.
     */
    String SUBJECTS_COMMAND_BLOCK = "commandblock";

    /**
     * The standard identifier for the collection which stores role templates.
     *
     * <p>Role templates are registered alongside {@link PermissionDescription}s,
     * via {@link PermissionDescription.Builder#assign(String, boolean)}.</p>
     */
    String SUBJECTS_ROLE_TEMPLATE = "role-template";

    /**
     * Returns the subject collection which holds users.
     *
     * <p>User identifiers are expected to be UUIDs in RFC4122 string format
     * (This *does* have dashes).</p>
     *
     * <p>This method should return the same SubjectCollection as the result of
     * invoking {@link #loadCollection(String)} with {@link #SUBJECTS_USER}.</p>
     *
     * @return A subject collection for users
     */
    SubjectCollection userSubjects();

    /**
     * Returns the subject collection which holds groups.
     *
     * <p>This method should return the same SubjectCollection as the result of
     * invoking {@link #loadCollection(String)} with {@link #SUBJECTS_GROUP}.</p>
     *
     * @return A subject collection for groups
     */
    SubjectCollection groupSubjects();

    /**
     * Gets the subject holding data that is applied by default to all
     * subjects.
     *
     * <p>This subject is at the root of all inheritance trees, below
     * even SubjectCollection defaults, meaning it has the lowest
     * priority when all other weighting is equal.</p>
     *
     * <p>Note: This data may be persisted, so plugins that add
     * permissions to this subject must take care to not override
     * permissions already set or modified.</p>
     *
     * <p>It is also recommended to use
     * {@link Subject#transientSubjectData()} where possible to avoid
     * persisting unnecessary data.</p>
     *
     * <p>Assigning default permissions should be used sparingly, and by
     * convention, only in situations where "default" game behaviour is restored
     * by granting a certain permission.</p>
     *
     * @return The subject holding defaults for all other subjects.
     */
    Subject defaults();

    /**
     * Get data for a role template for a specific plugin. If the plugin has not set any permissions
     * for the given role template, an empty {@link Optional} will be returned. Whether role template information
     * is persistent or transient is implementation-dependent, though the final choice should most likely be
     * up to the user.
     *
     * @param plugin The plugin to query the role template for.
     * @param roleTemplate The specific role template identifier. Any string may be used,
     *                     but {@link PermissionDescription} contains some common suggestions.
     * @return An optional possibly containing the subject data for the given role template
     */
    default Optional<? extends SubjectData> getRoleTemplate(PluginContainer plugin, String roleTemplate) {
        Objects.requireNonNull(plugin, "plugin");

        return getCollection(SUBJECTS_ROLE_TEMPLATE).flatMap(coll ->
                coll.getSubject(plugin.getMetadata().getId() + ":"
                        + Objects.requireNonNull(roleTemplate, "roleTemplate")))
                .map(Subject::getTransientSubjectData);
    }


    /**
     * Get the data contained in role templates for all plugins providing data at the given key
     *
     * @param roleTemplate The specific role template identifier. Any string may be used,
     *                     but {@link PermissionDescription} contains some common suggestions.
     * @return An immutable set of mappings from plugin to subject data holder.
     */
    default Set<Map.Entry<PluginContainer, ? extends SubjectData>> getRoleTemplates(String roleTemplate) {
        Optional<? extends SubjectCollection> coll = getCollection(SUBJECTS_ROLE_TEMPLATE);
        if (!coll.isPresent()) {
            return Collections.emptySet();
        }

        Optional<? extends Subject> globalSubj
                = coll.get().getSubject(Objects.requireNonNull(roleTemplate, "roleTemplate"));
        if (!globalSubj.isPresent()) {
            return Collections.emptySet();
        }

        return Collections.unmodifiableSet(globalSubj.get()
                .getTransientSubjectData().getParents(SubjectData.GLOBAL_CONTEXT).stream()
                .map(SubjectReference::resolve)
                .map(CompletableFuture::join)
                .map(it -> {
                    String[] name = it.getIdentifier().split(":", 2);
                    if (name.length < 2) {
                        return null;
                    }

                    Optional<PluginContainer> container = Sponge.getPluginManager().getPlugin(name[0]);
                    if (!container.isPresent()) {
                        return null;
                    }

                    return new AbstractMap.SimpleImmutableEntry<>(container.get(), it.getTransientSubjectData());
                }).filter(Objects::nonNull)
                .collect(Collectors.toSet()));

    }

    /**
     * Returns a predicate which determines whether or not a given identifier
     * is valid for a subject collection held by this service.
     *
     * <p>It is expected that as a minimum, the standard identifiers expressed
     * as static parameters in this class will pass the predicate.</p>
     *
     * @return The predicate
     */
    Predicate<String> identifierValidityPredicate();

    /**
     * Loads and returns a subject collection with the given identifier.
     *
     * <p>The returned future will complete exceptionally if the subject
     * collection with the given identifier cannot be loaded.</p>
     *
     * <p>A {@link IllegalArgumentException} will be thrown directly by this
     * method if the identifier does not pass the identifier validity
     * predicate.</p>
     *
     * @param identifier The identifier. All identifiers are case-insensitive
     * @return A subject collection for the given identifier
     * @throws IllegalArgumentException If the collection identifier does not
     *                                  pass the validity predicate for this
     *                                  service
     */
    CompletableFuture<? extends SubjectCollection> loadCollection(String identifier);

    /**
     * Returns a subject collection with the given identifier, if the
     * collection is already loaded within this service.
     *
     * <p>It is important to note that a subject collection with the given
     * identifier may still exist, even if this method returns an empty
     * optional. Checking for the presence of a subject collection should
     * be done using {@link #hasCollection(String)}.</p>
     *
     * <p>If the collection identifier does not pass the validity predicate,
     * this method will return an empty optional, and not throw an
     * exception.</p>
     *
     * @param identifier The identifier
     * @return A subject collection for the given identifier
     */
    Optional<? extends SubjectCollection> collection(String identifier);

    /**
     * Returns whether a subject collection with the given identifier currently
     * exists.
     *
     * @param identifier The identifier of the subject collection
     * @return If the collection currently exists
     */
    CompletableFuture<Boolean> hasCollection(String identifier);

    /**
     * Returns an immutable copy of all currently loaded subject collections
     * held by this permission service. This map is immutable.
     *
     * @return The loaded collections for this service
     */
    Map<String, ? extends SubjectCollection> loadedCollections();

    /**
     * Returns a set of the subject collection identifiers known to this
     * service.
     *
     * @return A set of collection identifiers
     */
    CompletableFuture<? extends Set<String>> allIdentifiers();

    /**
     * Creates a new subject reference to represent the expressed subject.
     *
     * <p>Note that instances of SubjectReference must be capable of resolving
     * the identifier to a Subject without being passed a reference to the
     * service.</p>
     *
     * <p>A {@link IllegalArgumentException} will be thrown directly by this
     * method if either identifiers do not pass the identifier validity
     * predicates.</p>
     *
     * @param collectionIdentifier The identifier of the collection holding the
     *                             subject
     * @param subjectIdentifier The identifier of the subject
     * @return A subject reference to represent the expressed subject
     * @throws IllegalArgumentException If either identifiers do not pass the
     *                                  the validity predicates for this
     *                                  service / the collection.
     */
    SubjectReference newSubjectReference(String collectionIdentifier, String subjectIdentifier);

    /**
     * Creates a new description builder for the given plugin's permission.
     *
     * @param plugin The plugin to create permission descriptions for
     * @return The newly created permission description builder
     * @throws IllegalArgumentException if plugin is not a plugin instance
     */
    PermissionDescription.Builder newDescriptionBuilder(PluginContainer plugin);

    /**
     * Gets the registered or generated {@link PermissionDescription} for the
     * given permission if available.
     *
     * <p>If the given permission is not defined itself this might also return
     * the associated permission template.</p>
     *
     * @param permission The permission to get the description for
     * @return The description for the given permission or
     *         {@link Optional#empty()}
     */
    Optional<? extends PermissionDescription> description(String permission);

    /**
     * Gets a immutable collection containing all registered or generated
     * {@link PermissionDescription}s.
     *
     * <p>Implementations may generate descriptions automatically for
     * permissions in use on the server, based upon permissions stored in
     * subject data, or based upon checks being performed.</p>
     *
     * @return An immutable collection contain all registered or generated
     *         descriptions
     */
    Collection<? extends PermissionDescription> descriptions();

}
