/** An object which represents an instruction to perform a particular action.
 * Contains all the information necessary for the action to be taken.
 * Allows you to perform an undo of the operation*/
class Scratch {
    public static void main(String[] args) {
        
    }
}

class Command
{
    enum Action
    {
        DEPOSIT, WITHDRAW
    }

    public Action action;
    public int amount;
    public boolean success;

    public Command(Action action, int amount)
    {
        this.action = action;
        this.amount = amount;
    }

}

class Account
{
    public int balance;

    public void process(Command c)
    {
        switch(c.action) {
            case DEPOSIT:
                balance+=c.amount;
                c.success = true;
                break;
            case WITHDRAW:
                if (c.amount >= balance) {
                    balance-=c.amount;
                    c.success = true;
                } else c.success = false;
                break;
        }
    }
}