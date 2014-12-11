/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pluckit;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 *
 * @author Douglas
 */
public class Pluckit extends Application {
    
    @Override
    public void start(Stage primaryStage) {
   
     
        menu();
      
        
        primaryStage.setTitle("Anything");
        primaryStage.setScene(wholeArea());
        primaryStage.show();
    }

     public MenuBar menu(){
        
          MenuBar menubar = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu tools = new Menu("tools");
     
        menubar.getMenus().addAll(file,edit,tools);
      
        
        MenuItem save = new MenuItem("Save");
        MenuItem load = new MenuItem("Load");
        MenuItem export = new MenuItem("Export");
        MenuItem exit = new MenuItem("Exit");
        
        file.getItems().addAll(save,load,export,exit);
        
        return menubar;
    }
       public VBox rightside(){
        Button a1 = new Button("A ");
        a1.setMinSize(100, 100);
        Button a2 = new Button("A#");
        Button a3 = new Button("A\u266D");
        Button b1 = new Button("B ");
        b1.setMinSize(100, 100);
        Button b2 = new Button("B#");
        Button b3 = new Button("B\u266D");
        Button c1 = new Button("C ");
        Button c2 = new Button("C#");
        Button c3 = new Button("C\u266D");
        Button d1 = new Button("D ");
        Button d2 = new Button("D#");
        Button d3 = new Button("D\u266D");
        Button e1 = new Button("E ");
        Button e2 = new Button("E#");
        Button e3 = new Button("E\u266D");
        Button f1 = new Button("F ");
        Button f2 = new Button("F#");
        Button f3 = new Button("F\u266D");
        Button g1 = new Button("G ");
        Button g2 = new Button("G#");
        Button g3 = new Button("G\u266D");
        c1.setMinSize(100, 100);
        d1.setMinSize(100, 100);
        e1.setMinSize(100, 100);
        f1.setMinSize(100, 100);
        g1.setMinSize(100, 100);
        
        /*
        Other Section
        */
        Button a4 = new Button("A ");
        Button a5 = new Button("A#");
        Button a6 = new Button("A\u266D");
        Button b4 = new Button("B ");
        Button b5 = new Button("B#");
        Button b6 = new Button("B\u266D");
        Button c4 = new Button("C ");
        Button c5 = new Button("C#");
        Button c6 = new Button("C\u266D");
        Button d4 = new Button("D ");
        Button d5 = new Button("D#");
        Button d6 = new Button("D\u266D");
        Button e4 = new Button("E ");
        Button e5 = new Button("E#");
        Button e6 = new Button("E\u266D");
        Button f4 = new Button("F ");
        Button f5 = new Button("F#");
        Button f6 = new Button("F\u266D");
        Button g4 = new Button("G ");
        Button g5 = new Button("G#");
        Button g6 = new Button("G\u266D");
        ScrollPane pane = new ScrollPane();
        a4.setMinSize(50, 50);
        b4.setMinSize(50, 50);
        c4.setMinSize(50, 50);
        d4.setMinSize(50, 50);
        e4.setMinSize(50, 50);
        f4.setMinSize(50, 50);
        g4.setMinSize(50, 50);
         a4.setMinSize(50, 50);
        b4.setMinSize(50, 50);
        c4.setMinSize(50, 50);
        d4.setMinSize(50, 50);
        e4.setMinSize(50, 50);
        f4.setMinSize(50, 50);
        g4.setMinSize(50, 50);
        a6.setMinSize(50, 50);
        b6.setMinSize(50, 50);
        c6.setMinSize(50, 50);
        d6.setMinSize(50, 50);
        e6.setMinSize(50, 50);
        f6.setMinSize(50, 50);
        g6.setMinSize(50, 50);
        a5.setMinSize(50, 50);
        b5.setMinSize(50, 50);
        c5.setMinSize(50, 50);
        d5.setMinSize(50, 50);
        e5.setMinSize(50, 50);
        f5.setMinSize(50, 50);
        g5.setMinSize(50, 50);
        /*
        created for the reason of two sections
        */
        HBox a = new HBox();
        a.getChildren().addAll(a4,a5,a6);
        HBox b = new HBox();
        b.getChildren().addAll(b4,b5,b6);
        HBox c = new HBox();
        c.getChildren().addAll(c4,c5,c6);
        HBox d = new HBox();
        d.getChildren().addAll(d4,d5,d6);
        HBox e = new HBox();
        e.getChildren().addAll(e4,e5,e6);
        HBox f = new HBox();
        f.getChildren().addAll(f4,f5,f6);
        HBox g = new HBox();
        g.getChildren().addAll(g4,g5,g6);
         HBox aa = new HBox();
        aa.getChildren().addAll(a1,a2,a3);
        HBox bb = new HBox();
        bb.getChildren().addAll(b1,b2,b3);
        HBox cc = new HBox();
        cc.getChildren().addAll(c1,c2,c3);
        HBox dd = new HBox();
        dd.getChildren().addAll(d1,d2,d3);
        HBox ee = new HBox();
        ee.getChildren().addAll(e1,e2,e3);
        HBox ff = new HBox();
        ff.getChildren().addAll(f1,f2,f3);
        HBox gg = new HBox();
        gg.getChildren().addAll(g1,g2,g3);
        
       
        
        VBox vbox = new VBox();
        VBox vbox2 = new VBox();
        VBox main3 = new VBox();
        vbox.getChildren().addAll(a,b,c,d,e,f,g);
        vbox2.getChildren().addAll(aa,bb,cc,dd,ee,ff,gg);
        main3.getChildren().addAll(vbox);
        Insets i = new Insets(0,0,50,0);
        vbox.setPadding(i);
        
      
   
 
        a1.setOnAction(new EventHandler<ActionEvent>() {
            double pos = 0;
            @Override
            public void handle(ActionEvent t) {
               
               
            }
        });
      
     return main3;
        
    }
       

