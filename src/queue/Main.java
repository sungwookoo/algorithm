package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/10845
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        run(n,br);
    }

    private static void run(int n, BufferedReader br) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        int last_tmp = 0;
        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            if (strArray[0].equals("push") && strArray.length == 2) {
                last_tmp = Integer.parseInt(strArray[1]);
                queue.add(last_tmp);

            } else if (strArray[0].equals("pop") && strArray.length == 1) {
                if (queue.size() == 0) System.out.println("-1");
                else System.out.println(queue.remove());
            } else if (strArray[0].equals("size") && strArray.length == 1) {
                System.out.println(queue.size());
            } else if (strArray[0].equals("empty") && strArray.length == 1) {
                if (queue.isEmpty()) System.out.println('1');
                else System.out.println('0');
            } else if (strArray[0].equals("front") && strArray.length == 1) {
                if (queue.size() == 0) System.out.println(-1);
                else System.out.println(queue.peek());
            } else if (strArray[0].equals("back") && strArray.length == 1) {
                if (queue.size() == 0) System.out.println(-1);
                else {
                    System.out.println(last_tmp);
                }
            }
        }

    }
}