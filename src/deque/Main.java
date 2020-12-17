package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        run(n,br);
    }

    private static void run(int n, BufferedReader br) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            if (strArray[0].equals("push_front") && strArray.length == 2) {
                deque.addLast(Integer.parseInt(strArray[1]));
            }
            else if (strArray[0].equals("push_back") && strArray.length == 2) {
                deque.addFirst(Integer.parseInt(strArray[1]));
            }
            else if (strArray[0].equals("pop_front") && strArray.length == 1) {
                if (deque.size() == 0) System.out.println("-1");
                else System.out.println(deque.removeLast());
            }
            else if (strArray[0].equals("pop_back") && strArray.length == 1) {
                if (deque.size() == 0) System.out.println("-1");
                else System.out.println(deque.removeFirst());
            }
            else if (strArray[0].equals("size") && strArray.length == 1) {
                System.out.println(deque.size());
            }
            else if (strArray[0].equals("empty") && strArray.length == 1) {
                if (deque.isEmpty()) System.out.println('1');
                else System.out.println('0');
            }
            else if (strArray[0].equals("front") && strArray.length == 1) {
                if (deque.size() == 0) System.out.println(-1);
                else System.out.println(deque.peekLast());
            }
            else if (strArray[0].equals("back") && strArray.length == 1) {
                if (deque.size() == 0) System.out.println(-1);
                else System.out.println(deque.peekFirst());
            }
        }
    }
}
