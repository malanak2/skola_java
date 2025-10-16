package cz.malanak.factories;

import cz.malanak.Helpers.PaymentCardHelper;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.card.PaymentCard;

import java.util.Calendar;
import java.util.Date;

public class PaymentCardFactory {
    public PaymentCard createPaymentCard(BaseAccount account, PaymentCard.Type type) {
        return new PaymentCard(account.uuid, PaymentCardHelper.GenerateCcv(), PaymentCardHelper.generateExpDate(), PaymentCardHelper.generateCardNumber(), type);
    }
}
