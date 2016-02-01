/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.rapidpm.ddi.examples.example003.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.rapidpm.ddi.DI;

import java.io.IOException;
import java.net.URL;

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
