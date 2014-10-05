package com.GummyPvP.AdminEssentials.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.GummyPvP.AdminEssentials.Main.Main;

public class QuitEvent implements Listener {

	private Main plugin;

	public QuitEvent(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (plugin.admin.contains(p)) {
			plugin.admin.remove(p);
			for (Player online : Bukkit.getOnlinePlayers()) {
				online.showPlayer(p);
			}
		}
	}
}
