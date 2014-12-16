/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pluckit;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Douglas
 */
public class TestTab {
    FlowPane tab;
    ArrayList<WritableImage> images;
    
    public FlowPane getTab(){
        tab = new FlowPane();
        tab.setTranslateX(10);
        tab.setTranslateY(10);
        return tab;
    }
    
    public void getChild(int chord[]){
          if (images == null)
            images = new ArrayList<WritableImage>();
        ImageView view = new ImageView(new Image("/tab.png"));
        
        StackPane newPane = new StackPane(view,getChord(-100,chord[0]),getChord(-60,chord[1]),getChord(-20,chord[2]),getChord(20,chord[3]),getChord(60,chord[4]),getChord(100,chord[5]));  
        
        tab.getChildren().addAll(newPane);
        tab.setHgap(20);
        tab.setVgap(20);
        
        
        images.add(newPane.snapshot(null, null));

    }
    
    
    
    public ImageView getChord(int posX, int posY){
      
        
        ImageView image = new ImageView(getNote());
        
        int pos = 0;
        
        switch(posY){
            case 0: image = new ImageView();
                break;
            case 1: pos = -180;
                 break;
            case 2: pos = -140;
                 break;
            case 3: pos = -100;
                 break;
            case 4: pos = -60;
                 break;
            case 5: pos = -20;
                 break;
            case 6: pos = 20;    
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
    
    public WritableImage getImage(int pos) 
    {
        return images.get(pos);
    }
    
    public int getImageCount() {
        return images.size();
    }
            
    public ArrayList<WritableImage> getImages()
    {
        return images;
    }
}
