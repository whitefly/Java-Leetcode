package 剑指Offer;

public class O37_xu_lie_hua_er_cha_shu_lcof {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Codec {
        int index;
        String splitTag = "#";
        String NULL = "x";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
        }

        void serializeHelper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(splitTag);
                return;
            }
            sb.append(root.val).append(splitTag);
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            index = 0;
            return deserializeHelper(data.split(splitTag));
        }

        TreeNode deserializeHelper(String[] items) {
            String item = items[index++];
            if (item.equals(NULL)) return null;

            TreeNode root = new TreeNode(Integer.parseInt(item));
            root.left = deserializeHelper(items);
            root.right = deserializeHelper(items);
            return root;
        }

    }

    public static void main(String[] args) {
        String demo = "1-x-x-";
        O37_xu_lie_hua_er_cha_shu_lcof.Codec s = new O37_xu_lie_hua_er_cha_shu_lcof.Codec();
        TreeNode deserialize = s.deserialize(demo);
        System.out.println("Ok");


    }

}
