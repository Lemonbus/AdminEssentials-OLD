
package adminessentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class FullJoin implements Listener {
	
	  @EventHandler
	  public void onPlayerLogin(PlayerLoginEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((p.hasPermission("adminessentials.fulljoin")) && (e.getResult() == PlayerLoginEvent.Result.KICK_FULL))
	      e.allow();
	    
	  }

}
