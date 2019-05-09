
public class Event {
	
	EventType type;
	
	public Event() {
		double r=Math.random()*100;
		if (r <= 25) {
			type = EventType.CHEST;
		}
		if (r > 25 && r <= 50) {
			type = EventType.MONSTER;
		}
		if (r > 50 && r <= 75) {
			type = EventType.OTHER;
		}
		if (r > 75) {
			type = EventType.NULL;
		}
	}
	
}
