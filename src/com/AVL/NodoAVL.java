package com.AVL;

import com.RecetasManager.Receta;
/***
 * Node class for the AVL tree.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class NodoAVL  {
    private Receta item;
    private NodoAVL parent;
    private boolean isLeftChild = false;
    private NodoAVL leftChild;
    private NodoAVL rightChild;
    private int leftHeight;
    private int rightHeight;
    /***
     * This method returns the 'isleftchild' variable.
     * @return Boolean
     */
    public boolean getIsLeftChild() {
        return isLeftChild;
    }
    /***
     * This method changes the value of the 'isleftchild' variable.
     * @param leftChild Boolean
     */
    public void setIsLeftChild(boolean leftChild) {
        isLeftChild = leftChild;
    }
    /***
     * This method returns the 'parent' variable.
     * @return NodoAVL
     */
    public NodoAVL getParent() {
        return parent;
    }
    /***
     * This method changes the value of the 'parent' variable.
     * @param parent NodoAVL
     */
    public void setParent(NodoAVL parent) {

        this.parent = parent;
    }


    /***
     * This method returns the 'item' variable.
     * @return Receta
     */
    public Receta getItem() {
        return item;
    }
    /***
     * This method changes the value of the 'item' variable.
     * @param item Receta
     */
    public void setItem(Receta item) {
        this.item = item;
    }
    /***
     * This method returns the 'leftchild' variable.
     * @return NodoAVL
     */
    public NodoAVL getLeftChild() {
        return leftChild;
    }
    /***
     * This method changes the value of the 'leftChild' variable.
     * @param leftChild NodoAVL
     */
    public void setLeftChild(NodoAVL leftChild) {
        this.leftChild = leftChild;
    }
    /***
     * This method returns the 'rightchild' variable.
     * @return NodoAVL
     */
    public NodoAVL getRightChild() {
        return rightChild;
    }
    /***
     * This method changes the value of the 'rightChild' variable.
     * @param rightChild NodoAVL
     */
    public void setRightChild(NodoAVL rightChild) {
        this.rightChild = rightChild;
    }
    /***
     * This method returns the 'leftHeight' variable.
     * @return Integer
     */
    public int getLeftHeight() {
        return leftHeight;
    }
    /***
     * This method changes the value of the 'leftHeight' variable.
     * @param leftHeight Integer
     */
    public void setLeftHeight(int leftHeight) {
        this.leftHeight = leftHeight;
    }
    /***
     * This method returns the 'rightHeight' variable.
     * @return Integer
     */
    public int getRightHeight() {
        return rightHeight;
    }
    /***
     * This method changes the value of the 'rightHeight' variable.
     * @param rightHeight Integer
     */
    public void setRightHeight(int rightHeight) {
        this.rightHeight = rightHeight;
    }
}
