package cz.malanak;

import com.google.inject.Inject;
import cz.malanak.Helpers.PaymentCardHelper;
import cz.malanak.Jobs.ApplyInterestJob;
import cz.malanak.Services.AccountService;
import cz.malanak.Services.CustomerService;
import cz.malanak.Services.PaymentCardService;
import cz.malanak.Services.SaveData;
import cz.malanak.accounts.*;
import cz.malanak.card.PaymentCard;
import cz.malanak.factories.AccountFactory;
import cz.malanak.factories.PaymentCardFactory;
import cz.malanak.factories.SerializerFactory;
import cz.malanak.identification.Customer;
import org.quartz.*;

import java.math.BigDecimal;
import java.util.List;


public class App {
    @Inject
    public AccountService accountService;
    @Inject
    public CustomerService customerService;
    @Inject
    public PaymentCardHelper paymentCardHelper;
    @Inject
    public Logger logger;
    @Inject
    public SerializerFactory serializerFactory;

    @Inject
    public PaymentCardService paymentCardService;
    @Inject
    public PaymentCardFactory paymentCardFactory;
    @Inject
    public AccountHelper accountHelper;
    @Inject
    public AccountFactory accountFactory;
    @Inject
    public SaveData saveData;
    @Inject
    public Scheduler scheduler;
    public void run() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            logger.error(e.getMessage());
            System.exit(1);
        }

        Customer customer = new Customer("Adolf Had");
        BankAccount account = new BankAccount(customer, accountHelper, logger);
        accountService.addAccount(account);
        account.printAccountInfo();
        account.addBalance(new BigDecimal("8999999999"));
        StudentAccount account1 = new StudentAccount(customer, "yes", "Mozartak", accountHelper, logger);
        accountService.addAccount(account1);
        account1.printAccountInfo();
        SaveAccount account2 = accountFactory.createSaveAccount(customer, new BigDecimal("0.5"));//new SaveAccount(customer, new BigDecimal("0.99"), accountHelper, logger);
        accountService.addAccount(account2);
        account2.printAccountInfo();
        BaseAccount[] arr = {account, account1, account2};
        Customer[] customers = {customer};
        PaymentCard card = paymentCardFactory.createPaymentCard(account2, PaymentCard.Type.debit);
        paymentCardService.addCard(card);
        PaymentCard card2 = paymentCardFactory.createPaymentCard(account2, PaymentCard.Type.credit);
        paymentCardService.addCard(card2);
        PaymentCard card3 = paymentCardFactory.createPaymentCard(account1, PaymentCard.Type.credit);
        paymentCardService.addCard(card3);
        logger.info(card.toString());

        // PaymentCard gotten_card = paymentCardService.getCardByNumber(card.getCardNumber());
        // Logger.info(gotten_card.toString());

        // List<PaymentCard> cards_for_acc_2 = paymentCardService.getCardsForAccount(account2);
        // cards_for_acc_2.forEach((c) -> logger.debug(c.toString()));


        // Logger.info(SaveData.SaveData(arr, customers));
        // Logger.info(Serializer.Xml.serialize((SaveAccount) arr[2]));
    }
}
