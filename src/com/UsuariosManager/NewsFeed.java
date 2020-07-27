package com.UsuariosManager;

import com.RecetasManager.Receta;
import com.StackPackage.Stack;
/***
 * This class is the template for the user's NewsFeed, section of recent posts of people the user follows.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class NewsFeed {

    Stack stack = new Stack();

    /***
     * Constructor method ofb the 'NewsFeed' class.
     */
    public NewsFeed(){


    }
    /***
     * This method adds other recipe to show in the stack of the user's NewsFeed.
     * @param receta Receta
     */
    public void agregarReceta(Receta receta){
        stack.push(receta);

    }
    /***
     * This method obtain the whole stack from the NewsFeed.
     * @return Stack
     */
    public Stack getStack() {
        return stack;
    }
    /***
     * This method sets a different stack to the NewsFeed.
     * @param stack Stack
     */
    public void setStack(Stack stack) {
        this.stack = stack;
    }
}
