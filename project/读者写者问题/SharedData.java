package demo1;

import java.util.concurrent.Semaphore;//ShareData.java

public class SharedData {
    public Semaphore rw = new Semaphore(1);			// ��д���������Ǹ���������
    
    public Semaphore mutex = new Semaphore(1);		// ���߼������λ�����
    
    public Semaphore queue = new Semaphore(1);		// ������
    
    public int readerCnt = 0;						// ���߼�����
}

