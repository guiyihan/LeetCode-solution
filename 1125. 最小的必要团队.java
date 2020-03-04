class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillcode = new HashMap();
        for (int i = 0; i < req_skills.length; i++) {
            skillcode.put(req_skills[i], 1 << i);
        }
        int[] peopleskill = new int[people.size()];
        int index = 0;
        for (List<String> skills : people) {
            int temp = 0;
            for (String skill : skills) {
                temp += skillcode.get(skill);
            }
            peopleskill[index] = temp;
            index++;
        }
        int[] dp = new int[1 << req_skills.length];
        List<Integer>[] namelist = new List[1 << req_skills.length];
        for (int i = 0; i < namelist.length; i++) {
            namelist[i] = new ArrayList<Integer>();
        }
        Arrays.fill(dp, peopleskill.length);
        dp[0] = 0;

        //遍历所有人
        for(int p=0;p<peopleskill.length;p++){
            //遍历所有dp项
            for(int i=0;i<dp.length;i++){
                int next=peopleskill[p]|i;
                if((next>i) && (dp[i]+1<dp[next])){
                    dp[next]=dp[i]+1;
                    namelist[next]=new ArrayList(namelist[i]);
                    namelist[next].add(p);
                }
            }
        }
        int[] res = new int[namelist[namelist.length - 1].size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = namelist[namelist.length - 1].get(i);
        }
        return res;
    }
}