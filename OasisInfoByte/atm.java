package program3;

//========= ATM  PROGRAM ===========

import java.util.*;

class user{
	   public String UserName="";
	   public int UserId;
	   public int Pin;
	   public double Balance = (double)0;
	   public double Withdraw = (double) 0 ;
	   public double Deposit = (double)0;
	   public double Transfer = (double)0;
	   
	   public user(String UserName, int UserId, int Pin, double Balance, double Withdraw, 
			   double Deposit, double Transfer){
		   this.UserName = UserName;
		   this.UserId = UserId;
		   this.Pin = Pin;
		   this.Balance = Balance;
		   this.Withdraw = Withdraw;
		   this.Deposit = Deposit;
		   this.Transfer = Transfer;
	   }
	   public void BalanceEnquiry() {
		   System.out.println("User Name is "+ UserName);
           System.out.println("Your Balance amount is "+ Balance);
           System.out.println("Your WithDrawl amount is "+ Withdraw);
	   }
	   
	   void withDrawAmount() {
	        System.out.println("Enter amount to be withdrawn");
	        Scanner s = new Scanner(System.in);
	        int Withdraw = s.nextInt();
	        if (Balance >= Withdraw) {
	            Balance = Balance - Withdraw;
	            this.Withdraw += Withdraw;
	            System.out.println("An amount of $: " + Withdraw + " has been successfully withdrawn");
	            System.out.println(" Available Balance is " + Balance);
	            System.out.println("Please collect your money");
	            

	        }
	        else{
	            System.out.println("Insufficient balance");
	        }
	    }
	   
	   void deposit1() {

	        System.out.println("Enter amount to be deposit");
	        Scanner s = new Scanner(System.in);
	        int Deposit = s.nextInt();
	        System.out.println("An amount of $: " + Deposit + "   has been successfully deposited ");
	        Balance = Balance + Deposit;
	        this.Deposit += Deposit;
	        System.out.println(" Available Balance is " + Balance);

	    }
	   
	   void transferBalance(){
	        System.out.println("Enter amount to be transfer");
	        Scanner s = new Scanner(System.in);
	        int Transfer = s.nextInt();
	        System.out.println("An amount of $: "  + Transfer + " has been transfer ");
	        Balance = Balance - Transfer;
	        this.Transfer += Transfer;
	        System.out.println(" Available Balance is " + Balance);
	    }

}

	
public class atm {

	public static void main(String[] args) {
        ArrayList<user> temp = new ArrayList<>();
        temp.add(new user("User1", 1901945, 12345, 1000000, 0, 0, 0));
        temp.add(new user("User2", 1901946, 12346, 10000000, 0, 0, 0));
        temp.add(new user("User3", 1901947, 12347, 100000, 0, 0, 0));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your user id");
        int userId = sc.nextInt();
        System.out.println("Enter your pin");
        int userPin = sc.nextInt();
        boolean flag = false;
        for(user User: temp) {
        	if(User.Pin == userPin && User.UserId == userId) {
        		System.out.println("Press 1 for Withdraw");
                System.out.println("Press 2 for Deposit");
                System.out.println("Press 3 for Transfer");
                System.out.println("Press 4 for Transaction History");
                System.out.println("Press 5 for Balance Enquiry ");
                System.out.println("Press 6 for Quit");
        		 flag = true;
        		 boolean run = true;
                 while (run) {

                     System.out.println("Enter Your Choice: ");
                     int choose = sc.nextInt();

                     switch (choose) {

                         case 1:
                             User.withDrawAmount();
                             break;
                         // return;
                         case 2:
                             User.deposit1();
                             break;
                         case 3:
                             User.transferBalance();
                             break;
                         case 5: 
                        	 User.BalanceEnquiry();
                        	 break;
                         case 6:
                        	 System.out.println("Thanks For Visiting .......");
                        	 run = false;
                         default:
                        	 System.out.println("INVALID CHOICE........");
                     }
                 }
                
        	}
        }
        if(flag == false) System.out.println("Incorrect user id"); 
         
        
	}

}
