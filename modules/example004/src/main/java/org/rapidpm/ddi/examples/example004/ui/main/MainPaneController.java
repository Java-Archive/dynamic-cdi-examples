package org.rapidpm.ddi.examples.example004.ui.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.rapidpm.ddi.examples.example004.ui.main.edit.EditPane;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * Created by Sven Ruppert on 01.06.2014.
 */
public class MainPaneController {

  @FXML Button btn;
  @FXML EditPane editPane;
  private int counter = 0;

  public MainPaneController() {
    System.out.println("MainPaneController created = " + LocalDateTime.now());
  }

  public void onDoSomething(ActionEvent actionEvent) {
    btn.setText("Main pressed " + counter);
    counter = counter + 1;

    //label from Edit changing
    editPane.setLabelText();
  }


  @PostConstruct
  public void postConstruct() {
    System.out.println("MainPaneController-editPane = " + editPane);
    System.out.println("MainPaneController-btn = " + btn);
  }
}
