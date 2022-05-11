import java.math.BigDecimal;
//import java.util.List;

public interface AccountService 
{
    //List<AccountObj> getAll();
    //List<AccountObj> getByUser(String custNum);
    //AccountObj find(int acc);
    void withdraw(String accountNum, BigDecimal amountToWithdraw);
}
