package cz.malanak.card;

import java.util.Date;
import java.util.UUID;

public class PaymentCard {
    private final String cardNumber;
    private final Date expirationDate;
    private final int ccv;
    private final int pin;
    public enum Type {
        credit,
        debit
    }
    public final Type type;

    private UUID accountId;

    public String getCardNumber() {
        return cardNumber;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public PaymentCard(UUID accountId, int ccv, Date expirationDate, String cardNumber, int pin, Type type) {
        this.accountId = accountId;
        this.ccv = ccv;
        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Id: %s, Owner: %s, Exp. date: %tm/%ty, Ccv: %d, Type: %s", cardNumber, accountId, expirationDate,expirationDate, ccv, type.name());
    }

    public boolean validatePin(int pin_to_validate) {
        return pin == pin_to_validate;
    }
}
