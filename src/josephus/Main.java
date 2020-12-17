package josephus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        josephus(n, k);
    }

    private static void josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=n; i++){
            queue.add(i);
        }
        sb.append("<");
        int num = 0;
        while (!queue.isEmpty()){
            for(int i=0; i<k-1; i++){
                num = queue.peek();
                queue.remove();
                queue.add(num);
            }
            num = queue.peek();

            if(queue.size()>0) {
                sb.append(num+", ");
                queue.remove();
            }
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(">");

        System.out.println(sb.toString());
    }
}
