package cz.malanak;

import com.google.inject.AbstractModule;
import cz.malanak.Services.AccountService;
import cz.malanak.Services.CustomerService;
import cz.malanak.Services.PaymentCardService;
import cz.malanak.accounts.AccountHelper;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.swing.*;

public class BInjector extends AbstractModule {
    @Override
    protected void configure() {
        try {
            bind(Scheduler.class).toInstance(
                    StdSchedulerFactory.getDefaultScheduler());
            bind(AccountService.class).toInstance(new AccountService());
            bind(CustomerService.class).toInstance(new CustomerService());
            bind(PaymentCardService.class).toInstance(new PaymentCardService());
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
