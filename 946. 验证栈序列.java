class Solution {
	/*
	经典题，由于所有的元素一定是按照pushed的顺序进入的，所有关键是什么时间出栈
	解法：
	将 pushed 队列中的每个数都 push 到栈中，同时检查这个数是不是 popped 序列中下一个要 pop 的值，如果是就把它 pop 出来。
	最后检查栈是否为空
	*/
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0,j=0;j<popped.length;){
            if(stack.isEmpty()){
                stack.addLast(pushed[i]);
                i++;
            }
            if(stack.peekLast()==popped[j]){
                stack.pollLast();
                j++;
            }else{
                if(i>=pushed.length){
                    break;
                }
                stack.addLast(pushed[i]);
                i++;
            }
        }
        return stack.isEmpty();
    }
}