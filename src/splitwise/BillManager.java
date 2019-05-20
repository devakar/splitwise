package splitwise;

import splitwise.*;
import java.util.*;
import java.lang.*;

public class BillManager {
	private HashMap<User, Integer> user_account;
	private ArrayList<Bill> bills;
	private HashMap<Group, HashMap<User, Integer>> group_account;
	
	public BillManager() {
		user_account=new HashMap<User, Integer>();
		bills=new ArrayList<>();
		group_account = new HashMap<Group, HashMap<User, Integer>>();
	}
	
	public void addBill(Bill b, User u, ArrayList<User> payee) {
		bills.add(b);
		int amount=b.getBillAmount();
		//System.out.println("**** Bill amount"+amount);
		int amount_per_user=amount/(payee.size()+1);
		//System.out.println("**** Bill amount per user"+amount_per_user);
		user_account.put(u, amount-amount_per_user);
		for(int i=0;i<payee.size();i++) {
			user_account.put(payee.get(i), 0-amount_per_user);
		}
	}
	
	public void addBill(Group g, Bill b, User u, ArrayList<User> payee) {
		bills.add(b);
		int amount=b.getBillAmount();
		//System.out.println("**** Bill amount"+amount);
		int amount_per_user=amount/(payee.size()+1);
		//System.out.println("**** Bill amount per user"+amount_per_user);
		HashMap<User, Integer> user_acc = new HashMap<User, Integer>();
		user_acc.put(u, amount-amount_per_user);
		for(int i=0;i<payee.size();i++) {
			user_acc.put(payee.get(i), 0-amount_per_user);
		}
		group_account.put(g, user_acc);
	}
	
	public void groupView(Group g) {
		System.out.println("********* Group View ***********");
		HashMap<User, Integer> user_account=group_account.get(g);
		System.out.println("In group "+g.getGroupName());
		groupViewUtil(user_account);
	}
	
	public void personView(User u) {
		System.out.println("********* Person View ***********");
		int amount=user_account.get(u);
		int Max_Value = (int) Collections.max(user_account.values());
		User user_max = getKeyFromValue(user_account, Max_Value);

		if(amount>=0)
			System.out.println(u.getUserName() + " gets :" + amount);
		else
			System.out.println(u.getUserName() + " needs to pay " + user_max.getUserName() + ":" + Math.abs(amount));
	}
	
	public void groupViewUtil(HashMap<User, Integer> user_account) {
		int Max_Value = (int) Collections.max(user_account.values());
		User user_max = getKeyFromValue(user_account, Max_Value);
		
		System.out.println(user_max.getUserName() + " gets :" + Math.abs(Max_Value));
		
		HashMap<User, Integer> user_acc = new HashMap<User, Integer>();
		user_acc.putAll(user_account);
		findPath(user_acc);	
	}
	
	public void findPath(HashMap<User, Integer> user_account) {
        int Max_Value = (int) Collections.max(user_account.values());
        int Min_Value = (int) Collections.min(user_account.values());
        
        if (Max_Value != Min_Value) {
            User user_max = getKeyFromValue(user_account, Max_Value);
            User user_min = getKeyFromValue(user_account, Min_Value);
            
            int result = Max_Value + Min_Value;
            
            if (result >= 0) {
                System.out.println(user_min.getUserName() + " needs to pay " + user_max.getUserName() + ":" + Math.abs(Min_Value));
                user_account.remove(user_max);
                user_account.remove(user_min);
                user_account.put(user_max, result);
                user_account.put(user_min, 0);
            } else {
                System.out.println(user_min.getUserName() + " needs to pay " + user_max.getUserName() + ":" + Math.abs(Max_Value));


                user_account.remove(user_max);
                user_account.remove(user_min);
                user_account.put(user_max, 0);
                user_account.put(user_min, result);
            }
            findPath(user_account);
        }

    }
	
	public static User getKeyFromValue(HashMap <User, Integer> user_account, int value) {
		for (User u : user_account.keySet()) {
            if (user_account.get(u).equals(value)) {
                return u;
            }
        }
        return null;
	}
	
	public HashMap<User, Integer> getUserAccount(){
//		for (User u : user_account.keySet()) {
//			System.out.println("**** getUserAccount()  user amount"+user_account.get(u));
//		}
		return user_account;
	}
	
}
