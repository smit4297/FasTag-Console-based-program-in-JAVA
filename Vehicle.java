package fastag;

public class Vehicle {

	private String owner;
	private int categoryId;
	private String licencePlateId;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String owner, String category, String licencePlateId){
		this();
		this.owner = owner;
		this.categoryId = VehicleCategory.findCategoryId(category);
		this.licencePlateId = licencePlateId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getLicencePlateId() {
		return licencePlateId;
	}

	public void setLicencePlateId(String licencePlateId) {
		this.licencePlateId = licencePlateId;
	}

	@Override
	public String toString() {
		return "Vehicle [owner=" + owner + ", categoryId=" + categoryId + ", licencePlateId=" + licencePlateId + "]";
	}
			
}
