package com.GummyPvP.AdminEssentials.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.GummyPvP.AdminEssentials.Main.Main;

public class MoveEvent implements Listener {

	private Main plugin;

	public MoveEvent(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (plugin.frozen.contains(e.getPlayer())) {
			e.setCancelled(true);
		} else
			return;
	}

}
