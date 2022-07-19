public class Main {

    public static void main(String[] args) throws NotEnoughMoneyException, InvalidNationIdException {
        Account account=new Account();
        account.deposit(1000);
        account.withdraw(2000);
        account.withdraw(100);
        System.out.println(account.amount);
        account.linkToNationalId(-4);
        account.linkToNationalId(100);
        System.out.println(account.nationalId);
    }
}

class Account {
    int accountNo, amount, nationalId;

    public Account(){

    }

    public void deposit(int amount){
        this.amount=amount;
    }

    public void withdraw(int amount) throws NotEnoughMoneyException{
        try{
            if(this.amount-amount<0)
                throw new NotEnoughMoneyException("NotEnoughMoneyException");
            else
                this.amount-=amount;
        }
        catch (NotEnoughMoneyException exception){
            System.err.println("NotEnoughMoneyException");
        }
    }

    public void linkToNationalId(int nationalId) throws InvalidNationIdException{
        try{
            if(nationalId<0)
                throw new NotEnoughMoneyException("InvalidNationIdException");
            else
                this.nationalId=nationalId;
        }
        catch (NotEnoughMoneyException exception){
            System.err.println("InvalidNationIdException");
        }
    }
}

class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

class InvalidNationIdException extends Exception{
    public InvalidNationIdException(String message) {
        super(message);
    }
}
