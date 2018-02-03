/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nkdvgdcheckerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author NicoleDillon
 */
public class CheckerboardFXMLController implements Initializable, Startable {
    private Stage stage;
 
    @FXML
    private VBox vbox;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private MenuBar menuBar;

    private CheckerBoard checkerboard;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkerboard = new CheckerBoard(8, 8, 600, 600);
    } 
    
    public void start(Stage stage) {
        this.stage = stage;

        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };

        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);

        refresh();
    }
    
    private void refresh() {
        anchorPane.getChildren().clear();
        checkerboard = new CheckerBoard(checkerboard.getNumRows(), checkerboard.getNumCols(), vbox.getWidth()-2, vbox.getHeight() - menuBar.getHeight() - 2, checkerboard.getLightColor(), checkerboard.getDarkColor());
        anchorPane.getChildren().addAll(checkerboard.build());
    }

    @FXML
    private void handleGrid(ActionEvent event) {
        //gets grid size and converts to int
        MenuItem item = (MenuItem)event.getSource();
        int size = Integer.parseInt(item.getId().substring(1));
        
        checkerboard = new CheckerBoard(size, size, checkerboard.getWidth(), checkerboard.getHeight(), checkerboard.getLightColor(), checkerboard.getDarkColor());
        checkerboard.build();
        refresh();
    }
    
    @FXML
    private void handleColors(ActionEvent event) {
        //get index number for color
        MenuItem item = (MenuItem)event.getSource();
        int color = Integer.parseInt(item.getId().substring(1));
        
        Color light[] = {Color.RED, Color.SKYBLUE};
        Color dark[] = {Color.BLACK, Color.DARKBLUE};
        
        checkerboard = new CheckerBoard(checkerboard.getNumRows(), checkerboard.getNumCols(), checkerboard.getWidth(), checkerboard.getHeight(), light[color], dark[color]);
        checkerboard.build(); 
        refresh();
    }
    
    
}
