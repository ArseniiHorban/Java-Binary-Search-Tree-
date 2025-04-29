public class TreeNode {
    protected int value; //Value = ID
    protected int cost; 
    protected String name; 
    protected TreeNode left, right;
    
    /**
     * TreeNode constructor
     * @param tempValue
     * @param tempCost
     * @param tempName
     */
    public TreeNode(int tempValue, int tempCost, String tempName)
    {
        value = tempValue;
        cost = tempCost;
        name = tempName;
        left = null;
        right = null;
    }
}
