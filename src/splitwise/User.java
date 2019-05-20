package splitwise;

public class User {
	private int user_id;
	private String user_name;
	private int mob_no;
	private String mail_id;
	
	public User(int user_id, String user_name, int mob_no, String mail_id) {
		this.user_id=user_id;
		this.user_name=user_name;
		this.mob_no=mob_no;
		this.mail_id=mail_id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public String getUserName() {
		return user_name;
	}
	
	public int getUserMobNo() {
		return mob_no;
	}
	
	public String getUserMailId() {
		return mail_id;
	}
	
}
