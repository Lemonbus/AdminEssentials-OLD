package com.GummyPvP.AdminEssentials.API;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.GummyPvP.AdminEssentials.Main.Main;

/**
 * 
 * @since 1.0.4
 * @author fmcgraw
 * @version 1.0.1
 * 
 */
public class AEAPI {

	private static Main plugin;

	private AEAPI() {

	}

	/**
	 * Gets the current list of players in admin mode.
	 * 
	 * @return an ArrayList of players in the admin mode ArrayList
	 */
	public static ArrayList<Player> getListOfPlayersInAdmin() {
		return plugin.admin;
	}

	/**
	 * 
	 * @param player
	 *            Returns a player object - Checks if player is in admin mode
	 * @return Returns true if provided player param is in the admin mode
	 *         returns false if they are not
	 */
	public static boolean isInAdmin(Player player) {
		return (plugin.admin.contains(player));

	}

	/**
	 * Checks if chat is currently muted
	 * 
	 * @return Returns a boolean value - true if chat is muted, false if chat is
	 *         not muted
	 */
	public static boolean isChatMuted() {
		return plugin.Muted;
	}

	/**
	 * Gets all currently frozen players
	 * 
	 * @return Returns an ArrayList of players that are in the frozen players
	 *         ArrayList
	 */
	public static ArrayList<Player> getListOfPlayersFrozen() {
		return plugin.frozen;
	}

	/**
	 * Checks if the player is frozen
	 * 
	 * @param player
	 *            Player being checked
	 * @return Returns a boolean value - true if player is frozen, false if
	 *         player is not frozen
	 * 
	 * @throws IllegalArgumentException
	 *             If player does not exist
	 */
	public static boolean isPlayerFrozen(Player player) {
		if (!(player instanceof Player))
			throw new IllegalArgumentException("Player does not exist!");
		return (plugin.frozen.contains(player));
	}

	/**
	 * Adds or removes player in admin mode, if said player exists
	 * 
	 * @param player
	 *            Player you want to put in admin mode
	 * @param paramBoolean
	 *            Boolean value - If true, will set player in admin mode. If
	 *            false, will remove player from admin mode.
	 * @throws IllegalArgumentException
	 *             If player does not exist
	 */
	public static void setAdminMode(Player player, boolean paramBoolean) {
		if (!(player instanceof Player))
			throw new IllegalArgumentException("Player does not exist!");
		if (paramBoolean) {
			// Set Admin
		}

	}
}
