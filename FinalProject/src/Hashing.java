import java.util.Scanner;

public class Hashing {

    public static class HashTable {

        int maxsize = 96;
        char[] characters = new char[maxsize];
        int[] occurrence = new int[maxsize];

        public void add(Character key) {

            int temp = key.hashCode();
            int i = temp - 32;
            if (characters[i] == '\u0000') {
                characters[i] = key;
                occurrence[i]++;
            } else if (characters[i] != '\u0000') {
                occurrence[i]++;
            }
        }

        public Character MinASCII(Character x, Character y) {

            if (x.hashCode() < y.hashCode())
                return x;
            return y;
        }

        public void MaxOccurrence() {

            int max = Integer.MIN_VALUE;
            int indMax = -1;
            for (int i = 0; i < maxsize; i++) {
                if (occurrence[i] > max) {
                    max = occurrence[i];
                    indMax = i;
                } else if (occurrence[i] == max && characters[i] != '\u0000' && characters[indMax] != '\u0000') {
                    char temp = MinASCII(characters[i], characters[indMax]);
                    if (temp == characters[i]) {
                        max = occurrence[i];
                        indMax = i;
                    }
                }
            }
            if(characters[indMax]==' ')
                System.out.println("Space " + occurrence[indMax]);
            else System.out.println(characters[indMax] + " " + occurrence[indMax]);
        }

        public static class StopWatch{

            long startTime;
            long endTime;
            void Start(){
                startTime=System.currentTimeMillis();
            }
            void Stop(){
                endTime=System.currentTimeMillis();
            }
            long getElapsedTime(){
                return endTime-startTime;
            }
        }
        public static void main(String[] args) {

            StopWatch sw=new StopWatch();
            Scanner s = new Scanner(System.in);
            HashTable myHT = new HashTable();
            System.out.println("Enter a string which may contain: ");
            System.out.println("Lower case alphabets (a-z)");
            System.out.println("Upper case alphabets (A-Z)");
            System.out.println("Numbers (0-9)");
            System.out.println("Special characters like !, - ,… etc.");
            String exp =s.nextLine();
            sw.Start();
            for (int i = 0; i < exp.length(); i++) {
                myHT.add(exp.charAt(i));
            }
            System.out.println("Printing character with maximum occurrence");
            myHT.MaxOccurrence();
            sw.Stop();
            System.out.println("Elapsed time in milliseconds: "+sw.getElapsedTime());
        }
    }
}

