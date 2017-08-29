import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WhaleAndSoul { // TODO change to class name
	private static WhaleAndSoul o = new WhaleAndSoul(); // TODO change Template to class name
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
	private static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = in.nextInt();
		int[][] M = new int[N][2];
		int longest = 0;
		int cheapest = 100000000;
		for (int i = 0; i < N; i++){
			M[i][0] = in.nextInt();
			M[i][1] = in.nextInt();
			if (M[i][1] >= longest){
				longest = M[i][1];
			}
		}
		for (int i = 0; i < N; i++){
			if (M[i][1] == longest){
				if (M[i][0] <= cheapest){
					cheapest = M[i][0];
				}
			}
		}
		out.println(cheapest+" "+longest);
		out.close();
	}
}
