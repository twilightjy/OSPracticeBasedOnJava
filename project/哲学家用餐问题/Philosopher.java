package demo2;


/*每个哲学家相当于一个线程*/
public class Philosopher extends Thread{
    private String name;
    private ChopSticks chop;
    public Philosopher(String name,ChopSticks chop){
        super(name);
        this.name=name;
        this.chop=chop;
    }

    public void run(){
    	//无限循环
        while(true){
            thinking();//思考
            chop.takeFork();//尝试拿起左右筷子
            eating();//若成功拿起左右筷子这吃饭
            chop.putFork();//吃完后放下筷子
        }

    }

   
    public void eating(){
        System.out.println("I am Eating:"+name);
        try {
            sleep(1000);//模拟吃饭，占用一段时间资源
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

   
    public void thinking(){
        System.out.println("I am Thinking:"+name);
        try {
            sleep(1000);//模拟思考
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}



