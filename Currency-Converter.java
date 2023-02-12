import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount in USD: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the target currency code (e.g. EUR, GBP, JPY): ");
        String targetCurrency = scanner.next();
        double exchangeRate = getExchangeRate(targetCurrency);
        double convertedAmount = amount * exchangeRate;
        System.out.println("The converted amount is: " + convertedAmount + " " + targetCurrency);
    }

    public static double getExchangeRate(String targetCurrency) {
        try {
            URL url = new URL("https://openexchangerates.org/api/latest.json?app_id=YOUR_APP_ID");
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject json = new JSONObject(response.toString());
            JSONObject rates = json.getJSONObject("rates");
            return rates.getDouble(targetCurrency);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
