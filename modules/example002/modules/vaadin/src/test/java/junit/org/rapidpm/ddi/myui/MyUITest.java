package junit.org.rapidpm.ddi.myui;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.MyUI;

/**
 * Created by svenruppert on 15.08.15.
 */
public class MyUITest {

  @Before
  public void setUp() throws Exception {
    DI.activatePackages("junit.org.rapidpm");

  }

  @Test
  public void test001() throws Exception {
    final MyUI myUI = DI.activateDI(new MyUI());

    Assert.assertEquals(myUI.label.getValue(), "here is a label");

    myUI.button.click();

    final String value = myUI.label.getValue();
    Assert.assertNotNull(value);
    Assert.assertNotEquals("here is a label", value);
    Assert.assertTrue(value.startsWith("Thank you for clicking "));

  }
}
