package cz.malanak.Services;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.inject.Inject;
import cz.malanak.Logger;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.card.PaymentCard;
import cz.malanak.identification.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccountService {
    @Inject
    Logger logger;
    private final List<BaseAccount> accounts = new ArrayList<>();

    public Iterable<BaseAccount> getIterable() {
        return accounts;
    }

    public void addAccount(BaseAccount account) {
        if (account == null) {
            logger.error("A null has been passed.");
            return;
        }
        accounts.add(account);
    }

    public boolean deleteAccount(BaseAccount account) {
        return accounts.remove(account);
    }

    public BaseAccount getAccountById(UUID accountId) {
        return accounts.stream().filter(a -> accountId.toString().equals(a.uuid.toString())).findFirst().orElse(null);
    }

    public List<BaseAccount> getAccountsForCustomer(Customer customer) {
        return accounts.stream().filter(a -> customer.uuid.equals(a.uuid)).collect(Collectors.toList());
    }
}
