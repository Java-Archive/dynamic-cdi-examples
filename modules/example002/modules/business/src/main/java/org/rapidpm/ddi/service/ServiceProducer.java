package org.rapidpm.ddi.service;

import org.rapidpm.ddi.producer.Producer;

import org.rapidpm.ddi.Produces;
import java.time.LocalDateTime;

/**
 * Created by svenruppert on 10.08.15.
 */
@Produces(Service.class)
public class ServiceProducer implements Producer<Service> {

  @Override
  public Service create() {
    return ServiceAdapterBuilder
        .newBuilder()
        .setOriginal(null)
        .withDoWork(() -> "mocked-" + LocalDateTime.now())
        .buildForTarget(Service.class);
  }
}
