package CarModels;

public class GasCar extends Car{
	private float displacement;
	
	public GasCar(String brand, String modelName, float displacement, int powerEngine, int price) {
		super(brand, modelName, powerEngine, price);
		this.displacement = displacement;
	}

	public float getDisplacement() {
		return displacement;
	}

	public void setDisplacement(float displacement) {
		this.displacement = displacement;
	}

	@Override
	public String toString() {
		StringBuilder  sb = new StringBuilder();
		sb.append("GAS_CAR ")
			.append(getBrand()).append(", ")
			.append(getModelName()).append(", ")
			.append(getDisplacement()).append("L, ")
			.append(getPowerEngine()).append("KW, ")
			.append(getPrice()).append(" euro");
		
		return sb.toString();
	}
	
}
