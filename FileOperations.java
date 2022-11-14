package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import CarModels.Car;
import CarModels.ElectricCar;
import CarModels.GasCar;
import CarModels.HybridCar;

public class FileOperations {
	public static ArrayList<String> readFromFile(String path){
		ArrayList<String> rows = null;
		
		try(BufferedReader br = Files.newBufferedReader(Paths.get(path))){
			rows = (ArrayList<String>) br.lines().collect(Collectors.toList());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public static void writeToFile(ArrayList<String> list, String path) {
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))){
			for(String row : list) {
				bw.write(row);
				bw.newLine();
			}
			
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void catalogueCarType(ArrayList<ElectricCar> e, ArrayList<GasCar> g, ArrayList<HybridCar> h) {
		for (int i = 0; i < e.size(); i++) {
			ElectricCar e1 = e.get(i);
			System.out.println(e1.toString());
		}
		for (int i = 0; i < g.size(); i++) {
			GasCar g1 = g.get(i);
			System.out.println(g1.toString());
		}
		for (int i = 0; i < h.size(); i++) {
			HybridCar h1 = h.get(i);
			System.out.println(h1.toString());
		}
	}
	
	public static HybridCar makeHybridCar() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Brand:");
		String brand = scan.nextLine();		
		System.out.println("ModelName:");
		String modelName = scan.nextLine();
		System.out.println("Displacement:");
		float displacement = scan.nextFloat();
		System.out.println("Power:");
		int powerEngine = scan.nextInt();
		System.out.println("Capacity:");
		int capacity = scan.nextInt();
		System.out.println("Price:");
		int price = scan.nextInt();
		
		return new HybridCar(brand, modelName, displacement, powerEngine, capacity, price);
	}
	
	public static void fillCars(ArrayList<String> arr, ArrayList<GasCar> gasCar, ArrayList<HybridCar> hybridCar, ArrayList<ElectricCar> elCar, ArrayList<Car> c) {
		for (String s : arr) {
			String[] split = s.split(", ");
			String[] splitType = split[0].split(" ");
			if (splitType[0].equals("GAS_CAR")) {
				String brand = splitType[1];
				String modelName = split[1];
				float displacement = Float.parseFloat(split[2].substring(0, split[2].length() - 1));
				int power = Integer.parseInt(split[3].substring(0, split[3].length() - 2));
				int price = Integer.parseInt(split[4].substring(0, split[4].length() - 5));
				GasCar g = new GasCar(brand, modelName, displacement, power, price);
				gasCar.add(g);
				c.add(g);
				
				continue;
			}
			
			if (splitType[0].equals("HYBRID_CAR")) {
				String brand = splitType[1];
				String modelName = split[1];
				float displacement = Float.parseFloat(split[2].substring(0, split[2].length() - 1));
				int power = Integer.parseInt(split[3].substring(0, split[3].length() - 2));
				int capacity = Integer.parseInt(split[4].substring(0, split[4].length() - 2));
				int price = Integer.parseInt(split[5].substring(0, split[5].length() - 5));
				HybridCar h = new HybridCar(brand, modelName, displacement, power, capacity, price);
				hybridCar.add(h);
				c.add(h);
				
				continue;
			}
			
			if (splitType[0].equals("ELECTRIC_CAR")) {
				String brand = splitType[1];
				String modelName = split[1];
				int power = Integer.parseInt(split[2].substring(0, split[2].length() - 2));
				int capacity = Integer.parseInt(split[3].substring(0, split[3].length() - 2));
				int price = Integer.parseInt(split[4].substring(0, split[4].length() - 5));
				ElectricCar e = new ElectricCar(brand, modelName, power, capacity, price);
				elCar.add(e);
				c.add(e);
				
				continue;
			}
		}
	}
	
	public static void sortByBrand(ArrayList<Car> cars) {
		cars.sort((o1, o2) -> o1.getBrand().compareTo(o2.getBrand()));
		for (Car c : cars) {
			System.out.println(c.toString());
		}
	}
	
	public static GasCar makeGasCar() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Brand:");
		String brand = scan.nextLine();
		System.out.println("ModelName:");
		String modelName = scan.nextLine();
		System.out.println("Displacement:");
		float displacement = scan.nextFloat();
		System.out.println("Power:");
		int powerEngine = scan.nextInt();
		System.out.println("Price:");
		int price = scan.nextInt();
		
		return new GasCar(brand, modelName, displacement, powerEngine, price);
	}

	public static ElectricCar makeElectricCar() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Brand:");
		String brand = scan.nextLine();
		System.out.println("ModelName:");
		String modelName = scan.nextLine();
		System.out.println("Power:");
		int enginePower = scan.nextInt();
		System.out.println("Capacity:");
		int capacity = scan.nextInt();
		System.out.println("Price:");
		int price = scan.nextInt();
		
		return new ElectricCar(brand, modelName, enginePower, capacity, price); 	
	}
	
	
}
