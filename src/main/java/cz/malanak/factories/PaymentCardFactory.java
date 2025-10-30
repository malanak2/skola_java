package cz.malanak.factories;

import com.google.inject.Inject;
import cz.malanak.Helpers.PaymentCardHelper;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.card.PaymentCard;


public class PaymentCardFactory {
    @Inject
    private PaymentCardHelper paymentCardHelper;


    public PaymentCard createPaymentCard(BaseAccount account, PaymentCard.Type type) {
        return new PaymentCard(account.uuid, paymentCardHelper.GenerateCcv(), paymentCardHelper.generateExpDate(), paymentCardHelper.generateCardNumber(), paymentCardHelper.generatePin(), type);
    }


}
