/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickit;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author MorganWillis
 */
public class PrepArea {
    String Name;
    ArrayList<Chord> song;
    
    public void setName(String newName) {
        Name = newName;
    }
    
    public String getName() {
        return Name;
    }
    
    public void setSong(ArrayList<Chord> newSong) {
        song = newSong;
    }
    
    public ArrayList<Chord> getSong(){
        return song;
    }
    
    public void addChord(Chord newChord) {
        song.add(newChord);
    }
    
    public void removeChord(int i){
        song.remove(i);
    }
    
    public void exportToWord(String address, WritableImage pic) throws AWTException, IOException {
        //Rectangle screenRect = new Rectangle(corner, size);
        BufferedImage capture = SwingFXUtils.fromFXImage(pic, null);
        ImageIO.write(capture, "bmp", new File(address));
        System.out.println("Image created and saved");
    }
    
    public void saveSong(String address) {
        try {
 
            // Create the document
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
            // create the root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("song");
            doc.appendChild(rootElement);
 
            // Create all the entries
            for(int i = 0; i < song.size(); i++) {
                
                // Create the entry element
                Element chord = doc.createElement("Chord");
                rootElement.appendChild(chord);
 
                // set the date attribute tofor the entry element
                Attr attr = doc.createAttribute("Name");
                attr.setValue(song.get(i).getName());
                chord.setAttributeNode(attr);
                
                chord.setTextContent(song.get(i).getFingers());
            }        
            
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result 
                    = new StreamResult(new File(address));
 
            // Give the xml an indent for easier reading
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty
                ("{http://xml.apache.org/xslt}indent-amount", "2");
            
 
            transformer.transform(source, result);
 
            // Let user know the file has been saved
            System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
          }
    }
    
    public void loadSong(String address) throws ParserConfigurationException, SAXException, IOException {
        
        song = new ArrayList<Chord>();
        
         // Show the user that the file is loading
        System.out.println("Loading Song \"" + address + "\"");
        
        // Build the document to hold the the xml file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(new File(address));
        
        
        // Set the date format
        NodeList inNodes = document.getElementsByTagName("song");
        
        // Go through the nodes to pull out the correct informations
        for (int i = 0; i < inNodes.getLength(); i++) {
            
            // Get the current node
            Node node = inNodes.item(i);
            

            // See what the node tpe is
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            

                // Set the node as an element
                Element elem = (Element) node;
                
                // Make sure we have an attribute 
                if(elem.getAttributes() != null) {
                    newSongChord(elem);
                }
            }
        }
    }
    
    private void newSongChord(Element elem) {
                

         // Get all the nodes of the described type
        NodeList chordNodes = elem.getElementsByTagName("Chord");
                       
        // Go through each node
        for(int i = 0; i < chordNodes.getLength(); i++) {


            // Make the node an element
            Element chordElem = (Element)chordNodes.item(i);
                        
            // Create the new scripture
            Chord newChord = new Chord();
                        
            // Get the book attribute
            newChord.setName(chordElem.getAttribute("Name"));
                            
            newChord.setFingers(chordElem.getTextContent());
            

            addChord(newChord);

        }
        
    }
    
    public void display() {
        for (int i = 0; i < song.size(); i++)
        {
            System.out.println(song.get(i).display());
        }
    }
}
