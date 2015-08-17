package org.rapidpm.ddi.examples.example004.ui.main.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.rapidpm.ddi.examples.example004.business.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * Created by Sven Ruppert on 01.06.2014.
 */
public class EditPaneController {

//@Proxy(metrics = true, virtual = true)

  @Inject Service service;

  @FXML Button btn;
  @FXML Label lb;
  private int counter = 0;

  public EditPaneController() {
    System.out.println("EditPaneController created " + LocalDateTime.now());
  }

  public void onDoSomething(ActionEvent actionEvent) {
    btn.setText("Edit pressed " + counter);
    counter = counter + 1;

    System.out.println("service.timestamp = " + service.getTimeStamp());
  }

  public void useService() {
    lb.setText(service.calculate());
  }


  @PostConstruct
  public void postConstruct() {
    System.out.println("EditPaneController-lb = " + lb);
    System.out.println("EditPaneController-btn = " + btn);
  }
}
