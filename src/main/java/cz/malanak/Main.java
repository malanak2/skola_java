package cz.malanak;


import com.fasterxml.jackson.core.JsonProcessingException;
import cz.malanak.Serialization.Serializer;
import cz.malanak.Services.SaveData;
import cz.malanak.accounts.BankAccount;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.accounts.StudentAccount;
import cz.malanak.factories.SerializerFactory;
import cz.malanak.identification.Customer;
import cz.malanak.Logger;

import java.math.BigDecimal;


/**
 * Main class
 */
public class Main {
    /**
     * Entrypoint
     * @param args Commandline arguments
     */
    public static void main(String[] args) throws JsonProcessingException {

        Customer customer = new Customer("Adolf Had");
        BankAccount account = new BankAccount(customer);
        account.printAccountInfo();
        account.addBalance(new BigDecimal("8999999999"));
        StudentAccount account1 = new StudentAccount(customer, "yes", "Mozartak");
        account1.printAccountInfo();
        SaveAccount account2 = new SaveAccount(customer, new BigDecimal(-99));
        account2.printAccountInfo();
        BaseAccount[] arr = {account, account1, account2};
        Customer[] customers = {customer};

        Logger.info(SaveData.SaveData(arr, customers));
        Serializer serializer = SerializerFactory.createSerializer();
        Logger.info(Serializer.Xml.serialize((SaveAccount) arr[2]));
    }
}