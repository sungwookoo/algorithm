package stack_sq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // https://www.acmicpc.net/problem/1874
    // 스택 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n >= 1 && n <= 100000) {
            stackSequence(n, br);
        }
    }

    private static void stackSequence(int n, BufferedReader br) throws IOException {
        int[] intArray = new int[n];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int sequence = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            intArray[i] = num;
            if (stack.size() == 0) {
                if(sequence>num){
//                    System.out.println("NO");
                    sb.delete(0,sb.length());
                    sb.append("NO\n");
                    System.out.println(sb.toString());
                    return;
                }
                else {
                    for (int j = sequence; j <= num; j++) {
                        stack.push(sequence++);
//                        System.out.println("+");
                        sb.append("+\n");
                    }
                    stack.pop();
//                    System.out.println("-");
                    sb.append("-\n");
                }
            } else {
                if (num <= stack.peek()) {
                    while (num <= stack.peek() && !stack.isEmpty()) {
                        stack.pop();
//                        System.out.println("-");
                        sb.append("-\n");
                        if(stack.size()==0) break;
                    }
                } else {
                    for (int j = sequence; j <= num; j++) {
                        stack.push(sequence++);
//                        System.out.println("+");
                        sb.append("+\n");
                    }
                    stack.pop();
//                    System.out.println("-");
                    sb.append("-\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}