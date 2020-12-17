package count_file_ext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

// https://www.acmicpc.net/problem/20291
// 파일 정리
// 확장자의 이름과 그 확장자 파일의 개수를 한 줄에 하나씩 출력한다. 확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력한다.
public class Main {
    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n>=1 && n<=50000) A(n, br);
    }
    private static void A(int n, BufferedReader br) throws IOException {
        HashMap<String, Integer> hm = new HashMap<>();
            for(int i=0; i<n; i++) {
                String text = br.readLine();
                if(text.contains(".")) {
                    String[] split = text.split("[.]");
                    Integer freq = hm.get(split[1]);
                    if (freq == null) hm.put(split[1], 1);
                    else hm.put(split[1], freq + 1);
                }
            }
            Object[] mapKey = hm.keySet().toArray();
            Arrays.sort(mapKey);
            for(Object key : mapKey) {
                System.out.println(key+" "+hm.get(key));
            }
    }
}