package topologicalsorting;

    public class LinkedList {
        Node head;
        static class Node{
            int data;
            Node next;
            Node(int d){
                data=d;
                next=null;
            }
        }
        public static LinkedList nodeInsertion(LinkedList list, int data){
            //Creating new node
            Node node1=new Node(data);
            node1.next=null;
            //Insert it at the top if the list is empty
            if (list.head==null)
                list.head=node1;
                //Else insert it at the end of the list
            else{
                Node last=list.head;
                while (last.next!=null) {
                    last=last.next;
                }
                last.next=node1;
            }
            return list;
        }
        public static void nodeSwapping(LinkedList S, LinkedList L){
            Node temp=null;
            Node pointer=S.head;
            if (pointer!=null){
                temp=S.head;
                S.head=pointer.next;
            }
            nodeInsertion(L, temp.data);
        }
        public static boolean valueExists(LinkedList list, int item){
            Node temp=list.head;
            while(temp!=null){
                if(temp.data==item)
                    return true;
                temp=temp.next;
            }
            return false;
        }
        public static int getLast(LinkedList list){
            Node node2=list.head;
            Node current=null;
            while(node2!= null){
                current=node2;
                node2=current.next;
            }
            return current.data;
        }
        public static void deleteNode(LinkedList list){
            Node i=list.head;
            Node j=i.next;
            while(j.next!=null){
                i=j;
                j=j.next;
            }
            i.next=null;
        }

    }




