package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    @FXML
    TextField txtfieldMoneyAmount;
    @FXML
    TextField txtfieldRate;
    @FXML
    Label lblResult;
    @FXML
    ComboBox cmbCurrency;
    String selectedCurrency;

    public void btn1Click(ActionEvent actionEvent) {

        double rate = CurrencyLoader.getPurchaseRateNB(selectedCurrency);

        double money = 0;
        try {
            money = Double.parseDouble(txtfieldMoneyAmount.getText());
            System.out.println(money * rate);
            lblResult.setText("" + money * rate);
        } catch (Exception e) {

        }
    }

    public void btnRateClick(ActionEvent actionEvent) {
        ArrayList<String> currencyNames = new ArrayList<>();

        for (int i = 0; i < CurrencyLoader.currenciesList.size(); i++) {

            currencyNames.add(CurrencyLoader.currenciesList.get(i).getCurrency());
        }


        ObservableList<Object> langs = FXCollections.observableArrayList(currencyNames);
        cmbCurrency.setItems(langs);
        //cmbCurrency.setValue("USD");

    }

    public void cmbRateClick(ActionEvent actionEvent) {
        selectedCurrency = (String) cmbCurrency.getValue();
        txtfieldRate.setText("" + CurrencyLoader.getPurchaseRateNB(selectedCurrency));
/*
        System.out.println(CurrencyLoader.getRate());
        double rate =  CurrencyLoader.getRate(CurrencyLoader.currenciesList);
        txtfieldRate.setText(""+rate);

        double money = 0;
        try {
            money = Double.parseDouble(txtfieldMoneyAmount.getText());
            System.out.println(money*rate);
            lblResult.setText(""+money*rate);
        }
        catch(Exception e)
        {

        }
        */

    }


}
