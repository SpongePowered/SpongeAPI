
package package org.spongepowered.api.util;

public enum PermissionLevel{

LOWEST(0), /* No permissions at all */
LOWER(1), /* Basic permissions */
MIDDLE(2),
HIGH(3),
HIGHEST(4), /* Player administrator level */
CONSOLE(5); /* Console operator level - no player should have that high permission level */

    private PermissionLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
