package demo1;

import java.util.Random;

 
public class Writer implements Runnable {

    SharedData sharedData;

    public Writer(SharedData sharedData){
        this.sharedData = sharedData;
    }

    private void write(){
        System.out.println(Thread.currentThread().getName() + " 写数据...");
        try {
			Thread.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(Thread.currentThread().getName() + " 写完了...");
    }

    @Override
    public void run() {
        while (true){
            try {
            	// 核心逻辑
                sharedData.queue.acquire();
                sharedData.rw.acquire();
                write();
                sharedData.rw.release();
                sharedData.queue.release();
                // 睡一觉zzz
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
