package topologicalsorting;
import java.util.Scanner;
public class TopologicalSorting {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Scanner s=new Scanner (System.in);
        int n,m,r,Ui,Vi;
        Graph island=new Graph();
        //Taking input of first line
        System.out.println("Please enter the number of islands, number of one-way bridges and index of the island you are initially on respectively");
        n=s.nextInt();
        m=s.nextInt();
        r=s.nextInt();
        island.setData(n,m,r);
        //Initializing the graph
        island.adjMatrix(island.getN());
        //Taking input of next m lines and filling the graph
        System.out.println("Please enter coordinates of one-way bridges");
        int c=0;
        while (c<island.getM())
        {
            Ui=s.nextInt();
            Vi=s.nextInt();
            island.setBridge(Ui,Vi,1);
            c++;
        }
        island.Sorting();
        Runtime runtime=Runtime.getRuntime();
        runtime.gc();
        long memory=runtime.totalMemory()-runtime.freeMemory();
        System.out.println("Memory usage in bytes: "+ memory + " Bytes");
        long stop= System.currentTimeMillis();
        long elapsedTime=stop-start;
        System.out.println("Execution time in milliseconds is: " +elapsedTime+ " MS");
    }
}
