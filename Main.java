import java.math.BigDecimal;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hi. Welcome to the CashWithdraw App");

        System.out.print("Enter your account number:");
        String accountNumberIn = System.console().readLine();

        System.out.print("How much would you like to withdraw: ");
        BigDecimal withdrawIn = new BigDecimal(System.console().readLine());
        try
        {
            AccountImp account = new AccountImp();
            account.withdraw(accountNumberIn, withdrawIn);
            System.out.println ("Cash withdrawn successfully. GoodBye");
        }
        catch(NullPointerException ex)
        {
            System.err.println("ERROR - " + ex.getMessage());
        }
        catch(ArithmeticException ex)
        {
            System.err.println("ERROR - " + ex.getMessage());
        }
        
    }
}