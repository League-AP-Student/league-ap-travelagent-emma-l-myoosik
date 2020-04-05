import java.util.List;

public class Trip {
	private List<Flight> flights;

	public int getDuration() {
		if (flights.size() == 0) {return 0;}
		
		Time departure = flights.get(0).getDeparturetime();
		Time arrival = flights.get(flights.size() - 1).getArrivalTime();
		return departure.minutesUntil(arrival);
	}

	public int getShortestLayover() {
		if (flights.size() < 2) { return -1; }
		
		int shortest = getDuration();
		for (int i = 0; i < flights.size() - 1; i++) {
			Flight f1 = flights.get(i);
			Flight f2 = flights.get(i + 1);
			
			Time arrival = f1.getArrivalTime();
			Time departure = f2.getDeparturetime();
			
			int layover = arrival.minutesUntil(departure);
			if (layover < shortest) {
				shortest = layover;
			}
			
		}
		return shortest;
	}
}
