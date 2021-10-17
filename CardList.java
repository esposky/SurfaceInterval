package nauiTables;

public class CardList {
	private CertCard[] list;
	
	CardList(CertCard[] list){
		setCardList(list);
	}
	
	private void setCardList(CertCard[] list){
		this.list = list;
	}
	
	public CertCard[] getCardList() {
		return list;
	}
}
