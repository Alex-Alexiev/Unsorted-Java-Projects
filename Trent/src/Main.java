
import java.util.Scanner;

public class Main {
     static Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
           int voteCount = scanner.nextInt();
           int voteA = 0;
           int voteB = 0;
           String votes = scanner.next();
           for (int i = 0; i < voteCount; i++){
                if (votes.charAt(i) == 'A') {
                      voteA++;
                }
                else if (votes.charAt(i) == 'B') {
                      voteB++;
                }
           }
           if (voteA > voteB) {
               System.out.println("A:"+voteA);
           } else if (voteB > voteA) {
               System.out.println("B:"+voteB);

           } else if (voteB == voteA) {
               System.out.println("Tie");
         }
     }
}


