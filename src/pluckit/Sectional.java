/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pluckit;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MorganWillis
 */
public class Sectional {
    String Name;
    ArrayList<Chord> chords = new ArrayList<Chord>();
    
    public void setChords(ArrayList<Chord> newChords) {
        chords = newChords;
    }
    
    public ArrayList<Chord> getChords() {
        return chords;
    }
    
    public void addChord(Chord newChord) {
        chords.add(newChord);
    }
    
    public void setName(String newName) {
        Name = newName;
    }
    
    public String getName() {
        return Name;
    }
    
    public void display() {
        System.out.println(Name);
        for(int i = 0; i < chords.size(); i++) {
            System.out.println("\t" + chords.get(i).display());
        }
    }
    
    public void createNewChord(String Name, String Fingering) {
        Chord newChord = new Chord();
        newChord.setName(Name);
        newChord.setFingers(Fingering);
        addChord(newChord);
    }
}
