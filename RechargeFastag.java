package fastag;

public class RechargeFastag {

	//re charge the FasTag based on re charge amount.
	public static String rechargefastag(Fastag fastag, int rechargeAmount) throws InsuffcientFundsException {

		float bankBalance = fastag.getBankAccount().getAccountBalance();
		float existingFastagBalance = fastag.getFastagBalance();

		if (rechargeAmount > bankBalance)
			throw new InsuffcientFundsException("Insuffcient funds in bank account.");

		fastag.setFastagBalance(existingFastagBalance + rechargeAmount);
		fastag.getBankAccount().setAccountBalance(bankBalance - rechargeAmount);

		return "Fastag Recharge Successful.";

	}
}
