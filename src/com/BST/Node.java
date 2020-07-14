package com.BST;

import com.UsuariosManager.Usuario;


class Node {
    private Usuario data;
    private Node left, right;

    Node(Usuario data)
    {

        this.data = data;
    }

    public Usuario getData() {
        return data;
    }

    public void setData(Usuario data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
