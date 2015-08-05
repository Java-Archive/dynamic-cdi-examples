package org.rapidpm.ddi.examples.services;

import org.rapidpm.proxybuilder.dynamicobjectadapter.DynamicObjectAdapterBuilder;

/**
 * Created by svenruppert on 05.08.15.
 */
@DynamicObjectAdapterBuilder
public interface Service {
  String doWork(String txt);
}
