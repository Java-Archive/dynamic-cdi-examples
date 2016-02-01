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

package org.rapidpm.ddi.examples.example003.ui.main.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.rapidpm.ddi.examples.example003.business.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDateTime;

public class EditPaneController {

//@Proxy(metrics = true, virtual = true)

  @Inject Service service;

  @FXML Button btn;
  @FXML Label lb;
  private int counter;

  public EditPaneController() {
    System.out.println("EditPaneController created " + LocalDateTime.now());
  }

  public void onDoSomething(ActionEvent actionEvent) {
    btn.setText("Edit pressed " + counter);
    counter = counter + 1;
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
