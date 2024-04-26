package org.PatternPack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternApplication {

    public  static void main(String arg[])
    {
        String sourceStr = "abcb12acbacb21fvefaerfgqerfg13er34r34r4r34$%#$#$@#E@#E@#R$REFVEFVWRF#F#$R#$R@#$E@#$@E";
        String patternExpression = "E@";
        boolean reverseptrn;
        Pattern pattern = getPattern(patternExpression);
        Matcher matcher = getMatcher(pattern, sourceStr);
        System.out.println("****************************************************");
        System.out.println("Source String\t:\t"+sourceStr);
        System.out.println("Source String Length\t:\t"+sourceStr.length());
        System.out.println("Pattern String\t:\t"+patternExpression);
        System.out.println("Matching Count\t: " + countOccurrences(matcher) );
        System.out.println("Source String without substring\t:\t"+sourceStr.replaceAll(patternExpression, ""));
        System.out.println("Source String Length without substring\t: "+sourceStr.replaceAll(patternExpression, "").length());
        //not palindrome
        if(!reverseStr(patternExpression).equals(patternExpression))
        {
            System.out.println("Reverse pattern\t: " + reverseStr(patternExpression));
            int revresecnt = countOccurrences(getMatcher(getPattern(reverseStr(patternExpression)), sourceStr));
            if (revresecnt > 0) {
                System.out.println("Reverse pattern found\t: Yes");
                System.out.println("Reverse Matching Count\t: " + revresecnt);
            } else {
                System.out.println("Reverse pattern found\t: No");
            }
        }
        System.out.println("****************************************************");
       // countPattern(matcher, sourceStr, patternExpression);
    }
    public static Pattern getPattern(String patternExpression) {
        return Pattern.compile(patternExpression);
    }

    public static Matcher getMatcher(Pattern pattern, String sourceStr) {
        return pattern.matcher(sourceStr);
    }
    public static String reverseStr(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }
    public static int reversePatternCount(String sourceString,String pattern)
    {
        return countOccurrences(getMatcher(getPattern(reverseStr(pattern)), sourceString));
    }
    public static int countOccurrences(Matcher matcher) {
        return (int) matcher.results().count();
    }

}

