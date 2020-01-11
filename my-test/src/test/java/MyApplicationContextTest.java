import com.zj.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.assertEquals;

/**
 * @Author zhongJun
 * @Date 2020-01-09 16:35
 */
public class MyApplicationContextTest {

	@Test
	public void testSimpleLoad() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MyTestBean bean = (MyTestBean) ac.getBean("myTestBean");
		assertEquals("testStr", bean.getTestStr());

		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		MyTestBean bean2 = (MyTestBean) bf.getBean("myTestBean");
		assertEquals("testStr", bean2.getTestStr());
	}
}
