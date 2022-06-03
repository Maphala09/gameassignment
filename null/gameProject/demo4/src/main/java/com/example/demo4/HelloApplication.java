package com.example.demo4;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
public class HelloApplication extends Application {
    int no = 0;
    Label one = new Label("score: ");
    Label two = new Label(" "+no);


    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root,600, 400);
        ImageView horror =  horror(scene);
        ImageView horror1 =  horror1(scene);
        ImageView horror2 =  horror2(scene);
        ImageView bonus =  bonus(scene);
        ImageView coin =  coin(scene);
        ImageView ship = createFighter(scene);
        one.setLayoutX(500);
        two.setLayoutX(536);
        root.getChildren().addAll(ship,horror,horror1,horror2,bonus,coin,one,two);
        BackgroundFill background_fill = new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        scene.addEventFilter(KeyEvent.KEY_PRESSED,event ->{
            double x = ship.getX();
            double y = ship.getY();
            switch (event.getCode()){
                case RIGHT -> ship.setX(x + 10);
                case LEFT -> ship.setX(x - 10);
                case UP -> ship.setY(y - 10);
                case DOWN -> ship.setY(y + 10);
            }
            if (ship.getBoundsInParent().intersects(horror.getBoundsInParent()) ||
                    ship.getBoundsInParent().intersects(horror1.getBoundsInParent()) ||
                    ship.getBoundsInParent().intersects(horror2.getBoundsInParent())) {
                System.out.println("YOUR DIED:....");
                ship.setImage(new Image("OVER.gif"));
                scene.addEventFilter(KeyEvent.KEY_PRESSED,event1 -> {
                    double hosh1 = ship.getX();
                    double hosh2 = ship.getY();

                    switch (event.getCode()){
                        case RIGHT -> ship.setX(x + 0);
                        case LEFT -> ship.setX(x - 0);
                        case UP -> ship.setY(y - 0);
                        case DOWN -> ship.setY(y + 0);
                    }
                });

            }
            else if((ship.getBoundsInParent().intersects(bonus.getBoundsInParent()) ||
                    ship.getBoundsInParent().intersects(coin.getBoundsInParent()))){
                System.out.println("coin");
                no=no+1;
                two.setText(""+no);
            }
        } );
        stage.setTitle("Plane Game!");
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.show();
    }
   private ImageView horror(Scene scene) {
        Image cloud = new Image("lo2.png");
        ImageView lo2 = new ImageView(cloud);
        lo2.setFitWidth(150);
        lo2.setFitHeight(150);
        //lo2.setLayoutX(500);
        lo2.setX(1600);
        lo2.setY(150);
        // image.setY(scene.getHeight() - image.getFitHeight());
        TranslateTransition poo = new TranslateTransition(Duration.millis(10000),  lo2);
        poo.setByX(-2000);
        poo.setCycleCount(Integer.MAX_VALUE);
        poo.play();
        return  lo2;
    }
    private ImageView horror1(Scene scene) {
        Image cloud = new Image("lo3.png");
        ImageView lo3 = new ImageView(cloud);
        lo3.setFitWidth(100);
        lo3.setFitHeight(100);
        lo3.setX(1550);
        lo3.setY(360);
        //lo2.setLayoutX(500);
        // image.setY(scene.getHeight() - image.getFitHeight());
        TranslateTransition tt = new TranslateTransition(Duration.millis(9000),  lo3);
        tt.setByX(-2100);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();
        return  lo3;
    }
    private ImageView horror2(Scene scene) {
        Image cloud = new Image("lo4.png");
        ImageView lo4 = new ImageView(cloud);
        lo4.setFitWidth(100);
        lo4.setFitHeight(100);
        //lo2.setLayoutX(500);
        lo4.setX(1600);
        lo4.setY(50);
        // image.setY(scene.getHeight() - image.getFitHeight());
        TranslateTransition poo = new TranslateTransition(Duration.millis(7000),  lo4);
        poo.setByX(-2000);
        poo.setCycleCount(Integer.MAX_VALUE);
        poo.play();
        return  lo4;
    }
    private ImageView bonus(Scene scene) {
        Image cloud = new Image("dollar.png");
        ImageView bonus = new ImageView(cloud);
        bonus.setFitWidth(50);
        bonus.setFitHeight(50);
        //lo2.setLayoutX(500);
        bonus.setX(1600);
        bonus.setY(10);
        // image.setY(scene.getHeight() - image.getFitHeight());
        TranslateTransition poo = new TranslateTransition(Duration.millis(6000),  bonus);
        poo.setByX(-2000);
        poo.setCycleCount(Integer.MAX_VALUE);
        poo.play();
        return  bonus;
    }
    private ImageView coin(Scene scene) {
        Image cloud = new Image("coin.png");
        ImageView coin = new ImageView(cloud);
        coin.setFitWidth(50);
        coin.setFitHeight(50);
        //lo2.setLayoutX(500);
        coin.setX(1600);
        coin.setY(200);
        // image.setY(scene.getHeight() - image.getFitHeight());
        TranslateTransition poo = new TranslateTransition(Duration.millis(6000),  coin);
        poo.setByX(-1800);
        poo.setCycleCount(Integer.MAX_VALUE);
        poo.play();
        return  coin;
    }

    private ImageView createFighter(Scene scene){
        ImageView image = new ImageView(new Image("lo.png"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());
        return image;
    }
    public static void main(String[] args) {
        launch();
    }
}