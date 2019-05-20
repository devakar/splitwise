package splitwise;

public class Bill {
	private int bill_id;
	private String bill_name;
	private int bill_amount;
	
	public Bill(int bill_id, String bill_name, int bill_amount) {
		this.bill_id=bill_id;
		this.bill_name=bill_name;
		this.bill_amount=bill_amount;
	}
	
	public int getBillId() {
		return bill_id;
	}
	
	public String getBillName() {
		return bill_name;
	}
	
	public int getBillAmount() {
		return bill_amount;
	}
}
