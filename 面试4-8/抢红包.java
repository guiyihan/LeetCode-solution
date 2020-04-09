class Main3{
    public static void main(String[] args) {
        hongbao(100,10);//100元，分给10人
    }
    public static void hongbao(double money, int num){

        double minMoney=0.01;//保底0.01元
        money-=minMoney*num;
        Random rand=new Random();
        double avg;
        double res;
        for(int i=0;i<num-1;i++){
            avg=money/(num-i);
            res=rand.nextDouble()*(avg*2)+minMoney;//0~剩余均值的两倍
            System.out.println(res);
            money-=res;
        }
        System.out.println(money+minMoney);//最后一个人直接返回剩余金额
    }
}