import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int tall = 0;
        for (String num : br.readLine().split(" ")) {
            tall++;
            int count = Integer.parseInt(num);
            for (int i = 0; i < n; i++) {
                if (list[i] != 0) continue;
                int low = 0;
                for (int j = 0; j < i; j++) {
                    if (list[j] != 0) continue;
                    if (list[j] < tall) {
                        low++;
                    }
                }
                if (low == count) {
                    list[i] = tall;
                    break;
                }
            }
        }


        for (int result : list) {
            bw.write(result + " ");
        }
        bw.flush();
        bw.close();
    }
}