       public FlowPane holderArea(){
         
        
           FlowPane flow = new FlowPane();
           flow.setVgap(20);
           flow.setHgap(20);

           return flow;
       }
       
       public Scene wholeArea(){
           
           
           
           
             Button a1 = new Button("A ");
        a1.setMinSize(100, 100);
        Button a2 = new Button("A#");
        Button a3 = new Button("A\u266D");
        Button b1 = new Button("B ");
        b1.setMinSize(100, 100);
        Button b2 = new Button("B#");
        Button b3 = new Button("B\u266D");
        Button c1 = new Button("C ");
        Button c2 = new Button("C#");
        Button c3 = new Button("C\u266D");
        Button d1 = new Button("D ");
        Button d2 = new Button("D#");
        Button d3 = new Button("D\u266D");
        Button e1 = new Button("E ");
        Button e2 = new Button("E#");
        Button e3 = new Button("E\u266D");
        Button f1 = new Button("F ");
        Button f2 = new Button("F#");
        Button f3 = new Button("F\u266D");
        Button g1 = new Button("G ");
        Button g2 = new Button("G#");
        Button g3 = new Button("G\u266D");
        c1.setMinSize(100, 100);
        d1.setMinSize(100, 100);
        e1.setMinSize(100, 100);
        f1.setMinSize(100, 100);
        g1.setMinSize(100, 100);
        
        /*
        Other Section
        */
        Button a4 = new Button("A ");
        Button a5 = new Button("A#");
        Button a6 = new Button("A\u266D");
        Button b4 = new Button("B ");
        Button b5 = new Button("B#");
        Button b6 = new Button("B\u266D");
        Button c4 = new Button("C ");
        Button c5 = new Button("C#");
        Button c6 = new Button("C\u266D");
        Button d4 = new Button("D ");
        Button d5 = new Button("D#");
        Button d6 = new Button("D\u266D");
        Button e4 = new Button("E ");
        Button e5 = new Button("E#");
        Button e6 = new Button("E\u266D");
        Button f4 = new Button("F ");
        Button f5 = new Button("F#");
        Button f6 = new Button("F\u266D");
        Button g4 = new Button("G ");
        Button g5 = new Button("G#");
        Button g6 = new Button("G\u266D");
        ScrollPane pane = new ScrollPane();
        a4.setMinSize(50, 50);
        b4.setMinSize(50, 50);
        c4.setMinSize(50, 50);
        d4.setMinSize(50, 50);
        e4.setMinSize(50, 50);
        f4.setMinSize(50, 50);
        g4.setMinSize(50, 50);
         a4.setMinSize(50, 50);
        b4.setMinSize(50, 50);
        c4.setMinSize(50, 50);
        d4.setMinSize(50, 50);
        e4.setMinSize(50, 50);
        f4.setMinSize(50, 50);
        g4.setMinSize(50, 50);
        a6.setMinSize(50, 50);
        b6.setMinSize(50, 50);
        c6.setMinSize(50, 50);
        d6.setMinSize(50, 50);
        e6.setMinSize(50, 50);
        f6.setMinSize(50, 50);
        g6.setMinSize(50, 50);
        a5.setMinSize(50, 50);
        b5.setMinSize(50, 50);
        c5.setMinSize(50, 50);
        d5.setMinSize(50, 50);
        e5.setMinSize(50, 50);
        f5.setMinSize(50, 50);
        g5.setMinSize(50, 50);
        /*
        created for the reason of two sections
        */
        HBox a = new HBox();
        a.getChildren().addAll(a4,a5,a6);
        a.setSpacing(10);
        HBox b = new HBox();
        b.getChildren().addAll(b4,b5,b6);
        b.setSpacing(10);
        HBox c = new HBox();
        c.getChildren().addAll(c4,c5,c6);
        c.setSpacing(10);
        HBox d = new HBox();
        d.getChildren().addAll(d4,d5,d6);
        d.setSpacing(10);
        HBox e = new HBox();
        e.getChildren().addAll(e4,e5,e6);
        e.setSpacing(10);
        HBox f = new HBox();
        f.getChildren().addAll(f4,f5,f6);
        f.setSpacing(10);
        HBox g = new HBox();
        g.getChildren().addAll(g4,g5,g6);
        g.setSpacing(10);
         HBox aa = new HBox();
        aa.getChildren().addAll(a1,a2,a3);
        HBox bb = new HBox();
        bb.getChildren().addAll(b1,b2,b3);
        HBox cc = new HBox();
        cc.getChildren().addAll(c1,c2,c3);
        HBox dd = new HBox();
        dd.getChildren().addAll(d1,d2,d3);
        HBox ee = new HBox();
        ee.getChildren().addAll(e1,e2,e3);
        HBox ff = new HBox();
        ff.getChildren().addAll(f1,f2,f3);
        HBox gg = new HBox();
        gg.getChildren().addAll(g1,g2,g3);
        
        HBox pics = new HBox(10);
        pics.getChildren().addAll(new ImageView(new Image("/solidCircle.png")),
                new ImageView(new Image("/hollowCircle.png")),
                new ImageView(new Image("/solidTriangle.png")),
                new ImageView(new Image("/hollowSquare.png")));
        
      
        VBox vbox = new VBox();
        VBox vbox2 = new VBox();
        VBox main3 = new VBox();
        
        vbox.getChildren().addAll(a,b,c,d,e,f,g);
        vbox.setSpacing(10);
        vbox2.getChildren().addAll(aa,bb,cc,dd,ee,ff,gg);
        main3.getChildren().addAll(vbox,pics);
         Insets i = new Insets(0,0,50,0);
        vbox.setPadding(i);

        int[] chord = new int[6];
        chord[0] = 0;
        chord[1] = 2;
        chord[2] = 1;
        chord[3] = 2;
        chord[4] = 0;
        chord[5] = 2;
        
         int[] chord2 = new int[6];
        chord2[0] = 0;
        chord2[1] = 6;
        chord2[2] = 4;
        chord2[3] = 3;
        chord2[4] = 2;
        chord2[5] = 0;
        
        final TestTab tab = new TestTab();
        a4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                
                tab.getChild(chord);
            }
        });
         a5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                
                tab.getChild(chord2);
            }
        });
          a6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                
                tab.getChild(chord);
            }
        });
          
         
        /****************************************************/
           ScrollPane holderArea = new ScrollPane();
           holderArea.setFitToWidth(true);
           ScrollPane sections = new ScrollPane();
           sections.setPrefWidth(225);
           sections.setContent(main3);
           holderArea.setContent(tab.getTab());
      
           BorderPane wholeArea = new BorderPane();
  
           wholeArea.setRight(sections);
           wholeArea.setCenter(holderArea);
           wholeArea.setTop(menu());
           Scene scene = new Scene(wholeArea, 1000, 650);
       
        
            return scene;
            
       }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
