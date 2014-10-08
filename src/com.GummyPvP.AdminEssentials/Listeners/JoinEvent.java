package com.GummyPvP.AdminEssentials.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.GummyPvP.AdminEssentials.Main.Main;
import com.GummyPvP.AdminEssentials.Main.UpdateChecker;

public class JoinEvent implements Listener {

	protected UpdateChecker up;

	private Main plugin;

	public JoinEvent(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		this.up = new UpdateChecker(plugin,
				"http://dev.bukkit.org/bukkit-plugins/adminessentials/files.rss");
		if (plugin.getConfig().getBoolean("Settings.update-notice")) {
			if (p.isOp()) {
				if (up.updateNeeded()) {
					p.sendMessage(ChatColor.AQUA + "[AdminEssentials] "
							+ ChatColor.GOLD + "Version: " + up.getVersion()
							+ " has been released! Download it here: "
							+ up.getLink());
				}
			}
		}
		for (Player admins : plugin.admin) {
			if (p.hasPermission("adminessentials.seeadmins")) {
				p.showPlayer(admins);
			} else {
				p.hidePlayer(admins);
			}
		}
	}

}
