package nauiTables;

public class Equipment {
	private String type;
	private String make;
	private String model;
	private boolean rental = false;
	private double price = 0;
	
	//Constructor for owned equipment
	Equipment(String ty, String ma, String mo){
		setType(ty);
		setMake(ma);
		setModel(mo);
	}
	
	//Constructor for rented equipment
	Equipment(String ty, String ma, String mo, boolean rent, double pr){
		setType(ty);
		setMake(ma);
		setModel(mo);
		setRental(rent);
		setPrice(pr);
	}

	public String getType() {
		String temp = type;
		return temp;
	}

	private void setType(String type) {
		this.type = type;
	}

	public String getMake() {
		String temp = make;
		return temp;
	}

	private void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		String temp = model;
		return temp;
	}

	private void setModel(String model) {
		this.model = model;
	}

	public boolean isRental() {
		boolean temp = rental;
		return temp;
	}

	private void setRental(boolean rental) {
		this.rental = rental;
	}

	public double getPrice() {
		double temp = price;
		return temp;
	}

	private void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		String res =  "Type: " + getType() + ", Make: " + getMake() + ", Model: " + getModel();
		if(isRental())
			res += ", Rental: "+ isRental() +", Price: " + getPrice(); 
		return res;
	}
}
