/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.rapidpm.ddi.examples.services.adapter;

import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.examples.external.ExternalService;

import javax.inject.Inject;
import java.time.LocalDateTime;

//@ExternalClassAdapter
public class ExternalAdapter implements ExternalAdapterInterface {

  @Inject ExternalService externalService; // geht ohne interface nicht mit dynamischen proxies

  public ExternalAdapter() {
    System.out.println("ExternalAdapter.now() = " + LocalDateTime.now());
    DI.activateDI(this); // TODO @Inject without function
  }

  public String workExternal(final String txt) {
    return externalService.workExternal(txt);
  }
}
