import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    private BankAccount employee;
    @BeforeEach
    public void setUp(){
        employee = new BankAccount("Yin","White", 2,"1997-05-12","saving");
    }

    @Test
    public void canGetFirstName(){
        String result = employee.getFirstName();
        String expected = "Yin";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetFirstName(){
        employee.setFirstName("Yang");
        String result = employee.getFirstName();
        String expected = "Yang";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetLastName(){
        String result = employee.getLastName();
        String expected = "White";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetLastName(){
        employee.setLastName("Grey");
        String result = employee.getLastName();
        String expected = "Grey";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetAccountNum(){
        int result = employee.getAccountNumber();
        int expected = 2;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetAccountNum(){
        employee.setAccountNumber(635);
        int result = employee.getAccountNumber();
        int expected = 635;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetDOB(){
        LocalDate result = employee.getDateOfBirth();
        LocalDate expected = LocalDate.parse("1997-05-12");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetDOB(){
        employee.setDateOfBirth(LocalDate.parse("2001-01-01"));
        LocalDate result = employee.getDateOfBirth();
        LocalDate expected = LocalDate.parse("2001-01-01");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canGetBalance(){
        int result = employee.getBalance();
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canSetBalance(){
        employee.setBalance(55);
        int result = employee.getBalance();
        int expected = 55;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canDeposit(){
        employee.deposit(34);
        int result = employee.getBalance();
        int expected = 34;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canWithdrawal(){
        employee.deposit(100);
        employee.withdrawal(20);
        int result = employee.getBalance();
        int expected = 80;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canWithdrawalWithNegBalance(){
        employee.deposit(5);
        employee.withdrawal(20);
        int result = employee.getBalance();
        int expected = 5;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canPayInterestSaving(){
        employee.deposit(5);
        employee.payInterest();
        int result = employee.getBalance();
        int expected = 15;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void canPayInterestCurrent(){
        employee = new BankAccount("Yin","White", 2,"1997-05-12","current");
        employee.deposit(5);
        employee.payInterest();
        int result = employee.getBalance();
        int expected = 10;
        assertThat(result).isEqualTo(expected);
    }
}
