public class SystemDB
{
    private static SystemDB systemDB_instance = null;

    private SystemDB()
    {
        
    }

    public static SystemDB getInstance()
    {
        if (systemDB_instance == null)
            systemDB_instance = new SystemDB();

        return systemDB_instance;
    }
}