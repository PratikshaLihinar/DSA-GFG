//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        // your code here
         StringBuilder result = new StringBuilder();

        // Use a stack to reverse the order of numbers and operators
        Stack<String> stack = new Stack<>();

        int i = 0, n = S.length();
        while (i < n) {
            StringBuilder number = new StringBuilder();
            
            // Extract the number
            while (i < n && Character.isDigit(S.charAt(i))) {
                number.append(S.charAt(i));
                i++;
            }
            
            // Push the number to the stack
            if (number.length() > 0) {
                stack.push(number.toString());
            }

            // If the current character is an operator, push it to the stack
            if (i < n && "+-*/".indexOf(S.charAt(i)) != -1) {
                stack.push(String.valueOf(S.charAt(i)));
                i++;
            }
        }

        // Pop elements from the stack to reverse the equation
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}