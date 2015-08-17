package org.rapidpm.ddi.examples.example003.business;

import java.time.LocalDateTime;

/**
 * Created by Sven Ruppert on 01.06.2014.
 */
public class Service {


  public Service() {
    System.out.println("Service constructed = " + LocalDateTime.now());
  }

  private int counter = 0;
  public String calculate(){
    String result = "Service used " + counter;
    System.out.println("Service.result = " + result);
    counter = counter +1;
    return result ;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Service{");
    sb.append("counter=").append(counter);
    sb.append('}');
    return sb.toString();
  }
}
