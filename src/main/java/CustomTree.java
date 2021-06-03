import lombok.Getter;

@Getter
public class CustomTree {

    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.add(value);
        }
    }

    public void distinct(Node node) {
        root.traverseInOrder(root, node);
    }
//    public void show(){
//        root.show(root,0);
//    }

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        private void add(int newValue) {
            if (newValue < value) {
                if (left == null) {
                    left = new Node(newValue);
                } else {
                    left.add(newValue);
                }
            } else {
                if (right == null) {
                    right = new Node(newValue);
                } else {
                    right.add(newValue);
                }
            }
        }

        private void traverseInOrder(Node node, Node root) {
            if (node.right != null) {
                traverseInOrder(node.right, root);
            }
            if(root.contains(node.value) == null){
                System.out.println(node.value);
            }
            if (node.left != null) {
                traverseInOrder(node.left, root);
            }

        }

        private Node contains(int target) {

            if (target == value) {
                return this;
            }

            if (target < value) {
                if (left == null) {
                    return null;
                } else {
                    return left.contains(target);
                }
            } else {
                if (right == null) {
                    return null;
                } else {
                    return right.contains(target);
                }
            }


        }

//        private void show(Node node, int level) {
//
//            if (node.right != null) {
//                show(node.right, level + 1);
//            }
//            for (int i = 0; i < level; i++) System.out.print("  ");
//            System.out.println(node.value);
//            if (node.left != null) {
//                show(node.left, level + 1);
//            }
//
//
//        }
    }
}
