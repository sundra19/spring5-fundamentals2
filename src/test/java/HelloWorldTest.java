import lab.model.Person;
import lab.model.SimpleCountry;
import lab.model.UsualPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";

	private UsualPerson expectedPerson;

	private BeanFactory context;

	@BeforeEach
	void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
		expectedPerson = getExpectedPerson();
	}

	@Test
	void testInitPerson() {
//		Person person = ;
		assertEquals(expectedPerson, context.getBean("person"));
//		System.out.println(person);
	}

	static UsualPerson getExpectedPerson() {
		return new UsualPerson()
				.setAge(35)
				.setName("John Smith")
				.setCountry(new SimpleCountry()
						.setId(1)
						.setName("Russia")
						.setCodeName("RU"));
	}
}
