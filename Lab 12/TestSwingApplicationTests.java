package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSwingApplicationTests {
	
	TestSwingApplication application = new TestSwingApplication();

	@Test
	void givenTwoIntegers_WhenSum_ThenCorrectResult() {
		
		// Given 5 and 7
		application.numberOneTextField.setText("5");
		application.numberTwoTextField.setText("7");
		String expectedResult = "12";
		
		// When operation is sum
		application.operationButton.doClick();
		
		// Then result is 12
		String actualResult = application.resultTextField.getText();
		assertEquals(expectedResult, actualResult);
	}

	
	@Test
	void givenAnInvalidInput_WhenSum_ThenInputIsClearedAndNoResultIsProvided() {
		
		// Given two invalid inputs
		application.numberOneTextField.setText("feliz");
		application.numberTwoTextField.setText("dia profe");
		String expectedResultTextFieldOne = "";
		String expectedResultTextFieldTwo = "";
		String expectedResultTextField = "";
		
		// When operation is sum
		application.operationButton.doClick();
		
		// Then all the textfields have no value
		String actualResultTextFieldOne = application.numberOneTextField.getText();
		String actualResultTextFieldTwo = application.numberTwoTextField.getText();
		String actualResultTextField = application.resultTextField.getText();
		assertEquals(expectedResultTextFieldOne, actualResultTextFieldOne);
		assertEquals(expectedResultTextFieldTwo, actualResultTextFieldTwo);
		assertEquals(expectedResultTextField, actualResultTextField);
	}

}
