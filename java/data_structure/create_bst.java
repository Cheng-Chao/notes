
public class HelloWorld {
		
	class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		TreeNode(int input){
			val = input;
			left = null;
			right = null;
		}
	}
	
	
	
	TreeNode InsertTreeNode(TreeNode root,int val) {
		if(root == null) {
			root = new TreeNode(val);
			return root;
		}
		if(root.val >= val) {
			root.right = InsertTreeNode(root.right,val);
			
		}
		else {
			root.left = InsertTreeNode(root.left,val);
			
		}	
			
		return root;
	}
	
	
	TreeNode CreateTreeNode() {
		TreeNode root = null;
		
		int a;
		for(int i=0;i<10;i++) {
			root = InsertTreeNode(root,a = (int)(Math.random()*100));
			System.out.print(a+" ");
		}		
		return root;
		
	}
	
	
	void TraversalTreeNode(TreeNode root) {
		if(root == null) return ;
		TraversalTreeNode(root.left);
		System.out.print(root.val+" ");
		TraversalTreeNode(root.right);
		
	}
	public static void main(String[] args) {
		HelloWorld he = new HelloWorld();
		TreeNode root = he.CreateTreeNode();
		System.out.println();
		he.TraversalTreeNode(root);
				
	}
		
}
