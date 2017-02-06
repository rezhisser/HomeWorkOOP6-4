
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		int n = Runtime.getRuntime().availableProcessors();
		Thread [] thrArray = new Thread[n];
		
		for (int i = 0; i < thrArray.length; i++) {
			thrArray[i]= new Thread(new FileManagement("e:/4", "e:/5", n));
		}
		for (Thread thread : thrArray) {
			thread.start();
		}
		
		
		

	}
	
	

}
