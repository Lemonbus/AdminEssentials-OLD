package com.GummyPvP.AdminEssentials.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.GummyPvP.AdminEssentials.Main.Main;

public class ChatEvent implements Listener {

	private Main plugin;

	public ChatEvent(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (plugin.Muted) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin
					.getConfig().getString("Settings.prefix")
					+ plugin.getConfig().getString("Settings.chat-is-muted")));
			e.setCancelled(true);
		} else
			return;
	}

}
