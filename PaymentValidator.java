package fastag;

public class PaymentValidator {

	public static String upiValidator(String upiId) {

		//detailed validation for UPI.
		String addressName = upiId.split("@")[0];
		String providerName = upiId.split("@")[1];

		if (upiId.split("@").length != 2)
			return "There Should Be Only One '@' in Upi Id.";

		else if (!addressName.matches("[a-zA-Z0-9.\\-_]+"))
			return "UPI address name only contains alphabets, digits, '.' and '_'.";

		else if (!providerName.matches("[a-zA-Z]+"))
			return "UPI provider name only contains alphabets.";

		return "valid";

	}

	public static String debitCardValidator(String debitCardNumber) {

		debitCardNumber = debitCardNumber.strip();

		if (debitCardNumber.length() != 19)
			return "Please Enter Only 16 Digits In Debit Card.";

		else if (!(debitCardNumber.charAt(4) == ' ' && debitCardNumber.charAt(9) == ' '
				&& debitCardNumber.charAt(14) == ' '))
			return "Please Enter Card-Number In Format Of XXXX XXXX XXXX XXXX.";

		for (int i = 0; i < debitCardNumber.length(); i++)
			if (!Character.isDigit(debitCardNumber.charAt(i)) && debitCardNumber.charAt(i) != ' ')
				return "Please Enter Only Digits.";

		return "valid";
	}

}
