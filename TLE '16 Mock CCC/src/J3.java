import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class J3 { // TODO change to class name
	private static J3 o = new J3(); // TODO change Template to class name
	public class Reader {
		private BufferedReader in;
		private StringTokenizer st;
		
		public Reader(InputStream inputStream) {
			in = new BufferedReader(new InputStreamReader(inputStream));
		} // Reader InputStream constructor
		
		public Reader(String fileName) throws FileNotFoundException {
			in = new BufferedReader(new FileReader(fileName));
		} // Reader String constructor

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(in.readLine().trim());
			} // while
			return st.nextToken();
		} // next method
		
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		} // nextLong method
		
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		} // nextInt method
		
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		} // nextDouble method
		
		public String nextLine() throws IOException {
			return in.readLine().trim();
		} // nextLine method
	} // Reader class
	
	private static Reader scanner = o.new Reader(System.in);
	private static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		long x1 = scanner.nextLong(); //papa x
		long y1 = scanner.nextLong(); //papa y
		int k = scanner.nextInt(); 
		long x2 = scanner.nextLong(); //kid x
		long y2 = scanner.nextLong(); //kid y
		int l = scanner.nextInt();
		out.println(calcSteps(x1, x2, k, l)+calcSteps(y1, y2, k, l));
		out.close();

	}
	
	public static long calcSteps(long c1, long c2, long k, long l){
		long factor = 0;
		long steps = 0;
		while (c1 != c2){
			factor = (c2-c1)/(k-l);
			steps += factor;
			c1 += k*factor;
			c2 += l*factor;
			k--;
		}
		return Math.abs(steps);
	}
	
}
