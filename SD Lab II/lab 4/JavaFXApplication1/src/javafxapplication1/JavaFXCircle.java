/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author student
 */
public class JavaFXCircle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //CREATE A CIRCLE AND SET ITS PROPERTIES
        Circle circle=new Circle();
        circle.setCenterX(50);
        circle.setCenterY(50);
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.BLUEVIOLET);
        
        
        //CREATE LAYOUT TO HOLD THE CIRCLE
        Pane root=new Pane();
        root.getChildren().add(circle);
        
        //CREATE SCENE TO HOLE THE ROOT
        Scene scene=new Scene(root,300,300);
        
        //CREATE STAGE
        primaryStage.setTitle("First JavaFX program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
