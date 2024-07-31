import java.util.*;
import java.text.*;

public class Atm
{
	public static void main(String[] args)
	{
		OptionMenu_vkp op=new OptionMenu_vkp();
		op.getLogin();
	}
}
class Atm_vkp
{
	Scanner input = new Scanner(System.in); 
	DecimalFormat df=new DecimalFormat("'Rupee '###,##0.00");
	int CN;
	int PN;
	double CB=2000;
	double SB=1000;
	void setCustomerNumber(int cn)
	{
	  CN=cn;	
	}
	void setPINNumber(int pn)
	{
	  PN=pn;	
	}
	int getCustomerNumber()
	{
		return CN;
	}
	int getPINNumber()
	{
		return PN;
	}
	void getCurrentbalance()
	{
		System.out.println("Your Current Account Balance : "+df.format(CB));
	}
	void getSavingbalance()
	{
		System.out.println("Your Saving Account Balance : "+df.format(SB));
	}
	void inputCurrentWithdraw()
	{
		System.out.println("Your Current Account Balance : "+ df.format(CB));
		System.out.println("Amount you want to withdraw from your Current Account : ");
		double amount= input.nextDouble();
		if((CB-amount) >= 0)
		{
			outputCurrentWithdraw(amount);
			System.out.println("Your New Current Account Balence : "+ df.format(CB));
		}
		else
		{
			System.out.println("Insufficient Balence");
		}
	}
	double outputCurrentWithdraw(double amount)
	{
		CB=CB-amount;
		return CB;
	}
void inputSavingWithdraw()
{
	System.out.println("Your Saving Account Balance : "+ df.format(SB));
	System.out.println("Amount you want to withdraw from your Saving Account : ");
	double amount= input.nextDouble();
	if((SB-amount) >= 0)
	{
		outputSavingWithdraw(amount);
		System.out.println("Your New Saving Account Balence : "+ df.format(SB));
	}
	else
	{
		System.out.println("Insufficient Balence");
	}
}
double outputSavingWithdraw(double amount)
{
	SB=SB-amount;
	return SB;
}
}
class OptionMenu_vkp extends Atm_vkp
{
	Scanner input = new Scanner(System.in);
	HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
	void getLogin()
	{ 
		int i=125;
		do
		{
			try 
			{
				data.put(11111,111);
				data.put(11112,222);
				data.put(11113,333);
				data.put(11114,444);
				data.put(11115,444);
				
				System.out.println("Welcome to VKP ATM");
				System.out.print("Enter your Customer number : ");
				setCustomerNumber(input.nextInt());
				System.out.println("Enter your PIN number:");
				setPINNumber(input.nextInt());
				
				int A=getCustomerNumber();
				int B=getPINNumber();
				
				if(data.containsKey(A) && data.get(A)==B)
				{
					getAccountType();
				}
				else
				{
					System.out.println("Wrong Customer Number or Pin Number");
					System.out.println("Please try again with valid Customer Number & PIN number");
				}
			}
			catch(InputMismatchException m)
			{
			  System.out.println("Please Enter only Numbers");
			  System.out.println("Characters and Symbols are not allowed");
			  i=450;
			}
			
		}while(i==125);
	}
	void getAccountType()
	{
		System.out.println("Select the Account Type you want to Access:");
		System.out.println("Type 1 : Current Account");
		System.out.println("Type 2 : Saving Account");
		System.out.println("Type 3 : Exit");
		System.out.print("Choice : ");
		
		int choice = input.nextInt();
		switch(choice)
		{
		case 1 : getCurrent();
			break;
		case 2 : getSaving();
			break;
		case 3 :
			System.out.println("Thank You for Using this ATM .VISIT AGAIN");
			break;
		default :
			System.out.println("Invalid Choice.");
			System.out.println("Please Enter Valid Choice");
			break;
		}
	}
	void getCurrent()
	{
		System.out.println("Current Account:");
		System.out.println("Type 1 : View Balance");
		System.out.println("Type 2 : Withdraw Funds");
		System.out.println("Type 3 : Deposite Funds");
		System.out.println("Type 4 : Exit");
		System.out.print("Choice : ");
		
		int choice=input.nextInt();
		switch(choice)
		{
		case 1:
			getCurrentbalance();
			getCurrent();
			break;
		case 2:
			inputCurrentWithdraw();
			getAccountType();
			break;
		case 3:
			break;
		case 4:
			System.out.println("Thank You for Using this ATM .VISIT AGAIN");
			break;
		default:
			System.out.println("Invalid Choice.");
			System.out.println("Please Enter Valid Choice");
		break;		
			
		}
	}
	void getSaving()
	{
		System.out.println("Saving Account:");
		System.out.println("Type 1 : View Balance");
		System.out.println("Type 2 : Withdraw Funds");
		System.out.println("Type 3 : Deposite Funds");
		System.out.println("Type 4 : Exit");
		System.out.print("Choice : ");
		
		int choice=input.nextInt();
		switch(choice)
		{
		case 1:
			getSavingbalance();
			getSaving();
			break;
		case 2:
			inputSavingWithdraw();
			getAccountType();
			break;
		case 3:
			
		case 4:
			System.out.println("Thank You for Using this ATM .VISIT AGAIN");
			break;
		default:
			System.out.println("Invalid Choice.");
			System.out.println("Please Enter Valid Choice");
		break;				
		}
	}
}
