/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.josemanuelcarrasco.pangfx;

import java.net.URL;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
    
    // Variables que uso en mi juego
    
    int ancho = 1366;
    int alto = 768;
    int posicionBolaX = 180;
    int posicionBolaY = 100;
    int velocidadBolaX = 3;
    int velocidadBolaY = 3;
    int velocidadGrupo = 0;
    int posicionGrupo = 0;
    int longitudArma = 0;
    int posicionArma = 518;
    AnimationTimer enemigoBola;
    boolean colisionNula5;
    AnimationTimer colisiones;
    Pane root;
    MediaPlayer mediaplayerInicio;
    boolean vida1;
    boolean vida2;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        
        // -- FONDO -- //
        
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
//        Polygon cuerpovida = new Polygon (new double[]{
//            120.0, 650.0,
//            145.0, 650.0,
//            140.0, 630.0,
//            125.0, 630.0});
//        Circle cabezavida = new Circle (132.5,624,7.5);

//        Polygon cuerpovida2 = new Polygon (new double[]{
//            150.0, 650.0,
//            175.0, 650.0,
//            170.0, 630.0,
//            155.0, 630.0});
//        Circle cabezavida2 = new Circle (162.5,624,7.5);
        
        // Pintar vida
//        cabezavida.setFill(Color.BISQUE);
//        cuerpovida.setFill(Color.SKYBLUE);
//        cabezavida2.setFill(Color.BISQUE);
//        cuerpovida2.setFill(Color.SKYBLUE);


       // Grupos para la creacion de las vidas
       Group vida1 = new Group();
       Polygon cuerpovida = new Polygon (new double[]{
            120.0, 650.0,
            145.0, 650.0,
            140.0, 630.0,
            125.0, 630.0});
       Circle cabezavida = new Circle (132.5,624,7.5);
       cabezavida.setFill(Color.BISQUE);
       cuerpovida.setFill(Color.SKYBLUE);
       vida1.getChildren().add(cabezavida);
       vida1.getChildren().add(cuerpovida);
        
        Group vida2 = new Group();
        Polygon cuerpovida2 = new Polygon (new double[]{
            150.0, 650.0,
            175.0, 650.0,
            170.0, 630.0,
            155.0, 630.0});
        Circle cabezavida2 = new Circle (162.5,624,7.5);
        cabezavida2.setFill(Color.BISQUE);
        cuerpovida2.setFill(Color.SKYBLUE);
        vida2.getChildren().add(cabezavida2);
        vida2.getChildren().add(cuerpovida2);
               
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
        
        // Creacion de las X para tachar las vidas
        Group eliminaVida = new Group();
        // Linea 1
        Line linea1 = new Line(25, 40, 5, 5);
        linea1.setLayoutX(148);
        linea1.setLayoutY(612);
        linea1.setStrokeWidth(5);
        linea1.setStroke(Color.RED);
        
        // Linea 2
        Line linea2 = new Line(25, 40, 5, 5);
        linea2.setLayoutX(148);
        linea2.setLayoutY(612);
        linea2.setStrokeWidth(5);
        linea2.setStroke(Color.RED);
        linea2.setRotate(60);
        eliminaVida.getChildren().add(linea1);
        eliminaVida.getChildren().add(linea2);
//        eliminaVida.setVisible(false);
        
                // Creacion de las X para tachar las vidas
        Group eliminaVida2 = new Group();
        // Linea 3
        Line linea3 = new Line(25, 40, 5, 5);
        linea3.setLayoutX(118);
        linea3.setLayoutY(612);
        linea3.setStrokeWidth(5);
        linea3.setStroke(Color.RED);
        
        // Linea 4
        Line linea4 = new Line(25, 40, 5, 5);
        linea4.setLayoutX(118);
        linea4.setLayoutY(612);
        linea4.setStrokeWidth(5);
        linea4.setStroke(Color.RED);
        linea4.setRotate(60);
        eliminaVida2.getChildren().add(linea3);
        eliminaVida2.getChildren().add(linea4);
