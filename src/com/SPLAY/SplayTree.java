package com.SPLAY;


import com.EmpresasManager.Empresa;
/***
 * Splay tree class; stores the info of each created company.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class SplayTree {
    private BinaryNode root;
    /***
     * Constructor method of the SplayTree class.\
     */
    public SplayTree() {
        root = null;
    }

    /**
     * This method inserts a new company into the tree.
     * @param data Empresa
     */
    public void insert(Empresa data) {
        BinaryNode n;
        int c;
        if (root == null) {
            root = new BinaryNode(data);
            return;
        }
        splay(data);
        if ((c = data.getNombre().compareTo(root.getData().getNombre())) == 0) {

            return;
        }
        n = new BinaryNode(data);
        if (c < 0) {
            n.setLeft(root.getLeft());
            n.setRight(root);
            root.setLeft(null);
        } else {
            n.setRight(root.getRight());
            n.setLeft(root);
            root.setRight(null);
        }
        root = n;
    }

    /**
     * This method removes a company from the tree.
     * @param data Empresa
     */
    public void remove(Empresa data) {
        BinaryNode x;
        splay(data);
        if (data.getNombre().compareTo(root.getData().getNombre()) != 0) {

            return;
        }

        if (root.getLeft() == null) {
            root = root.getRight();
        } else {
            x = root.getRight();
            root = root.getLeft();
            splay(data);
            root.setRight(x);
        }
    }

    /**
     * This method finds the smallest item in the tree.
     * @return Empresa
     */
    public Empresa findMin() {
        BinaryNode x = root;
        if(root == null) return null;
        while(x.getLeft() != null) x = x.getLeft();
        splay(x.getData());
        return x.getData();
    }

    /**
     * This method finds the largest item in the tree.
     * @return Empresa
     */
    public Empresa findMax() {
        BinaryNode x = root;
        if(root == null) return null;
        while(x.getRight() != null) x = x.getRight();
        splay(x.getData());
        return x.getData();
    }

    /**
     * This method finds an item in the tree.
     * @param data String
     * @return Empresa
     */
    public Empresa find(String data) {
        if (root == null) {
            return null;
        }
        splay(data);
        if(root.getData().getNombre().compareTo(data) != 0) {
            return null;
        }
        return root.getData();
    }
    /***
     * This method verifies if an item is in the tree.
     * @param data String
     * @return Boolean
     */
    public boolean contains(String data) {
        if (root == null) {
            return false;
        }
        splay(data);
        if(root.getData().getNombre().compareTo(data) != 0) {
            return false;
        }
        return true;
    }

    /**
     * This method tests if the tree is logically empty.
     * @return Boolean
     */
    public boolean isEmpty() {
        return root == null;
    }

    /***
     * This method moves a node to the root.
     * @param data Empresa
     */
    private void moveToRoot(Empresa data) {
        BinaryNode l, r, t, y;
        l = r = header;
        t = root;
        header.setLeft(null);
        header.setRight(null);
        for (;;) {
            if (data.getNombre().compareTo(t.getData().getNombre()) < 0) {
                if (t.getLeft() == null) break;
                r.setLeft(t);
                r = t;
                t = t.getLeft();
            } else if (data.getNombre().compareTo(t.getData().getNombre()) > 0) {
                if (t.getRight() == null) break;
                l.setRight(t);
                l = t;
                t = t.getRight();
            } else {
                break;
            }
        }
        l.setRight(t.getLeft());
        r.setLeft(t.getRight());
        t.setLeft(header.getRight());
        t.setRight(header.getLeft());
        root = t;
    }

    private static BinaryNode header = new BinaryNode(null);

    /***
     * This method applies the 'splay' characteristic sorting operation on a node.
     * @param data Empresa
     */
    private void splay(Empresa data) {
        BinaryNode l, r, t, y;
        l = r = header;
        t = root;
        header.setLeft(null);
        header.setRight(null);
        for (;;) {
            if (data.getNombre().compareTo(t.getData().getNombre()) < 0) {
                if (t.getLeft() == null) break;
                if (data.getNombre().compareTo(t.getLeft().getData().getNombre()) < 0) {
                    y = t.getLeft();
                    t.setLeft(y.getRight());
                    y.setRight(t);
                    t = y;
                    if (t.getLeft() == null) break;
                }
                r.setLeft(t);
                r = t;
                t = t.getLeft();
            } else if (data.getNombre().compareTo(t.getData().getNombre()) > 0) {
                if (t.getRight() == null) break;
                if (data.getNombre().compareTo(t.getRight().getData().getNombre()) > 0) {
                    y = t.getRight();
                    t.setRight(y.getLeft());
                    y.setLeft(t);
                    t = y;
                    if (t.getRight() == null) break;
                }
                l.setRight(t);
                l = t;
                t = t.getRight();
            } else {
                break;
            }
        }
        l.setRight(t.getLeft());
        r.setLeft(t.getRight());
        t.setLeft(header.getRight());
        t.setRight(header.getLeft());
        root = t;
    }
    /***
     * This method applies the 'splay' characteristic sorting operation on a node.
     * @param data String
     */
    private void splay(String data) {
        BinaryNode l, r, t, y;
        l = r = header;
        t = root;
        header.setLeft(null);
        header.setRight(null);
        for (;;) {
            if (data.compareTo(t.getData().getNombre()) < 0) {
                if (t.getLeft() == null) break;
                if (data.compareTo(t.getLeft().getData().getNombre()) < 0) {
                    y = t.getLeft();
                    t.setLeft(y.getRight());
                    y.setRight(t);
                    t = y;
                    if (t.getLeft() == null) break;
                }
                r.setLeft(t);
                r = t;
                t = t.getLeft();
            } else if (data.compareTo(t.getData().getNombre()) > 0) {
                if (t.getRight() == null) break;
                if (data.compareTo(t.getRight().getData().getNombre()) > 0) {
                    y = t.getRight();
                    t.setRight(y.getLeft());
                    y.setLeft(t);
                    t = y;
                    if (t.getRight() == null) break;
                }
                l.setRight(t);
                l = t;
                t = t.getRight();
            } else {
                break;
            }
        }
        l.setRight(t.getLeft());
        r.setLeft(t.getRight());
        t.setLeft(header.getRight());
        t.setRight(header.getLeft());
        root = t;
    }



}