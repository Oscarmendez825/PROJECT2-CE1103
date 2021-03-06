package com.AVL;


import com.RecetasManager.Receta;
/***
 * AVL tree class; stores the personal recipes of each user.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class AVLTree {

    private NodoAVL root;

    public void printAll(){

        printAll(root);
    }
    /***
     *this method prints the data of all the nodes in the tree.
     * @param root NodoAVL
     */
    public void printAll(NodoAVL root) {
        if(root!=null) {
            System.out.print(root.getItem()+" "+"leftHeight: "+root.getLeftHeight()+", rightHeight: "+root.getRightHeight()+"\n");
            printAll(root.getLeftChild());
            printAll(root.getRightChild());

        }
    }
    /***
     * Facade method for the true 'contains' method
     * @param item String
     * @return Boolean
     */
    public boolean contains(String item){
        return contains(root, item);

    }
    /***
     * this method verifies if a certain item is in the tree.
     * @param root NodoAVL
     * @param item String
     * @return Boolean
     */
    public boolean contains(NodoAVL root,String item){
        if(root==null) {
            return false;
        } else if(item.compareTo(root.getItem().getName())<0) {
            return contains(root.getLeftChild(),item);
        } else if(item.compareTo(root.getItem().getName())>0) {
            return contains(root.getRightChild(),item);
        } else {
            return true;
        }
    }
    /***
     * Facade method for the true 'search' method.
     * @param item String
     * @return Receta
     */
    public Receta search(String item) {

        return search(root,item);
    }
    /***
     * this recursive method finds a certain item in the tree, and returns it.
     * @param root NodoAVL
     * @param item String
     * @return Receta
     */
    public Receta search(NodoAVL root,String item){
        if(root==null) {
            return null;
        } else if(item.compareTo(root.getItem().getName())<0) {
            return search(root.getLeftChild(),item);
        } else if(item.compareTo(root.getItem().getName())>0) {
            return search(root.getRightChild(),item);
        } else {
            return root.getItem();
        }
    }
    /***
     * Facade method for the true 'delete' method.
     * @param item Receta
     */
    public void delete(Receta item) {

        delete(root, item);
    }
    /***
     * This recursive method deletes a recipe from the actual tree.
     * @param root NodoAVL
     * @param item Receta
     */
    public void delete(NodoAVL root,Receta item) {
        if(root==null) {
        } else if(item.getName().compareTo(root.getItem().getName())<0) {
            delete(root.getLeftChild(),item);
        } else if(item.getName().compareTo(root.getItem().getName())>0) {
            delete(root.getRightChild(),item);
        } else {
            if(root.getLeftChild()==null) {
                if(root.getRightChild()==null) {
                    //leaf node
                    if(root.getIsLeftChild()) {
                        root.getParent().setLeftChild(null);
                        root.setParent(null);
                    } else {
                        if(root.getParent()==null) {
                            root = null;
                        } else {
                            root.getParent().setRightChild(null);
                            root.setParent(null);
                        }
                    }
                } else {
                    if(root.getIsLeftChild()) {
                        root.getParent().setLeftChild(root.getRightChild());
                        root.getRightChild().setParent(root.getParent());
                        root.setParent(null);
                        root.setRightChild(null);

                    } else {
                        if(root.getParent()==null) {
                            root = root.getRightChild();
                            root.setParent(null);
                        } else {
                            root.getParent().setRightChild(root.getRightChild());
                            root.getRightChild().setParent(root.getParent());
                            root.setParent(null);
                            root.setRightChild(null);
                        }
                    }
                }
            } else {
                if(root.getRightChild()==null) {
                    if(root.getIsLeftChild()) {
                        root.getParent().setLeftChild(root.getLeftChild());
                        root.getLeftChild().setParent(root.getParent());
                        root.setParent(null);
                        root.setLeftChild(null);
                    } else {
                        if(root.getParent()==null) {
                            root = root.getLeftChild();
                            root.setParent(null);
                        } else {
                            root.getParent().setRightChild(root.getLeftChild());
                            root.getLeftChild().setParent(root.getParent());
                            root.setParent(null);
                            root.setLeftChild(null);
                        }
                    }
                } else {
                    NodoAVL tmp = getSmallest(root.getRightChild());
                    Receta tmpKey = tmp.getItem();
                    root.setItem(tmpKey);
                    tmp.getParent().setLeftChild(null);
                    tmp.setParent(null);
                }
            }
        }
    }
    /***
     * this method finds and returns the actual smallest item of the tree.
     * @param root NodoAVL
     * @return NodoAVL
     */
    public NodoAVL getSmallest(NodoAVL root) {
        NodoAVL node = root;
        while(node.getLeftChild()!=null) {
            node = node.getLeftChild();
        }
        return node;
    }
    /***
     * Facade method of the true 'insert' method.
     * @param item Receta
     */
    public void insert(Receta item) {
        if(root==null) {
            root = new NodoAVL();
            root.setItem(item);
        } else {
            insert(root, item);
        }
    }
    /***
     * This recursive method inserts a new recipe in the tree.
     * @param root NodoAVL
     * @param item Receta
     */
    private void insert(NodoAVL root,Receta item) {
        if(item.getName().compareTo(root.getItem().getName())<0) {
            if(root.getLeftChild()==null) {
                NodoAVL node = new NodoAVL();
                node.setItem(item);
                root.setLeftChild(node);
                root.setLeftHeight(1);
                node.setParent(root);
                node.setIsLeftChild(true);
                rebalance(root);
            } else {
                insert(root.getLeftChild(),item);
            }
        } else if(item.getName().compareTo(root.getItem().getName())>0) {
            if(root.getRightChild()==null) {
                NodoAVL node = new NodoAVL();
                node.setItem(item);
                root.setRightChild(node);
                root.setRightHeight(1);
                node.setParent(root);
                node.setIsLeftChild(false);
                rebalance(root);
            } else {
                insert(root.getRightChild(),item);
            }
        }
    }
    /***
     * This method does rotations and rebalances the tree.
     * @param root NodoAVL
     */
    public void rebalance(NodoAVL root) {
        if(getDiff(root)>1) {
            if(getDiff(root.getLeftChild())>=0) {
                LLRotation(root);
            } else {
                LRRotation(root);
            }
            root = root.getParent();

        } else if(getDiff(root)<-1){
            if(getDiff(root.getRightChild())<=0) {
                RRRotation(root);
            } else {
                RLRotation(root);
            }
            root = root.getParent();

        }

        if(root.getParent()!=null) {
            if(root.getIsLeftChild()) {
                root.getParent().setLeftHeight(1+Math.max(root.getLeftHeight(),root.getRightHeight()));
                rebalance(root.getParent());
            } else {
                root.getParent().setRightHeight(1+Math.max(root.getLeftHeight(),root.getRightHeight()));
                rebalance(root.getParent());
            }
        }

    }
    /***
     * This method returns the height difference between both left and right branches of the tree.
     * @param root NodoAVL
     * @return Integer
     */
    public int getDiff(NodoAVL root) {
        if(root==null) return 0;
        return root.getLeftHeight()-root.getRightHeight();
    }
    /***
     * This methos does a node rotation to the left.
     * @param root NodoAVL
     */
    public void LLRotation(NodoAVL root) {
        // LL Rotation
        NodoAVL leftChild = root.getLeftChild();
        NodoAVL grandParent = root.getParent();
        boolean rootIsLeft = root.getIsLeftChild();
        // root 와 leftChild disconnect
        leftChild.setParent(null);
        root.setLeftChild(null);
        root.setLeftHeight(0);
        root.setIsLeftChild(false);
        if(leftChild.getRightHeight()!=0) {
            //root 와 leftChild의 rightChild connect
            root.setLeftChild(leftChild.getRightChild());
            root.setLeftHeight(leftChild.getRightHeight());
            leftChild.getRightChild().setParent(root);
            leftChild.getRightChild().setIsLeftChild(true);
        }
        leftChild.setRightChild(root);
        root.setParent(leftChild);
        leftChild.setRightHeight(1+root.getRightHeight());
        if(rootIsLeft) {
            grandParent.setLeftChild(leftChild);
            grandParent.setLeftHeight(1+Math.max(leftChild.getLeftHeight(),leftChild.getRightHeight()));
            leftChild.setParent(grandParent);
            leftChild.setIsLeftChild(true);
        } else {
            if(grandParent!=null) {
                grandParent.setRightChild(leftChild);
                grandParent.setRightHeight(1+Math.max(leftChild.getLeftHeight(),leftChild.getRightHeight()));
                leftChild.setParent(grandParent);
            } else {
                this.root = leftChild;
            }
            leftChild.setIsLeftChild(false);

        }
    }


    /***
     * This method does a rotation to the right.
     * @param root NodoAVL
     */
    public void RRRotation(NodoAVL root) {
        // LL Rotation
        NodoAVL rightChild = root.getRightChild();
        NodoAVL grandParent = root.getParent();
        boolean rootIsLeft = root.getIsLeftChild();
        // root 와 rightChild disconnect
        rightChild.setParent(null);
        root.setRightChild(null);
        root.setRightHeight(0);
        root.setIsLeftChild(true);
        if(rightChild.getLeftHeight()!=0) {
            //root 와 rightChild의 leftChild connect
            root.setRightChild(rightChild.getLeftChild());
            root.setRightHeight(rightChild.getLeftHeight());
            rightChild.getLeftChild().setParent(root);
            rightChild.getLeftChild().setIsLeftChild(false);
        }
        rightChild.setLeftChild(root);
        root.setParent(rightChild);
        rightChild.setLeftHeight(1+Math.max(root.getLeftHeight(),root.getRightHeight()));
        if(rootIsLeft) {
            grandParent.setLeftChild(rightChild);
            grandParent.setLeftHeight(1+Math.max(rightChild.getLeftHeight(),rightChild.getRightHeight()));
            rightChild.setParent(grandParent);
            rightChild.setIsLeftChild(true);
        } else {
            if(grandParent!=null) {
                grandParent.setRightChild(rightChild);
                grandParent.setRightHeight(1+Math.max(rightChild.getLeftHeight(),rightChild.getRightHeight()));
                rightChild.setParent(grandParent);
            } else {
                this.root = rightChild;
            }
            rightChild.setIsLeftChild(false);
        }
    }
    /***
     * This method does a LR rotation on a given node.
     * @param root NodoAVL
     */
    public void LRRotation(NodoAVL root) {
        RRRotation(root.getLeftChild());
        LLRotation(root);
    }
    /***
     * This method does a RL rotation on a given node.
     * @param root NodoAVL
     */
    public void RLRotation(NodoAVL root) {
        LLRotation(root.getRightChild());
        RRRotation(root);
    }
}
