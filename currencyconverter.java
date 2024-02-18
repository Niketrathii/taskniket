import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Initialize some static exchange rates (replace with real-time rates)
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");

        // Allow the user to choose the base currency
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        // Allow the user to choose the target currency
        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Fetch real-time exchange rates from an API (not implemented in this example)
        // In a real scenario, you would use an API to get the latest exchange rates.

        // Take input from the user for the amount to convert
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Convert the amount from the base currency to the target currency
        double convertedAmount = convertCurrency(amountToConvert, baseCurrency, targetCurrency);

        // Display the result
        System.out.printf("%.2f %s is equal to %.2f %s\n",
                amountToConvert, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        if (exchangeRates.containsKey(baseCurrency) && exchangeRates.containsKey(targetCurrency)) {
            double baseRate = exchangeRates.get(baseCurrency);
            double targetRate = exchangeRates.get(targetCurrency);
            return (amount / baseRate) * targetRate;
        } else {
            System.out.println("Invalid currency codes. Unable to perform conversion.");
            System.exit(1);
            return 0; // To satisfy compiler, this line will not be executed due to System.exit(1)
        }
    }
}