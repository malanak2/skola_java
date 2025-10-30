package cz.malanak.accounts;

import cz.malanak.Logger;
import cz.malanak.identification.Customer;

public class StudentAccount extends BaseAccount {
    private String _isic;
    private String _school;
    public StudentAccount(Customer owner, String ISIC, String School, AccountHelper accountHelper, Logger logger) {
        super(owner, accountHelper, logger);
        _isic = ISIC;
        _school = School;
    }

    public String get_isic() {
        return _isic;
    }

    public String get_school() {
        return _school;
    }

    @Override
    public void printAccountInfo() {
        logger.debug(String.format("[StudentAccount]: %s, %s, %s, %s, %f", owner.toString(), uuid.toString(), _isic, _school, _balance.floatValue()));
    }
}
