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
package org.spongepowered.api.scoreboard;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;

import java.util.UUID;

/**
 * A team member represents something which has a meaningful {@link Component}
 * representation on a {@link Team}. The client may be able to link the team
 * {@link Component} entry to a particular object, and perform extra functionality.
 *
 * <p>Examples include:</p>
 *
 * <ul>
 *     <li>{@link Player}s, represented in Vanilla by their name</li>
 *     <li>Other {@link Living living entities}, represented in Vanilla by their {@link UUID}</li>
 * </ul>
 *
 */
public interface TeamMember {

    /**
     * Gets a {@link Component} representing this team member, suitable for adding
     * to an {@link Team} with {@link Team#addMember(Component)}.
     *
     * @return an {@link Component} representing this team member
     */
    Component getTeamRepresentation();

}
