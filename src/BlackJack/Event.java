package BlackJack;

public class Event {
	private int timer = 0;
	
	public Event(int timer) {
		this.timer = timer;
	}
	
	public int getTimer() {
		return this.timer;
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
}
