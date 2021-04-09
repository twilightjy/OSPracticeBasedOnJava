package demo2;


/*ÿ����ѧ���൱��һ���߳�*/
public class Philosopher extends Thread{
    private String name;
    private ChopSticks chop;
    public Philosopher(String name,ChopSticks chop){
        super(name);
        this.name=name;
        this.chop=chop;
    }

    public void run(){
    	//����ѭ��
        while(true){
            thinking();//˼��
            chop.takeFork();//�����������ҿ���
            eating();//���ɹ��������ҿ�����Է�
            chop.putFork();//�������¿���
        }

    }

   
    public void eating(){
        System.out.println("I am Eating:"+name);
        try {
            sleep(1000);//ģ��Է���ռ��һ��ʱ����Դ
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

   
    public void thinking(){
        System.out.println("I am Thinking:"+name);
        try {
            sleep(1000);//ģ��˼��
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}



