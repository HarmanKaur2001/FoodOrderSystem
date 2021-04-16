package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Customer;
import models.Orders;
import utilities.DButilities;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardViewController implements Initializable {

    @FXML
    private Label customersLabel;

    @FXML
    private Label ordersLabel;

    @FXML
    private ListView<Customer> customersListView;

    @FXML
    private ListView<Orders> ordersListView;


    @FXML
    private void createNewCustomer(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/CustomerView.fxml","Food Order" );
    }

    @FXML
    private void createNewOrder(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/OrderViewController.fxml","Here you can order");
    }




    @FXML
    private void createNewCustomersButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/CustomerView.fxml"));
        Scene scene = new Scene(root);

        //get the stage from the event that was passed in
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Food Ordering - Create New Customer");
        stage.setTitle("Food Ordering - Create New Order");
        stage.show();
    }

    @FXML
    private void createNewOrdersButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/OrderViewController.fxml"));
        Scene scene = new Scene(root);

        //get the stage from the event that was passed in
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Food Ordering - Create New Customer");
        stage.setTitle("Food Ordering - Create New Order");
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Customer customer: DButilities.getAllCustomers()){
            customersListView.getItems().add(customer);
            for(Orders orders: DButilities.getAllOrders()){
                ordersListView.getItems().add(orders);
            }
        }
    }
}
