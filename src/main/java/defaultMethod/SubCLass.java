package defaultMethod;

import javax.management.relation.RoleUnresolved;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubCLass extends DefaultMethodClass implements DefaultMethodInterface {


    /**
     * 若父类和父接口中有同名方法，那么类优先
     */
    public static void main(String[] args) {

        Tree A = new Tree("A");
        Tree B = new Tree("B");
        Tree C = new Tree("C");
        Tree D = new Tree("D");
        Tree E = new Tree("E");
        Tree F = new Tree("F");


        A.setSubTree(Arrays.asList(B, C));
        B.setSubTree(Arrays.asList(D,E));
        D.setSubTree(Arrays.asList(F));

        Stack<Tree> stack = new Stack<Tree>();
        try {
            search(A, "C", stack);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf(stack.toString());

    }

    private static void search(Tree a, String d, Stack<Tree> stack) {



        stack.push(a);

        if (a.getName().equals(d)) {
            throw new RuntimeException();
        }


        if (a.getSubTree() != null && a.getSubTree().size() > 0) {
            for (int i = 0; i < a.getSubTree().size(); i++) {
                search(a.getSubTree().get(i), d, stack);
            }
        }

        stack.pop();



    }


    static class Tree {
        String name;
        List<Tree> subTree;

        public Tree(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Tree> getSubTree() {
            return subTree;
        }

        public void setSubTree(List<Tree> subTree) {
            this.subTree = subTree;
        }
    }


}
