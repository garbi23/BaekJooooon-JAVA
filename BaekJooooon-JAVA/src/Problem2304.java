import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Problem2304 {
    static ArrayList<Main.Pos> pos = new ArrayList<>();
    public Problem2304() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int maxY = 0;
        int index = 0;
        int result = 0;
        for(int i = 0; i < n; i++){
            String[] datas = br.readLine().split(" ");
            int x =  Integer.parseInt(datas[0]);
            int y =  Integer.parseInt(datas[1]);
            pos.add(new Main.Pos(x, y));
        }
        pos.sort(Comparator.comparing(Main.Pos::getX));
        int idx= 0;
        for(Main.Pos positon : pos){
            if(positon.y > maxY){
                maxY = positon.y;
                index = idx;
            }
            idx++;
        }
        int preMaxY = 0;
        int preMaxX = 0;
        for(int i = 0; i <= index; i++){
            if(pos.get(i).y >= preMaxY){
                result+= Math.abs(preMaxX - pos.get(i).x)*preMaxY;
                preMaxY = pos.get(i).y;
                preMaxX = pos.get(i).x;
            }
        }
        preMaxY = 0;
        preMaxX = 0;
        for(int i = n-1; i >= index; i--){
            if(pos.get(i).y >= preMaxY){
                result+= Math.abs(preMaxX - pos.get(i).x)*preMaxY;
                preMaxY = pos.get(i).y;
                preMaxX = pos.get(i).x;
            }
        }

        result+= maxY;

        System.out.print(result);
    }
    public static class Pos{
        int x = 0;
        int y = 0;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
    }

}
