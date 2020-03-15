package LeetCode_solution.competition2;

import java.util.ArrayList;
import java.util.List;

public class solution2 {
}
class CustomStack {
    private List<Integer> stack;
    int maxSize;
    public CustomStack(int maxSize) {
        stack=new ArrayList<>(maxSize);
        this.maxSize=maxSize;
    }

    public void push(int x) {
        if(stack.size()<maxSize){
            stack.add(x);
        }
    }

    public int pop() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.remove(stack.size()-1);
    }

    public void increment(int k, int val) {
        k=Math.min(k,stack.size());
        for (int i = 0; i < k; i++) {
            stack.set(i,stack.get(i)+val);
        }
    }
}
