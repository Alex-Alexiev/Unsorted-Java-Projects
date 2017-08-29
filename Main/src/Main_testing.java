import java.util.Scanner;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main_testing {

	static Scanner sacnner = new Scanner(System.in);
	static int left = 10;
	static int right = 10;
	
	public static void main(String[] args) {
		printUsage();
	}
 
	private static void printUsage() {
	  OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
	  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
	    method.setAccessible(true);
	    if (method.getName().startsWith("get") 
	        && Modifier.isPublic(method.getModifiers())) {
	            Object value;
	        try {	
	            value = method.invoke(operatingSystemMXBean);
	        } catch (Exception e) {
	            value = e;
	        } 
	        System.out.println(method.getName() + " = " + value);
	    }
	  } 
	}

}
