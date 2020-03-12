package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       Pane pane = new Pane();

       Label l = new
               Label(" ");

       //Create a slider
      Slider slider  =  new Slider();
      //set the value of property min, max and value
     slider.setMin(0);
     slider.setMax(3);
     slider.setValue(0);
     //enable Tickable and Tick MArks
     slider.setShowTickLabels(true);
     slider.setShowTickMarks(true);
     slider.setMajorTickUnit(1);
     slider.setMinorTickCount(1);
     slider.setBlockIncrement(1);
     slider.setSnapToTicks(true);
   //  slider.setBackground(Background.EMPTY);

        slider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                        l.setText("Value:"+ t1);
                    }
                }
        );


        Label sliderCaption = new Label( "Adjust t ");

       /* Label sliderValue = new Label(
                Double.toString(slider.getValue()));*/





        Sphere sphere3 = new Sphere();
        sphere3.setRadius(10);
        sphere3.setCullFace(CullFace.BACK);

        Sphere sphere4 = new Sphere();
        sphere4.setRadius(10);
        sphere4.setCullFace(CullFace.BACK);

        Sphere sphere5 = new Sphere();
        sphere5.setRadius(10);
        sphere5.setCullFace(CullFace.BACK);



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

        /*VBox root = new
                VBox();
        root.getChildren().addAll(sphere,sphere1
                ,sphere2,sphere3,sphere4,sphere5,sliderCaption,slider);*/

       pane.getChildren().add(sphere);
       pane.getChildren().add(sphere1);
        pane.getChildren().add(sphere2);
        pane.getChildren().add(sphere3);
        pane.getChildren().add(sphere4);
        pane.getChildren().add(sphere5);
        pane.getChildren().add(slider);
        pane.getChildren().add(sliderCaption);
        pane.getChildren().add(l);

//        Group root = new Group(sphere);
        l.relocate(350,200);
        sliderCaption.relocate(120,200);
        slider.relocate(200,200);
        sphere.relocate(100,300);
        sphere1.relocate(200,300);
        sphere2.relocate(300,300);
        sphere3.relocate(150,350);
        sphere4.relocate(250,350);
        sphere5.relocate(350,350);
        Scene scene = new Scene(pane,700,400);
      //  scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        //scene.setFill(Color.BLACK);

       // primaryStage.setScene(new Scene(, 300,300));
        primaryStage.show();


        Bounds bounds = pane.getBoundsInLocal();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(250) ,
                new KeyValue(sphere.layoutYProperty(), bounds.getMaxY() -sphere.getRadius())));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline. play();

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(250),
                new KeyValue(sphere1.layoutYProperty(), bounds.getMaxY() -sphere1.getRadius())));
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1. play();

        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(250),
                new KeyValue(sphere2.layoutYProperty(), bounds.getMaxY() -sphere2.getRadius())));
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2. play();

        Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(250),
                new KeyValue(sphere3.layoutYProperty(), bounds.getMaxY() -sphere3.getRadius())));
        timeline3.setCycleCount(Animation.INDEFINITE);
        timeline3. play();

        Timeline timeline4 = new Timeline(new KeyFrame(Duration.millis(250),
                new KeyValue(sphere4.layoutYProperty(), bounds.getMaxY() -sphere4.getRadius())));
        timeline4.setCycleCount(Animation.INDEFINITE);
        timeline4. play();

        Timeline timeline5 = new Timeline(new KeyFrame(Duration.millis(250),
                new KeyValue(sphere5.layoutYProperty(), bounds.getMaxY() -sphere5.getRadius())));
        timeline5.setCycleCount(Animation.INDEFINITE);
        timeline5. play();

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
