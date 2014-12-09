/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickit;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author MorganWillis
 */
public class Chord {
    String name;
    List<String> Symbol;
    String fingers;
    
    public void Position(GridPane currentGrid) {
        
    }
    
    public void setName(String newName) {
        name = newName; 
    }
    
    public String getName() {
        return name;
    }
    
    public String getFingers() {
        return fingers;
    }
    
    public void setFingers(String newFingers) {
        fingers = newFingers;
    }
    
    public String display() {
        return (name + ": " + fingers);
    }
}
