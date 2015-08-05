package org.rapidpm.ddi.examples.services.adapter;

import org.rapidpm.ddi.examples.external.ExternalService;

import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * Created by svenruppert on 05.08.15.
 */ //@ExternalClassAdapter
public class ExternalAdapter implements ExternalAdapterInterface {

  public ExternalAdapter() {
    System.out.println("ExternalAdapter.now() = " + LocalDateTime.now());
  }

  @Inject ExternalService externalService; // geht ohne interface nicht mit dynmaschen proxies

  public String workExternal(final String txt) {
    return externalService.workExternal(txt);
  }
}
