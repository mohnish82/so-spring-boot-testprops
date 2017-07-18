package com.desasha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
@ActiveProfiles("test")
public class SpringPropertyLoadTest {
	
	@Autowired
	Environment env;
	
	@Test
	public void shouldLoadDefaultProps() {
		assertThat(env.getProperty("prop1")).isEqualTo("main_one");
	}
	
    @Test
    public void shouldOverrideDefaultPropWithTestProp() {
    	assertThat(env.getProperty("prop2")).isEqualTo("test_two");
    }

}
