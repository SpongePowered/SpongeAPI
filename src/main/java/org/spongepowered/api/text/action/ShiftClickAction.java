package org.spongepowered.api.text.action;

/**
 * A ShiftClickAction is a TextAction that responds to shift-clicks.
 * Currently the only value is InsertText, which maps to the insertion field in Message JSON.
 * Possibly more shift click actions will be added to the client in the future.
 *
 * @param <R> the type of the result of the action
 */
public interface ShiftClickAction<R> extends TextAction<R> {

    /**
     * Inserts some text into the chat prompt.
     */
    interface InsertText extends ShiftClickAction<String> { }

}
