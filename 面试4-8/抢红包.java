class Main3{
    public static void main(String[] args) {
        hongbao(100,10);
    }
    public static void hongbao(double money, int num){

        double minMoney=0.01;
        money-=minMoney*num;
        Random rand=new Random();
        double avg;
        double res;
        for(int i=0;i<num-1;i++){
            avg=money/(num-i);
            res=rand.nextDouble()*(avg*2)+minMoney;
            System.out.println(res);
            money-=res;
        }
        System.out.println(money+minMoney);
    }
}