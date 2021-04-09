package demo1;

import java.util.Random;

public class Reader implements Runnable {

    SharedData sharedData;

    public Reader(SharedData sharedData){
        this.sharedData = sharedData;
    }

    private void read(){
        System.out.println(Thread.currentThread().getName() + " 读数据...");
        try {
        	Thread.sleep(new Random().nextInt(10));
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        System.out.println(Thread.currentThread().getName() + " 读完了...");
    }

    @Override
    public void run() {
        while (true){
            try {
                // 第一个(cnt==0)读者进行P操作
                sharedData.queue.acquire();
                sharedData.mutex.acquire();
                if(sharedData.readerCnt == 0){
                    sharedData.rw.acquire();
                }
                sharedData.readerCnt++;
                sharedData.mutex.release();
                sharedData.queue.release();
                
                // 开始读 >_<
                read();
                
                // 最后一个(cnt==0)读者进行V操作
                sharedData.mutex.acquire();
                sharedData.readerCnt--;
                if(sharedData.readerCnt == 0){
                    sharedData.rw.release();
                }
                sharedData.mutex.release();
                
                // 睡一觉zzz
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
