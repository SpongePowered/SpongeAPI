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
