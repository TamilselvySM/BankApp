package com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//class ThreadB extends Thread{
//    public void run( ) {
//       for(int i = 1; i <= 5; i++) {
//          System.out.println("From Thread B with i = "+ -1*i);
//       }
//       System.out.println("Exiting from Thread B ...");
//    }
//}

public class Main extends Thread {

	public static void main(String[] args) {
//		ThreadB b = new ThreadB();
//		b.start();
		Scanner input = new Scanner(System.in);
		int n = 0;
		int i=0;
		List<Bank> bank_list = new ArrayList<>();
		Main t1=new Main(); 
		System.out.println("BANK");
		do {
			System.out.println("Enter 1 for Create Account \t");
			System.out.println("Enter 2 for Check Balance \t");
			System.out.println("Enter 3 for Withdraw \t");
			System.out.println("Enter 4 for Deposit \t");
			System.out.println("Enter 5 for Exit \t");
			System.out.println("Enter 6 to view account Details \t");
			System.out.println();
			System.out.print("Enter your choice \t");
			int option = input.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter Details to create an account");
				System.out.print("Name \t");
				String name = input.next();
				System.out.print("Age \t");
				int age = input.nextInt(); 
				System.out.print("Phone Number \t"); 
				String number = input.next(); 
				System.out.print("Branch Name \t");
				String branch = input.next();
				String test=branch.substring(0,3);
//				test=test.concat("00");		
				i=i+1;
				String x=test+00+i;
				System.out.println("\n Your Account Number is "+x+"\n");
				double bal=0;
				System.out.println("Are you want to deposit?");
				System.out.println("Y for Yes, N for No");
				char a = input.next().charAt(0);
				
				if (a=='Y')
				{
					System.out.println("Enter the Amount to Deposit");
					bal = input.nextFloat();
					System.out.println("Current Balance = " + bal);
				}
				else if (a=='N')
				{
					System.out.println("Thank U");
				}
				else {
					System.out.println("Invalid input");
				}
				Bank details = new Bank();
				details.setName(name);
				details.setAge(age);
				details.setPhoneNumber(number);
				details.setBranchName(branch);
				details.setBalance(bal);
				bank_list.add(details);
				details.setAccountNumber(x);
				System.out.println(details);
				System.out.println();
				  if(bank_list.isEmpty())
				  {
					  System.out.println("xxxx");
				  }
				  else
				  {
					  t1.start();    
				  }
				
				break;

			case 2:	
//				System.out.println(bank_list.get(0).getAccountNumber());
				Bank acctest = new Bank();
				System.out.println("Please enter your account number =\t" );
				String accNum = input.next();
//				System.out.println(accNum);
				acctest.setAccountNumber(accNum);
				if(bank_list.contains(acctest))
				{
//				System.out.println(bank_list.indexOf(acctest));
				int y=bank_list.indexOf(acctest);
				 for (int l = 0; l < 10; l++) {
				 try{
				    Thread.sleep(1000);
					double bl=(bank_list.get(y).getBalance()*0.05)+bank_list.get(y).getBalance();
					bank_list.get(y).setBalance(bl);
				    }
				    catch(InterruptedException e)
				    {
				    	System.out.println("Interrupted Exception");
				    }  
			
				 }
				System.out.println("Your Current Balance = "+bank_list.get(y).getBalance());
				
				}
				else
				{
				System.out.println("Please check the entered number");
				}

				break;

			case 3:
				Bank acctest1 = new Bank();
				System.out.println("Please enter your account number =\t" );
				String acc = input.next();
				acctest1.setAccountNumber(acc);
				if(bank_list.contains(acctest1))
				{
					int y=bank_list.indexOf(acctest1);
					System.out.println("Your Current Balance = "+bank_list.get(y).getBalance());
					double c=bank_list.get(y).getBalance();
					System.out.println("Enter Amount to Withdraw");
					double wdAmount = input.nextFloat();
					if (wdAmount<c)
					{
						c=c-wdAmount;
						acctest1.setBalance(c);
						bank_list.get(y).setBalance(c);
						System.out.println("Current Balance = " + c);	
					}
					 else 
					 {
						System.out.println("Please check the entered amount \n");
					 }
				}
				else 
				{
					System.out.println("Please check the entered account Number \n");
				}
				
				break;

			case 4:
				Bank acctest2 = new Bank();
				System.out.println("Please enter your account number =\t" );
				String ac = input.next();
				acctest2.setAccountNumber(ac);
				if(bank_list.contains(acctest2))
				{
					int y=bank_list.indexOf(acctest2);
					System.out.println("Your Current Balance = "+bank_list.get(y).getBalance());
					double c=bank_list.get(y).getBalance();
					System.out.println("Enter Amount to Deposit");
					double dpAmount = input.nextFloat();
					c = c + dpAmount;
					System.out.println("Total Balance = " + c);
					bank_list.get(y).setBalance(c);
				}
				else 
				{
					System.out.println("Please check the entered account Number \n");
				}
				break;
			case 5:
				System.exit(0);
				break;
			case 6:
				System.out.println("Accounts Details");
				int size = bank_list.size();
				for(int g=0; g<size; g++)
				{
					System.out.println(bank_list.get(g));
				}
//				new Main().display(bank_list);
				break;
			default:
				System.out.println("Invalid input");
				System.out.println("\n");
				break;
			}
		} while (n >= 0);
	}
//	 public void run(){  
//		  for(int i=1;i<10;i++){  
//		    try{
//		    	Thread.sleep(1000);
//		    	}
//		    catch(InterruptedException e)
//		    {
//		    	System.out.println(e);
//		    }  
//		    System.out.println(i);  
//		  }  
//		 }  
//	public void display(List bank) {
//		System.out.println(bank.get(0));
//	}

//	private  double getBalance() {
//		return this.getBalance();
//	}
}
