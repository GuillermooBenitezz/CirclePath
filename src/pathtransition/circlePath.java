/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pathtransition;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;


/**
 *
 * @author usu2dam
 */
public class circlePath extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(40, 40, 30, 80);
        rectangle.setFill(Color.ORANGE);
        
        Circle circle = new Circle(140, 115, 70);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        pane.getChildren().addAll(circle, rectangle);
        
        PathTransition pathtrans = new PathTransition();
        pathtrans.setDuration(Duration.millis(4000));
        pathtrans.setPath(circle);
        pathtrans.setNode(rectangle); 

        pathtrans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathtrans.setCycleCount(Timeline.INDEFINITE);
        pathtrans.setAutoReverse(true);
        pathtrans.play();
        circle.setOnMousePressed(event -> pathtrans.pause());
        circle.setOnMouseReleased(event -> pathtrans.play());
        
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Circle Path Transition");
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
