package lab4;

/**
 * Завдання 1.
 */
public sealed interface MobileSubscription
        permits MobileSubscription.Prepaid,
                MobileSubscription.Contract,
                MobileSubscription.Corporate {

    /** Предоплата */
    record Prepaid(double currentBalance, int availableMinutes) implements MobileSubscription { }

    /** Контракт */
    record Contract(double monthlyFee, boolean hasDebt) implements MobileSubscription { }

    /** Корпоративний */
    record Corporate(String companyName, double discountPercentage) implements MobileSubscription { }
}
