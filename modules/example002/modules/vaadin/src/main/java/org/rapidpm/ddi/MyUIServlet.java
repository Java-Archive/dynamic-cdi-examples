package org.rapidpm.ddi;

import com.vaadin.annotations.VaadinServletConfiguration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 * Created by svenruppert on 11.08.15.
 */
@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true, displayName = "Exampl002")
@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
public class MyUIServlet extends DDIVaadinServlet  {

  public MyUIServlet() {
    //Metrics - System.out.println("MyUIServlet - LocalDateTime.now() = " + LocalDateTime.now());
  }

  @Override
  protected void servletInitialized() throws ServletException {
    super.servletInitialized();
  }

}
