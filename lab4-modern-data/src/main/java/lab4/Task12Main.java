package lab4;

import java.util.Arrays;

/** Завдання 1 та 2 */
public class Task12Main {

    public static void main(String[] args) {
        System.out.println("=== ЗАВДАННЯ 1: неруйнівна мутація ===");

        MobileSubscription.Prepaid prepaid = new MobileSubscription.Prepaid(120.50, 300);
        MobileSubscription.Contract contract = new MobileSubscription.Contract(350.0, false);
        MobileSubscription.Corporate corporate = new MobileSubscription.Corporate("TechCorp", 15);
        
        var prepaidCopy = new MobileSubscription.Prepaid(-10.0, prepaid.availableMinutes());
        var contractCopy = new MobileSubscription.Contract(contract.monthlyFee(), true);
        var corporateCopy = new MobileSubscription.Corporate(corporate.companyName(), 35);

        System.out.println("Оригінал : " + prepaid);
        System.out.println("Копія    : " + prepaidCopy);
        System.out.println("Оригінал : " + contract);
        System.out.println("Копія    : " + contractCopy);
        System.out.println("Оригінал : " + corporate);
        System.out.println("Копія    : " + corporateCopy);
        System.out.println("Оригінали не змінились (record незмінний), посилання різні: "
                + (prepaid != prepaidCopy));

        System.out.println("\n=== ЗАВДАННЯ 2: switch expression + pattern matching ===");

        MobileSubscription[] subscriptions = {
                new MobileSubscription.Prepaid(-5.25, 100),
                new MobileSubscription.Prepaid(20.0, 0),
                new MobileSubscription.Prepaid(200.0, 0),
                new MobileSubscription.Prepaid(150.0, 250),
                new MobileSubscription.Contract(700.0, true),
                new MobileSubscription.Contract(250.0, true),
                new MobileSubscription.Contract(0.0, false),
                new MobileSubscription.Contract(399.0, false),
                new MobileSubscription.Corporate("MegaHolding", 40),
                new MobileSubscription.Corporate("SmallFirm", 10),
                new MobileSubscription.Corporate("", 0),
                new MobileSubscription.Corporate("NoDiscount LLC", 0),
                prepaidCopy, contractCopy, corporateCopy
        };

        for (int i = 0; i < subscriptions.length; i++) {
            System.out.printf("%2d) %s%n    -> %s%n", i + 1, subscriptions[i],
                    SubscriptionRouter.route(subscriptions[i]));
        }
        System.out.println("\nВсього оброблено: " + Arrays.stream(subscriptions).count());
    }
}
