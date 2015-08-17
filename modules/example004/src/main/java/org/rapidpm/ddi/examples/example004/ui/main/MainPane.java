package org.rapidpm.ddi.examples.example004.ui.main;


import org.rapidpm.ddi.examples.example004.ui.BasePane;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * Created by Sven Ruppert on 01.06.2014.
 */
public class MainPane extends BasePane<MainPaneController> {

  public MainPane() {
  }


  @PostConstruct
  public void postContruct() {
    System.out.println("MainPane constructed = " + LocalDateTime.now());
  }
}
