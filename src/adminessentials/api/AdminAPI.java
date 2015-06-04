package adminessentials.api;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import adminessentials.utils.AdminManager;
import adminessentials.utils.Manager;

public class AdminAPI {

	private AdminAPI() {

	}

	/**
	 * Clears the chat, with a specified message. Color code values are allowed
	 * with the '&' character.
	 * 
	 * @param msg
	 *            Message that is sent after clearing chat.
	 */
	public static void clearChat(String msg) {
		for (int i = 0; i < 150; i++) {
			Bukkit.broadcastMessage(" ");
		}

		Bukkit.broadcastMessage(ChatColor
				.translateAlternateColorCodes('&', msg));
	}

	/**
	 * Clears a player's chat with a specified message. Color code values are
	 * allowed with the '&' character.
	 * 
	 * @param p
	 *            Player to clear chat.
	 * @param msg
	 *            Message that is sent after clearing player's chat.
	 */
	public static void clearChat(Player p, String msg) {
		for (int i = 0; i < 150; i++) {
			p.sendMessage(" ");
		}

		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

	/**
	 * Mutes chat. If 'b' is true, chat will be muted. If 'b' is false, chat
	 * will be unmuted.
	 * 
	 * @param msg
	 *            Message that is sent after muting chat. Supports color codes
	 *            with '&'.
	 * @param b
	 *            Boolean that tells whether to mute chat or unmute chat.
	 */
	public static void muteChat(String msg, boolean b) {
		Manager.getInstance().setMuted(b);
		Bukkit.broadcastMessage(ChatColor
				.translateAlternateColorCodes('&', msg));
	}

	/**
	 * Gets the list of players in admin mode.
	 * 
	 * @return ArrayList of players in admin mode.
	 */
	public static ArrayList<Player> getPlayersInAdminMode() {
		return AdminManager.getInstance().listInAdmin();
	}

	/**
	 * Checks if player is in admin mode.
	 * 
	 * @param p
	 *            Player to check.
	 * @return True if player is in admin mode, false otherwise.
	 */
	public static boolean isInAdminMode(Player p) {
		return AdminManager.getInstance().isInAdminMode(p);
	}

	/**
	 * Checks if a player name is in admin mode.
	 * 
	 * @param s
	 *            Name of player to check
	 * @return True if player is in admin mode, false otherwise.
	 */
	public static boolean isInAdminMode(String s) {
		Player p = Bukkit.getPlayer(s);
		if (p != null)
			return AdminManager.getInstance().isInAdminMode(p);
		return false;
	}

	/**
	 * Sets/Removes the player in admin mode.
	 * 
	 * @param p
	 *            Player to set,
	 * @param b
	 *            Sets player in admin mode if true, removes player from admin
	 *            mode if false.
	 */
	public static void setAdminMode(Player p, boolean b) {
		AdminManager.getInstance().setAdminMode(p, b);
	}

	/**
	 * Sets/Removes the player in admin mode.
	 * 
	 * @param s
	 *            Player to set,
	 * @param b
	 *            Sets player in admin mode if true, removes player from admin
	 *            mode if false.
	 */
	public static void setAdminMode(String s, boolean b) {
		Player p = Bukkit.getPlayer(s);
		if (p != null)
			AdminManager.getInstance().setAdminMode(p, b);
		else
			Bukkit.getLogger().warning("Player " + s + " is null!");
	}
}
