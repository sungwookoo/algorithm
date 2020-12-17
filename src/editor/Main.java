package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    // https://www.acmicpc.net/problem/1406
    // 에디터 ( 2020/12/17 - ListIterator 사용하여 시간초과 문제 해결 )
    // input line 1 : 에디터 초기에 편집기에 입력되어 있는 문자열이 주어진다. (length : ~600,000)
    // input line 2 : 둘째 줄에는 입력할 명령어의 개수를 나타내는 정수 M이 주어진다. (range : 1~500,000)
    // input line 3~: M개의 줄에 걸쳐 입력할 명령어가 주어진다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        if(M>=1 && M<=500000){
            edit(str,M,br);
        }
    }
    private static void edit(String str, int M, BufferedReader br) throws IOException {
        char[] strArray = str.toCharArray();
        LinkedList<Character> linkedList = new LinkedList<>();
        ListIterator<Character> strList = linkedList.listIterator();

        for(char c : strArray){
            strList.add(c);
        }


        for(int i=0; i<M; i++){
            String cmd = br.readLine();
            String[] cmdArray = cmd.split(" "); // cmdArray[0] : command type, cmdArray[1] : string to add
            if(cmdArray[0].equals("L")){
                if(strList.hasPrevious()) strList.previous();
            }
            else if(cmdArray[0].equals("D")){
                if(strList.hasNext()) strList.next();
            }
            else if(cmdArray[0].equals("B")){
                if(strList.hasPrevious()) {
                    strList.previous();
                    strList.remove();
                }
            }
            else if(cmdArray[0].equals("P")){
                char[] cArray = cmdArray[1].toCharArray();
                strList.add(cArray[0]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(strList.hasPrevious()){
            strList.previous();
        }
        while(strList.hasNext()){
            sb.append(strList.next());
        }
        System.out.println(sb.toString());
    }
}
