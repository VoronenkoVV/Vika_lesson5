package sample;

import org.apache.felix.utils.json.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class getData {
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

    public static double getRate(String currency) {
        String result = getDataByURI("https://api.privatbank.ua/p24api/exchange_rates?json&date=11.8.2020");
        System.out.println(result);
        JSONParser parser = new JSONParser(result);

        ArrayList exchange = (ArrayList) parser.getParsed().get("exchangeRate");

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        double usd = -1;
        for (Object t : exchange) {
            HashMap tempMap = (HashMap) t;
            try {
                if (tempMap.get("currency").equals(currency)) {
                    usd = (double) tempMap.get("saleRateNB");
                    return usd;
                }
            }
            catch (Exception e)
            {

            }
        }
        return usd;
    }

}
