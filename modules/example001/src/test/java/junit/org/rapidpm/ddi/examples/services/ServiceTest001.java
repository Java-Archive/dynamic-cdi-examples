package junit.org.rapidpm.ddi.examples.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.examples.services.ServiceImpl;

import javax.inject.Inject;

/**
 * Created by svenruppert on 07.08.15.
 */
public class ServiceTest001 {

  @Before
  public void setUp() throws Exception {
    DI.getInstance().activateDI(this);
  }

  @Inject ServiceImpl instance;

  @Test
  public void test001() throws Exception {

    Assert.assertNotNull(instance);
    final String hello = instance.doWork("Hello");
    Assert.assertNotNull(hello);
    Assert.assertFalse(hello.isEmpty());
  }
}
