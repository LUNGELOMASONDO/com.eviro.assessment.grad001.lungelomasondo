import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SystemDB
{
    private static SystemDB systemDB_instance = null;

    public List<AccountObj> db;

    private SystemDB()
    {
        db = new ArrayList<AccountObj>();

        SavingsAccountObj s1 = new SavingsAccountObj();
        s1.id = 101;
        s1.accountNum = 1;
        s1.customerNum = "CUST001";
        s1.balance = new BigDecimal(2000);
        db.add(s1);

        SavingsAccountObj s2 = new SavingsAccountObj();
        s2.id = 102;
        s2.accountNum = 2;
        s2.customerNum = "CUST002";
        s2.balance = new BigDecimal(5000);
        db.add(s2);

        CurrentAccountObj s3 = new CurrentAccountObj();
        s3.id = 103;
        s3.accountNum = 3;
        s3.customerNum = "CUST003";
        s3.balance = new BigDecimal(1000);
        s3.overdraft = new BigDecimal(10000);
        db.add(s3);

        CurrentAccountObj s4 = new CurrentAccountObj();
        s4.id = 104;
        s4.accountNum = 4;
        s4.customerNum = "CUST004";
        s4.balance = new BigDecimal(-5000);
        s4.overdraft = new BigDecimal(20000);
        db.add(s4);
    }
    
    public static SystemDB getInstance()
    {
        if (systemDB_instance == null)
            systemDB_instance = new SystemDB();

        return systemDB_instance;
    }
}