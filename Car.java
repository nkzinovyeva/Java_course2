
import java.text.DecimalFormat;

public class Car extends MotorVehicle {

	private double value;

	public Car(String model, double value) {
		super(model);
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String toString() {
		DecimalFormat oneDecimal = new DecimalFormat("0.0");

		return "Car: " + getModel() + " (value " + oneDecimal.format(getValue()).replace(",", ".") + " euros)";
	}

}
