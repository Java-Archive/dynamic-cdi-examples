package org.rapidpm.ddi;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.rapidpm.ddi.service.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
@Theme("valo")
public class MyUI extends UI {


  private static final AtomicInteger COUNTER = new AtomicInteger(0);
  private int clickCount;

  @Inject Service service;

  public Button button;
  public Label label;

  @Override
  protected void init(VaadinRequest vaadinRequest) {

  }


  @PostConstruct
  public void initialize() {
    System.out.println("MyUI.initialize = " + LocalDateTime.now());
    COUNTER.incrementAndGet();
    clickCount = 0;

    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    label = new Label("here is a label");
    button = new Button("Click Me");
    button.addClickListener(event -> label.setValue("Thank you for clicking " + service.doWork()));
    layout.addComponent(button);
    layout.addComponent(label);
  }


  public static int getNumberOfInstances() {
    return COUNTER.get();
  }

  public static void resetCounter() {
    COUNTER.set(0);
  }

}
