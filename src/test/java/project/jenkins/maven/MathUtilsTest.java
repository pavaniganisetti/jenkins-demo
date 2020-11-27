package project.jenkins.maven;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*; 

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@EnabledOnOs(OS.LINUX)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("when running MathUtilsTest")
class MathUtilsTest {

	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	 void beforeAll() {
		System.out.println("Running before all the methods...");
	}
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
//		testReporter.publishEntry(testInfo.getDisplayName()+ "******"+testInfo.getTestMethod());
	}
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up after each method...");

	}

	@Nested
	@Tag("Math")
	@DisplayName("testAdd running")
	class testAdd {
		
		@Test
		@DisplayName("when adding two positive numbers")
		void testAddPositive() {
			assertEquals(2,  mathUtils.add(1, 1),"The method should return correct sum");
		}
		
		@Test
		@DisplayName("when adding two negative numbers")
		void testAddNegative() {
			assertEquals(-2,  mathUtils.add(-1, -1),"The method should return correct sum");
		}
	}
	
	@RepeatedTest(3)
	@Tag("Math")
	@DisplayName("Substract method")
	void testSubstract(RepetitionInfo repetitionInfo) {
		if(repetitionInfo.getCurrentRepetition() == 2) {
			assertEquals(3,mathUtils.substract(4, 1),() -> "The method should return the difference btw number");
		}	
		assertEquals(3,mathUtils.substract(5, 2),() -> "The method should return the difference btw number");
	}
	
	
	@Test
	@Tag("Math")
	@DisplayName("Division method")
	void testDivide() {
		Boolean isDivisionPossible = true;
		assumeTrue(isDivisionPossible);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),() -> "Divide by zero exception");
	}

	@Test
	@Tag("Math")
	@DisplayName("Multiply method")
	void testMultiply() {
		System.out.println(testInfo.getTags());
		assertAll(
				() -> assertEquals(4,mathUtils.multiply(2, 2)),
				() -> assertEquals(-2,mathUtils.multiply(-1, 2)),
				() -> assertEquals(4,mathUtils.multiply(-2, -2)),
				() -> assertEquals(0,mathUtils.multiply(0, 2))
				);
	}
	
	@Test
	@DisplayName("Find Circle Area")
	@Tag("Circle")
	@Disabled
	void testComputeCircleArea() {
		double expected = 314.1592653589793;
		assertEquals(expected, mathUtils.computeCircleArea(10), "should return area of circle");
	}
	
	@Test
	@Tag("Square")
	@DisplayName("Find Square Area")
	void testComputeSquareArea() {
		assertEquals(4,mathUtils.computeSquareArea(2),() -> "should return area of square");
	}
	
}

