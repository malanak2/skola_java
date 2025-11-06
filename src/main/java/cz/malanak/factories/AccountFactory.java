package cz.malanak.factories;

import com.google.inject.Inject;
import cz.malanak.Jobs.ApplyInterestJob;
import cz.malanak.Logger;
import cz.malanak.Services.AccountService;
import cz.malanak.Services.TransactionService;
import cz.malanak.accounts.AccountHelper;
import cz.malanak.accounts.BankAccount;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.accounts.StudentAccount;
import cz.malanak.identification.Customer;
import org.quartz.*;

import java.math.BigDecimal;

public class AccountFactory {
    @Inject
    private AccountHelper accountHelper;
    @Inject
    AccountService accountService;
    @Inject
    private Logger logger;
    @Inject
    Scheduler scheduler;
    @Inject
    TransactionService transactionService;

    public BankAccount createAccount(Customer customer) {
        return new BankAccount(customer, accountHelper, logger);
    }
    public SaveAccount createSaveAccount(Customer customer, BigDecimal interest_rate) {
        SaveAccount account = new SaveAccount(customer, interest_rate, accountHelper, logger);
        JobDataMap jobData = new JobDataMap();
        jobData.put("account", account.uuid.toString());
        jobData.put("logger", logger);
        jobData.put("accountService", accountService);
        jobData.put("transactionService", transactionService);
        // Define a job
        JobDetail job = JobBuilder.newJob(ApplyInterestJob.class)
                .withIdentity("applyInterestJob-" + account.uuid, "interest")
                .setJobData(jobData)
                .build();

        // Create a trigger with a cron expression (runs every 5 minutes)
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("applyInterestTrigger-" + account.uuid, "interest")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * ? * * *"))
                .build();

        // Schedule the job
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            logger.error(e.getMessage());
            return null;
        }
        return account;
    }
    public StudentAccount createStudentAccount(Customer customer, String isic, String school) {
        return new StudentAccount(customer, isic, school, accountHelper, logger);
    }
}
