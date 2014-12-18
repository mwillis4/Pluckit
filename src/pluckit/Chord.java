/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pluckit;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author MorganWillis
 */
public class Chord {

    // Holds the name of the chord
    String name;
    String fingers; // Holds the string of the fingering for this chord
        
    /**
     * Set the name of the chord
     * @param newName 
     */
    public void setName(String newName) {
        name = newName; 
    }
    
    /** 
     * get the name of the chord
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * get the fingering for the chord
     * @return 
     */
    public String getFingers() {
        return fingers;
    }
    
    /**
     * Sets the fingering for the chord
     * @param newFingers 
     */
    public void setFingers(String newFingers) {
        fingers = newFingers;
    }
    
    /**
     * Displays the chord
     * @return 
     */
    public String display() {
        return (name + ": " + fingers);
    }
}
