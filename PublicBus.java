
public class PublicBus extends MotorVehicle {
	private String lineNumber;

	public PublicBus(String model, String lineNumber) {
		super(model);
		this.lineNumber = lineNumber;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String toString() {

		return "Bus: " + getModel() + " (line " + getLineNumber() + ")";

	}
}
