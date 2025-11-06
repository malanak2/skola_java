package cz.malanak;


import com.google.inject.Guice;
import com.google.inject.Injector;
import cz.malanak.Helpers.PaymentCardHelper;
import cz.malanak.Services.AccountService;
import cz.malanak.Services.CustomerService;
import cz.malanak.Services.PaymentCardService;
import cz.malanak.accounts.BankAccount;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.accounts.StudentAccount;
import cz.malanak.card.PaymentCard;
import cz.malanak.factories.AccountFactory;
import cz.malanak.factories.PaymentCardFactory;
import cz.malanak.factories.SerializerFactory;
import cz.malanak.identification.Customer;
import jakarta.inject.Inject;
import org.apache.log4j.BasicConfigurator;

import java.math.BigDecimal;
import java.util.List;


/**
 * Main class
 */
public class Main {
    /**
     * Entrypoint
     * @param args Commandline arguments
     */
    public static void main(String[] args) {
        // Source - https://stackoverflow.com/questions/12532339/no-appenders-could-be-found-for-loggerlog4j
// Posted by maba
// Retrieved 2025-11-06, License - CC BY-SA 3.0

        BasicConfigurator.configure();

        Injector injector = Guice.createInjector(new BInjector());


        App app = injector.getInstance(App.class);
        app.run();
    }
}