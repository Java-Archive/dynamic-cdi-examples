package org.rapidpm.ddi.examples.example004.business.module001;

import org.rapidpm.ddi.producer.Producer;

import javax.inject.Produces;
import java.time.LocalDateTime;

/**
 * Created by svenruppert on 17.08.15.
 */
@Produces(TimeStampService.class)
public class TimeStampProducer implements Producer<TimeStampService>{

  public TimeStampService create(){
    System.out.println("TimeStampProducer-create = " + LocalDateTime.now());
    return TimeStampServiceAdapterBuilder.newBuilder()
        .setOriginal(null)
        .withCreateTimeStamp(() -> LocalDateTime.now().toString())
        .buildForTarget(TimeStampService.class);
  }
}
