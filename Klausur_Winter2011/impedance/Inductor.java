package impedance;

public class Inductor extends Impedance {

	private double valueInHenry;

	public Inductor(double valueInHenry) {
		super();
		if (valueInHenry < 0) {

			throw new NegativeNumberException(valueInHenry);
		} else
			this.valueInHenry = valueInHenry;
	}

	public double getValueInHenry() {
		return valueInHenry;
	}

	@Override
	public Complex getImpedanceAtOmega(double omega) {
		if (omega < 0) {
			throw new NegativeNumberException(omega);

		} else
			return new Complex(0, omega * valueInHenry);
	}

}
