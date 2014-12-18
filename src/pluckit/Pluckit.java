/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pluckit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import static org.docx4j.Docx4J.save;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.xml.sax.SAXException;

/**
 *
 * @author Douglas
 */
public class Pluckit extends Application {
    Stage theStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) throws ParserConfigurationException, SAXException, IOException {
        
        setStage(primaryStage);
        primaryStage.setTitle("Pick It Version 1.0.0.0");
        primaryStage.setScene(wholeArea());
        primaryStage.show();
    }

    public Scene wholeArea() throws ParserConfigurationException, SAXException, IOException {
        final TestTab tab = new TestTab();
        ScrollPane holderArea = new ScrollPane();
        ArrayList<Chord> allChords = new ArrayList<Chord>();
        ArrayList<Chord> savedChords = new ArrayList<Chord>();
        Database data = new Database();
        ArrayList<Sectional> sectionalList = new ArrayList<Sectional>();
        File chordsFile = new File("Chords.xml");
        data.setSectionalAddress(chordsFile.getAbsolutePath());
        sectionalList = data.loadSectional();
        
          FlowPane leftSideButtons = new FlowPane();

        for (Sectional sectionalList1 : sectionalList) {
            System.out.println(sectionalList1.getName());
            for (Chord chord : sectionalList1.getChords()) {
                Button button = new Button(chord.getName());
                button.setMinSize(70, 70);
                leftSideButtons.getChildren().add(button);
                int[] chords = new int[6];
                Character number = chord.getFingers().charAt(0);
                String num = number.toString();
                chords[0] = Integer.parseInt(num);
                number = chord.getFingers().charAt(1);
                num = number.toString();
                chords[1] = Integer.parseInt(num);
                number = chord.getFingers().charAt(2);
                num = number.toString();
                chords[2] = Integer.parseInt(num);
                number = chord.getFingers().charAt(3);
                num = number.toString();
                chords[3] = Integer.parseInt(num);
                number = chord.getFingers().charAt(4);
                num = number.toString();
                chords[4] = Integer.parseInt(num);
                number = chord.getFingers().charAt(5);
                num = number.toString();
                chords[5] = Integer.parseInt(num);

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {

                        tab.getChild(chords);
                        allChords.add(chord);
                    }
                });

            }

        }

        HBox pics = new HBox(10);
        Image image = new Image("/solidCircle.png");
        ImageView view = new ImageView(image);
        pics.getChildren().addAll(view,
                new ImageView(new Image("/hollowCircle.png")),
                new ImageView(new Image("/solidTriangle.png")),
                new ImageView(new Image("/hollowSquare.png")));

        pics.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ImageView moving = view;

                pics.setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent ee) {
                        moving.setTranslateX(ee.getX());
                        moving.setTranslateY(ee.getY());

                    }
                });
            }
        });

       // leftSideButtons.getChildren().add(pics);
        MenuBar menubar = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu tools = new Menu("tools");

        menubar.getMenus().addAll(file, edit, tools);

        MenuItem save = new MenuItem("Save");
        MenuItem load = new MenuItem("Load");
        MenuItem export = new MenuItem("Export");
        MenuItem exit = new MenuItem("Exit");

        MenuItem loadChord = new MenuItem("Load Chord");
        MenuItem newChord = new MenuItem("New Chord");
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                PrepArea song = new PrepArea();
                ArrayList<Chord> chordlist = new ArrayList<Chord>();
                song.setSong(chordlist);
                Stage chooser = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TEXT files (*.xml)", "*.xml");
                fileChooser.getExtensionFilters().add(filter);
                File file = fileChooser.showOpenDialog(chooser);

                String pickedSong = file.getPath();
                System.out.println("this is " + pickedSong + " file");
                try {
                    song.loadSong(pickedSong);
                } catch (ParserConfigurationException | SAXException | IOException ex) {
                    Logger.getLogger(Pluckit.class.getName()).log(Level.SEVERE, null, ex);
                }

                chordlist = song.getSong();

                for (Chord chordList : chordlist) {
                    int[] chords = new int[6];
                    Character number = chordList.getFingers().charAt(0);
                    String num = number.toString();
                    chords[0] = Integer.parseInt(num);
                    number = chordList.getFingers().charAt(1);
                    num = number.toString();
                    chords[1] = Integer.parseInt(num);
                    number = chordList.getFingers().charAt(2);
                    num = number.toString();
                    chords[2] = Integer.parseInt(num);
                    number = chordList.getFingers().charAt(3);
                    num = number.toString();
                    chords[3] = Integer.parseInt(num);
                    number = chordList.getFingers().charAt(4);
                    num = number.toString();
                    chords[4] = Integer.parseInt(num);
                    number = chordList.getFingers().charAt(5);
                    num = number.toString();
                    chords[5] = Integer.parseInt(num);

                    tab.getChild(chords);
                    allChords.add(chordList);

                }

            }
        });
        
            save.setOnAction ( 
                new EventHandler<ActionEvent>() {
            @Override
                public void handle
                (ActionEvent event
                
                    ) {
                PrepArea saveXML = new PrepArea();
                    saveXML.setSong(allChords);
                    Stage chooser = new Stage();
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open XML File");
                    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
                    fileChooser.getExtensionFilters().add(filter);
                    File file = fileChooser.showSaveDialog(chooser);
                    String fileName = file.toString();
                    saveXML.saveSong(fileName);

                }
            }

            );

            loadChord.setOnAction ( 
                new EventHandler<ActionEvent>() {
            @Override
                public void handle
                (ActionEvent event
                
                    ) {

                Stage chooser = new Stage();
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open XML File");
                    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
                    fileChooser.getExtensionFilters().add(filter);
                    File file = fileChooser.showOpenDialog(chooser);

                    String pickedChords = file.getPath();
                    System.out.println("this is " + pickedChords + " file");
                    Database chordData = new Database();
                    ArrayList<Sectional> sectionalList2 = new ArrayList<Sectional>();
                    chordData.setSectionalAddress(pickedChords);

                try {
                    sectionalList2 = chordData.loadSectional();
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(Pluckit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(Pluckit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Pluckit.class.getName()).log(Level.SEVERE, null, ex);
                }

                    for (Sectional sectionalList1 : sectionalList2) {
                        System.out.println(sectionalList1.getName());
                        for (Chord chord : sectionalList1.getChords()) {
                            Button button = new Button(chord.getName());
                            button.setMinSize(70, 70);
                            leftSideButtons.getChildren().add(button);
                            int[] chords = new int[6];
                            Character number = chord.getFingers().charAt(0);
                            String num = number.toString();
                            chords[0] = Integer.parseInt(num);
                            number = chord.getFingers().charAt(1);
                            num = number.toString();
                            chords[1] = Integer.parseInt(num);
                            number = chord.getFingers().charAt(2);
                            num = number.toString();
                            chords[2] = Integer.parseInt(num);
                            number = chord.getFingers().charAt(3);
                            num = number.toString();
                            chords[3] = Integer.parseInt(num);
                            number = chord.getFingers().charAt(4);
                            num = number.toString();
                            chords[4] = Integer.parseInt(num);
                            number = chord.getFingers().charAt(5);
                            num = number.toString();
                            chords[5] = Integer.parseInt(num);

                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent t) {

                                    tab.getChild(chords);
                                }
                            });
                        }
                    }
                    System.out.println("Chords Loaded");
                }

            }

            );
            
            /**********************************
        * This is for creating a new chord
        ***********************************/
        newChord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox vbox1 = new VBox();
                Stage chordMaker = new Stage();
                chordMaker.setTitle("New Chord");
               HBox chordfinger = new HBox();
               HBox chordname = new HBox();
               Label chordName = new Label("Chord Name");
               Label finger1 = new Label("Finger Position");
                TextField fingers = new TextField ();
                TextField name = new TextField ();
                Button getFingers = new Button("Get Chord");
                chordfinger.getChildren().addAll(finger1,fingers);
                chordname.getChildren().addAll(chordName,name);
                vbox1.getChildren().addAll(chordname,chordfinger,getFingers);
                Scene chordScene = new Scene(vbox1,600,300);
                chordMaker.setScene(chordScene);
                chordMaker.show();
               
                getFingers.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                       
                        Chord chord = new Chord();
                chord.setFingers( fingers.getText());
                chord.setName(name.getText());
                   Button button = new Button(name.getText());
                button.setMinSize(70, 70);
                leftSideButtons.getChildren().add(button);
                int[] chords = new int[6];
                Character number = chord.getFingers().charAt(0);
                String num = number.toString();
                chords[0] = Integer.parseInt(num);
                number = chord.getFingers().charAt(1);
                num = number.toString();
                chords[1] = Integer.parseInt(num);
                number = chord.getFingers().charAt(2);
                num = number.toString();
                chords[2] = Integer.parseInt(num);
                number = chord.getFingers().charAt(3);
                num = number.toString();
                chords[3] = Integer.parseInt(num);
                number = chord.getFingers().charAt(4);
                num = number.toString();
                chords[4] = Integer.parseInt(num);
                number = chord.getFingers().charAt(5);
                num = number.toString();
                chords[5] = Integer.parseInt(num);
                savedChords.add(chord);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {

                        tab.getChild(chords);
                        allChords.add(chord);
                    }
                });
                        
                    }
                });
                
            }
            
        });

            export.setOnAction ( 
                (new EventHandler<ActionEvent>() {
            @Override
                public void handle
                (ActionEvent event) {

                pluckit.PrepArea newPA = new pluckit.PrepArea();
                    String exportAddress;
                    Stage chooser = new Stage();
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Export Location");
                    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Word Document (*.docx)", "*.docx");
                    fileChooser.getExtensionFilters().add(filter);
                    File file = fileChooser.showSaveDialog(chooser);
                    
                    try {

                        exportAddress = file.toString();
                        newPA.exportToWord(exportAddress, tab.getImages());
                    } catch (Exception ex) {
                        Logger.getLogger(Pluckit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            ));
        
            exit.setOnAction ( 
                (new EventHandler<ActionEvent>() {
            @Override
                public void handle
                (ActionEvent event) {
                    theStage.close();
                }
            }

            ));
            
            file.getItems().addAll(save, load, export, exit);
            tools.getItems().addAll(loadChord,newChord);
        /**
         * *************************************************
         */

            holderArea.setFitToWidth(true);
        ScrollPane sections = new ScrollPane();

            sections.setPrefWidth(225);
            sections.setFitToWidth(true);
            sections.setContent(leftSideButtons);

            holderArea.setContent(tab.getTab());

        BorderPane wholeArea = new BorderPane();

            wholeArea.setRight(sections);

            wholeArea.setCenter(holderArea);

            wholeArea.setTop(menubar);
            Scene scene = new Scene(wholeArea, 1000, 650);

            return scene;

        } /**
                 * @param args the command line arguments
                 */

    public static void main(String[] args) {
        launch(args);
    }

    private void setStage(Stage primaryStage) {
        theStage = primaryStage;
    }
    
    
}