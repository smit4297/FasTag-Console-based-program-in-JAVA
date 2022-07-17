package fastag;

public class Fastag {
	
	private static int fastagIdGen = 1000;
	private int fastagId;
	private Vehicle vehicle;
	private BankAccount bankAccount;
	private float fastagBalance;
	
	public Fastag() {
		this.fastagId = ++fastagIdGen;
	}
	
	public Fastag(Vehicle vehicle, BankAccount bankAccount , float fastagBalance) {
		this();
		this.vehicle = vehicle;
		this.bankAccount = bankAccount;
		this.fastagBalance = fastagBalance;
	}

	public int getFastagId() {
		return fastagId;
	}

	public void setFastagId(int fastagId) {
		this.fastagId = fastagId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public float getFastagBalance() {
		return fastagBalance;
	}

	public void setFastagBalance(float fastagBalance) {
		this.fastagBalance = fastagBalance;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}	
	
}
