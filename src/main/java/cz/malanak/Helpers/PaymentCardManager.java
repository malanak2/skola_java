package cz.malanak.Helpers;

import cz.malanak.accounts.BaseAccount;
import cz.malanak.card.PaymentCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PaymentCardManager {
    private static ArrayList<PaymentCard> cards = new ArrayList<PaymentCard>()
    ;

    public static void addCard(PaymentCard card) {
        cards.add(card);
    }

    public static boolean deleteCard(PaymentCard card) {
        return cards.remove(card);
    }

    public static PaymentCard getCard(String cardNumber) {
        return cards.stream().filter(c -> cardNumber.equals(c.getCardNumber())).findFirst().orElse(null);
    }
    public static List<PaymentCard> getCards(BaseAccount account) {
        // Dejme tomu, streamy sou *********
        return cards.stream().filter(c -> account.uuid.equals(c.getAccountId())).collect(Collectors.toList());
    }
}
