package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField txtfieldMoneyAmount;
    @FXML
    TextField txtfieldRate;
    @FXML
    Label lblResult;
    public void btn1Click(ActionEvent actionEvent) {
//String result=getData.getDataByURI("https://api.privatbank.ua/p24api/exchange_rates?json&date=11.8.2020");

        //System.out.println(getData.getRate("USD"));
        double usdRate =  getData.getRate("USD");
        txtfieldRate.setText(""+usdRate);

        double money = 0;
        try {
            money = Double.parseDouble(txtfieldMoneyAmount.getText());
            System.out.println(money*usdRate);
            lblResult.setText(""+money*usdRate);
        }
        catch(Exception e)
        {

        }


    }
}
