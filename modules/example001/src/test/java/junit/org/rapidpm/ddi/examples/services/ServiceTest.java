package junit.org.rapidpm.ddi.examples.services;

import org.junit.Assert;
import org.junit.Test;
import org.rapidpm.ddi.DDIServiceFactory;
import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.examples.services.ServiceImpl;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapter;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterface;
import org.rapidpm.ddi.examples.services.adapter.ExternalAdapterInterfaceAdapterBuilder;
import org.rapidpm.proxybuilder.type.virtual.Concurrency;
import org.rapidpm.proxybuilder.type.virtual.ProxyGenerator;
import org.rapidpm.proxybuilder.type.virtual.ProxyType;
import org.rapidpm.proxybuilder.type.virtual.dynamic.ServiceStrategyFactoryNotThreadSafe;


/**
 * Created by svenruppert on 05.08.15.
 */
public class ServiceTest {


  @Test
  public void test001() throws Exception {
    final ServiceImpl instance = new ServiceImpl();
    DI.getInstance().activateDI(instance);

    Assert.assertNotNull(instance);
    final String hello = instance.doWork("Hello");
    Assert.assertNotNull(hello);
    Assert.assertFalse(hello.isEmpty());
  }


  @Test
  public void test002() throws Exception {
    ExternalAdapter externalAdapter = new ExternalAdapter();
    DI.getInstance().activateDI(externalAdapter); //externe

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


  @Test
  public void test003() throws Exception {
    ExternalAdapterInterface targetPRoxy = ProxyGenerator.<ExternalAdapterInterface, ExternalAdapter>newBuilder()
        .withSubject(ExternalAdapterInterface.class).withRealClass(ExternalAdapter.class)
        .withType(ProxyType.DYNAMIC)
        .withConcurrency(Concurrency.NONE)
        .withServiceFactory(new DDIServiceFactory<>(ExternalAdapter.class))
        .withServiceStrategyFactory(new ServiceStrategyFactoryNotThreadSafe<>())
        .build()
        .make();

    final ExternalAdapterInterface target = ExternalAdapterInterfaceAdapterBuilder.newBuilder()
        .setOriginal(targetPRoxy)
        .withWorkExternal(txt -> "mocked")
        .buildForTarget(ExternalAdapterInterface.class);

    Assert.assertNotNull(target);

    final String hello = target.workExternal("hello");
    Assert.assertNotNull(hello);
    Assert.assertFalse(hello.isEmpty());
    Assert.assertEquals("mocked",hello);
  }
}
