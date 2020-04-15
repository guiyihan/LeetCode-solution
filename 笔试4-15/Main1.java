package Interview4_15;

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1=in.next()+"[";
        String s2=in.next();
        String[] arr=s2.split("],");
        int count=0;
        for(String line:arr){
            if(line.contains(s1)){
                printOut(line);
                System.out.println();
                count++;
            }
        }
        if(count==0){
            System.out.println("FAIL");
        }
    }
    public static void printOut(String s){
        int i=0;
        char[] chars=s.toCharArray();
        while(chars[i]!='='){
            i++;
        }
        i++;
        while(chars[i]!=','){
            System.out.print(chars[i]);
            i++;
        }
        System.out.print(' ');
        while(chars[i]!='='){
            i++;
        }
        i++;
        while(chars[i]!=','){
            System.out.print(chars[i]);
            i++;
        }
        System.out.print(' ');
        while(chars[i]!='='){
            i++;
        }
        i++;
        while(i<chars.length&&chars[i]!=']'){
            System.out.print(chars[i]);
            i++;
        }
    }
}
