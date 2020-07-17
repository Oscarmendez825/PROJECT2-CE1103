package com.UsuariosManager;

import com.RecetasManager.Receta;
import com.StackPackage.Stack;

public class NewsFeed {

    Stack stack = new Stack();


    public NewsFeed(){


    }
    public void agregarReceta(Receta receta){
        stack.push(receta);

    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }
}
