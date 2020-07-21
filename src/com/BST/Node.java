package com.BST;

import com.UsuariosManager.Usuario;

/***
 * Node class for the BST tree.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
class Node {
    private Usuario data;
    private Node left, right;

    Node(Usuario data)
    {

        this.data = data;
    }

    /***
     * This method returns the 'data' variable.
     * @return Usuario
     */
    public Usuario getData() {
        return data;
    }

    /***
     * This method changes the value of the 'data' variable.
     * @param data Usuario
     */
    public void setData(Usuario data) {
        this.data = data;
    }

    /***
     * This method returns the 'left' variable.
     * @return Node
     */
    public Node getLeft() {
        return left;
    }

    /***
     * This method changes the value of the 'left' variable.
     * @param left Node
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /***
     * This method returns the 'right' variable.
     * @return Node
     */
    public Node getRight() {
        return right;
    }

    /***
     * This method changes the value of the 'right' variable.
     * @param right Node
     */
    public void setRight(Node right) {
        this.right = right;
    }
}
