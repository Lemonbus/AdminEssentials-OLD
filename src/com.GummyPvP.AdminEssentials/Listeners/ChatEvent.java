package com.GummyPvP.AdminEssentials.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.GummyPvP.AdminEssentials.Main.Main;

public class ChatEvent implements Listener {

	private Main plugin;

	public ChatEvent(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

		if (plugin.Muted) {
			if (!p.hasPermission("adminessentials.mutechat.bypass")) {
				p.sendMessage(ChatColor.translateAlternateColorCodes(
						'&',
						plugin.getConfig().getString("Settings.prefix")
								+ plugin.getConfig().getString(
										"Settings.chat-is-muted")));
				e.setCancelled(true);
			} else
				return;
		} else
			return;
	}

	@EventHandler
	public void onAdminChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

		if (plugin.getConfig().getBoolean("Settings.admin-prefix-enabled")) {
			if (plugin.admin.contains(p)) {
				String s = e.getMessage();
				e.setCancelled(true);
				for (Player online : e.getRecipients()) {
					online.sendMessage(ChatColor.translateAlternateColorCodes(
							'&',
							plugin.getConfig().getString(
									"Settings.admin-prefix"))
							+ ChatColor.RESET + p.getDisplayName() + ": " + s);
				}
			} else
				return;
		} else
			return;
	}

}
