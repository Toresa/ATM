import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Account {

    private int id;
    private double balance;
    private GregorianCalendar dateCreated;
    private static double annualInterestRate;

    Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        this.dateCreated = new GregorianCalendar();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getDateCreated() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(this.dateCreated.getTime());
        return date;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        return this.balance * (annualInterestRate/1200);
    }

    public boolean withdraw(double amount){
        if (amount>0 & amount<=this.getBalance()){
            this.balance -= amount;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deposit(double amount){
        if (amount>0){
            this.balance += amount;
            return true;
        }
        else {
            return false;
        }
    }


}
