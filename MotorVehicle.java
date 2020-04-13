
public class MotorVehicle implements Ownable{

	private String model;
	
	public MotorVehicle(String model) {
		this.setModel(model);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String toString() {
		return model;
	}

	@Override
	public double getValue() {
		return 0;
	}
}
