package com.SPLAY;

import com.EmpresasManager.Empresa;
/***
 * Node class for the Splay tree.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
class BinaryNode
{
    private Empresa data;
    private BinaryNode left;
    private BinaryNode right;
    /***
     * Constructor method of the BinaryNode class.
     * @param data Empresa
     */
    public BinaryNode(Empresa data) {
        this.data = data;
        left = right = null;
    }
    /***
     * This method returns the 'data' variable.
     * @return Empresa
     */
    public Empresa getData() {
        return data;
    }
    /***
     * This method changes the value of the 'data' variable.
     * @param data Empresa
     */
    public void setData(Empresa data) {
        this.data = data;
    }
    /***
     * This method returns the 'left' variable.
     * @return BinaryNode
     */
    public BinaryNode getLeft() {
        return left;
    }
    /***
     * This method changes the value of the 'left' variable.
     * @param left BinaryNode
     */
    public void setLeft(BinaryNode left) {
        
        this.left = left;
    }
    /***
     * This method returns the 'right' variable.
     * @return BinaryNode
     */
    public BinaryNode getRight() {
        return right;
    }
    /***
     * This method changes the value of the 'right' variable.
     * @param right BinaryNode
     */
    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
