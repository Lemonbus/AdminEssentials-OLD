package adminessentials.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class AdminManager {

	private AdminManager() {

	}

	static AdminManager instance = new AdminManager();

	public static AdminManager getInstance() {
		return instance;
	}

	private ArrayList<Player> adminMode = new ArrayList<Player>();

	public boolean isInAdminMode(Player p) {
		return adminMode.contains(p);
	}

	public void setAdminMode(Player p, boolean b) {
		if (b) {
			adminMode.add(p);
		} else
			adminMode.remove(p);
	}

	public ArrayList<Player> listInAdmin() {
		return adminMode;
	}
}
