package CarModels;

public abstract class Car {
	private String brand;
	private String modelName;
	private int powerEngine;
	private int price;
	
	public Car(String brand, String modelName, int powerEngine, int price) {
		this.brand = brand;
		this.modelName = modelName;
		this.powerEngine = powerEngine;
		this.price = price;
	}
	
	public abstract String toString();

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPowerEngine() {
		return powerEngine;
	}

	public void setPowerEngine(int powerEngine) {
		this.powerEngine = powerEngine;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
