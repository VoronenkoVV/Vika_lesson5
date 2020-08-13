package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import org.apache.felix.utils.json.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class CurrencyLoader {

    public static ArrayList <Currency> currenciesList;

    public static String getDataByURI(String url) {
        String data = "";

        InputStream is = null;

        try {
            is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                try {
                    while (rd.ready()) {
                        data += rd.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static double getPurchaseRateNB(String currency) {
        double usd = -1;
        for (Currency t : currenciesList) {
            try {
                if (t.getCurrency().equals(currency)) {
                    return t.getPurchaseRateNB();
                }
            }
            catch (Exception e)
            {

            }

        }
        return usd;
    }

    public static void loadCurrencies() {
        String result = getDataByURI("https://api.privatbank.ua/p24api/exchange_rates?json&date=11.8.2020");
        System.out.println(result);
        JSONParser parser = new JSONParser(result);
        currenciesList=new ArrayList<>();

        ArrayList exchange = (ArrayList) parser.getParsed().get("exchangeRate");
        for (Object t : exchange) {
            HashMap tempMap = (HashMap) t;
            try {
                String currency= (String)tempMap.get("currency");
                Double saleRateNB = (Double)tempMap.get("saleRateNB");
                Double purchaseRateNB = (Double)tempMap.get("purchaseRateNB");

                currenciesList.add(new Currency(saleRateNB, purchaseRateNB, currency));
            }
            catch (Exception e)
            {

            }
        }
        currenciesList.remove(0);

    }


}
