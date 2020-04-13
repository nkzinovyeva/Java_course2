

import java.text.DecimalFormat;

public class GroupSet extends Component {

	private int gears;

	public GroupSet(String id, String name, int gears, double price) {
		super(id, name, price);
		this.gears = gears;
	}

	public int getGears() {
		return gears;
	}

	public void setGearsl(int gears) {
		this.gears = gears;
	}

	@Override
	public String toString() {
		DecimalFormat oneDecimal = new DecimalFormat("0.0");

		return getId() + ": " + getName() + " group set, " + getGears() + " gears, "
				+ oneDecimal.format(getPrice()).replace(",", ".") + " euros";
	}

}
