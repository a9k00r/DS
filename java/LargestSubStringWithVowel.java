import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'findSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String findSubstring(String s, int k) {

        int length = s.length();

        int[] pref = new int[length];

        for (int i = 0; i < length; i++) {

            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                pref[i] = 1;

            else
                pref[i] = 0;

            if (i != 0)
                pref[i] += pref[i - 1];
        }

        if (maxCount == 0)
            return "Not found!";

        int maxCount = pref[k - 1];

        String result = s.substring(0, k);

        for (int i = k; i < length; i++) {
            // Store the current
            // count of vowels
            int currCount = pref[i] - pref[i - k];

            // Update the result if current count
            // is greater than maximum count
            if (currCount > maxCount) {
                maxCount = currCount;
                result = s.substring(i - k + 1, i + 1);
            }

        }

        return result;

    }

}