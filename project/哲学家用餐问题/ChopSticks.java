package demo2;

public class ChopSticks{
    /*5只筷子，初始为都未被用 true为正在被使用，false为未被是一个*/
    private boolean[] used={false,false,false,false,false};

    /*只有当左右手的筷子都未被使用时，才允许获取筷子，且必须同时获取左右手筷子*/
    public synchronized void takeFork(){
        String name = Thread.currentThread().getName();//获取当前线程的名字
        int i = Integer.parseInt(name);
        while(used[i]||used[(i+1)%5]){
            try {
                wait();//如果左右手有一只正被使用，等待
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //左右筷子均为false状态时被notify，可以使用筷子
        used[i ]= true;//左手筷子
        used[(i+1)%5]=true;//右手筷子
    }

    /*必须同时释放左右手的筷子*/
    public synchronized void putFork(){
        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name);
        //放下筷子	
        used[i ]= false;
        used[(i+1)%5]=false;
        notifyAll();//唤醒其他wait()中的线程
    }
}
