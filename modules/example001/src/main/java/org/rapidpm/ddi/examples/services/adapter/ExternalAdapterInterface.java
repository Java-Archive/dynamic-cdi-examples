package org.rapidpm.ddi.examples.services.adapter;


import org.rapidpm.proxybuilder.objectadapter.annotations.dynamicobjectadapter.DynamicObjectAdapterBuilder;

/**
 * Created by Sven Ruppert on 05.08.15.
 */
@DynamicObjectAdapterBuilder
public interface ExternalAdapterInterface {
  String workExternal(final String txt);
}
