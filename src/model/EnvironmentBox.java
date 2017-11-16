package model;

public class EnvironmentBox {
	private boolean UWall;
	private boolean DWall;
	private boolean LWall;
	private boolean RWall;
	public EnvironmentBox(boolean UWall,boolean DWall,boolean LWall, boolean RWall) {
		this.UWall = UWall;
		this.DWall = DWall;
		this.LWall = LWall;
		this.RWall = RWall;
	}
	public boolean hasUWall() {
		return UWall;
	}
	public boolean hasDWall() {
		return DWall;
	}
	public boolean hasLWall() {
		return LWall;
	}
	public boolean hasRWall() {
		return RWall;
	}
	
	
}
