import java.lang.reflect.Field;
import java.util.Scanner;

public class StopTest implements Runnable{
	@SuppressWarnings("rawtypes")
	private Class claszOperation = null;
	@SuppressWarnings("rawtypes")
	private Class claszPrint = null;
	private boolean running = true;
	public StopTest(Class claszOperation, Class claszPrint) {
		this.claszOperation = claszOperation;
		this.claszPrint = claszPrint;
	}
	
	public void run() {

		while(running) {
			@SuppressWarnings("resource")
			String str = new Scanner(System.in).next();

			if("q".equalsIgnoreCase(str)) {
				//System.out.println("StopTest...q Entered");
				//System.out.println("setBoolean(claszOperation, running,false) ");
				int i=0;
				while(setBoolean(claszOperation, "running", false)){
					//System.out.println("Reset  setBoolean(claszOperation, running,false) ");
					i++;
					if (i>3){  //最大重试3次 
						break;
					}
				};
				//System.out.println("setBoolean(claszPrint, running,false) ");
				
				i=0;
				while(setBoolean(claszPrint, "running", false)){
					//System.out.println("Reset  setBoolean(claszPrint, running,false) ");					
					i++;
					if (i>3){  //最大重试3次 
						break;
					}
				};
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				

				//ThreadMutex.stopSecondLevel();
				//ThreadMutex.setFirstLevel();
				running = false;
				//return;
			}
			
		}
		//System.out.println(" ThreadMutex.getSecondLevel()="+ThreadMutex.getSecondLevel());
		//ThreadMutex.stopSecondLevel();
		//System.out.println("StopTest ...stop. ThreadMutex.getSecondLevel()="+ThreadMutex.getSecondLevel());
	}
	public static void main(String[] args) {
		/*boolean flag = setBoolean(TestSM1Perf.SM1Encyption.class, "running", true);*/
		//System.out.println(flag);
	}
	@SuppressWarnings("rawtypes")
	public static boolean setBoolean(Class clasz, String fieldName, boolean flag) {
		// 获得对象的类型
		try {
			/*Field[] arr = clasz.getFields();
			for(int i=0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}
			
			arr = clasz.getDeclaredFields();
			for(int i=0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}
			 */			
			
			Field f = clasz.getDeclaredField("running"); 
			f.setBoolean(clasz, false);

			return f.getBoolean(clasz);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
