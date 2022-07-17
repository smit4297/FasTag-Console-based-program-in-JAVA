package fastag;

public class BankAccount {
	
	private static int accountIdGen = 2000;
	private int accountId;
	private float accountBalance;
	private String bankName;
	private String ownerName;
	private String upiId;
	private String debitCardNumber;
	
	public BankAccount() {
		this.accountId = ++accountIdGen;
	}
	
	public BankAccount( String bankName, String ownerName, float accountBalance, String upiId, String debitCardNumber) {
		this();
		this.accountBalance = accountBalance;
		this.bankName = bankName;
		this.ownerName = ownerName;
		this.upiId = upiId;
		this.debitCardNumber = debitCardNumber;
	}

	public int getAccountId() {
		return accountId;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getBankName() {
		return bankName;
	}

	public String getUpiId() {
		return upiId;
	}

	public String getDebitCardNumber() {
		return debitCardNumber;
	}

	
}
