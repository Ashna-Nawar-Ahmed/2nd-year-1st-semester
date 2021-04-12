/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 *
 * @author Ashna Ahmed
 */
public class NewClass extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    private void reset(Canvas canvas, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        final Canvas canvas = new Canvas(300, 250);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        //final GraphicsContext gc = canvas.getGraphicsContext2D();
        // Clear away portions as the user drags the mouse
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                gc.clearRect(e.getX() - 2, e.getY() - 2, 5, 5);
            }
        });

        // Fill the Canvas with a Blue rectnagle when the user double-clicks
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (t.getClickCount() > 1) {
                    reset(canvas, Color.BLUE);
                }
            }
        });
    }

}
