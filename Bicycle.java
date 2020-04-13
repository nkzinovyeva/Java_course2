
import java.text.DecimalFormat;

public class Bicycle implements Ownable  {

	private String model;
	private double value;

	public Bicycle(String model, double value) {
		this.model = model;
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		DecimalFormat oneDecimal = new DecimalFormat("0.0");
		
		return  "Bicycle: " + getModel() + " (value " +  oneDecimal.format(getValue()).replace(",", ".") + " euros)";
	}
}
