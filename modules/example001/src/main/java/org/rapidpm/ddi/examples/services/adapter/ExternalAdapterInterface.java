package org.rapidpm.ddi.examples.services.adapter;

import org.rapidpm.proxybuilder.dynamicobjectadapter.DynamicObjectAdapterBuilder;

/**
 * Created by svenruppert on 05.08.15.
 */
@DynamicObjectAdapterBuilder
public interface ExternalAdapterInterface {
  String workExternal(final String txt);
}
