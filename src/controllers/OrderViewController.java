package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Customer;
import models.Orders;
import utilities.DButilities;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class OrderViewController implements Initializable {

    @FXML
    private TextField orderIdTextField;

    @FXML
    private ComboBox ordersComboBox;

    @FXML
    private DatePicker orderDatePicker;

    @FXML
    private TextField priceTextField;
    @FXML
    private TextArea textArea;
    private Orders order;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> orderSet = new ArrayList<>();
        orderSet.addAll(Arrays.asList("Drinks", "Snacks", "Deserts", "Maincourse"));
        Orders orderView =new Orders("Harman","Kaur","39 sandway Drive","Female",
                LocalDate.of(2001,12,14),
                "22G5",orderSet,LocalDate.of(2021,04,15),22.44);
        orderIdTextField.setText(orderView.getOrderId());
        ordersComboBox.getItems().add(orderSet);
        orderDatePicker.getValue();
        priceTextField.setText(Integer.toString((int) orderView.getPrice()));
        DButilities.addOrders(order);
    }

    @FXML
    protected void submitButton(ActionEvent event) {
        textArea.setText("Thank you for yor order!!!");
    }

    @FXML
    private void changeToDashboard(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/DashboardViewController.fxml","Food Ordering");
    }
}
