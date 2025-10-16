package cz.malanak.factories;

import cz.malanak.accounts.BankAccount;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.accounts.StudentAccount;
import cz.malanak.identification.Customer;

import java.math.BigDecimal;

public class AccountFactory {
    public static BankAccount createAccount(Customer customer) {
        return new BankAccount(customer);
    }
    public static SaveAccount createSaveAccount(Customer customer, BigDecimal interest_rate) {
        return new SaveAccount(customer, interest_rate);
    }
    public static StudentAccount createStudentAccount(Customer customer, String isic, String school) {
        return new StudentAccount(customer, isic, school);
    }
}
