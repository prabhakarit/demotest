package com;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

//@SpringBootTest
@ContextConfiguration
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class ApplicationIntegrationTests {

	@Test
	void testAppRun() throws Exception {
		Application.main(new String[]{});
	}

    @Test
	void testWithDifferentSamples() throws Exception {
		Application.main(new String[]{});
	}
}
