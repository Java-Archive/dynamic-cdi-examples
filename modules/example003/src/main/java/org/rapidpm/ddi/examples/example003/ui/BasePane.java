package org.rapidpm.ddi.examples.example003.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.rapidpm.ddi.DI;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;

/**
 * Created by Sven Ruppert on 28.09.2014.
 */
public class BasePane<T> extends AnchorPane {

  public T controller;

  public BasePane() {
    final String fxmlFile = this.getClass().getSimpleName() + ".fxml";
    FXMLLoader loader = createFXMLLoader(fxmlFile);

    controller = DI.activateDI(loader.getController());

    AnchorPane.setBottomAnchor(this, 0.0);
    AnchorPane.setTopAnchor(this, 0.0);
    AnchorPane.setLeftAnchor(this, 0.0);
    AnchorPane.setRightAnchor(this, 0.0);
  }


  private FXMLLoader createFXMLLoader(final String fxmlFile) {
    URL resource = getClass().getResource(fxmlFile);
    FXMLLoader loader = new FXMLLoader(resource);
    loader.setRoot(this);
//    loader.setController(new MainPaneController());
    try {
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return loader;
  }
}
