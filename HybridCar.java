package CarModels;

public class HybridCar extends Car{
	private int capacity;
	private float displacement;
	
	public HybridCar(String brand, String modelName, float displacement, int powerEngine, int price, int capacity) {
		super(brand, modelName, powerEngine, price);
		this.capacity = capacity;
		this.displacement = displacement;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getDisplacement() {
		return displacement;
	}

	public void setDisplacement(float displacement) {
		this.displacement = displacement;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("HYBRID_CAR ")
			.append(getBrand()).append(", ")
			.append(getModelName()).append(", ")
			.append(getDisplacement()).append("L, ")
			.append(getPowerEngine()).append("KW, ")
			.append(getCapacity()).append("Ah, ")
			.append(getPrice()).append(" euro");
		
		return sb.toString();
	}

}
