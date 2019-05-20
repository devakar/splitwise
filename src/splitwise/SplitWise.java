package splitwise;
import java.util.ArrayList;
import java.util.HashMap;

import splitwise.*;
public class SplitWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u1 = new User(1, "dev", 1234, "d@gmail.com");
		User u2 = new User(2, "beta", 1234, "d@gmail.com");
		User u3 = new User(3, "alpha", 1234, "d@gmail.com");
		//System.out.println(u1.getUserName()+"   "+ u2.getUserName()+ "   "+u3.getUserName());
		Group g1 = new Group(1, "cp");
		//System.out.println(g1.getGroupName());
		g1.addUserToGroup(u1);
		g1.addUserToGroup(u2);
		g1.addUserToGroup(u3);
		
		
//		ArrayList<User> users = g1.getUsersInGroup();
		
//		for(int i=0;i<users.size();i++) {
//			System.out.println(users.get(i).getUserName());
//		}
		
		Bill b = new Bill(1, "restro", 300);
		BillManager m = new BillManager();
		
		
		ArrayList<User> payee = new ArrayList<User>();
		payee.add(u2);
		payee.add(u3);
		m.addBill(b, u1, payee);
		
		
		m.personView(u1);
		m.personView(u2);
		m.personView(u3);
		
		Bill b2 = new Bill(2, "restro", 300);
		m.addBill(g1,b2, u1, payee);
		m.groupView(g1);

	}

}
