package formula1;

import java.util.ArrayList;

public class Driver extends Person implements Comparable<Driver> {
	private RacingTeam team;
	private ArrayList<RaceResult> races = new ArrayList<RaceResult>();

	public Driver(String firstName, String surname, RacingTeam team) {
		super(firstName, surname);
		this.team = team;
		this.team.addDriver(this);

	}

	public RacingTeam getRacingTeam() {
		return this.team;
	}

	public final void addRace(RaceResult race) {
		if (!races.contains(race)) {
			races.add(race);
		}
	}

	public int getGrandPrixPoints() {
		int summe = 0;
		for (RaceResult raceResult : races) {
			summe += raceResult.getDriverPoints(this);

		}
		return summe;

	}

	@Override
	public int compareTo(Driver o) {
		if (this.getGrandPrixPoints() > o.getGrandPrixPoints()) {
			return -1;
		} else if (this.getGrandPrixPoints() < o.getGrandPrixPoints()) {
			return 1;
		} else
			return 0;
	}

}
