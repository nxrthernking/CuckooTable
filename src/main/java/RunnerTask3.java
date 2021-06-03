public class RunnerTask3 {
    public static void main(String[] args) {
        CustomTree tree1 = new CustomTree();
        CustomTree tree2 = new CustomTree();

        tree1.add(322);
        tree1.add(10);
        tree1.add(4);
        tree1.add(8);
        tree1.add(2);
        tree1.add(5);
        tree1.add(7);
        tree1.add(26);
        tree1.add(22);
        tree1.add(20);
        tree1.add(24);
        tree1.add(34);
        tree1.add(1337);
        tree1.add(1103);

        tree2.add(12);
        tree2.add(10);
        tree2.add(4);
        tree2.add(8);
        tree2.add(2);
        tree2.add(5);
        tree2.add(7);
        tree2.add(26);
        tree2.add(22);
        tree2.add(20);
        tree2.add(24);
        tree2.add(34);
        tree2.add(32);
        tree2.add(36);

//        tree1.show();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        tree2.show();

        tree1.distinct(tree2.getRoot());
    }
}
