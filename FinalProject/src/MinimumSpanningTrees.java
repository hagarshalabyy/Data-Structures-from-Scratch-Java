import java.util.Scanner;
public class MinimumSpanningTrees {

        static void printGraph(LinkedList<LinkedList<Integer> > adj)
        {
            for (int i = 1; i < adj.size(); i++) {
                System.out.println("\nAdjacency list of vertex" + i);
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(" -> "+adj.get(i).get(j));
                }
                System.out.println();
            }
        }
        static int max_keyindex(int key[],boolean mst[],int V){
            int largest_index=0;
            int max=Integer.MIN_VALUE;
            for(int i=1;i<V;i++){
                if(mst[i]==false&&key[i]>max){
                    max=key[i];
                    largest_index=i;
                }
            }
            return largest_index;
        }
        public static void mst(LinkedList<LinkedList<Integer>> graph,int sum1,int V){
            int key[]=new int[V];
            boolean mstt[]=new boolean[V];
            for(int i=0;i<V;i++){
                key[i]=Integer.MIN_VALUE;
                mstt[i]=false;
            }
            key[1]=0;
            for(int c=1;c<V;c++){
                int i=max_keyindex(key,mstt,V);
                mstt[i]=true;
                for(int v=0;v<V;v++){
                    if(graph.get(i).get(v)!=null&&mstt[graph.get(i).get(v)]==false&&key[graph.get(i).get(v)]<Math.abs(i-graph.get(i).get(v))){
                        key[graph.get(i).get(v)]=Math.abs(i-graph.get(i).get(v));
                    }
                }
            }
            int sum=0;
            for(int i=1;i<V;i++){
                sum+=key[i];
            }
            System.out.println("The total cost = "+(sum1-sum));
        }
        public static void main(String[] args) {
            Scanner s=new Scanner(System.in);

            int z=0;
            do{

                System.out.println("Enter '1' to start APP or '0' to EXIT");
                z=s.nextInt();
                if (z==0){
                    System.out.println("-----GOODBYE-----");
                    break;
                }
                System.out.println("Enter number of the vertices and edges : ");
                int V=s.nextInt();
                int U=s.nextInt();
                LinkedList<LinkedList<Integer>> graph=new LinkedList<LinkedList<Integer>>();
                for(int i=0;i<V+1;i++){
                    graph.add(new LinkedList<Integer>());
                }

                System.out.println("Enter the two vertices of the first EDGE in your graph: ");
                int u1=s.nextInt();
                int v1=s.nextInt();
                graph.pushedge(graph,u1,v1);

                System.out.println("Enter the two vertices of the seconed EDGE in your graph: ");
                int u2=s.nextInt();
                int v2=s.nextInt();
                graph.pushedge(graph,u2,v2);
                System.out.println("Enter the two vertices of the third EDGE in your graph: ");
                int u3=s.nextInt();
                int v3=s.nextInt();
                graph.pushedge(graph,u3,v3);
                System.out.println("Enter the two vertices of the fourth EDGE in your graph: ");
                int u4=s.nextInt();
                int v4=s.nextInt();
                graph.pushedge(graph,u4,v4);
                System.out.println("Enter the two vertices of the fifth EDGE in your graph: ");
                int u5=s.nextInt();
                int v5=s.nextInt();
                graph.pushedge(graph,u5,v5);
                int sum1=0;
                int cost[]={Math.abs(u1-v1),Math.abs(u2-v2),Math.abs(u3-v3),Math.abs(u4-v4),Math.abs(u5-v5)};
                for(int i=0;i<V;i++ ){
                    sum1+=cost[i];
                }
                printGraph(graph);
                MinimumSpanningTrees gp=new MinimumSpanningTrees();

                gp.mst(graph,sum1,V+1);
            }while(z==1);
        }
    }
    class LinkedList<A>{
        Node head;
        class Node{
            A v;
            Node next;
            public Node(A v){
                this.v=v;
                next= null;
            }
        }
        public void add(A e){
            Node addnode=new Node(e);
            if (head==null){
                head= addnode;
            }
            else{
                Node temp=head;
                head= addnode;
                addnode.next=temp;
            }
        }
        public boolean isEmpty(){

            if (head == null) {
                return true;
            }
            else
                return false;
        }
        public Node getnode(int i){
            int c=0;
            Node current =head;
            while (head==null){

                if(c==i){
                    return current;
                }
                c++;
                current=current.next;
            }
            return null;
        }
        int size() {
            int c=0;
            Node current=head;
            while (current!=null){
                c++;
                current=current.next;
            }
            return c;
        }
        public A get(int index)
        {
            Node current = head;
            int c = 0;
            while (current != null)
            {
                if (c == index){
                    return current.v;
                }
                c++;
                current = current.next;
            }
            return null;
        }
        public static void pushedge(LinkedList<LinkedList<Integer>> adjecent,int v,int u){
            adjecent.get(v).add(u);
            adjecent.get(u).add(v);
        }
    }



