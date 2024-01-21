public class Test {

    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public int preIndex ;

    public TreeNode buildTree(char[] preorder, char[] inorder) {

        return buildTreeChild(preorder,inorder,0,inorder.length);

    }

    /*private TreeNode buildTreeChild(char[] preorder,char[] inorder,int inbegin,int inend) {
        if (inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[this.preIndex]);

        int rootIndex = findIndexRoot(inorder,0,inorder.length,root.val);
        this.preIndex++;

        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);

        return root;
    }*/
    private TreeNode buildTreeChild(char[] preorder,char[] inorder,int inbegin,int inend) {
        if (inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int rootIndex = findIndexRoot(inorder,inbegin,inend,root.val);
        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder,inorder,rootIndex + 1,inend);
        return root;

    }

    private int findIndexRoot(char[] inorder,int inbegin, int inend,int key) {
        for (int i = inbegin;i < inend;i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test  solutionCreateTree = new Test();
        char[] preorder = {'E','F','H','I','G','J','K'};
        char[] inorder = {'H','F','I','E','J','K','G'};
        Test.TreeNode root = solutionCreateTree.buildTree(preorder,inorder);
    }
}