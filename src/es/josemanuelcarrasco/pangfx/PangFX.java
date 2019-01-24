/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.josemanuelcarrasco.pangfx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author josemanuel
 */
public class PangFX extends Application {
    
    int enemigobolaX = 10;
    int enemigobolaY = 50;
    int velocidadbolaX = 0;
    int velocidadbolaY = 0;
    AnimationTimer enemigobola;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        int ancho = 1366;
        int alto = 768;
        
        // Elementos del borde de la pantalla del juego
        Rectangle ContornoVertical = new Rectangle(0, 0, 15, 600);
        ContornoVertical.setFill(Color.GREENYELLOW);
        Rectangle ContornoVertical2 = new Rectangle(1349,0,1366,600);
        ContornoVertical2.setFill(Color.GREENYELLOW);
        Rectangle ContornoHorizontal = new Rectangle(0,0,1366,15);
        ContornoHorizontal.setFill(Color.GREENYELLOW);
        Rectangle ContornoHorizontal2 = new Rectangle(0,600,1366,15);
        ContornoHorizontal2.setFill(Color.GREENYELLOW);
        
        // Elementos del Cielo del juego
        Rectangle Cielo = new Rectangle(15,15,1334,585);
        Cielo.setFill(Color.LIGHTSKYBLUE);
        
        // Elementos del Cajetin del juego
        Rectangle Cajetin = new Rectangle (0,615,1366,110);
        Cajetin.setFill(Color.SLATEGRAY);
        
        // Elementos de la montaña del juego
        Polygon poligonomontaña = new Polygon (new double[]{
            15.0, 600.0,
            1349.0, 600.0,
            600.0, 150.0,
            450.0, 150.0});
        
        Polygon nievemontaña = new Polygon (new double[]{
            600.0, 150.0,
            450.0, 150.0,
            363.0, 240.0,
            751.0, 240.0});
        
        // Elementos para la creación de las nubes del juego
        Circle elementonube1 = new Circle (200,150,25);
        Circle elementonube2 = new Circle (225,150,20);
        Circle elementonube3 = new Circle (175,150,18);
        Circle elementonube4 = new Circle (975,200,40);
        Circle elementonube5 = new Circle (1030,200,50);
        Circle elementonube6 = new Circle (1075,200,40);
        Circle elementonube7 = new Circle (1115,200,25);
        Circle elementonube8 = new Circle (940,200,25);
        
        // Elementos para la creacion de las vidas
        Polygon cuerpovida = new Polygon (new double[]{
            120.0, 650.0,
            145.0, 650.0,
            140.0, 630.0,
            125.0, 630.0});
        Circle cabezavida = new Circle (132.5,624,7.5);

        Polygon cuerpovida2 = new Polygon (new double[]{
            150.0, 650.0,
            175.0, 650.0,
            170.0, 630.0,
            155.0, 630.0});
        Circle cabezavida2 = new Circle (162.5,624,7.5);
        
        // Pintar vida
        cabezavida.setFill(Color.BISQUE);
        cuerpovida.setFill(Color.SKYBLUE);
        cabezavida2.setFill(Color.BISQUE);
        cuerpovida2.setFill(Color.SKYBLUE);
               
        // Colores de la Montaña
        nievemontaña.setFill(Color.WHITE);
        poligonomontaña.setFill(Color.DARKSLATEGREY);
        
        // Colores de las nubes
        elementonube1.setFill(Color.WHITE);
        elementonube2.setFill(Color.WHITE);
        elementonube3.setFill(Color.WHITE);
        elementonube4.setFill(Color.WHITE);
        elementonube5.setFill(Color.WHITE);
        elementonube6.setFill(Color.WHITE);
        elementonube7.setFill(Color.WHITE);
        elementonube8.setFill(Color.WHITE);
        
        // Texto puntuacion
        Text puntuacion = new Text(118,690,"Puntuación: 0");
        puntuacion.setFont(new Font(30));
        puntuacion.setFill(Color.WHITE);
        
        // Texto Ubicacion
        Text ubicacion = new Text((ancho/2)- 80, 650,"MONTE FUJI");
        ubicacion.setFont(new Font(30));
        ubicacion.setFill(Color.WHITE);
                
        // Poligonos adorno
        Polygon adorno1 = new Polygon (new double[]{
            25.0, 660.0,
            75.0, 660.0,
            50.0, 630.0});
        Polygon adorno2 = new Polygon (new double[]{
            25.0, 660.0,
            75.0, 660.0,
            50.0, 690.0});
        Polygon adorno3 = new Polygon (new double[]{
            1341.0, 660.0,
            1291.0, 660.0,
            1316.0, 630.0});
        Polygon adorno4 = new Polygon (new double[]{
            1341.0, 660.0,
            1291.0, 660.0,
            1316.0, 690.0});
        
        // Pintar los adornos
        adorno1.setFill(Color.RED);
        adorno2.setFill(Color.YELLOW);
        adorno3.setFill(Color.YELLOW);
        adorno4.setFill(Color.RED);
        
        // Enemigo
        Circle enemigo = new Circle (180, 200, 70);
        enemigo.setFill(Color.DARKRED);
                
        // Pasos para introducir una imagen
        Image inicial = new Image(getClass().getResourceAsStream("Imagenes/dssd.png"));
        ImageView imageView1 = new ImageView(inicial);
        imageView1.setX((ancho/2)- 15);
        imageView1.setY(555);
        imageView1.setScaleX(2);
        imageView1.setScaleY(2);
              
        // Codigos para incluir los elementos anteriormente realizados
        Pane root = new Pane();
        root.getChildren().add(ContornoVertical);
        root.getChildren().add(ContornoVertical2);
        root.getChildren().add(ContornoHorizontal);
        root.getChildren().add(ContornoHorizontal2);
        root.getChildren().add(Cielo);
        root.getChildren().add(Cajetin);
        root.getChildren().add(poligonomontaña);
        root.getChildren().add(nievemontaña);
        root.getChildren().add(elementonube1);
        root.getChildren().add(elementonube2);
        root.getChildren().add(elementonube3);
        root.getChildren().add(elementonube4);
        root.getChildren().add(elementonube5);
        root.getChildren().add(elementonube6);
        root.getChildren().add(elementonube7);
        root.getChildren().add(elementonube8);
        
        root.getChildren().add(cuerpovida);
        root.getChildren().add(cabezavida);
        root.getChildren().add(cuerpovida2);
        root.getChildren().add(cabezavida2);
        
        root.getChildren().add(puntuacion);
        root.getChildren().add(ubicacion);
        
        root.getChildren().add(adorno1);
        root.getChildren().add(adorno2);
        root.getChildren().add(adorno3);
        root.getChildren().add(adorno4);
        
        root.getChildren().add(imageView1);
        
        root.getChildren().add(enemigo);
        
        
        
        Scene scene = new Scene (root, ancho, alto);
        
        primaryStage.setTitle("PangFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        enemigobola = new AnimationTimer(){
            @Override
            public void handle(long now) {

                enemigo.setLayoutY(velocidadbolaY);
                System.out.println(velocidadbolaX);
                
            Shape colisionpared = Shape.intersect(enemigo, ContornoHorizontal2);
            boolean colisionNula = colisionpared.getBoundsInLocal().isEmpty();
            
            if (colisionNula == false){
                velocidadbolaY -=3;
            }
            else {
                
            }
            
                
            };
            
        };
        enemigobola.start();

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
