package demo1;

import java.util.concurrent.Semaphore;//ShareData.java

public class SharedData {
    public Semaphore rw = new Semaphore(1);			// 读写锁（本质是个互斥锁）
    
    public Semaphore mutex = new Semaphore(1);		// 读者计数器の互斥锁
    
    public Semaphore queue = new Semaphore(1);		// 队列锁
    
    public int readerCnt = 0;						// 读者计数器
}

