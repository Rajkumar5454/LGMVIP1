import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static Map<String, Double> exchangeRates;

    static {
        // Initialize exchange rate table
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.72);
        // Add more exchange rates as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Perform conversion
        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);

        // Display result
        System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        // Retrieve exchange rates from the table
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        // Perform conversion
        return (amount / baseRate) * targetRate;
    }
}
