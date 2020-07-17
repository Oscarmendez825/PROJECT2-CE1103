package com.SPLAY;


import com.EmpresasManager.Empresa;

public class SplayTree {
    private BinaryNode root;

    public SplayTree() {
        root = null;
    }

    /**
     * Insert into the tree.
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
            //	    throw new DuplicateItemException(x.toString());
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
     * Remove from the tree.
     */
    public void remove(Empresa data) {
        BinaryNode x;
        splay(data);
        if (data.getNombre().compareTo(root.getData().getNombre()) != 0) {
            //            throw new ItemNotFoundException(x.toString());
            return;
        }
        // Now delete the root
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
     * Find the smallest item in the tree.
     */
    public Empresa findMin() {
        BinaryNode x = root;
        if(root == null) return null;
        while(x.getLeft() != null) x = x.getLeft();
        splay(x.getData());
        return x.getData();
    }

    /**
     * Find the largest item in the tree.
     */
    public Empresa findMax() {
        BinaryNode x = root;
        if(root == null) return null;
        while(x.getRight() != null) x = x.getRight();
        splay(x.getData());
        return x.getData();
    }

    /**
     * Find an item in the tree.
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
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /** this method just illustrates the top-down method of
     * implementing the move-to-root operation
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
                r.setLeft(t);                                 /* link right */
                r = t;
                t = t.getLeft();
            } else if (data.getNombre().compareTo(t.getData().getNombre()) > 0) {
                if (t.getRight() == null) break;
                l.setRight(t);                                /* link left */
                l = t;
                t = t.getRight();
            } else {
                break;
            }
        }
        l.setRight(t.getLeft());                                   /* assemble */
        r.setLeft(t.getRight());
        t.setLeft(header.getRight());
        t.setRight(header.getLeft());
        root = t;
    }

    private static BinaryNode header = new BinaryNode(null); // For splay


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
                    y = t.getLeft();                            /* rotate right */
                    t.setLeft(y.getRight());
                    y.setRight(t);
                    t = y;
                    if (t.getLeft() == null) break;
                }
                r.setLeft(t);                                 /* link right */
                r = t;
                t = t.getLeft();
            } else if (data.getNombre().compareTo(t.getData().getNombre()) > 0) {
                if (t.getRight() == null) break;
                if (data.getNombre().compareTo(t.getRight().getData().getNombre()) > 0) {
                    y = t.getRight();                            /* rotate left */
                    t.setRight(y.getLeft());
                    y.setLeft(t);
                    t = y;
                    if (t.getRight() == null) break;
                }
                l.setRight(t);                                /* link left */
                l = t;
                t = t.getRight();
            } else {
                break;
            }
        }
        l.setRight(t.getLeft());                                   /* assemble */
        r.setLeft(t.getRight());
        t.setLeft(header.getRight());
        t.setRight(header.getLeft());
        root = t;
    }
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
                    y = t.getLeft();                            /* rotate right */
                    t.setLeft(y.getRight());
                    y.setRight(t);
                    t = y;
                    if (t.getLeft() == null) break;
                }
                r.setLeft(t);                                 /* link right */
                r = t;
                t = t.getLeft();
            } else if (data.compareTo(t.getData().getNombre()) > 0) {
                if (t.getRight() == null) break;
                if (data.compareTo(t.getRight().getData().getNombre()) > 0) {
                    y = t.getRight();                            /* rotate left */
                    t.setRight(y.getLeft());
                    y.setLeft(t);
                    t = y;
                    if (t.getRight() == null) break;
                }
                l.setRight(t);                                /* link left */
                l = t;
                t = t.getRight();
            } else {
                break;
            }
        }
        l.setRight(t.getLeft());                                   /* assemble */
        r.setLeft(t.getRight());
        t.setLeft(header.getRight());
        t.setRight(header.getLeft());
        root = t;
    }



}