


import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {
private TestDemo testDemo ;
	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean exceptException) {
		if (!exceptException) { assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
			
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
static Stream < Arguments> argumentsForAddPositive (){
	
	
	
	return Stream.of(
			arguments(3,4,7, false),
			arguments(-1,2,1, true),
			arguments(0,1,1, true)
			
			);
	
}
@Test
void assertThatNumberSquaredIsCorrect() {
	
	TestDemo mockDemo = spy(testDemo);
	doReturn(5).when(mockDemo).getRandomInt();
	int fiveSquared= mockDemo.randomNumberSquared();
	assertThat(fiveSquared).isEqualTo(25);
}

}
