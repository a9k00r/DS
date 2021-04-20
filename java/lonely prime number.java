
import java.util.*;
public class Solution{

    static boolean isPrime(int n)
    {
 
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;
 
        // Check if number is 2
        else if (n == 2)
            return true;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
     
    public static void main(String []args){
        
        String inp = "12, 3, 4, 5, 5, 4, 3, 2, 2, 21, 23, 40, 7, 6, 4, 7";
        
        String [] arr = inp.split(", ");
        
 
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i =0; i< arr.length; i++) {
            
            int num = Integer.parseInt(arr[i]);
            
            if (isPrime(num)) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num)+1) ;
                }
                else {
                    map.put(num, 1);
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
               if (e.getValue() == 1)
                System.out.println(e.getKey());
            }
     }
}