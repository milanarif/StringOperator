package stringop;

import com.google.common.base.CharMatcher;

public class StringOperator {

   private String s;

   public StringOperator(String s){
      this.s = s;
   }

   public String trimString(){
      return CharMatcher.whitespace().trimFrom(s);
   }
}
