package adminessentials.events;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MuteChatEvent extends Event {

	CommandSender sender;

	public MuteChatEvent(CommandSender sender) {
		this.sender = sender;
	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	/**
	 * Gets the sender of the mutechat command.
	 * 
	 * @return CommandSender
	 */
	public CommandSender getSender() {
		return this.sender;
	}
}
