package org.rapidpm.ddi.examples.external;

import java.time.LocalDateTime;

/**
 * Created by svenruppert on 05.08.15.
 */
public class ExternalService {


  public ExternalService() {
    System.out.println("ExternalService.now() = " + LocalDateTime.now());
  }

  public String workExternal(String txt) {
    return txt + "_external";
  }
}
