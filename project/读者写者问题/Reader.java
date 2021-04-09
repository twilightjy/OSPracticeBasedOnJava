package demo1;

import java.util.Random;

public class Reader implements Runnable {

    SharedData sharedData;

    public Reader(SharedData sharedData){
        this.sharedData = sharedData;
    }

    private void read(){
        System.out.println(Thread.currentThread().getName() + " ������...");
        try {
        	Thread.sleep(new Random().nextInt(10));
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        System.out.println(Thread.currentThread().getName() + " ������...");
    }

    @Override
    public void run() {
        while (true){
            try {
                // ��һ��(cnt==0)���߽���P����
                sharedData.queue.acquire();
                sharedData.mutex.acquire();
                if(sharedData.readerCnt == 0){
                    sharedData.rw.acquire();
                }
                sharedData.readerCnt++;
                sharedData.mutex.release();
                sharedData.queue.release();
                
                // ��ʼ�� >_<
                read();
                
                // ���һ��(cnt==0)���߽���V����
                sharedData.mutex.acquire();
                sharedData.readerCnt--;
                if(sharedData.readerCnt == 0){
                    sharedData.rw.release();
                }
                sharedData.mutex.release();
                
                // ˯һ��zzz
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
