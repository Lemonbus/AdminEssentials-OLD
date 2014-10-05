package com.GummyPvP.AdminEssentials.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.GummyPvP.AdminEssentials.Main.Main;

public class JoinEvent implements Listener {

	private Main plugin;

	public JoinEvent(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		for (Player admins : plugin.admin) {
			if (p.hasPermission("adminessentials.seeadmins")) {
				p.showPlayer(admins);
			} else {
				p.hidePlayer(admins);
			}
		}
	}

}
