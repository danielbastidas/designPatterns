/** Null Object pattern: a no operation object that conforms to the required
 * interface satisfying dependency requirement of some other object
 * Do you want no behavior
 * Avoids null check
 * When there is no option of telling component A to use an instance o
 * component B */
class Scratch {
    public static void main(String[] args) throws Exception {
        NullLog log = new NullLog();
        Account account = new Account(log);
        account.someOperation();
    }
}

interface Log
{
    // max # of elements in the log
    int getRecordLimit();

    // number of elements already in the log
    int getRecordCount();

    // expected to increment record count
    void logInfo(String message);
}

class Account
{
    private Log log;

    public Account(Log log)
    {
        this.log = log;
    }

    public void someOperation() throws Exception
    {
        int c = log.getRecordCount();
        log.logInfo("Performing an operation");
        if (c+1 != log.getRecordCount())
            throw new Exception();
        if (log.getRecordCount() >= log.getRecordLimit())
            throw new Exception();
    }
}

class NullLog implements Log
{

    private int recordCount = 0;

    // max # of elements in the log
    public int getRecordLimit(){return Integer.MAX_VALUE;}

    // number of elements already in the log
    public int getRecordCount(){return ++recordCount;}

    // expected to increment record count
    public void logInfo(String message){}
}