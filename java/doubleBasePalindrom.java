
/* 
Double Base Palindromes
The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 Hence we call 585 a double base palindrome number.


Write a program to find the sum of all double base palindrome numbers which are less than a given number.
 (Starting from 1, including the given number).

 

As an example, if the given number is 5, the double base palindromes less than or equal to 5 are 1 (binary 1),
 3 (binary 11) and 5 (binary 101). The sum is 1 + 3 + 5 = 9.

 

Please note that the palindromic number, in either base, may not include leading zeros.
*/

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

    static int makePalindrome(int n, boolean odd) {
        int res = n;
        if (odd)
            n = n / 10;
            
        while (n > 0) {
            res = 10 * res + n % 10;
            n /= 10;
        }
        return res;
    }
  
    static boolean isPalindrome(int n, int base) {
        int reversed = 0;
        int temp = n;
        while (temp > 0) {
            reversed = reversed * base + temp % base;
            temp /= base;
        }
        return reversed == n;
    }
    
    public static int getSumOfDoubleBasePalindromes(int maximum) {
  
        int sum = 0, i = 1, k = 2;
        int p = makePalindrome(i, true);
        while (p <= maximum) {
            if (isPalindrome(p, k))
                sum += p;
            i++;
            p = makePalindrome(i, true);
        }
  
        i = 1;
        p = makePalindrome(i, false);
        
        while (p <= maximum) {
            if (isPalindrome(p, k))
                sum += p;
            i++;
            p = makePalindrome(i, false);
        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int maximum = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getSumOfDoubleBasePalindromes(maximum);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
 