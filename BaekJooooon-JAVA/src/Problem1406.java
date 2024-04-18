import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Problem1406 {
    public Problem1406() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        LinkedList<Character> lore = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            lore.add(str.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());

        ListIterator<Character> iter = lore.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }

        for(int i=0; i < n; i ++){
            String[] commands = br.readLine().split(" ");
            switch (commands[0]) {
                case "L":
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case "D":
                    if (iter.hasNext()) iter.next();
                    break;
                case "B":
                    if (iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P":
                    char world = commands[1].toCharArray()[0];
                    iter.add(world);
                    break;
            }
        }
        for(char c : lore){
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }

}
