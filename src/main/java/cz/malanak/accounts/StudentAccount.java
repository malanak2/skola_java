package cz.malanak.accounts;

import cz.malanak.identification.Customer;

public class StudentAccount extends BaseAccount {
    private String _isic;
    private String _school;
    public StudentAccount(Customer owner, String ISIC, String School) {
        super(owner);
        _isic = ISIC;
        _school = School;
    }

    @Override
    public void printAccountInfo() {
        System.out.println(String.format("[StudentAccount]: %s, %s, %s, %s, %f", _owner.toString(), uuid.toString(), _isic, _school, _balance.floatValue()));
    }
}
