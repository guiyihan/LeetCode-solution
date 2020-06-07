class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return new ArrayList<>();
        }
        Map<String, List<String>> graph=new HashMap<>();
        for(String s:wordList){
            List<String> list=wordList.stream().filter((s2)->isConnect(s,s2)).collect(Collectors.toList());
            graph.put(s,list);
        }
        graph.put(beginWord,wordList.stream().filter((s2)->isConnect(beginWord,s2)).collect(Collectors.toList()));
        Deque<List<String>> deque=new ArrayDeque<>();
        List<List<String>> res=new ArrayList<>();
        Map<String,Integer> dist=new HashMap<>(wordList.size());
        wordList.forEach((s)->dist.put(s,Integer.MAX_VALUE));
        List<String> list=new ArrayList<>();
        list.add(beginWord);
        deque.addLast(list);
        dist.put(beginWord,1);

        while(!deque.isEmpty()){
            List<String> temp=deque.pollFirst();
            if(temp.size()>dist.get(endWord)){
                break;
            }
            String now=temp.get(temp.size()-1);
            if(isConnect(now,endWord) && temp.size()+1<=dist.get(endWord)){
                temp.add(endWord);
                res.add(temp);
                dist.put(endWord,temp.size());
                continue;
            }
            for(String next:graph.get(now)){
                if(dist.get(next)>temp.size()){
                    List<String> newList=new ArrayList<>(temp);
                    newList.add(next);
                    deque.addLast(newList);
                    dist.put(next,newList.size());
                }
            }
        }
        return res;
    }
    private boolean isConnect(String s1, String s2){
        int diff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
        }
        return diff==1;
    }
}