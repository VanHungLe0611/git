package formula1;

@SuppressWarnings("serial")
public class RaceResult extends RuntimeException {

	private String grandPrixName;
	private Driver[] driverFinish = new Driver[10];

	public RaceResult(String grandPrixName, Driver[] driverFinish) {
		if (driverFinish.length == 0) {
			throw new NullPointerException();
		} else {
			this.grandPrixName = grandPrixName;
			this.driverFinish = driverFinish;
			for (Driver driver : driverFinish) {
				driver.addRace(this);
			}
			
		}
	}

	public void probieren() {
		for (int i = 0; i < driverFinish.length; i++) {
			System.out.println(driverFinish[i].getFirstName() + " " + driverFinish[i].getSurname());
		}
	}

	public String getName() {
		return grandPrixName;
	}

	public int getDriverPoints(Driver driver) {
		int[] pointLUT = new int[] { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };
		int position = 10;
		for (int i = 0; i < driverFinish.length; i++) {
			if (driver.equals(driverFinish[i])) {
				position = i;
			}
		}
		if (position < 10) {
			return pointLUT[position];
		} else {
			return 0;
		}

	}

}
