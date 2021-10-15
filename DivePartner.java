package nauiTables;

public class DivePartner {
	private String name;
	private String certNum;
	private String role;
	
	DivePartner(String name, String number, String role){
		setName(name);
		setCertNum(number);
		setRole(role);
	}

	public String getName() {
		String temp = name;
		return temp;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getCertNum() {
		String temp = certNum;
		return temp;
	}

	private void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getRole() {
		String temp = role;
		return temp;
	}

	private void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Name: " + getName() + ", CertNum: " + getCertNum() + ", Role: " + getRole();
	}
	
	
}
