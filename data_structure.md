

- [createBST](#createbst) 



# createBST
    
        static void insertNode_1(TreeNode root, int input){
            if(root == null){
                root = new TreeNode(input);
            }
            TreeNode parent = root;
            while(root!=null)
            {

                 parent = root;
                if(input<root.val){

                root = root.left;   
                }
                else{
                    root = root.right;
                }
            }
            if(input <parent.val){
                parent.left = new TreeNode(input);
            }
            else{
                parent.right = new TreeNode(input);
            }


        } 
