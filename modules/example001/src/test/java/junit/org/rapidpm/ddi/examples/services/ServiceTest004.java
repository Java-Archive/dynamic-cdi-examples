package junit.org.rapidpm.ddi.examples.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.ddi.DDIServiceFactory;
import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapter;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterface;
import org.rapidpm.ddi.producer.Producer;
import org.rapidpm.proxybuilder.type.virtual.Concurrency;
import org.rapidpm.proxybuilder.type.virtual.ProxyGenerator;
import org.rapidpm.proxybuilder.type.virtual.ProxyType;
import org.rapidpm.proxybuilder.type.virtual.dynamic.ServiceStrategyFactoryNotThreadSafe;

import javax.inject.Inject;
import javax.inject.Produces;

/**
 * Created by svenruppert on 07.08.15.
 */
public class ServiceTest004 {

  @Inject ExternalAdapterInterface targetPRoxy;

  @Before
  public void setUp() throws Exception {
    DI.activateDI(this);
  }

  @Test
  public void test001() throws Exception {
    Assert.assertNotNull(targetPRoxy);
    final String hello = targetPRoxy.workExternal("hello");
    Assert.assertNotNull(hello);
    Assert.assertFalse(hello.isEmpty());
    Assert.assertEquals("hello_external", hello);
  }

  @Produces(ExternalAdapterInterface.class)
  public static class ExternalAdapterInterfaceProducer implements Producer<ExternalAdapterInterface> {
    @Override
    public ExternalAdapterInterface create() {
      return ProxyGenerator.<ExternalAdapterInterface, ExternalAdapter>newBuilder()
          .withSubject(ExternalAdapterInterface.class).withRealClass(ExternalAdapter.class)
          .withType(ProxyType.DYNAMIC)
          .withConcurrency(Concurrency.NONE)
          .withServiceFactory(new DDIServiceFactory<>(ExternalAdapter.class))
          .withServiceStrategyFactory(new ServiceStrategyFactoryNotThreadSafe<>())
          .build()
          .make();
    }
  }
}
