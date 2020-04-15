package Interview4_15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        String[] arr=s.split(",");
        Map<String,Integer> count=new HashMap<>();
        for(String name: arr){
            if(!check(name)){
                System.out.println("error.0001");
                return;
            }
            int temp=count.getOrDefault(name,0);
            count.put(name,temp+1);
        }
        int max=0;
        String res="error.0001";
        for(String name:count.keySet()){
            if(count.get(name)>max){
                max=count.get(name);
                res=name;
            }else if(count.get(name)==max && name.compareTo(res)<0){
                max=count.get(name);
                res=name;
            }
        }
        System.out.println(res);
    }
    public static boolean check(String name){
        if(name.charAt(0)-'A'<0||name.charAt(0)-'A'>25){
            return false;
        }
        for (int i = 1; i <name.length() ; i++) {
            if(name.charAt(i)-'a'<0||name.charAt(i)-'a'>25){
                return false;
            }
        }
        return true;
    }
}