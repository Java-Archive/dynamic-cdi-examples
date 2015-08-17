package junit.org.rapidpm.ddi.examples.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapter;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterface;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterfaceAdapterBuilder;

import javax.inject.Inject;

/**
 * Created by svenruppert on 07.08.15.
 */
public class ServiceTest002 {


  @Before
  public void setUp() throws Exception {
    DI.activateDI(this);
  }

  @Inject ExternalAdapter externalAdapter;

  @Test
  public void test001() throws Exception {

    //could be inside a producer
    final ExternalAdapterInterface target = ExternalAdapterInterfaceAdapterBuilder.newBuilder()
        .setOriginal(externalAdapter)
        .withWorkExternal(txt -> "mocked")
        .buildForTarget(ExternalAdapterInterface.class);

    Assert.assertNotNull(target);

    final String hello = target.workExternal("hello");
    Assert.assertNotNull(hello);
    Assert.assertFalse(hello.isEmpty());
    Assert.assertEquals("mocked",hello);
  }



}
