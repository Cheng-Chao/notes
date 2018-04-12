Balanced Binary Tree







Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.






/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
  static class ints{
      public int val;
      ints(int input){val=input;}
  }
    
    public boolean isBalanced(TreeNode root, ints height){

        if(root ==null){
            height.val = 0;
            return true;
        }
        ints left= new ints(0);
        ints right= new ints(0);
        
        if(isBalanced(root.left, left)&&isBalanced(root.right, right)){
           if(Math.abs(left.val - right.val)<=1){
                height.val = Math.max(left.val,right.val)+1;
               return true;

            }  
        }
        return false;
    }
    public boolean isBalanced(TreeNode root) {
        ints hhhh = new ints(0);
        return isBalanced(root, hhhh);
    }
}
