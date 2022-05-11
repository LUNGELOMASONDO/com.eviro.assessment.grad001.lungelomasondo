import java.math.BigDecimal;
//import java.util.List;
//import java.util.stream.Collectors;

public class AccountImp implements AccountService
{
    private SystemDB _accounts;

    private static final BigDecimal SAVINGSMINBALANCE = new BigDecimal(1000);
    private static final BigDecimal OVERDRAFTLIMIT = new BigDecimal(100000);

    public AccountImp()
    {
        _accounts = SystemDB.getInstance();
    }

    @Override
    public void withdraw(String accountNum, BigDecimal amountToWithdraw)
    {
        AccountObj account = _accounts.db.stream().filter(c -> c.accountNum.equals(accountNum)).findFirst().orElse(null);
        
        if (account == null)
            throw new NullPointerException("Account [" + accountNum + "] does not exist");

        if (account instanceof SavingsAccountObj)
        {
            if (account.balance.subtract(amountToWithdraw).compareTo(SAVINGSMINBALANCE) == -1)
                throw new ArithmeticException("Your balance is currently R" + account.balance + " \nSavings accounts must have a minimum balance of R1000 at all times");
        }

        if (account instanceof CurrentAccountObj)
        {
            CurrentAccountObj cAccount = (CurrentAccountObj) account;

            if (cAccount.overdraft.compareTo(OVERDRAFTLIMIT) == 1)
                throw new ArithmeticException("This account exceeds the limit of R"+ OVERDRAFTLIMIT +" on overdraft");

            if (amountToWithdraw.compareTo(account.balance.add(OVERDRAFTLIMIT)) == 1)
                throw new ArithmeticException("One cannot withdraw more than the (balance[R" + account.balance + "] + overdraft limit[R" + OVERDRAFTLIMIT + "]) on a current account");
        }

        account.balance = account.balance.subtract(amountToWithdraw);
    }
    /*
    @Override
    public List<AccountObj> getAll()
    {
        return _accounts.db;
    }

    @Override
    public AccountObj find(int acc)
    {
        return _accounts.db.stream().filter(c -> c.accountNum == acc).findFirst().orElse(null);
    }

    @Override
    public List<AccountObj> getByUser(String custNum)
    {
        return _accounts.db.stream().filter(c -> c.customerNum.equalsIgnoreCase(custNum)).collect(Collectors.toList());
    }
    */
}
