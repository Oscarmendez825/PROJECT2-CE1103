package com.AVL;

import com.RecetasManager.Receta;

public class NodoAVL  {
    private Receta item;
    private NodoAVL parent;
    private boolean isLeftChild = false;
    private NodoAVL leftChild;
    private NodoAVL rightChild;
    private int leftHeight;
    private int rightHeight;

    public boolean getIsLeftChild() {
        return isLeftChild;
    }

    public void setIsLeftChild(boolean leftChild) {
        isLeftChild = leftChild;
    }

    public NodoAVL getParent() {
        return parent;
    }

    public void setParent(NodoAVL parent) {

        this.parent = parent;
    }



    public Receta getItem() {
        return item;
    }

    public void setItem(Receta item) {
        this.item = item;
    }

    public NodoAVL getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodoAVL leftChild) {
        this.leftChild = leftChild;
    }

    public NodoAVL getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodoAVL rightChild) {
        this.rightChild = rightChild;
    }

    public int getLeftHeight() {
        return leftHeight;
    }

    public void setLeftHeight(int leftHeight) {
        this.leftHeight = leftHeight;
    }

    public int getRightHeight() {
        return rightHeight;
    }

    public void setRightHeight(int rightHeight) {
        this.rightHeight = rightHeight;
    }
}
