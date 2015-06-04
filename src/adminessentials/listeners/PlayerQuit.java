package adminessentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import adminessentials.events.PlayerLeaveAdminEvent;
import adminessentials.utils.AdminManager;

public class PlayerQuit implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		AdminManager.getInstance().setAdminMode(p, false);
		Bukkit.getPluginManager().callEvent(new PlayerLeaveAdminEvent(p));
	}

}
