import java.util.Scanner;

class Reyes_Trees 
{
    public static void main(String[] args) {
        //setting values
        int[] nodes = new int[7];
        for(int i = 0; i<7; i++){
            Scanner myScan = new Scanner(System.in); 
            System.out.println("Enter node value");
            int userNode = myScan.nextInt();
            nodes[i] = userNode;
        }
        
        System.out.println(" ");
        System.out.print("Binary Tree Array:");
        for(int i = 0; i<7; i++){
            System.out.print(nodes[i]);
        }
        System.out.println(" ");
        System.out.println(" ");
        
        //insertion
        BinaryTree bt1 = new BinaryTree(nodes[0]);
        bt1.insertLeft(bt1.root, nodes[1]);
        bt1.insertRight(bt1.root, nodes[2]);
        
        bt1.insertLeft(bt1.root.left, nodes[3]);
        bt1.insertRight(bt1.root.left, nodes[4]);
        
        bt1.insertLeft(bt1.root.right, nodes[5]);
        bt1.insertRight(bt1.root.right, nodes[6]);

        //main
        System.out.println("Inorder Traversal");
        bt1.inorderTraversal(bt1.root);
        System.out.println("");
        System.out.println("Preorder Traversal");
        bt1.preorderTraversal(bt1.root);
        System.out.println("");
        System.out.println("Postorder Traversal");
        bt1.postorderTraversal(bt1.root);
        
    }
}

class Node
{
    int key;
    Node left, right;
    
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node root;
    public BinaryTree(int key)
    {
        root = new Node(key);
    }
    
    void insertLeft(Node current, int key)
    {
        if(current.left == null){
            current.left = new Node(key);
        }else{
            Node newNode = new Node(key);
            newNode.left = current.left;
            current.left = newNode;
        }
    }
    
    void insertRight(Node current, int key)
    {
       if(current.right == null){
            current.right = new Node(key);
        }else{
            Node newNode = new Node(key);
            newNode.right = current.right;
            current.right = newNode;
        } 
    }
    
    void inorderTraversal(Node root)
    {
        if(root != null){
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }
    
    void preorderTraversal(Node root)
    {
        if(root != null){
            System.out.print(root.key + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    
    void postorderTraversal(Node root)
    {
        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }
    
    int findHeight(Node node){
        if(node == null)
            return 0;
        else {
            int leftHeight = findHeight(node.left);
            int rightHeight = findHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
    int countNodes(Node root){
        if(root == null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    Node searchNode(Node root, int key){
        if (root == null || root.key == key)
            return root;
        if (root.key < key)
            return searchNode(root.right, key);
        return searchNode(root.left, key);
    }
    
    int findMinValue(Node node){
        Node current = node;
        while(current.left != null)
            current = current.left;
        return current.key;
    }
    
    Node deleteNode(Node root, int key){
        if (root == null)
            return root;
            
        if (key<root.key)
            root.left = deleteNode(root.left, key);
        else if(key > root.key)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left== null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = findMinValue(root.right);
            root.right = deleteNode(root.right, root.key);
        }
        return root;
    }
  
}
