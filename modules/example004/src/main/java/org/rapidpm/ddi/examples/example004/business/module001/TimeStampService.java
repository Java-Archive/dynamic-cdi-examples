package org.rapidpm.ddi.examples.example004.business.module001;


import org.rapidpm.proxybuilder.objectadapter.annotations.dynamicobjectadapter.DynamicObjectAdapterBuilder;

import java.time.LocalDateTime;

/**
 * Created by svenruppert on 17.08.15.
 */

@DynamicObjectAdapterBuilder
public interface TimeStampService {
  String createTimeStamp();

  LocalDateTime convertTimeStamp(String timstamp);
}
