package splitwise;
import splitwise.User;
import java.util.*;
public class Group {
	private int group_id;
	private String group_name;
	private ArrayList <User> users;
	
	public Group(int group_id, String group_name) {
		this.group_id=group_id;
		this.group_name=group_name;
		this.users=new ArrayList<User>();
	}
	
	public int getGroupId() {
		return group_id;
	}
	
	public String getGroupName() {
		return group_name;
	}
	
	public ArrayList<User> getUsersInGroup(){
		return users;
	}
	
	public void addUserToGroup(User u) {
		users.add(u);
	}
	
	public void removeUserFromGroup(User u) {
		users.remove(u);
	}
}
