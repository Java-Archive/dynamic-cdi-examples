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

package junit.org.rapidpm.ddi.examples.services;

import org.junit.Assert;
import org.junit.Test;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterface;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterfaceAdapterBuilder;

public class ServiceTest003 {


  @Test
  public void test001() throws Exception {


    final ExternalAdapterInterface target = ExternalAdapterInterfaceAdapterBuilder.newBuilder()
        .setOriginal(null)
        .withWorkExternal(txt -> "mocked")
        .buildForTarget(ExternalAdapterInterface.class);

    Assert.assertNotNull(target);

    final String hello = target.workExternal("hello");
    Assert.assertNotNull(hello);
    Assert.assertFalse(hello.isEmpty());
    Assert.assertEquals("mocked", hello);
  }
}
