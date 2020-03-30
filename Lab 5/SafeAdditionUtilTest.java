package mx.tec.lab.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.CsvFileSource; 

public class SafeAdditionUtilTest {
	
	@ParameterizedTest(name = "{index}: safeAdd({0}, {1}) = {2}")
//	@CsvSource({
//		"1, 2, 3",
//		"-10, 30, 20",
//		"15, -5, 10",
//		"-5, -10, -15"
//	})
//	@MethodSource("sumProvider")
	@CsvFileSource(resources = "/JUnitParamsTestParameters.csv")
	public void whenWithAnnotationProvidedParams_thenSafeAdd(int m1, int m2, int result) {
		SafeAdditionUtil serviceUnderText = new SafeAdditionUtil();
		
		assertEquals(result, serviceUnderText.safeAdd(m1, m2));
	}
	
	
	
	
	
	private static Stream<Arguments> sumProvider(){
		return Stream.of(
				Arguments.of(1,2,3),
				Arguments.of(-10,30,20),
				Arguments.of(15,-5,10),
				Arguments.of(-5,-10,-15)
		);
	}
	
}
