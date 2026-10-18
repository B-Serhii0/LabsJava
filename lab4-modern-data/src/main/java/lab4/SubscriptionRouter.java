package lab4;

import static java.lang.String.format;

/**
 * Завдання 2.
 */
public final class SubscriptionRouter {

    private SubscriptionRouter() { }

    public static String route(MobileSubscription subscription) {
        return switch (subscription) {

            // ---- Prepaid ----
            case MobileSubscription.Prepaid(double balance, int minutes) when balance < 0 ->
                    format("БЛОКУВАТИ вихідні дзвінки: від'ємний баланс (%.2f грн)", balance);
            case MobileSubscription.Prepaid(double balance, int minutes) when minutes == 0 && balance < 50 ->
                    "Запропонувати поповнити рахунок: хвилини вичерпано, баланс малий";
            case MobileSubscription.Prepaid(double balance, int minutes) when minutes == 0 ->
                    "Хвилини вичерпано — переведення на поминутну тарифікацію";
            case MobileSubscription.Prepaid(double balance, int minutes) ->
                    format("Тариф активний: баланс %.2f грн, %d хв доступно", balance, minutes);

            // ---- Contract ----
            case MobileSubscription.Contract(double fee, boolean debt) when debt && fee > 500 ->
                    "Передати у відділ стягнення: борг за дорогим контрактом";
            case MobileSubscription.Contract(double fee, boolean debt) when debt ->
                    "Надіслати нагадування про оплату заборгованості";
            case MobileSubscription.Contract(double fee, boolean debt) when fee == 0 ->
                    "Безкоштовний контракт — перевірити акційні умови";
            case MobileSubscription.Contract(double fee, boolean debt) ->
                    format("Контракт у нормі: щомісячна плата %.2f грн", fee);

            // ---- Corporate ----
            case MobileSubscription.Corporate(String company, double discount) when discount >= 30 ->
                    format("VIP-клієнт «%s»: закріпити персонального менеджера (знижка %.0f%%)", company, discount);
            case MobileSubscription.Corporate(String company, double discount) when discount > 0 ->
                    format("Корпоративна знижка %.0f%% для «%s»", discount, company);
            case MobileSubscription.Corporate(String company, double discount) when company.isBlank() ->
                    "Помилка даних: не вказано назву компанії";
            case MobileSubscription.Corporate(String company, double discount) ->
                    format("«%s»: знижки немає, запропонувати корпоративний пакет", company);
        };
    }
}
