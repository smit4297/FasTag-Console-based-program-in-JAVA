package fastag;

//exception class for InsuffcientFunds in bankaccount.
public class InsuffcientFundsException extends Exception {

	public InsuffcientFundsException() {

	}

	public InsuffcientFundsException(String msg) {
		super(msg);
	}

}
