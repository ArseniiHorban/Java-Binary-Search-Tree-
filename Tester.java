public class Tester {

    private static Tester testerVariable = new Tester();
    Tree tree = new Tree();

    /**
     * Tester main method to launch multiple tests
     * @param args
     */
    public static void main(String[] args) {
        testerVariable.pushValues();
        testerVariable.printValues();
        testerVariable.deleteValues();
        testerVariable.falseDeleteValues();
        testerVariable.searchTest();
        testerVariable.falseSearchTest();
        testerVariable.saveTest();
        testerVariable.downloadTest();
        
    }

    /**
     * Pushing values test
     */
    private void pushValues()
    {
        tree.insertValue(6, 10, "A");
        tree.insertValue(5, 20, "B");
        tree.insertValue(3, 30, "C" );
        tree.insertValue(4, 40, "D");
        tree.insertValue(10, 50, "E");
        tree.insertValue(1, 60, "F");

        System.out.println("The pushed values are:");
        System.out.println(tree.inorderTraverser());
        System.out.println("With total cost of");
        System.out.println(tree.getTotalCost()+"\n");
    }

    /**
     * Different traverse methods test
     */
    private void printValues()
    {
        System.out.println("\nDifferent traverse method test: \n");

        System.out.println("inorder:");
        System.out.println(tree.inorderTraverser());
        System.out.println("postoder:");
        System.out.println(tree.postorderTraverser());
        System.out.println("preorder:");
        System.out.println(tree.preorderTraverserUser() + "\n");
    }

    /**
     * Deliting a TreeNode test
     */
    private void deleteValues()
    {

        System.out.println("\nDelition test: \n");

        System.out.println("Current values of the tree:");
        System.out.println(tree.inorderTraverser());

        tree.deleteValue(5);

        System.out.println("Values after deliting '5':");
        System.out.println(tree.inorderTraverser()+"\n");
    }

    /**
     * Deliting a TreeNode with wrong input test
     */
    private void falseDeleteValues()
    {
        System.out.println("\nFalse delete values test \n");
        tree.deleteValue(666);
    }

    /**
     * Searching a specific item by its ID test
     */
    private void searchTest()
    {
        System.out.println("\nSearch Test \n");
        System.out.println("We are searching for 3 (its cost should be 30 with name 'C') ");
        tree.printNode(tree.searcher(3));
    }

    /**
     * Searching a specific item by its ID with wrong input test
     */
    private void falseSearchTest()
    {
        System.out.println("\nFalse search Test \n");
        tree.printNode(tree.searcher(666));
    }       

    /**
     * Saving a Tree to a text file test
     */
    private void saveTest()
    {
        System.out.println("\nSave to a text file test\n");
        tree.fileOutputHandler();
    }

    /**
     * Downloading a Tree from a text file test
     */
    private void downloadTest()
    {
        System.out.println("\nDownload test: \n");
        System.out.println("The tree should remain the same");
        tree.deleteAllNodes();
        tree.fileInputHandler();
        System.out.println(tree.inorderTraverser()+"\n");
    }
}
