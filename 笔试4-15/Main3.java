package Interview4_15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main3 {
    static int maxValue=0;
    static boolean R=false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int[] nums=new int[N];
        int[] value=new int[N];
        for(int i=0;i<N;i++){
            nums[i]=in.nextInt();
        }
        in.nextLine();
        List<Integer>[] graph=new List[N];
        for (int i = 0; i <N ; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<N;i++){

            String s1 = in.nextLine();
            String[] arr=s1.split(" ");
            if(arr.length!=nums[i]+2){
                System.out.println("NA");
                return;
            }
            value[i]=Integer.parseInt(arr[1]);
            for (int j = 2; j <arr.length ; j++) {
                graph[i].add(Integer.parseInt(arr[j])-1);
            }
        }
        for (int i = 0; i <N ; i++) {
            dfs(i,0,graph,value,new boolean[N]);
        }
        if(R){
            System.out.println("R");
        }else {
            System.out.println(maxValue);
        }
    }
    public static void dfs(int now,int val,List<Integer>[] graph,int[] value,boolean[] bitmap){
        if(bitmap[now]){
            R=true;
            return;
        }else {
            bitmap[now]=true;
        }
        List<Integer> nowList=graph[now];
        val+=value[now];
        if(nowList.isEmpty()){
            maxValue=Math.max(maxValue,val);
        }
        for(int i: nowList){
            dfs(i,val,graph,value, Arrays.copyOf(bitmap,bitmap.length));
        }
    }
}
