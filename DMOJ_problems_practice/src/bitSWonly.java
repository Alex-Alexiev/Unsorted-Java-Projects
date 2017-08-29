import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bitSWonly {
	private static bitSWonly o = new bitSWonly();
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
	
	private static Reader in = o.new Reader(System.in);
	
	public static void main(String[] args) throws IOException {
		int numCases = in.nextInt();
		long in1[] = new long[numCases];
		long in2[] = new long[numCases];
		long result[] = new long[numCases];
		String output;
		for (int i = 0; i < numCases; i++){
			in1[i] = in.nextLong();
			in2[i] = in.nextLong();
			result[i] = in.nextLong();
		}
		for (int i = 0; i < numCases; i++){
			output = (in1[i]*in2[i] == result[i]) ? "POSSIBLE DOUBLE SIGMA" : "16 BIT S/W ONLY";
			System.out.println(output);
		}
	}
}