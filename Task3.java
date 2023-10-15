import java.util.Scanner;

class MyBankAccount   
 {
    private int myBalance;
    public MyBankAccount(int initialAmount)
	{
        this.myBalance = initialAmount;
    }

    public int checkMyBalance() 
	{
        return myBalance;
    }

    public void makeDeposit(int amount)
	{
        if (amount > 0) 
		{
            myBalance += amount;
            System.out.println("Deposit of " + amount + " Rs completed successfully");
        } else 
		{
            System.out.println("Invalid input. Please enter an amount greater than 0");
        }
    }

    public void makeWithdrawal(int amount) 
	{
        if (amount > 0 && amount <= myBalance)
		{
            System.out.println("Withdrawal of " + amount + " Rs completed successfully");
            myBalance -= amount;
        } else 
		{
            System.out.println("Invalid input!! Insufficient balance or negative value entered");
        }
    }
}

class MyATM {
    private MyBankAccount myAccount;

    public MyATM(MyBankAccount account) 
	{
        this.myAccount = account;
    }

    public void showOptions()
	{
        System.out.println("Select Options");
        System.out.println("1. Check Balance");
        System.out.println("2. Make a Deposit");
        System.out.println("3. Make a Withdrawal");
        System.out.println("4. Exit");
    }

    public void runATM() 
	{
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            showOptions();
            System.out.println("Enter your choice");
            choice = sc.nextInt();

            switch (choice)
			{
                case 1:
                    System.out.println("Your current balance: " + myAccount.checkMyBalance());
                    break;
                case 2:
                    System.out.println("Enter the deposit amount");
                    int depositAmount = sc.nextInt();
                    myAccount.makeDeposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter the withdrawal amount");
                    int withdrawAmount = sc.nextInt();
                    myAccount.makeWithdrawal(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice!! Please select from the available options");
            }
        } while (choice != 4);
        sc.close();
    }
}

public class Task3 
{
    public static void main(String[] args) 
	{
        int initialBalance = 5000; // Set initial account balance to 5000
        MyBankAccount myUserAccount = new MyBankAccount(initialBalance);
        MyATM myATM = new MyATM(myUserAccount);
        myATM.runATM();
    }
}