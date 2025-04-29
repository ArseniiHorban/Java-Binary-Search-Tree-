import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Main mainVariable = new Main();
    static Tree tree = new Tree();
    /**
     * Main method of a program
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        mainVariable.menu();
    }

    /**
     * Menu method (in fact - director method)
     * It calls appropriate functions depending on the user input
     */
    public void menu()
    {
        boolean menuRepeater = true;    
        while(menuRepeater == true)
        {
            switch (getMenuInteger()) { //switch to call methods appropriate to user's choice (menu integer)
            case 0: //add a new treenode
                System.out.print("\033[H\033[2J");
                tree.insertValue(getId(), getCost(), getName()); //Add a new TreeNode
                break;
            case 1: //inorder print
                System.out.println(tree.inorderTraverser()); //Print all TreeNodes in inorder mode
                break;
            case 2: //preorder and postorder print
                System.out.print("\033[H\033[2J");
                System.out.println("\nPreorder traverse:"); //Print all TreeNodes in preorder mode
                System.out.println(tree.preorderTraverserUser());
                System.out.println("\nPostorder traverse:"); //Print all TreeNodes in postorder mode
                System.out.println(tree.postorderTraverser());
                break;
            case 3://Delete a TreeNode
                System.out.print("\033[H\033[2J");
                tree.deleteValue(getId());
                System.out.print("\033[H\033[2J");
                System.out.println("now your items are:");
                System.out.println(tree.inorderTraverser()); //printing all items after delition
                break;
            case 4://Search for a specific TreeNode
                System.out.print("\033[H\033[2J");
                tree.printNode(tree.searcher(getId()));
                break;
            case 5://Calculate total cost
                System.out.println("Total cost of all your items is:");
                System.out.println(tree.getTotalCost());
                break;
            case 6: //Save data to a text file
                tree.fileOutputHandler();
                break;
            case 7: //Download data from a text file 
                tree.deleteAllNodes();
                tree.fileInputHandler();
                break;
            case 8: //Exit
                menuRepeater = false;
            }   
        }
        System.exit(0);
    }

    /**
     * Function to get the menu integer for the menu from the user
     * @return menuInteger
     */
    private int getMenuInteger()
    {
        int integer = 0;
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("0 - Add items to the database");
            System.out.println("1 - Display all the items");
            System.out.println("2 - Try some other types of displaying");
            System.out.println("3 - Delete an item");
            System.out.println("4 - Search for am item");
            System.out.println("5 - Calculate total cost of all the items");
            System.out.println("6 - Save database to the text file");
            System.out.println("7 - Load database from the text file");
            System.out.println("8 - exit");
            integer = in.nextInt();
            while(integer<0 || integer>8) {
                System.out.println("please, enter the correct value: number beetwen 0 and 8");
                integer = in.nextInt();
            }
        }catch(InputMismatchException e) {
            System.out.println("please, enter the correct value: number beetwen 0 and 8");
            getMenuInteger();
        }
        return integer;
    }

    /**
     * Function to get the ID of the specific item from the user
     * @return value
     */
    private int getId()
    {
        int value = 0;
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Please, enter the ID");
            value = in.nextInt();
        }catch(InputMismatchException e) {
            System.out.println("please, enter the number");
            value = getId();
        }
        return value;
    }
    /**
     * Function to get a Cost from the user
     * @return cost
     */
    private int getCost()
    {
        int cost = 0;
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Please, enter the cost");
            cost = in.nextInt();
        }catch(InputMismatchException e) {
            System.out.println("please, enter the number");
            cost = getCost();
        }
        return cost;
    }

    /**
     * Function to get a Name from the user
     * @return name
     */
    private String getName()
    {
        String name = "";
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Please, enter the name");
            name = in.nextLine();
        }catch(Exception e) {
            System.out.println("Here is an exception, so try again:");
            name = getName();
        }
        return name;
    }
}
