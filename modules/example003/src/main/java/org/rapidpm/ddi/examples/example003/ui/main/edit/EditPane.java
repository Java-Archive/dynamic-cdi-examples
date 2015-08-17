package org.rapidpm.ddi.examples.example003.ui.main.edit;


import org.rapidpm.ddi.examples.example003.ui.BasePane;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * Created by Sven Ruppert on 01.06.2014.
 */
public class EditPane extends BasePane<EditPaneController> {

  public EditPane() {
  }

  public void setLabelText() {
    controller.useService();
  }

  @PostConstruct
  public void postContruct() {
    System.out.println("EditPane constructed = " + LocalDateTime.now());
  }
}
