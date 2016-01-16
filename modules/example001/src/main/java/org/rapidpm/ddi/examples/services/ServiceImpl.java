package org.rapidpm.ddi.examples.services;


import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterface;

import javax.inject.Inject;

/**
 * Created by Sven Ruppert on 05.08.15.
 */
public class ServiceImpl implements Service {


  @Inject ExternalAdapterInterface adapterInterface;


  @Override
  public String doWork(final String txt) {
    return adapterInterface.workExternal(txt) + " - " + ServiceImpl.class.getSimpleName();
  }


}
