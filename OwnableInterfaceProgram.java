
public class OwnableInterfaceProgram {

	public static void main(String[] args) {
		Car car = new Car("VW Golf", 5000);
	    Bicycle bike1 = new Bicycle("Colnago C50", 520);
	    Bicycle bike2 = new Bicycle("Trek 9500", 340);
	    PublicBus bus1 = new PublicBus("Ebusco Coach", "10");
	    PublicBus bus2 = new PublicBus("Volvo Coach", "11");

	    MotorVehicle[] motorVehicles = { car, bus1, bus2 };
	    Ownable[] myOwnVehicles = { car, bike1, bike2 };
	    double totalValue = 0;

	    System.out.println("=== All motor vehicles ===");
	    for (MotorVehicle vehicle : motorVehicles) {
	        System.out.println(vehicle);
	    }

	    System.out.println("\n=== My own vehicles ===");
	    for (Ownable ownVehicle : myOwnVehicles) {
	        System.out.println(ownVehicle);
	        totalValue += ownVehicle.getValue();
	    }
	    System.out.println("-------------------------");
	    System.out.println("The total value is " + totalValue + " euros.");
	}

}
