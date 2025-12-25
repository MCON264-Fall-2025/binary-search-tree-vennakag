package bst;

import java.util.*;

public class TraversalExercises {

    // Iterative preorder using a stack
    public static <T extends Comparable<T>> List<T> preorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement iterative preorder using Deque as a stack
        // Hint: push root; while stack not empty:
        //   pop node, visit it, then push right child, then left child
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        if(root!=null){
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode<T> node = stack.pop();
                result.add(node.value);
                    if(node.right!=null){
                        stack.push(node.right);
                    }
                    if(node.left!=null){
                    stack.push(node.left);
                    }
            }
        }
        return result;
    }

    // Iterative inorder using a stack
    public static <T extends Comparable<T>> List<T> inorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement iterative inorder
        // Hint: use a pointer 'curr' and a stack:
        //   while (curr != null || !stack.isEmpty()) { ... }
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> node = root;
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.value);
            node = node.right;
        }
        return result;
    }

    // Optional / challenge: iterative postorder
    public static <T extends Comparable<T>> List<T> postorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO (challenge): implement iterative postorder
        // You may use two stacks, or one stack with a previous-node pointer.
        Stack<TreeNode<T>> stack1 = new Stack<>();
        Stack<TreeNode<T>> stack2 = new Stack<>();
        TreeNode<T> node = root;
        stack1.push(node);
        while(!stack1.isEmpty()){
            node = stack1.pop();
            result.add(node.value);
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push(node.right);
            }
        }
        while(!stack2.isEmpty()){
            result.add(stack2.pop().value);
        }
        return result;
    }

    // Practice version of level-order
    public static <T extends Comparable<T>> List<T> levelOrderUsingQueue(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Queue<TreeNode<T>> q = new ArrayDeque<>();
        // TODO: implement BFS using a Queue<TreeNode<T>>
        if (root == null) {
            return result;
        }else{
            TreeNode<T> current = root;
            q.add(current);
            while(!q.isEmpty()){
                current = q.peek();
                q.remove();
                result.add(current.value);
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
            }
        }
        return result;
    }
}

