class LFUCache {
    Map<Integer,Node> freqMap=new HashMap();
    Map<Integer,Node> dict=new HashMap();
    int minFreq=0;
    int capacity;
    public LFUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(capacity==0){
            return -1;
        }
        if(dict.containsKey(key)){
            Node res=dict.get(key);
            increase(res);
            return res.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(dict.containsKey(key)){
            Node node=dict.get(key);
            node.value=value;
            increase(node);
        }else{
            if(dict.size()>0 && dict.size()==this.capacity){
                removeLastFreq();
            }
            Node node=new Node(key, value);
            minFreq=1;
            dict.put(key,node);
            Node head=freqMap.get(1);
            if(head!=null){
                head.pre=node;
                node.next=head;
            }
            freqMap.put(1,node);
        }
    }
    private void increase(Node node){
        if(freqMap.get(node.freq)==node){
            freqMap.put(node.freq, node.next);
            if(node.next!=null){
                node.next.pre=null;
            }
        }
        if(node.freq==minFreq && node.next==null && node.pre==null){
            minFreq+=1;
        }
        node.freq+=1;
        node.disconnect();
        Node head=freqMap.get(node.freq);
        if(head!=null){
            head.pre=node;
            node.next=head;

        }
        freqMap.put(node.freq, node);



    }
   private void removeLastFreq(){
        Node lastFreq = freqMap.get(this.minFreq);
        while(lastFreq.next!=null){
            lastFreq=lastFreq.next;
        }
        dict.remove(lastFreq.key);
        if(freqMap.get(this.minFreq)==lastFreq){
            freqMap.put(this.minFreq, null);
        }
        
        if(lastFreq.pre!=null){
            lastFreq.pre.next=null;
            lastFreq.disconnect();
        }

    }
    class Node{
        public int value;
        public int freq;
        public Node pre;
        public Node next;
        public int key;

        public Node(int key, int value){
            this.key=key;
            this.value=value;
            freq=1;
        }
        public void disconnect(){
            if(pre!=null){
                this.pre.next=this.next;
            }
            if(next!=null){
                this.next.pre=this.pre;
            }
            this.next=null;
            this.pre=null;
        }

    }
}
