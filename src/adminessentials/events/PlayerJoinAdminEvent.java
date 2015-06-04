package adminessentials.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerJoinAdminEvent extends Event {
	
	private Player p;
	
	public PlayerJoinAdminEvent(Player p) {
		this.p = p;
	}
	
	private static final HandlerList handlers = new HandlerList();
	 
	public HandlerList getHandlers() {
	    return handlers;
	}
	 
	public static HandlerList getHandlerList() {
	    return handlers;
	}
	
	/**
	 * Gets the player that went into admin mode.
	 * 
	 * @return Player
	 * 
	 */
	public Player getPlayer() {
		return this.p;
	}

}
