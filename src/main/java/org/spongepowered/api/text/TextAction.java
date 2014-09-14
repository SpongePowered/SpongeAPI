/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.text;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.spongepowered.api.text.TextClientEvent.ActionType;

/**
 * Constants of possible values for client chat actions.
 * 
 * @see net.minecraft.event.ClickEvent.Action
 * @see net.minecraft.event.HoverEvent.Action
 */
public final class TextAction {

    // Click Actions
    public static final TextAction OPEN_URL         = new TextAction("open_url", ActionType.CLICK);
    public static final TextAction OPEN_FILE        = new TextAction("open_file", ActionType.CLICK, false);
    public static final TextAction RUN_COMMAND      = new TextAction("run_command", ActionType.CLICK);
    public static final TextAction TWITCH_USER_INFO = new TextAction("twitch_user_info", ActionType.CLICK, false);
    public static final TextAction SUGGEST_COMMAND  = new TextAction("suggest_command", ActionType.CLICK);
    
    // Hover Actions
    public static final TextAction SHOW_TEXT        = new TextAction("show_text", ActionType.HOVER);
    public static final TextAction SHOW_ACHIEVEMENT = new TextAction("show_achievement", ActionType.HOVER);
    public static final TextAction SHOW_ITEM        = new TextAction("show_item", ActionType.HOVER);
    
    private final static Map<String, TextAction> values = new LinkedHashMap<String, TextAction>();
    private final String canonName;
    private final ActionType actionType;
    private final boolean allowed;

    public TextAction(String name, ActionType type) {
        this(name, type, true);
    }

    public TextAction(String name, ActionType type, boolean allowed) {
        // check if the name already exists.
        TextAction action = getType(name);
        if (action != null) {
            // It exists, use current values, don't re-register
            this.canonName = action.getCanonicalName();
            this.actionType = action.getActionType();
            this.allowed = action.isAllowed();
            return;
        }
        // doesn't exist. Proceed as normal
        this.canonName = name;
        this.actionType = type;
        this.allowed = allowed;
        values.put(name.toLowerCase(), this);

    }

    /**
     * Gets the name as it appears in the raw json.
     * 
     * @return
     */
    public String getCanonicalName() {
        return this.canonName;
    }

    /**
     * Gets the type of action this is. Currently possibilities are
     * {@link ActionType.CLICK} and {@link ActionType.HOVER}
     * 
     * @return
     */
    public ActionType getActionType() {
        return this.actionType;
    }

    /**
     * Gets whether this action is allowed to be sent by the server?
     * If this is false, the client will ignore it.
     * 
     * @return
     */
    public boolean isAllowed() {
        return this.allowed;
    }

    /**
     * Gets a Collection of known actions.
     * 
     * @return
     */
    public static Collection<TextAction> getActions() {
        return values.values();
    }

    /**
     * Gets the action object associated with the given name
     * 
     * @param canonicalName Unique name
     * @return
     */
    public static TextAction getType(String canonicalName) {
        return values.get(canonicalName.toLowerCase());
    }

}
