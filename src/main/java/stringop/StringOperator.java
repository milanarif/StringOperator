package stringop;

import com.google.common.base.CharMatcher;

public class StringOperator {
   public static void main(String[] args) {
      returnHello();
      System.out.println("1234");
   }

   public static String returnHello(){
      return CharMatcher.whitespace().trimFrom(" Hello!  ");
   }
}


