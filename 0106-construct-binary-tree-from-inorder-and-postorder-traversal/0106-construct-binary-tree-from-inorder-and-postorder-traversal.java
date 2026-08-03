class Solution {
    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        // Store inorder values with their indices
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {

        if (left > right)
            return null;

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        int mid = map.get(rootValue);

        // Build right subtree first
        root.right = build(inorder, postorder, mid + 1, right);
        root.left = build(inorder, postorder, left, mid - 1);

        return root;
    }
}
