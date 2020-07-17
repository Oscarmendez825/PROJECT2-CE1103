package com.SPLAY;

import com.EmpresasManager.Empresa;

class BinaryNode
{
    private Empresa data;          // The data in the node
    private BinaryNode left;         // Left child
    private BinaryNode right;        // Right child

    public BinaryNode(Empresa data) {
        this.data = data;
        left = right = null;
    }

    public Empresa getData() {
        return data;
    }

    public void setData(Empresa data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
