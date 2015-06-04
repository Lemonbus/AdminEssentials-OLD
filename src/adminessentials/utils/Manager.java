package adminessentials.utils;

public class Manager {

	private Manager() {

	}

	static Manager instance = new Manager();

	public static Manager getInstance() {
		return instance;
	}

	private boolean muted = false;

	public boolean isMuted() {
		return muted;
	}

	public void setMuted(boolean b) {
		this.muted = b;
	}
}
