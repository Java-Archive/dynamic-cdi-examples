package org.rapidpm.ddi.examples.example004.business;

import org.rapidpm.ddi.Proxy;
import org.rapidpm.ddi.examples.example004.business.module001.TimeStampService;

import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * Created by Sven Ruppert on 01.06.2014.
 */
public class ServiceImpl implements Service {

  @Inject @Proxy(virtual = true, metrics = true) TimeStampService timeStampService;
  private int counter = 0;

  public ServiceImpl() {
    System.out.println("ServiceImpl constructed = " + LocalDateTime.now());
  }

  @Override
  public String calculate() {
    String result = "Service used " + counter;
    System.out.println("Service.result = " + result);
    counter = counter + 1;
    return result;
  }


  public String getTimeStamp() {
    return timeStampService.createTimeStamp();
  }

}
