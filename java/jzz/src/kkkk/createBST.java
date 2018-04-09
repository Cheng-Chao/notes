package kkkk;

import java.util.Stack;

public class createBST {
    static class node {
        int val;
        node left;
        node right;

        node(int input) {
            val = input;
            left = right = null;
        }
    }

    static void createBST(int[] a, node root) {
        for (int i = 0; i < a.length; i++) {
            insertNode(a[i], root);
        }
    }

    static void insertNode(int val, node root) {
        node parent = root;
        while (root != null) {
            parent = root;
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }

        }
        if (val < parent.val) {
            parent.left = new node(val);
        } else {
            parent.right = new node(val);
        }
    }


    public static void main(String args[]) {
        final int size = 20;
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
        for (int i : a)
            System.out.print(i + " ");
        node root = new node(500);
        createBST(a, root);
        System.out.println();
        inorder(root);
    }

    private static void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);


    }
}


