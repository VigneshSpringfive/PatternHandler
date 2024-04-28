package org.patternpack;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternApplication {

    public  static void main(String[] arg)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source string: ");
        String sourceStr = scanner.nextLine();

        System.out.print("Enter sub string: ");
        String patternExpression = scanner.nextLine();
        scanner.close();

        Pattern pattern = getPattern(patternExpression);
        Matcher matcher = getMatcher(pattern, sourceStr);

        StringBuilder output=new StringBuilder();
        output.append("****************************************************\n");
        output.append("Source String : ").append(sourceStr).append("\n");
        output.append("Source String Length : ").append(sourceStr.length()).append("\n");
        output.append("Pattern String : ").append(patternExpression).append("\n");
        output.append("Matching Count : ").append(countOccurrences(matcher)).append("\n");
        output.append("Source String without substring : ").append(sourceStr.replace(patternExpression, "")).append("\n");
        output.append("Source String Length without substring : ").append(sourceStr.replace(patternExpression, "").length()).append("\n");
        //not palindrome
        if(!reverseStr(patternExpression).equals(patternExpression))
        {
            output.append("Reverse pattern : ").append(reverseStr(patternExpression)).append("\n");

            int reverseCnt = countOccurrences(getMatcher(getPattern(reverseStr(patternExpression)), sourceStr));
            if (reverseCnt > 0) {
                output.append("Reverse pattern found : Yes  ").append("Reverse Matching Count : ").append(reverseCnt).append("\n");

            } else {
                output.append("Reverse pattern found : No").append("\n");

            }
        }
        output.append("****************************************************");
        System.out.println(output);

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
    public static int countOccurrences(Matcher matcher) {
        return (int) matcher.results().count();
    }

}

