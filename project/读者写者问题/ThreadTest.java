package demo1;

public class ThreadTest {

    public static void main(String[] args) {
    	// ��������
        SharedData sharedData = new SharedData();
        
		// 4д��
        for(int i = 0 ; i<5 ; i++){
        	new Thread(new Writer(sharedData)).start();
        }
		// 4����
        for(int i = 0 ; i<5 ; i++){
            new Thread(new Reader(sharedData)).start();
        }
        		
    }
    
}
