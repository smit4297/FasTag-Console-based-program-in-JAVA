package fastag;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VehicleCategory {

	private static final Map<Integer, String> vehicleCategory;
	// static initializer
	static {

		Map<Integer, String> tempCategoryStorage = new HashMap<Integer, String>();
		tempCategoryStorage.put(1, "2-wheeler");
		tempCategoryStorage.put(2, "3-wheeler");
		tempCategoryStorage.put(3, "LMV-noncommercial");
		tempCategoryStorage.put(4, "LMV-commercial");
		tempCategoryStorage.put(5, "HMV-noncommercial");
		tempCategoryStorage.put(6, "HMV-commercial");

		vehicleCategory = Collections.unmodifiableMap(tempCategoryStorage);
	}

	//find category id based on category passed in argument.
	public static Integer findCategoryId(String category) {
		Integer id = -1;

		for (Map.Entry<Integer, String> vehicle : vehicleCategory.entrySet()) {
			if (vehicle.getValue().toLowerCase().equals(category.toLowerCase())) {
				id = vehicle.getKey();
				break;
			}
		}
		return id;
	}

	public static Map<Integer, String> getVehiclecategory() {
		return vehicleCategory;
	}

}
