package fastag;

import java.util.ArrayList;
import java.util.List;

public class VehicleDatabase {

	//temp database for 6 different category vehicles. 
	public static List<Vehicle> vehicles = new ArrayList<Vehicle>();
	static {
		vehicles.add(new Vehicle("Henish Patel", "2-wheeler", "GJ 02 AQ 9997"));
		vehicles.add(new Vehicle("Harsh Patel", "3-wheeler", "GJ 01 LS 1234"));
		vehicles.add(new Vehicle("Smit Patel", "LMV-noncommercial", "GJ 02 BD 6016"));
		vehicles.add(new Vehicle("Saloni Mathur", "LMV-commercial", "RJ 02 ES 4297"));
		vehicles.add(new Vehicle("Elon Musk", "HMV-noncommercial", "RJ 04 AR 4572"));
		vehicles.add(new Vehicle("Bill Gates", "HMV-commercial", "MH 01 PR 9995"));
	}

	public static List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	static {
		bankAccounts.add(new BankAccount("State Bank Of India", "Henish Patel", 0.0f, "henish43@oksbi", "2453 6533 7927 6357"));
		bankAccounts.add(new BankAccount("Kotak Bank", "Harsh Patel", 25000f, "harshptl714@kotak", "7654 8737 9835 7624"));
		bankAccounts.add(new BankAccount("HDFC Bank", "Smit Patel", 300.0f, "9898729876@apl", "1263 8372 9372 9275"));
		bankAccounts.add(new BankAccount("ICICI Bank", "Saloni Mathur", 600.0f, "saloni@icici", "1234 5678 1234 5678"));
		bankAccounts.add(new BankAccount("Corporation Bank", "Elon Musk", 100000f, "elonmusk@ybl", "2453 6533 7927 6357"));
		bankAccounts.add(new BankAccount("State Bank Of India", "Bill Gates", 50000f, "billgates@oksbi", "4567 3456 9825 2334"));
	}

	//associate fasTags with vehicles and bank accounts.
	public static List<Fastag> fastags = new ArrayList<Fastag>();
	static {
		fastags.add(new Fastag(vehicles.get(0), bankAccounts.get(0), 0f));
		fastags.add(new Fastag(vehicles.get(1), bankAccounts.get(1), 100f));
		fastags.add(new Fastag(vehicles.get(2), bankAccounts.get(2), 30f));
		fastags.add(new Fastag(vehicles.get(3), bankAccounts.get(3), 50f));
		fastags.add(new Fastag(vehicles.get(4), bankAccounts.get(4), 1000f));
		fastags.add(new Fastag(vehicles.get(5), bankAccounts.get(5), 500f));
	}

}
