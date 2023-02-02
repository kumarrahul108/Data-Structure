

// Binary Search Tree 

import java.util.*; 

public class P1_Binary_Search_Tree 
{

    static Node root = null; 

    // *** Creating Node Class *** 
    static class Node 
    {
        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }  


    // *** Creating Tree Class ***
    static class Search_Tree 
    {
        // buils BST
        public  Node buildTree(Node root,int val)
        {
            // Base 
            if(root == null)
            {
                root = new Node(val);
                return root; 
            }

            if(root.data > val)
            {
                root.left = buildTree(root.left, val);
            }

            if(root.data < val) 
            {
                root.right = buildTree(root.right, val);
            }

            return root;
        }



        // *** Inorder traversal   --> Gives Acsending Order Sequence ***
        public void inOrder(Node root)
        {
            // Base 
            if(root == null)
            {
                return ;
            }
             inOrder(root.left);
             System.out.print(root.data + "  ");
             inOrder(root.right); 
        }



        // *** Searching in BST ***
        public boolean serach(Node root,int key)
        {
            // Base 
            if(root == null)
            {
                return false;
            }

            if(root.data > key)
            {
                return serach(root.left, key);
            }  

            else if(root.data < key) 
            {
                return serach(root.right, key);   
            }

            else 
            {
                return true;
            }
        }



        // *** Deletion in BST ***
        public Node delete(Node root,int key)
        {
            // search node 
            if(root.data > key)
            {
                root.left = delete(root.left, key);
            }

            else if(root.data < key) 
            {
                root.right = delete(root.right, key);
            } 

            else 
            {
                // case 1 --> leaf node 
                if(root.left == null && root.right == null) 
                {
                    return null;
                }  

                // case 2 --> 1 child node
                if(root.left == null)
                {
                    return root.right;   
                }

                else if(root.right == null)
                {
                    return root.left;
                }

                // case 3 --> 2 child node
                Node is = inOrderSuccessor(root.right);
                root.data = is.data;
                root.right = delete(root.right, key);
                
            }  

            return root;
        }

    

    // *** In Order Successor *** 
    public static Node inOrderSuccessor(Node root)
    {
        while(root.left != null) 
        {
            root = root.left;
        }

        return root;
    }



    // Print in Range 
    public void printRange(Node root,int x,int y)
    {
        // Base 
        if(root == null) 
        {
            return;  
        }     

        if(root.data >= x && root.data <= y)
        {
            printRange(root.left, x, y);
            System.out.print(root.data + "  ");
            printRange(root.right, x, y);  
        }

        else if(root.data >=y)
        {
            printRange(root.left, x, y);
        }

        else if(root.data <= x) 
        {
            printRange(root.right, x, y); 
        }
    }  




    // *** Root - Leaf Paths ***
    public void leafPath(Node root,ArrayList<Integer> path) 
    {
        // Base 
        if(root == null)
        {
            return;
        } 

        path.add(root.data);

        // leaf node 
        if(root.left == null && root.right == null)
        {
            printPath(path);
        }
        // non leaf node
        else 
        {
            leafPath(root.left, path);
            leafPath(root.right, path);
        }  

        path.remove(path.size()-1);
    }



    // *** Print the Paths *** 
    public void printPath(ArrayList<Integer> path)
    {
        for(int i=0;i<path.size();i++)
        {
            System.out.print(path.get(i) + "  ");
        }
        System.out.println();  
    } 
}


    // **** Main Function ****  
    public static void main(String[] args) 
    {
        int val[] = {5,1,3,4,2,7};

        Search_Tree t = new Search_Tree();

        for(int i=0;i<val.length;i++)
        {
            root = t.buildTree(root, val[i]);
        }

        System.out.print("\nInorder TRaversal of Binary Search Tree :   ");
        t.inOrder(root);

        System.out.print("\n\nSeraching Element - 2 in Binary Serach Tree :  " + t.serach(root, 2));

        t.delete(root, 2);

        System.out.print("\n\nTree after delteing one of its Node :  -->  ");
        t.inOrder(root);

        System.out.print("\n\nPrint Range :  ");
        t.printRange(root,3,6); 

        System.out.print("\n\nPath :   Root to Leaf -->  \n");
        ArrayList<Integer> l1 = new ArrayList<>();
        t.leafPath(root, l1);
    }
}