
public class Event {

	EventType type;
	
	public Event(){
		double r=Math.random()*100;
		if (r<=25) {
			type = EventType.NULL;
		}
		else if (r<=50) {
			type = EventType.CHEST;
		}
		else if (r<=75) {
			type = EventType.MONSTER;
		}
		else {
			type = EventType.OTHER;
		}
	}

	public EventType getType() {
		return type;
	}
		
}
