package stringop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringOperatorTest {

   @Test
   void correctStringOutput(){
   String expectedResult = "Hello!";

   String actualResult = StringOperator.returnHello();

   assertThat(actualResult).isEqualTo(expectedResult);
   }
}
