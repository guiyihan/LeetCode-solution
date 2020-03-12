import java.io.*;
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            int key=s.nextInt();

            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
            if((key&x)!=key){
                key=key&x;
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }else{
                    map.put(key,1);
                }
            }

        }
        int res=0;
        for (int v: map.values()) {
            res=Math.max(res,v);
        }
        System.out.println(res);
    }
}