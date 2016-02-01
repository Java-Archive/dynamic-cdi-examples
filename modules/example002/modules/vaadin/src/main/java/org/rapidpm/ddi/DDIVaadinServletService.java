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

package org.rapidpm.ddi;

import com.vaadin.server.*;
import com.vaadin.ui.UI;
import org.reflections.util.ClasspathHelper;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class DDIVaadinServletService extends VaadinServletService {

  public static final String PKG_PREFIX = "org.rapidpm"; // must come from external config

  public DDIVaadinServletService(VaadinServlet servlet, DeploymentConfiguration deploymentConfiguration) throws ServiceException {
    super(servlet, deploymentConfiguration);

    if (DI.isPkgPrefixActivated(PKG_PREFIX)) {
      //nothing....
      System.out.println("DI.getPkgPrefixActivatedTimestamp() = " + DI.getPkgPrefixActivatedTimestamp(PKG_PREFIX));
    } else {
//      final VaadinServlet current = VaadinServlet.getCurrent();
//      final ServletContext currentServletContext = current.getServletContext();
      System.out.println("DDIVaadinServletService-DI.activatePackages-LocalDateTime.now() = " + LocalDateTime.now());
      final ServletContext currentServletContext = servlet.getServletContext();
      final Collection<URL> urlsWebInfLib = ClasspathHelper.forWebInfLib(currentServletContext);

      final List<URL> urlList = urlsWebInfLib.stream()
          .filter(u -> u.toString().contains("rapidpm-"))  //reduce the jars to scann
          .collect(Collectors.toList());
      DI.activatePackages(PKG_PREFIX, urlList); //reduce the classes to scann
      System.out.println("DDIVaadinServletService-DI.activatePackages-LocalDateTime.now() = " + LocalDateTime.now());
      //inject
    }


    addSessionInitListener(event -> event.getSession().addUIProvider(new DefaultUIProvider() {
      @Override
      public UI createInstance(final UICreateEvent event) {
        final UI instance = super.createInstance(event);
        //metrics - System.out.println("DDIVaadinServletService.getInstance-instance = " + instance);
        return DI.activateDI(instance);
      }
    }));

    addSessionDestroyListener(event -> {
      System.out.println("addSessionDestroyListener-event = " + event);
//      VaadinSessionDestroyEvent sessionDestroyEvent = new VaadinSessionDestroyEvent(CDIUtil.getSessionId(event.getSession()));
//      getBeanManager().fireEvent(sessionDestroyEvent);
    });
  }


  @Override
  public void handleRequest(VaadinRequest request, VaadinResponse response) throws ServiceException {
    super.handleRequest(request, response);
    System.out.println("handleRequest-request = " + request.getContextPath());
  }

  @PostConstruct
  public void initialize() {
    System.out.println("DDIVaadinServletService = initialize " + LocalDateTime.now());
  }
}
