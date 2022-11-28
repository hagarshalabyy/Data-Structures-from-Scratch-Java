package topologicalsorting;
import static topologicalsorting.LinkedList.deleteNode;
import static topologicalsorting.LinkedList.getLast;
import static topologicalsorting.LinkedList.nodeInsertion;
import static topologicalsorting.LinkedList.nodeSwapping;
import static topologicalsorting.LinkedList.valueExists;

public class Graph {
    private int n,m,r;
    private int G[][];
    public int getN() {
        return n;
    }
    public int getM() {
        return m;
    }
    public int getR() {
        return r;
    }
    public void setData(int n, int m, int r) {
        this.n=n;
        this.m=m;
        this.r=r;
    }
    public void adjMatrix(int vertices) {
        n= vertices;
        G= new int[n][n];
    }
    public void setBridge(int Ui, int Vi, int bridge){
        if(Ui>=getR())
            G[Ui-1][Vi-1]=bridge;
    }
    public int getBridge(int Ui, int Vi){
        return G[Ui][Vi];
    }
    public void Sorting(){
        int b=countLongestPaths(G, getN());
        LinkedList L=new LinkedList();
        LinkedList S=new LinkedList();
        //Filling S (the list of nodes with indegree=0)
        int sum=0;
        //Calculates the sum of a column in adjacency matrix
        for(int i=0; i<getN(); i++){
            for(int j=getR()-1; j<getN(); j++){
                sum=sum+G[j][i];
                if(sum==0 && !valueExists(S,i+1))
                    S=nodeInsertion(S,i+1);
            }
        }
        do{
            //Moving nodes from S to L
            nodeSwapping(S,L);
            //Removing edges from the graph
            for(int i=getR()-1; i<getN(); i++){
                for(int j=0; j<getN(); j++){
                    if(valueExists(L,i+1)&&getBridge(i,j)==1){
                        setBridge(i+1,j+1,0);
                        sum=0;
                        for(int s=0; s<getN(); s++)
                            sum=sum+G[s][j];
                        if(sum==0 && !valueExists(S,j+1))
                            S=nodeInsertion(S,j+1);
                    }
                }
            }
        }while(S.head!=null);
        //Checking if the graph still has edges
        int c=0;
        for(int i=getR(); i<getN(); i++){
            for(int j=0; j<getN(); j++){
                if(getBridge(i,j)==1)
                    c++;
            }
        }
        //Returning results
        if(c!=0)
            System.out.println("Graph has at least one cycle");
        else{
            if (b==1)
                System.out.println("The island you are most likely to get stuck on is: "+getLast(L));
            else{
                int arr[]=new int[b];
                System.out.print("The islands you are most likely to get stuck on are: ");
                for(int i=0; i<b; i++){
                    arr[i]=getLast(L);
                    deleteNode(L);
                }
                for(int i=b-1; i>=0; i--)
                    System.out.print(arr[i]+" ");
                System.out.println();
            }
        }
    }
    public static int countLongestPaths(int[][] array, int n){
        int x[]=new int[n];
        int sum=0,max=x[0],c=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                sum=sum+array[j][i];
            x[i]=sum;
            sum=0;
        }
        for(int i=1; i<x.length;i++){
            if(x[i]>max)
                max=x[i];
        }
        for(int i=0; i<x.length; i++){
            if(x[i]==max)
                c++;
        }
        return c;
    }
}



