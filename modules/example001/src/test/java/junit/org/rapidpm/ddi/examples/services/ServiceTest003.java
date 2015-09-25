package junit.org.rapidpm.ddi.examples.services;

import org.junit.Assert;
import org.junit.Test;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterface;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterfaceAdapterBuilder;

/**
 * Created by svenruppert on 05.08.15.
 */
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
