package cz.malanak.Services;

import cz.malanak.accounts.BaseAccount;
import cz.malanak.card.PaymentCard;
import cz.malanak.identification.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccountService {
    private final List<BaseAccount> accounts = new ArrayList<>();

    public void addAccount(BaseAccount account) {
        accounts.add(account);
    }

    public boolean deleteAccount(BaseAccount account) {
        return accounts.remove(accounts);
    }

    public BaseAccount getAccountById(UUID accountId) {
        return accounts.stream().filter(a -> accountId.equals(a.uuid)).findFirst().orElse(null);
    }

    public List<BaseAccount> getAccountsForCustomer(Customer customer) {
        return accounts.stream().filter(a -> customer.uuid.equals(a.uuid)).collect(Collectors.toList());
    }
}
