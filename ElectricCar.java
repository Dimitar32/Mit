package CarModels;

public class ElectricCar extends Car{
	private int capacity;
	
	public ElectricCar(String brand, String modelName, int powerEngine, int capacity, int price) {
		super(brand, modelName, powerEngine, price);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ELECTRIC_CAR ")
			.append(getBrand()).append(", ")
			.append(getModelName()).append(", ")
			.append(getPowerEngine()).append("KW, ")
			.append(getCapacity()).append("Ah, ")
			.append(getPrice()).append(" euro");
		
		return sb.toString();
	}

}
