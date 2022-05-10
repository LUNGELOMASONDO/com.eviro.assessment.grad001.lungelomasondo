public class SavingsAccountObj extends AccountObj
{
    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;

        if(!(o instanceof SavingsAccountObj))
            return false;

        SavingsAccountObj c = (SavingsAccountObj) o;

        return Integer.compare(super.id, c.id) == 0 
                || Integer.compare(super.accountNum, c.accountNum) == 0;
    }
}