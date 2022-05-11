import java.math.BigDecimal;

public class CurrentAccountObj extends AccountObj
{
    public BigDecimal overdraft;

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;

        if(!(o instanceof CurrentAccountObj))
            return false;

        CurrentAccountObj c = (CurrentAccountObj) o;

        return Integer.compare(super.id, c.id) == 0 
                || super.accountNum.equals(c.accountNum);
    }
}