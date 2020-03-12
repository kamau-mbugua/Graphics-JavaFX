package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       Pane pane = new Pane();

        Sphere sphere = new Sphere();
        sphere.setRadius(10);
        sphere.setCullFace(CullFace.FRONT);
//        sphere.setTranslateY(100);
//        sphere.setTranslateX(100);


        Sphere sphere1 = new Sphere();
        sphere1.setRadius(10);
        sphere1.setCullFace(CullFace.FRONT);
//        sphere1.setTranslateY(100);
//        sphere1.setTranslateX(120);
//
        Sphere sphere2 = new Sphere();
        sphere2.setRadius(10);
        sphere2.setCullFace(CullFace.FRONT);
//        sphere2.setTranslateY(100);
//        sphere2.setTranslateX(140);

       pane.getChildren().add(sphere);
       pane.getChildren().add(sphere1);
        pane.getChildren().add(sphere2);

//        Group root = new Group(sphere);

        sphere.relocate(100,0);
        sphere1.relocate(150,0);
        sphere2.relocate(200,0);
        Scene scene = new Scene(pane,400,400);
        primaryStage.setScene(scene);
       // primaryStage.setScene(new Scene(, 300,300));
        primaryStage.show();

        Bounds bounds = pane.getBoundsInLocal();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3),
                new KeyValue(sphere.layoutYProperty(), bounds.getMaxY()-sphere.getRadius())));
        timeline.setCycleCount(4);
        timeline.play();

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(3),
                new KeyValue(sphere1.layoutYProperty(), bounds.getMaxY()-sphere1.getRadius())));
        timeline1.setCycleCount(4);
        timeline1.play();

        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(3),
                new KeyValue(sphere2.layoutYProperty(), bounds.getMaxY()-sphere2.getRadius())));
        timeline2.setCycleCount(4);
        timeline2.play();

        primaryStage.setTitle("Write a program that draws three black dots of radius 0.25 at x = 0, 1, 2 along the x-axis.\n" +
                "Then display instead three black dots at positions t, t + 1, and t + 2 (using t = 0. 25\n" +
                "initially). Make the display toggle back and forth between the two sets of dots, once\n" +
                "\n" +
                "every quarter-second. Do you tend to see the dots as moving? What if you increase t to 0.\n" +
                "5? Include a slider that lets you adjust t from 0 to 3. Does the illusion of the dots moving\n" +
                "ever weaken? When t = 1, you could interpret the motion as “the outer dot jumps back\n" +
                "and forth from the far left (x = 0) to the far right (x = 3) while the middle two dots remain\n" +
                "fixed.” Can you persuade yourself that this is what you’re seeing? The strong impression\n" +
                "that the dots are moving as a group is remarkably hard to abandon, supporting the Gestalt\n" +
                "theory.");



      /*  Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
