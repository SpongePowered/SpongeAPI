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

package org.spongepowered.api.misc;

public interface Achievement {
	
	/**
	 * Gets the list of achievements.
	 * 
	 * @return The list of achievements
	 */
	AchievementList getAchievements();
	
	/**
	 * The list of achievements that can be given to a player.
	 */
	public enum AchievementList {
		TAKING_INVENTORY,
		GETTING_WOOD,
		BENCHMARKING,
		TIME_TO_MINE,
		HOT_TOPIC,
		ACQUIRE_HARDWARE,
		TIME_TO_FARM,
		BAKE_BREAD,
		THE_LIE,
		GETTING_AN_UPGRADE,
		DELICIOUS_FISH,
		ON_A_RAIL,
		TIME_TO_STRIKE,
		MONSTER_HUNTER,
		COW_TIPPER,
		WHEN_PIGS_FLY,
		SNIPER_DUEL,
		DIAMONDS,
		WE_NEED_TO_GO_DEEPER,
		RETURN_TO_SENDER,
		INTO_FIRE,
		LOCAL_BREWERY,
		THE_END_PORTAL,
		THE_END_DRAGON,
		ENCHANTER,
		OVERKILL,
		LIBRARIAN,
		ADVENTURING_TIME,
		THE_BEGINNING_SPAWN,
		THE_BEGINNING_DEFEAT,
		BEACONATOR,
		REPOPULATION,
		DIAMONDS_TO_YOU,
		OVERPOWERED
	}
}
