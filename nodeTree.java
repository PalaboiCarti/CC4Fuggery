class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
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
  
}
