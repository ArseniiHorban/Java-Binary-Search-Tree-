import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tree {
    protected TreeNode root; //creating the root of the node variable

    /**
     * Tree class constructor
     */
    public Tree()
    {
        root = null;
    }

    /**
     * function to insert a TreeNode to a tree
     * it calls the insertValueRecursive function to do so
     * @param value
     * @param cost
     * @param name
     */
    public void insertValue(int value, int cost, String name)
    {
        root = insertValueRecursive(value, cost, name, root); //calling the recursive function 
    }

    /**
     * function to delete the TreeNode
     * it calls the deleteValueRecursive function to do so
     * @param value (ID of the deleting item)
     */
    public void deleteValue(int value) {
        root = deleteValueRecursive(value, root); //calling the recursive function 
    }

    /**
     * function to search for a specific TreeNode
     * @param value
     * @return TreeNode
     */
    public TreeNode searcher(int value) {
        return searcher(value, root); //calling the recursive function 
    }

    /**
     * Function to traverse each node in the tree and return information about it in type appropriate to display for the user
     * @return String info (inorder)
     */
    public String inorderTraverser()
    {
        return traverseInorderRecursive(root); //calling the recursive function 
    }
    
    /**
     * Function to traverse each node in the tree in Preorder mode in the way appropriate to save it in text file
     * @return String info (preorder)
     */
    public String preorderTraverser()
    {
        return traversePreorderRecursive(root); //calling the recursive function 
    }

    /**
     * Fucntion to traverse each node in the tree in Preorder mode in the way appropriate to display for the user
     * @return String info (preorder)
     */
    public String preorderTraverserUser()
    {
        return traversePreorderRecursiveUser(root); //calling the recursive function 
    }

    /**
     * Function to traverse each node in the tree in Postnode mode in the way appropriate to display for the user
     * @return String info (postorder)
     */
    public String postorderTraverser()
    {
        return traversePostorderRecursive(root); //calling the recursive function 
    }

    /**
     * Function to traverse each node in the tree to get the total cost
     * @return
     */
    public int getTotalCost()
    {
        return calculateTotalCostRecursive(root); //calling the recursive function 
    }

    /**
     * Function to traverse each node and delete it
     */
    public void deleteAllNodes() {
        root = deleteAllNodesRecursive(root); //calling the recursive function 
    }

    /**
     * recursive function to create a TreeNode
     * @param value
     * @param cost
     * @param name
     * @param root
     * @return new TreeNode
     */
    private TreeNode insertValueRecursive(int value, int cost, String name, TreeNode root){
        if(root == null)
        {
            root = new TreeNode(value, cost, name);
            return root;
        }
        if(value == root.value)
        {
            System.out.println("This ID already exists, please try again");
            return root;
        }
        if(value < root.value)
            root.left = insertValueRecursive(value, cost, name, root.left);
        else if(value > root.value)
            root.right = insertValueRecursive(value, cost, name, root.right);
            
        return root;
    }

    /**
     * Recursive function to delete the TreeNode
     * @param value
     * @param root
     * @return 
     */
    private TreeNode deleteValueRecursive(int value, TreeNode root) {
        if (root == null) {
        System.out.println("There is no such an item");
            return root;
        }

        if (value < root.value) {
            root.left = deleteValueRecursive(value, root.left);
        } else if (value > root.value) {
            root.right = deleteValueRecursive(value, root.right);
        } else {

            // No children case
            if (root.left == null && root.right == null) {
                return null;
            }

            // 1 child case
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // 2 children case
            TreeNode smallestValueNode = findMin(root.right); // finding the smallest value from the right subtree
            root.value = smallestValueNode.value; // replacing the TreeNode value which is deliting by the smallest value from the findMin method
            root.cost = smallestValueNode.cost;
            root.name = smallestValueNode.name;
            // Удаляем этот наименьший узел в правом поддереве
            root.right = deleteValueRecursive(smallestValueNode.value, root.right);
        }

        return root;
    }

    /**
     * Function to find the minimum value in the right subtree
     * (it is used in the method to delete the value, in case of two children current function is used to replace the deleting node)
     * @param root
     * @return
     */
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * Recursive function to search for a node
     * @param value
     * @param root
     * @return Searched Tree Node
     */
    private TreeNode searcher(int value, TreeNode root)
    {
        if (root == null) {
            return null;
        } else if (value < root.value) {
            return searcher(value, root.left);
        } else if (value > root.value) {
            return searcher(value, root.right);
        } 
        return root;
    }

    /**
     * Recursive function to calculate total cost of all items (it works nearly the same way as TraversePreorderRecursive)
     * @param root
     * @return
     */
    private int calculateTotalCostRecursive(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int output = 0;
        output += root.cost;
        output += calculateTotalCostRecursive(root.left);
        output += calculateTotalCostRecursive(root.right);
        return output;
    }


    /**
     * Recursive function for preorder traverse 
     * @param root
     * @return PreorderTraverse String
     */
    private String traversePreorderRecursive(TreeNode root) {
        if (root == null) {
            return "";
        }

        String output = "";
        output += root.value + " " + root.cost + " " + root.name + "\n";
        output += traversePreorderRecursive(root.left);
        output += traversePreorderRecursive(root.right);
        return output;
    }

    /**
     * Recursive function for preorder traverse (it returns a String in the type that is readable to user)
     * @param root
     * @return PreorderTraverse String (User oriented type)
     */
    private String traversePreorderRecursiveUser(TreeNode root) {
        if (root == null) {
            return "";
        }

        String output = "";
        output += "ID: "+ root.value + " | Cost: " + root.cost + " | Name: " + root.name + "\n";
        output += traversePreorderRecursiveUser(root.left);
        output += traversePreorderRecursiveUser(root.right);
        return output;
    }

    /**
     * Recursive function for Inorder traverse (it returns a String in the type that is readable to user)
     * @param root
     * @return InorderTraverse String (user oriented type)
     */
    private String traverseInorderRecursive(TreeNode root) {
        if (root == null) {
            return "";
        }

        String output = "";
        output += traverseInorderRecursive(root.left);
        output += "ID: "+ root.value + " | Cost: " + root.cost + " | Name: " + root.name + "\n";
        output += traverseInorderRecursive(root.right);
        return output;
    }

    /**
     * Recursive function for Postorder traverse (it returns a String in the type that is readable to user)
     * @param root
     * @return PostorderTraverse String (user oriented type)
    */
    private String traversePostorderRecursive(TreeNode root) {
        if (root == null) {
            return "";
        }

        String output = "";
        output += traversePostorderRecursive(root.left);
        output += traversePostorderRecursive(root.right);
        output += "ID: "+ root.value + " | Cost: " + root.cost + " | Name: " + root.name + "\n";
        return output;
    }

    /**
     * Recursive function for deliting all the nodes in the tree 
     * @param root
     * @return
     */
    private TreeNode deleteAllNodesRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
    
        // Рекурсивно удаляем все узлы в левом и правом поддеревьях
        root.left = deleteAllNodesRecursive(root.left);
        root.right = deleteAllNodesRecursive(root.right);
    
        // Удаляем текущий узел, возвращая null, чтобы этот узел был удален из дерева
        root = null;
    
        return root;
    }

    /**
     * Function to print information about the node 
     * @param printedNode
     */
    public void printNode(TreeNode printedNode)
    {
        if(printedNode != null)
        {
            System.out.println("Name: " + printedNode.name);
            System.out.println("Cost: " + printedNode.cost);
            System.out.println("ID: " + printedNode.value + "\n");
        }
        else
            System.out.println("There is no such an item");
    }

    /**
     * Function to save the tree in a text file
     */
    public void fileOutputHandler() {
        try {
            File file = new File("TreeSave.txt");
            FileOutputStream output = new FileOutputStream(file, false);
            PrintWriter printWriter = new PrintWriter(output);

            printWriter.println(preorderTraverser());

            printWriter.print("This is the preorder traverse of the numbers in the Tree ");
            printWriter.close();
            System.out.println("Numbers data is saved to the text file");
        } catch (FileNotFoundException e) {
            System.out.println("file not found " + e);
        }
    }

    /**
     * Function to read a text file and download it to a tree
     */
    public void fileInputHandler() {
        Scanner scanner;
        try {
            File file = new File("TreeSave.txt");
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    int value = Integer.parseInt(parts[0]);
                    int cost = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    insertValue(value, cost, name);
                }
            }
            scanner.close();
            System.out.println("Tree data has been loaded from the text file");
        } catch (Exception e) {
            System.out.println("oops.. we got some problem here: " + e);
        }
    }
}
