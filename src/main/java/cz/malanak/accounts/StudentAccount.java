package cz.malanak.accounts;

import cz.malanak.identification.Customer;

public class StudentAccount extends BankAccount {
    private String _isic;
    private String _school;
    public StudentAccount(Customer owner, String ISIC, String School) {
        super(owner);
        _isic = ISIC;
        _school = School;
    }
}
