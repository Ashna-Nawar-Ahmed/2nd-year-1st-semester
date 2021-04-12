/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offline.pkg5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Ashna Ahmed
 */
public class Offline5 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Circle");
        Button btn2 = new Button("Line");
        Button btn3 = new Button("Rectangle");
        final BorderPane root = new BorderPane();
        root.setBottom(btn);

        //EVENT HANDLING
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Circle circle = new Circle();
                circle.setCenterX(50);
                circle.setCenterY(50);
                circle.setRadius(50);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.CORNSILK);
                root.setCenter(circle);
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Line line = new Line();
                line.setStartX(20);
                line.setStartY(20);
                line.setEndX(100);
                line.setEndY(100);
                line.setStroke(Color.BLUE);

                root.setCenter(line);
                
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Rectangle r=new Rectangle();
                r.setHeight(60);
                r.setWidth(75);
                r.setStroke(Color.DARKSALMON);
                
                root.setCenter(r);

            }
        });
        //static double Xstart;
        //final double Ystart,Xend,Yend;
        btn.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            double Xstart;
                Xstart=event.getX();
                
                System.out.println(Xstart);
            }
        });

        Pane root2 = new Pane();
        
        Scene scene = new Scene(root, 300, 300);
        HBox layout2 = new HBox(10);
        layout2.getChildren().addAll(btn, btn2,btn3);
        root.setBottom(layout2);
        //CREATE STAGE
        primaryStage.setTitle("JavaFX program");
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
