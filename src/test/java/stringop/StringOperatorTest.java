package stringop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringOperatorTest {

   @Test
   void correctStringOutput(){
   StringOperator string = new StringOperator(" HEJ  ");
   String expectedResult = "HEJ";

   String actualResult = string.trimString();

   assertThat(actualResult).isEqualTo(expectedResult);
   }
}
