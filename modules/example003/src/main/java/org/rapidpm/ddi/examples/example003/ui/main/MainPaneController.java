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

package org.rapidpm.ddi.examples.example003.ui.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.rapidpm.ddi.examples.example003.ui.main.edit.EditPane;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

public class MainPaneController {

  @FXML Button btn;
  @FXML EditPane editPane;
  private int counter;

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
