/**
 Generate Parentheses:

Given n pairs of parentheses, write a function to generate all combinations of
well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 */

class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        generate(n, n, 0, new char[n * 2]);
        return res;
    }

    public void generate(int open, int close, int pos, char[] arr) {
        if (close < open)
            return;
        if (open == 0 && close == 0)
            res.add(new String(arr));

        if (open > 0) {
            arr[pos] = '(';
            generate(open - 1, close, pos + 1, arr);
        }
        if (close > 0) {
            arr[pos] = ')';
            generate(open, close - 1, pos + 1, arr);
        }
    }
}