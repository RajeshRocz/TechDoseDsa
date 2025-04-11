package dsa.tree;

public class Tree {



}

class TreeStructure{
    TreeNode root;

    public void add(int value){
        TreeNode newNode=new TreeNode(value);
        if(root==null){
            root=newNode;
            return;
        }

        TreeNode currentNode=root;

        while(true){
            if(currentNode.value<value){
                if(currentNode.right==null){
                    currentNode.right=newNode;
                    return;
                }
                currentNode=currentNode.right;
            }else{
                if(currentNode.left==null){
                    currentNode.left=newNode;
                    return;
                }
                currentNode=currentNode.left;
            }
        }

    }


}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value=value;
    }
}
