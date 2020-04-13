
public class ComponentInheritanceProgram {

	public static void main(String[] args) {
		Component[] bike1 = { new Frame("F001", "SuperLight", "titanium", 1500),
				new GroupSet("GS01", "Campagnolo Record", 11, 2300) };
		Component[] bike2 = { new Frame("F002", "AluLight", "aluminium", 700),
				new GroupSet("GS02", "Shimano Ultegra", 10, 900) };
		double totalPrice = 0;
		System.out.println("--- Bike 1 ---");
		for (Component component : bike1) {
			System.out.println(component);
			totalPrice += component.getPrice();
		}
		System.out.println("Total price: " + totalPrice);
		totalPrice = 0;
		System.out.println("\n--- Bike 2 ---");
		for (Component component : bike2) {
			System.out.println(component);
			totalPrice += component.getPrice();
		}
		System.out.println("Total price: " + totalPrice);
	}
}