import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);

	static String path = "C:/Users/aalexiev/Google Drive/Programming/Eclipse Projects/OrphanBlack/Data/Data.txt";

	public static void main(String[] args) throws Exception {

		List<String> readAllLines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		List<String> binaryLines = new ArrayList<String>();
		List<String> binaryLinesInverse = new ArrayList<String>();

		for (int i = 0; i < readAllLines.size(); i++) {

			if (i % 2 == 1) {
				continue;
			}

			String s = readAllLines.get(i);
			String b = ""; 
			String bi = ""; 

			for (int j = 0; j < s.length(); j++) {
				char chr = s.charAt(j);
				if (chr == 'A' || chr == 'T') {
					b += "0";
					bi += "1";
				} else {
					b += "1";
					bi += "0";
				}
			}

			boolean ok = true;

			for (int m = 0; m < 2; m++) {
				ok = true;
				String ss = "";
				if (m == 0) {
					ss = b;
				}
				else {
					ss = bi;
				}
				String d = "";
				for (int k = 0; k < 8; k++) {
					d = "";
					for (int l = k; l < s.length() - 8; l += 8) {
						String b8 = ss.substring(l, l + 8);
						int i8 = Integer.parseInt(b8, 2);
						if (i8 == 32 || (i8 <= 90 && i8 >= 65)) {
							char chrr = (char) i8;
							d += chrr;
							ok = true;
						}
						else {
							ok = false;
							break;
						}
					} 
					if (ok) {
						System.out.println(d);
					}
				}
			}
		}
	}
}


