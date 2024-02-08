import java.time.LocalDate;

public class BankAccount {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private double balance;
    private String accountType;
    private double overdraft;

    public BankAccount(String firstName, String lastName, int accountNumber, String dateOfBirth, String accountType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.balance = 0;
        this.accountType = accountType;
        this.overdraft = 0;
    }

    //Getter and Setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(int amount){
        this.balance += amount;
    }

    //Other methods
    public void withdrawal(double amount){
        double check = this.balance - amount;
        if(check>overdraft){
            this.balance -= amount;
        }else{
            System.out.println("You have reached your overdraft limit");
        }
    }

    public void payInterest(){
        if(this.accountType == "saving"){
            this.balance += (balance * 2);
        }
        if(this.accountType == "current"){
            this.balance += (balance * 1);
        }
    }

}
