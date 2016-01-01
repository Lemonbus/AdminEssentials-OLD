package adminessentials.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class FreezeManager {

	private FreezeManager() {

	}

	static FreezeManager instance = new FreezeManager();

	public static FreezeManager getInstance() {
		return instance;
	}

	private ArrayList<Player> frozen = new ArrayList<Player>();

	public boolean isFrozen(Player p) {
		return frozen.contains(p);
	}

	public void setFrozen(Player p, boolean b) {
		if (b) {
			if (isFrozen(p))
				return; // Already frozen, don't add them again.
			frozen.add(p);
		} else
			frozen.remove(p);
	}
	
	public ArrayList<Player> listOfFrozenPlayers() {
		return frozen;
	}

}
