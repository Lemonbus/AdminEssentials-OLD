package adminessentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import adminessentials.utils.FreezeManager;

public class PlayerMove implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {

		Player p = e.getPlayer();

		if (!FreezeManager.getInstance().isFrozen(p))
			return;

		e.setCancelled(true);

	}

}
