import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
    }
    public Node merge(List<Node> headList){
        
        int k=headLits.size();
        if(k==1){
            return headList.get(0);
        }else if(k==2){
            return merge(headList.get(0),headList.get(1));
        }
        Node left= merge(headList.subList(0,k/2));
        Node right= merge(headList.subList(k/2,k));
        return merge(left, right);
    }
    public Node merge1(List<Node> headList){
        if(headList.size()==0){
            return null;
        }
        Node res=headList.get(0);
        for(int i=1;i<headList.size();i++){
            res=merge(res,headList.get(i));
        }
        return res;
    }
    public Node merge (Node head1,Node head2){
        Node result=new Node(-1);
        Node p=result;
        while(head1!=null || head2!=null){
            if(head1!= null&& head2!=null){
                if(head1.val<head2.val){
                    p.next=head1;
                    p=p.next;
                }else{
                    p.next=head2;
                    p=p.next;
                }
            }
            while(head1==null && head2!=null){
                p.next=head2;
                p.next;
            }
            while(head1!=null && head2==null){
                p.next=head1;
                p.next;
            }
            
        }
        return result.next;
    }
}