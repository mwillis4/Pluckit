/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pluckit;

import java.awt.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Douglas
 */
public class TestTab {
    FlowPane tab;
    
    public FlowPane getTab(){
        tab = new FlowPane();
        tab.setTranslateX(10);
        tab.setTranslateY(10);
        return tab;
    }
    
    public void getChild(int chord[]){
        tab.getChildren().addAll(new StackPane(new Rectangle(220, 420, Color.CORNFLOWERBLUE)
                ,new ImageView(new Image("/tab.png")),getChord(-100,chord[0]),getChord(-60,chord[1]),
                getChord(-20,chord[2]),getChord(20,chord[3]),getChord(60,chord[4]),getChord(100,chord[5])));
        tab.setHgap(20);
        tab.setVgap(20);
    }
    
    
    
    public ImageView getChord(int posX, int posY){
        ImageView image = new ImageView(getNote());
        
        int pos = 0;
        
        switch(posY){
            case 0: image = new ImageView();
                break;
            case 1: pos = -200;
                 break;
            case 2: pos = -160;
                 break;
            case 3: pos = -120;
                 break;
            case 4: pos = -80;
                 break;
            case 5: pos = -40;
                 break;
            case 6: pos = 0;    
                 break;
                
                
        }
        
        image.setTranslateX(posX);
        image.setTranslateY(pos);
        return image;
    }
    
    public Image getNote(){
        Image note = new Image("/circle.png");
        
        return note;
    }
}