//        eliminaVida2.setVisible(false);

        

        
        
        
        
        
       // -- FONDO -- //
        
        // Enemigo
        Circle enemigo = new Circle(posicionBolaX,posicionBolaY,70,Color.DARKRED);
        
 
        // Grupo para poder realizar la colision del muñeco con la bola
        Group movimientoImagen = new Group();
            Image inicial = new Image(getClass().getResourceAsStream("Imagenes/dssd.png"));
            ImageView imageView1 = new ImageView(inicial);
            imageView1.setX((ancho/2)- 15);
            imageView1.setY(555);
            imageView1.setScaleX(2);
            imageView1.setScaleY(2);
            Rectangle arma = new Rectangle(677.5,posicionArma,5,longitudArma);
            Rectangle tope = new Rectangle (668,543,34,58);
            tope.setVisible(false);
            movimientoImagen.getChildren().add(imageView1);
            movimientoImagen.getChildren().add(tope);
            movimientoImagen.getChildren().add(arma);
            
            
            
        //Música inicio
        
            final URL resource = getClass().getResource("Musica/Musica_inicial_Pang.mp3");
            Media media = new Media(resource.toString());
            mediaplayerInicio = new MediaPlayer(media);
            
            // Iniciamos la musica para que al iniciar la aplicacion reproduzca el sonido
            mediaplayerInicio.play();
            
        //Imagen de inicio 
            Image imagenFondo= new Image (getClass().getResourceAsStream("Imagenes/fondoInicio.jpg"));
            ImageView fondoInicio = new ImageView();
            
            fondoInicio.setImage(imagenFondo);

            fondoInicio.setScaleX(0.9);
            fondoInicio.setScaleY(0.95);
            fondoInicio.setX(-120);
            fondoInicio.setY(-50);
        
                
        // Pasos para introducir una imagen
        //Image inicial = new Image(getClass().getResourceAsStream("Imagenes/dssd.png"));
        //Image derecha = new Image(getClass().getResourceAsStream("Capa-2.gif"));
        //Image izquierda = new Image(getClass().getResourceAsStream("Capa-1.gif"));
        //ImageView imageView1 = new ImageView(inicial);
        //imageView1.setX((ancho/2)- 15);
        //imageView1.setY(555);
        //imageView1.setScaleX(2);
        //imageView1.setScaleY(2);
        //imageView1.setImage(derecha);
        //imageView1.setImage(izquierda);
        
              
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
        root.getChildren().add(vida1);
        root.getChildren().add(vida2);

        
        root.getChildren().add(puntuacion);
        root.getChildren().add(ubicacion);
        
        
        root.getChildren().add(adorno1);
        root.getChildren().add(adorno2);
        root.getChildren().add(adorno3);
        root.getChildren().add(adorno4);
        root.getChildren().add(eliminaVida);
        root.getChildren().add(eliminaVida2);


        
        
        root.getChildren().add(enemigo);
        
        
        root.getChildren().add(movimientoImagen);
        root.getChildren().add(fondoInicio);
        
        
        Scene scene = new Scene (root, ancho, alto);
        

        primaryStage.setTitle("PangFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case LEFT:
                    velocidadGrupo = -2;
                    break;
                case RIGHT:
                    velocidadGrupo = 2;
                    break;
                case SPACE:
                    longitudArma +=2; 
//                    posicionArma += 2;
//                    arma.setLayoutY(posicionArma);
                    arma.setHeight(longitudArma);

                case ENTER:
                    fondoInicio.setVisible(false);
                    mediaplayerInicio.stop();
                    enemigoBola.start();
                    break;
                    
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            velocidadGrupo = 0;
        });
        
        enemigoBola = new AnimationTimer(){
            @Override
            public void handle(long now) {
                
            
            posicionGrupo += velocidadGrupo;
            movimientoImagen.setLayoutX(posicionGrupo);
//            imageView1.setLayoutX(posicionGrupo);
        

            enemigo.setLayoutX(posicionBolaX);
            enemigo.setLayoutY(posicionBolaY);
            System.out.println(velocidadBolaX+"X");
            System.out.println(velocidadBolaY+"Y");
            
            // Cambiamos la posicion de la bola    
            posicionBolaX += velocidadBolaX;
            posicionBolaY += velocidadBolaY; 

            // Pasos para hacer la colision de la bola con la Cara Horizontal Inferior
            Shape colisionPared = Shape.intersect(enemigo,ContornoHorizontal2);
            boolean colisionNula = !colisionPared.getBoundsInLocal().isEmpty();
            
            // Si la colision detecta colision:       
            if (colisionNula == true){
              
                velocidadBolaY = -3;

                
            }
            
            
            // Pasos para hacer la colision de la bola con la Cara Vertical Derecha
            Shape colisionPared2 = Shape.intersect(enemigo,ContornoVertical2);
            boolean colisionNula2 = !colisionPared2.getBoundsInLocal().isEmpty();
            
            // Si la colision detecta colisión:
            if (colisionNula2 == true){

                velocidadBolaX = -3;
                
                }
            
            // Pasos para hacer la colision de la bola con la Cara Horizontal Superior
            Shape colisionPared3 = Shape.intersect(enemigo,ContornoHorizontal);
            boolean colisionNula3 = !colisionPared3.getBoundsInLocal().isEmpty();

            // Si la colision detecta colisión:
            if (colisionNula3 == true){
                
                velocidadBolaY = 3;
            }
            
            // Pasos para hacer la colision de la bola con la Cara Vertical Izquierda
            Shape colisionPared4 = Shape.intersect(enemigo,ContornoVertical);
            boolean colisionNula4 = !colisionPared4.getBoundsInLocal().isEmpty();
            
            // Si la colision detecta colisión:
            if (colisionNula4 == true){
                velocidadBolaX = 3 ;
                
                } 
            
            // Pasos para hacer la colision de la Bola con el Personaje
            Shape eliminado = Shape.intersect(enemigo,tope);
            colisionNula5 = !eliminado.getBoundsInLocal().isEmpty();
            
            // Si la colision detecta colisión:
            if (colisionNula5 == true){
                
                this.stop();
                reinicio();
            }

            // Pasos para hacer la colision del Personaje con la Cara Vertical Izquierda
            Shape limite1 = Shape.intersect (tope, ContornoVertical);
            boolean colisionNula6 = !limite1.getBoundsInLocal().isEmpty();
              
            // Si la colision detecta colisión:
                if (colisionNula6 == true){
                    velocidadGrupo = 2;
                }
                
            // Pasos para hacer la colision del Personaje con la Cara Vertical Derecha
            Shape limite2 = Shape.intersect (tope,ContornoVertical2);
            boolean colisionNula7 = !limite2.getBoundsInLocal().isEmpty();
            
            // Si la colision detecta colisión:
                if (colisionNula7 == true){
                    velocidadGrupo = -2;
                }
            
            }
            
            
            
        };
        

//        colisiones = new AnimationTimer(){
//            @Override
//            public void handle(long now) {
//                reinicio();
//                }
//            };
                
        
    };
    
    
    private void reinicio(){
        
        posicionBolaX = 180;
        posicionBolaY = 100;
        velocidadBolaX = 3;
        velocidadBolaY = 3;
        enemigoBola.start();
        posicionGrupo = 0;

    }
    
//        public void pantallainicio(){
//        root.getChildren().add()
//    }
    
        
        
  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        launch(args);
    }
    };
