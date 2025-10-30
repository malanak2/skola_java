package cz.malanak.factories;

import com.google.inject.Inject;
import cz.malanak.Logger;
import cz.malanak.accounts.AccountHelper;
import cz.malanak.accounts.BankAccount;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.accounts.StudentAccount;
import cz.malanak.identification.Customer;

import java.math.BigDecimal;

public class AccountFactory {
    @Inject
    private AccountHelper accountHelper;
    @Inject
    private Logger logger;


    public BankAccount createAccount(Customer customer) {
        return new BankAccount(customer, accountHelper, logger);
    }
    public SaveAccount createSaveAccount(Customer customer, BigDecimal interest_rate) {
        return new SaveAccount(customer, interest_rate, accountHelper, logger);
    }
    public StudentAccount createStudentAccount(Customer customer, String isic, String school) {
        return new StudentAccount(customer, isic, school, accountHelper, logger);
    }
}
