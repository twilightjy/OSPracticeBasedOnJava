package demo2;

//����
public class ThreadTest {

  public static void main(String []args){
      ChopSticks chop = new ChopSticks();//chopֻnewһ�������Ա�֤synchronized��Ч
      //5����ѧ�Ҷ�Ӧ5���߳�
      new Philosopher("0",chop).start();
      new Philosopher("1",chop).start();
      new Philosopher("2",chop).start();
      new Philosopher("3",chop).start();
      new Philosopher("4",chop).start();
  }
}
