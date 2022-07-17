package fastag;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TollPrice {

	private static final Map<Integer, Integer> tollCharge;
	// static initializer
	static {

		Map<Integer, Integer> temptollChargeStorage = new HashMap<Integer, Integer>();
		temptollChargeStorage.put(1, 0);
		temptollChargeStorage.put(2, 10);
		temptollChargeStorage.put(3, 60);
		temptollChargeStorage.put(4, 60);
		temptollChargeStorage.put(5, 120);
		temptollChargeStorage.put(6, 150);

		tollCharge = Collections.unmodifiableMap(temptollChargeStorage);
	}

	//charge toll based on vehicle category.
	public static String chargeToll(Fastag fastag) {

		int vehicleCategoryId = fastag.getVehicle().getCategoryId();
		float fastagAvailableBalance = fastag.getFastagBalance();
		int amountDeducted = 0;

		for (Map.Entry<Integer, Integer> vehicleToll : tollCharge.entrySet()) {

			if (vehicleToll.getKey() == vehicleCategoryId) {

				fastagAvailableBalance -= vehicleToll.getValue();
				amountDeducted = vehicleToll.getValue();
			}
		}

		fastag.setFastagBalance(fastagAvailableBalance);

		return "₹" + amountDeducted + " debited from your FasTag, enjoy your journey:)"
				+ "\nExisting FasTag balance is ₹" + fastag.getFastagBalance();

	}

}
