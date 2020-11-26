package project.jenkins.maven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

	private MathUtils mathUtils;
	
	@BeforeEach
	void initEach()
	{
		mathUtils = new MathUtils();
	}
	
	@Test
	@DisplayName("Addition")
	void testAdd() {
		assertEquals(2,mathUtils.add(1, 1),()-> "Should return correct sum");
	}
	
	@Test
	@DisplayName("Substraction")
	void testSubstrat()
	{
		assertEquals(2,mathUtils.substract(4, 2),() -> "Should return correct substraction result!");
	}
}
