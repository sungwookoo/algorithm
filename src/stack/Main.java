package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/10828
public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n >= 1 && n <= 10000) {
            for (int i = 0; i < n; i++) {
                String[] strArray = br.readLine().split(" ");
                if (strArray[0].equals("push") && strArray.length == 2) {
                    stack.push(Integer.parseInt(strArray[1]));
                } else if (strArray[0].equals("pop") && strArray.length == 1) {
                    if (stack.size() == 0) System.out.println("-1");
                    else System.out.println(stack.pop());
                } else if (strArray[0].equals("top") && strArray.length == 1) {
                    if (stack.size() == 0) System.out.println(-1);
                    else System.out.println(stack.peek());
                } else if (strArray[0].equals("size") && strArray.length == 1) {
                    System.out.println(stack.size());
                } else if (strArray[0].equals("empty") && strArray.length == 1) {
                    if (stack.isEmpty()) System.out.println('1');
                    else System.out.println('0');
                }
            }
        }
    }
}
