import java.util.Scanner;
public class BinarySearchTree {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the redundancy ratio:");
            double r = sc.nextDouble();
            System.out.println("Enter number:");
            int first= sc.nextInt();
            Tree t = new Tree();
            t.insert(first);
            int sum = 1;
            int flag = 1;
            do{
                System.out.println("Enter number:");
                int c = sc.nextInt();
                if (c == -1) {
                    break;
                }
                t.search(c, t.root);
                if (t.found == false) {
                    t.insert(c);
                    sum++;
                }
                flag++;
            }while(r > ((flag*1.0)/ sum));
            double ratio = (flag*1.0)/sum;
            System.out.println("The redundancy ratio=" + flag + "/" + sum + "=" + ratio);
            if (ratio >= r) {
                System.out.println("many reptitions");
            } else {
                System.out.println("only few reptitions");
            }
        }
    }
    class Tree {
        class Node {
            int number;
            Node left;
            Node right;
            public Node(int j) {
                number = j;
                left = right = null;
            }
        }
        Node root;
        boolean found;
        Tree() {
            root = null;
        }
        void insert(int number) {
            root = insertRec(root, number);
        }
        Node insertRec(Node root, int number) {
            if (root == null) {
                root = new Node(number);
                return root;
            }
            if (number > root.number) {
                root.left = insertRec(root.left, number);
            } else if (number < root.number) {
                root.right = insertRec(root.right, number);
            }
            return root;
        }
        void search(int number, Node root) {
            if(root==null){
                return;}
            this.found = false;
            if (root.number == number) {
                this.found = true;
                return;
            }
            if (number> root.number) {
                search(number, root.left);
            } else if (number< root.number) {
                search(number, root.right);
            }
        }
    }

