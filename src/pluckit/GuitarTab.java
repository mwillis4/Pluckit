/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickit;

/**
 *
 * @author MorganWillis
 */
class GuitarTab {
    
    Pluck tabPluck;
    Chord tabChord;
    
    public Chord getChord() {
        return tabChord;
    }
    
    public void setChord(Chord newChord) {
        tabChord = newChord;
    }
    
    public Pluck getPluck() {
        return tabPluck;
    }
    
    public void setPluck(Pluck newPluck) {
        tabPluck = newPluck;
    }
    
    public GuitarTab createBlank() {
    
        return null;
    }
    
}
