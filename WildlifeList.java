package nauiTables;

import java.util.Arrays;

public class WildlifeList {
	private Wildlife[] wlList;

	public WildlifeList(Wildlife[] wlList) {
		setWlList(wlList);
	}

	public Wildlife[] getWlList() {
		Wildlife[] temp = new Wildlife[wlList.length];
		for(int i = 0; i < temp.length; i++)
			temp[i] = wlList[i];
		return temp;
	}

	public void setWlList(Wildlife[] wlList) {
		this.wlList = wlList;
	}

	public String toString() {
		return "WildlifeList [getWlList()=" + Arrays.toString(getWlList()) + "]";
	}
}
