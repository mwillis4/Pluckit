///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pickit;
//
//import java.awt.AWTException;
//import java.awt.Dimension;
//import java.awt.Point;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.SnapshotParameters;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import javax.xml.parsers.ParserConfigurationException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.docx4j.openpackaging.exceptions.Docx4JException;
//import org.xml.sax.SAXException;
//
///**
// *
// * @author MorganWillis
// */
//public class PickIt extends Application {
//    
//    @Override
//    public void start(Stage primaryStage) {
//        final Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//
//        
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                Database newDB = new Database();
//                ArrayList<Sectional> sectionalList = new ArrayList<Sectional>();
//                newDB
//                    .setSectionalAddress("C:\\Users\\MorganWillis\\Documents\\NetBeansProjects\\TextFiles\\Chords.xml");
//                
//                try {
//                    sectionalList = newDB.loadSectional();
//                } catch (ParserConfigurationException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (SAXException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                PrepArea newPA = new PrepArea();
//                
//                try {
//                    newPA.loadSong("C:\\Users\\MorganWillis\\Documents\\NetBeansProjects\\TextFiles\\song.xml");
//                    newPA.display();
//                } catch (ParserConfigurationException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (SAXException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                String exportAddress = "C:\\Users\\MorganWillis\\Documents\\NetBeansProjects\\TextFiles\\textPic.xml";
//             
//                try {
//                    newPA.exportToWord(exportAddress, null);
//                } catch (AWTException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (InvalidFormatException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (Docx4JException ex) {
//                    Logger.getLogger(PickIt.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//}
