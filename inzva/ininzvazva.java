/*
A string S is called stringzva if it ensures the following conditions:
S is empty.
S is "inzva".
S is a string formed "in" + T + "zva" where T is some stringzva.
S is a string formed X + Y where X and Y are some stringzva.

For example, "inzva", "ininzvazva", "inzvainzva" are stringzva but "inziva", "zvain" are not stringzva.

You are given a string.
You should print "Yes" if the given string is stringzva, otherwise you should print "No".
*/


import java.util.Scanner;
import java.util.Stack;

public class ininzvazva {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        Stack<String> stack = new Stack<>();

        if (s == "") {
            System.out.println("Yes");
            return;
        }
        if (s.length() % 5 != 0) {
            System.out.println("No");
            return;
        }
        if (s.charAt(s.length()-1) != 'a' || s.charAt(s.length()-2) != 'v') {
            System.out.println("No");
            return;
        }

        int i = 0;
        while (i < s.length()-2) {
            if (s.charAt(i) == 'i' && s.charAt(i+1) == 'n') {
                stack.push("in");
                i += 2;
            }
            else if (s.charAt(i) == 'z' && s.charAt(i+1) == 'v' && s.charAt(i+2) == 'a') {
                if (stack.peek() == "in") {
                    stack.pop();
                }
                else {
                    System.out.println("No");
                    return;
                }
                i += 3;
            }
            else {
                System.out.println("No");
                return;
            }
        }
        if (stack.empty()) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
