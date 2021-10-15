package nauiTables;

public class Wildlife {
	private String type;
	private String species;
	
	Wildlife(String ty, String sp){
		setType(ty);
		setSpecies(sp);
	}

	public String getType() {
		String temp = type;
		return temp;
	}

	private void setType(String type) {
		this.type = type;
	}

	public String getSpecies() {
		String temp = species;
		return temp;
	}

	private void setSpecies(String species) {
		this.species = species;
	}

	public String toString() {
		return "Type: " + getType() + ", Species: " + getSpecies();
	}
}
