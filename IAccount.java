import java.math.BigDecimal;

public interface IAccount 
{
    void Deposit(BigDecimal amount);
    double CalcInterest();
    BigDecimal Withdraw()
}
