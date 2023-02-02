
// Binary Tree In Java 

import java.util.*; 

public class P1_Binary_Tree 
{
    static Node root;

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

    static int idx = -1;
    
    // *** Construct a Tree *** 
    public Node buildTree(int nodes[])
    {
        idx++;

        if(nodes[idx] == -1)
        {
            return null;  
        }  

        Node n = new Node(nodes[idx]);
        n.left = buildTree(nodes);
        n.right = buildTree(nodes);

        return n;
    }  


    // *** Pre Order ***
    public void preOrder(Node root) 
    {
        // Base 
        if(root == null)
        {
            return;
        }  

        System.out.print(root.data + "    ");
        preOrder(root.left); 
        preOrder(root.right); 
    }  



    // *** Post Order ***
    public void postOrder(Node root) 
    {
        // Base 
        if(root == null)
        {
            return;
        }  

        preOrder(root.left); 
        preOrder(root.right); 
        System.out.print(root.data + "    ");
    }


    // *** In Order ***
    public void inOrder(Node root)
    {
        // Base 
        if(root == null)
        {
            return; 
        }  

        inOrder(root.left);
        System.out.print(root.data + "   ");
        inOrder(root.right); 
    }  


    // *** No of Nodes ***
    public int noNodes(Node root)
    {
        // Base 
        if(root == null)
        {
            return 0; 
        }  

        int left = noNodes(root.left);
        int right = noNodes(root.right);

        return (left + right + 1);  
    }  



    // *** Sum of Nodes *** 
    public int sumNodes(Node root)
    {
        // Base 
        if(root == null)
        {
            return 0;
        }

        int left = sumNodes(root.left);
        int right = sumNodes(root.right);

        return (left + right + root.data); 
    }



    // *** Height of Tree *** 
    public int height(Node root) 
    {
        // Base 
        if(root == null)
        {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int ht = Math.max(left,right) + 1;

        return ht;
    } 



    // *** Diameter of Tree -> Tn = O(n) ***
    public int diameter(Node root)
    {
        // Base 
        if(root == null)
        {
            return 0;
        }  
        
        int dia1 = diameter(root.left);  
        int dia2 = diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;

        int dia = Math.max(dia3, Math.max(dia2, dia1));  

        return dia; 
    }  



    // *** Diameter of Tree -> Tn = O(n^2) *** 

    static class MyInfo
    {
        int ht;
        int dia; 

        MyInfo(int ht,int dia)
        {
            this.ht = ht;
            this.dia = dia;
        }
    }    


    public MyInfo diameter2(Node root)
    {
        // Base
        if(root == null)
        {
            return new MyInfo(0, 0);
        }

        MyInfo left = diameter2(root.left);
        MyInfo right = diameter2(root.right);

        // Height 
        int myHt = Math.max(left.ht, right.ht) + 1;

        // Diameter 
        int diaa1 = left.dia;
        int diaa2 = right.dia;
        int diaa3 = left.ht + right.ht + 1;

        int myDia = Math.max(diaa3, Math.max(diaa2, diaa1));

        MyInfo t = new MyInfo(myHt, myDia);

        return t; 
    }



    // *** Level Order ***
    public void levelOrder(Node root) 
    {
        // Base 
        if(root == null)
        {
            return;
        }  

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);  

        while(!q.isEmpty())
        {
            Node curr = q.remove();
            
            if(curr == null)
            {
                System.out.println();

                if(q.isEmpty())
                {
                    break;
                } 
                else 
                {
                    q.add(null); 
                }
            } 
            else 
            {
                System.out.print(curr.data + "  "); 
                if(curr.left != null)
                {
                    q.add(curr.left);
                }
                if(curr.right != null)
                {
                    q.add(curr.right);
                }

            }
        }
    }



    // *** Main Function ***  
    public static void main(String[] args) 
    {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        P1_Binary_Tree tree = new P1_Binary_Tree();

        root = tree.buildTree(nodes);

        System.out.print("\n\nRoot of Tree :  " + root.data);   

        System.out.print("\n\nPre-Order Traversal of Tree :  ");
        tree.preOrder(root); 

        System.out.print("\n\nPost-Order Traversal of Tree :  ");
        tree.postOrder(root);  
        
        System.out.print("\n\nIn-Order Traversal of Tree :  ");
        tree.inOrder(root);  
        
        System.out.print("\n\nLevel-Order Traversal of Tree :  \n");
        tree.levelOrder(root); 

        System.out.print("\n\nNumber of Nodes of Tree  :  " + tree.noNodes(root));

        System.out.print("\n\nSum of Nodes of Tree  :  " + tree.sumNodes(root)); 

        System.out.print("\n\nHeight of Tree  :  " + tree.height(root));

        System.out.print("\n\nDiameter of Tree  :  " + tree.diameter(root));  

        System.out.print("\n\nDiameter of Tree  :  " + tree.diameter2(root).dia);

    }
}