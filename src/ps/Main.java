package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // https://www.acmicpc.net/problem/9012
    // 괄호 검사
    // 출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        checkVps(n, br);
    }

    public static void checkVps(int n, BufferedReader br) throws IOException {
        for(int i=0; i<n; i++) {
            Stack<Character> stack = new Stack<>();

            String a = br.readLine();
            char[] charArray = a.toCharArray();

            for(char c : charArray){
                if(c=='('){
                    stack.push(c);
                }
                else if(c==')' && stack.size()!=0){
                    if(stack.peek()=='('){
                        stack.pop();
                    }
                    else{
                        stack.push(c);
                    }
                }
                else {
                    stack.push(c);
                }
            }
            if(stack.size()==0)System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
