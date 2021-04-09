package demo1;

public class ThreadTest {

    public static void main(String[] args) {
    	// 共享数据
        SharedData sharedData = new SharedData();
        
		// 4写者
        for(int i = 0 ; i<5 ; i++){
        	new Thread(new Writer(sharedData)).start();
        }
		// 4读者
        for(int i = 0 ; i<5 ; i++){
            new Thread(new Reader(sharedData)).start();
        }
        		
    }
    
}
