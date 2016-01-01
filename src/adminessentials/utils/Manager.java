package adminessentials.utils;


public class Manager {

	private Manager() {

	}

	static Manager instance = new Manager();

	public static Manager getInstance() {
		return instance;
	}

	private boolean muted = false;
	private boolean slowed = false;
	private int seconds = 0;

	public boolean isMuted() {
		return muted;
	}

	public void setMuted(boolean b) {
		this.muted = b;
	}

	public boolean isSlowed() {
		return slowed;
	}

	public void setSlowed(boolean b, int seconds) {
		if (b) {
			this.seconds = seconds;
		} else
			this.seconds = 0;

		this.slowed = b;
	}

	public int getSecondsSlowed() {
		return seconds;
	}
	
	public boolean isInteger(String arg) {
		
		try {
			Integer.parseInt(arg);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	public String getPrefix() {
		return ConfigManager.getInstance().getConfig().getString("Settings.prefix");
	}
}
