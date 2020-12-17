package reverse_word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/9093
// 문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.
public class Main {
    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        reverseWord(T, br);
    }

    public static void reverseWord(int T, BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            String[] strArray = br.readLine().split(" ");
            for(String s : strArray){
                sb.append((new StringBuffer(s)).reverse().toString()+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}