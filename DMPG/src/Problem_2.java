import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_2 { // TODO change to class name
		
		private static Problem_2 o = new Problem_2(); // TODO change Template to class name
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
		
		
		private static City cities[];
		
		public static void main(String[] args) throws IOException {
			
			long N = in.nextLong();
			long Q = in.nextLong();
			int a;
			int b;
			
			cities = new City[(int) N]; 	
			
			for (int i = 0; i < N; i++) {
				cities[i] = o.new City();
			}
			
			for (int i = 0; i < Q; i++) {
				
				String type = in.next();
				a = in.nextInt() - 1;
				b = in.nextInt() - 1;
				
				if (type.equals("A")){
					//out.println("a: " + a + " B: " + b);
					cities[a].C.add(b);
					cities[b].C.add(a);
					
					/*for (int k = 0 ; k < cities[b].C.size(); k++){
						cities[a].C.add(cities[b].C.get(k));
					}
					for (int k = 0 ; k < cities[a].C.size(); k++){
						cities[b].C.add(cities[a].C.get(k));
					}*/
					
				} else if (type.equals("Q")){
					//out.println("got to q");
					
					ArrayList<Integer> restrictions = new ArrayList<Integer>();
					restrictions.add(a);
					
					
					
					if (checkConnections(a, b, restrictions)) {
					//if (checkConnections(a, b)){
						out.println("Y");
					} else {
						out.println("N");
					}
				}
			}
			out.close();
		}
			
			/*public static boolean checkConnections(int c1, int c2){

				for (int i = 0; i < cities[c1].C.size(); i++) {
					
					if (cities[c1].C.get((int) i) == c2) { //if connected
						return true;
					}  
				}
				return false;
			}*/
			
		
		public static boolean checkConnections(int c1, int c2, ArrayList<Integer> restrictions){
			for (int i = 0; i < cities[c1].C.size(); i++) {
				
				if (cities[c1].C.get(i) == c2) { //if connectedm,wejkf5ei,tyfgrtewiqwopghyeoo
					return true;
				}  else {
					for (int j = 0; j < restrictions.size(); j++) {
						if (cities[c1].C.get(i) != restrictions.get(j)) {
							restrictions.add(c1);
							return (checkConnections(cities[c1].C.get(i), c2, restrictions));
						}
					}
				}
			}
			return false;
		}
		

			public class City {
				ArrayList<Integer> C;
				//long index;
				
				public City() {
					this.C = new ArrayList<Integer>();
					//this.C = C;
					//this.index = index;
				}
				
			}
}
			
			

	

