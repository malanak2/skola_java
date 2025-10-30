package cz.malanak.Services;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.inject.Inject;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.card.PaymentCard;
import cz.malanak.factories.AccountFactory;
import cz.malanak.factories.PaymentCardFactory;
import cz.malanak.identification.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
// Needs injection of Services
public class PaymentCardService {
    @Inject
    private AccountService accountService;

    private final List<PaymentCard> cards = new ArrayList<PaymentCard>();

    public void addCard(PaymentCard card) {
        cards.add(card);
    }

    public boolean deleteCard(PaymentCard card) {
        return cards.remove(card);
    }

    public PaymentCard getCardByNumber(String cardNumber) {
        return cards.stream().filter(c -> cardNumber.equals(c.getCardNumber())).findFirst().orElse(null);
    }
    public List<PaymentCard> getCardsForAccount(BaseAccount account) {
        return cards.stream().filter(c -> account.uuid.equals(c.getAccountId())).collect(Collectors.toList());
    }


    public BigDecimal withdrawWithCard(String cardNumber, BigDecimal amount, int pin) throws IllegalArgumentException {
        return withdrawWithCard(getCardByNumber(cardNumber), amount, pin);
    }
    public BigDecimal withdrawWithCard(PaymentCard card, BigDecimal amount, int pin) throws IllegalArgumentException {
        if (!card.validatePin(pin))
        {
            throw new IllegalArgumentException("Invalid pin");
        }
        BaseAccount account = accountService.getAccountById(card.getAccountId());
        return account.removeBalance(amount);
    }
}
