package fastag;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FastagMinBalance {

	private static final Map<Integer, Integer> fastagMinimumBalance;
	// static initializer
	static {

		Map<Integer, Integer> tempBalaceStorage = new HashMap<Integer, Integer>();
		tempBalaceStorage.put(1, 0);
		tempBalaceStorage.put(2, 50);
		tempBalaceStorage.put(3, 150);
		tempBalaceStorage.put(4, 200);
		tempBalaceStorage.put(5, 250);
		tempBalaceStorage.put(6, 350);

		fastagMinimumBalance = Collections.unmodifiableMap(tempBalaceStorage);
	}

	//return minimum balance required in fastag according to vehicle category.
	public static int getMinBalance(Fastag fastag) {
		int minBalance = 0;
		int vehicleCategoryId = fastag.getVehicle().getCategoryId();
		for (Map.Entry<Integer, Integer> balance : fastagMinimumBalance.entrySet()) {
			if (balance.getKey() == vehicleCategoryId) {
				minBalance = balance.getValue();
				break;
			}
		}
		return minBalance;
	}

	//check weather the given fastag has minimum balance or not.
	public static boolean hasMinimumBalance(Fastag fastag) {

		int vehicleCategoryId = fastag.getVehicle().getCategoryId();
		float fastagAvailableBalance = fastag.getFastagBalance();

		for (Map.Entry<Integer, Integer> minBalance : fastagMinimumBalance.entrySet())
			if (minBalance.getKey() == vehicleCategoryId && fastagAvailableBalance >= minBalance.getValue())
				return true;

		return false;

	}
}
