package demo2;

//测试
public class ThreadTest {

  public static void main(String []args){
      ChopSticks chop = new ChopSticks();//chop只new一个对象，以保证synchronized起效
      //5个哲学家对应5个线程
      new Philosopher("0",chop).start();
      new Philosopher("1",chop).start();
      new Philosopher("2",chop).start();
      new Philosopher("3",chop).start();
      new Philosopher("4",chop).start();
  }
}
