package cz.malanak.Jobs;

import com.google.inject.Inject;
import cz.malanak.Logger;
import cz.malanak.Services.AccountService;
import cz.malanak.Services.TransactionService;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.factories.TransactionFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.UUID;
import java.util.logging.Level;

public class ApplyInterestJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Logger logger = (Logger)jobExecutionContext.getJobDetail().getJobDataMap().get("logger");
        logger.info("Job run");
        UUID account_uuid = UUID.fromString((String)jobExecutionContext.getJobDetail().getJobDataMap().get("account"));
        AccountService accountService = (AccountService)jobExecutionContext.getJobDetail().getJobDataMap().get("accountService");
        SaveAccount account = (SaveAccount) accountService.getAccountById(account_uuid);
        TransactionService transactionService = (TransactionService) jobExecutionContext.getJobDetail().getJobDataMap().get("transactionService");
        logger.info(String.format("Applying interest for account %s", account.uuid));
        transactionService.applyInterest(account);
    }
}
