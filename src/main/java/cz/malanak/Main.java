package cz.malanak;


import com.fasterxml.jackson.core.JsonProcessingException;
import cz.malanak.Helpers.PaymentCardManager;
import cz.malanak.Serialization.Serializer;
import cz.malanak.Services.SaveData;
import cz.malanak.accounts.BankAccount;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.accounts.StudentAccount;
import cz.malanak.card.PaymentCard;
import cz.malanak.factories.PaymentCardFactory;
import cz.malanak.factories.SerializerFactory;
import cz.malanak.identification.Customer;
import cz.malanak.Logger;

import java.math.BigDecimal;
import java.util.List;


/**
 * Main class
 */
public class Main {
    public PaymentCard[] cards;
    /**
     * Entrypoint
     * @param args Commandline arguments
     */
    public static void main(String[] args) throws JsonProcessingException {
        PaymentCardFactory paymentCardFactory = new PaymentCardFactory();
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
        PaymentCard card = paymentCardFactory.createPaymentCard(account2, PaymentCard.Type.debit);
        PaymentCardManager.addCard(card);
        PaymentCard card2 = paymentCardFactory.createPaymentCard(account2, PaymentCard.Type.credit);
        PaymentCardManager.addCard(card2);
        PaymentCard card3 = paymentCardFactory.createPaymentCard(account1, PaymentCard.Type.credit);
        PaymentCardManager.addCard(card3);
        Logger.info(card.toString());

        PaymentCard gotten_card = PaymentCardManager.getCard(card.getCardNumber());
        // Logger.info(gotten_card.toString());

        List<PaymentCard> cards_for_acc_2 = PaymentCardManager.getCards(account2);
        cards_for_acc_2.forEach((c) -> {
            Logger.debug(c.toString());
        });

        // Logger.info(SaveData.SaveData(arr, customers));
        // Logger.info(Serializer.Xml.serialize((SaveAccount) arr[2]));
    }
}