class Solution {
	/*针对以下特殊情况进行了优化
	输入：
	[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
	输出：
	["JFK","KUL"]
	预期：
	["JFK","NRT","JFK","KUL"]
	
	巧妙地解决了顺序错误的这个问题
	*/
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> graph=new HashMap();
        
        for(List<String> ticket: tickets){
            if(!graph.containsKey(ticket.get(0))){
                List<String> temp=new ArrayList<String>();
                temp.add(ticket.get(1));
                graph.put(ticket.get(0),temp);
            }else{
                List<String> temp=graph.get(ticket.get(0));
                temp.add(ticket.get(1));
            }
            
        }
        List<String> res=route(graph,new ArrayList<String>(),"JFK");
        Collections.reverse(res);
        return res;
        
    }
    public List<String> route(Map<String,List<String>> graph, List<String>res, String from){
        
        
        
        List<String> tickets=graph.get(from);
        if(tickets!=null){
            Collections.sort(tickets);
            while(tickets.size()>0){
                String nextCity=tickets.remove(0);
                route(graph,res,nextCity);
            }
        }
        
        
        res.add(from);
        return res;
        
        
        
        
    }


}