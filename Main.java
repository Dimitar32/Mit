package Main;

import java.util.ArrayList;
import java.util.Scanner;

import CarModels.Car;
import CarModels.ElectricCar;
import CarModels.GasCar;
import CarModels.HybridCar;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();
//		String myPath = "C:\\Users\\Dimitar\\Desktop\\mitii.txt";
		
		ArrayList<String> stringCars = FileOperations.readFromFile(path);
		ArrayList<ElectricCar> electricCars = new ArrayList<>();
		ArrayList<GasCar> gasCars = new ArrayList<>();
		ArrayList<HybridCar> hybridCars = new ArrayList<>();
		ArrayList<Car> cars = new ArrayList<>();
		
		FileOperations.fillCars(stringCars, gasCars, hybridCars, electricCars, cars);
		
		options();
		int n = 0;
		while (n != 8) {
			System.out.println("Which option you choose: ");
			n = scan.nextInt();
			switch(n) {
			case 1:
				for (String s : stringCars) {
					System.out.println(s);
				}
				break;
			case 2:
				ElectricCar e = FileOperations.makeElectricCar();
				stringCars.add(e.toString());
				electricCars.add(e);
				cars.add(e);
				break;
			case 3:
				GasCar g = FileOperations.makeGasCar();
				stringCars.add(g.toString());
				gasCars.add(g);
				cars.add(g);
				break;
			case 4:
				HybridCar h = FileOperations.makeHybridCar();
				stringCars.add(h.toString());
				hybridCars.add(h);
				cars.add(h);
				break;
			case 5:
				FileOperations.catalogueCarType(electricCars, gasCars, hybridCars);
				break;
			case 6:
				FileOperations.sortByBrand(cars);
				break;
			case 7:
				FileOperations.writeToFile(stringCars, path);
				break;
			case 8:
				System.out.println("Stop the program");
				break;
			}
		}	
		scan.close();
	}
	
	private static void options() {
		System.out.println("Please make your choice:\r\n"
				+ "1 - Show the entire Mobility4You catalogue\r\n"
				+ "2 – Add a new electric car\r\n"
				+ "3 – Add a new gas-powered car\r\n"
				+ "4 – Add a new hybrid car\r\n"
				+ "5 - Show the entire Mobility4You catalogue sorted by car-type\r\n"
				+ "6 – Show the entire Mobility4You catalogue sorted by brand(alphabetically)\r\n"
				+ "7 – Write to file\r\n"
				+ "8 – Stop the program");
	}
}
