package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class HelloApplication extends Application {
    TextField textField;
    Button button;
    Label label;
    ListView<String> suggestion;
    DictionaryUsingHashMap dictionaryUsingHashMap =new DictionaryUsingHashMap();
    Pane t=new Pane();
    Pane find(){
        Pane root=new Pane();
        root.setPrefSize(500,600);
        textField=new TextField();
        textField.setTranslateX(20);
        textField.setTranslateY(20);

        button=new Button("search");
        button.setTranslateX(200);
        button.setTranslateY(20);
//        b.setOnAction();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                label.setText("heieiie");
                String word=textField.getText();
                if(word.isBlank()||word.isEmpty()){
                    label.setText("Please enter text");
                    label.setTextFill(Color.RED);
                }
                else{
                    String meaning=dictionaryUsingHashMap.getMeaning(word);
                    label.setText(meaning);
                    label.setTextFill(Color.BLACK);
                }
            }
        });
        label=new Label("enter here");
        label.setTranslateX(20);
        label.setTranslateY(50);
        suggestion=new ListView<>();
        suggestion.setTranslateX(20);
        suggestion.setTranslateY(70);
        String[] allWords={"hi","prem"};
        suggestion.setOrientation(Orientation.VERTICAL);
        suggestion.getItems().addAll(allWords);
        suggestion.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String meaning=suggestion.getSelectionModel().getSelectedItem();
//                label.setText(meaning);
                String suggestedMeaning=dictionaryUsingHashMap.getMeaning(meaning);
                label.setText(suggestedMeaning);
                label.setTextFill(Color.BLUE);

            }
        });

        root.getChildren().addAll(textField,button,label,suggestion);
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(find());
        stage.setTitle("dict!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}