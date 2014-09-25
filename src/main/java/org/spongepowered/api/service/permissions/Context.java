package org.spongepowered.api.service.permissions;

/**
 * The context that a permission check occurs in.
 */
public interface Context {
    // TODO: Figure out the appropriate methods for this.
    // TODO too: make this behave in a key-value ish way, so that permissions plugins can pass the interface around without knowing implementation details.
    public boolean matches(PermissionSubject subject);
}
