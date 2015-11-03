package com.baseev.stack.impl;

import java.util.ArrayList;
import java.util.List;

import com.baseev.stack.Stack;

public class ArrayStack<E>
    implements Stack<E>
{

    private E container[];
    private int top;
    private final static int DEFAULT_SIZE = 10;
    
    public ArrayStack (int initSize)
    {
        container = (E[]) new Object [initSize];
        top = -1;
    }
    
    public E getTop()
    {
        if (top == -1)
            return null;
        return container[top];
    }
 
    public boolean isEmpty()
    {
        return (top == -1);
    }
 
    public E pop()
    {
        if (top == -1)
            return null;
        return container[top--];
    }
 
    public void push(E itm)
    {
        container[++top] = itm;
    }
 
    public int size()
    {
        return (top + 1);
    }
    
    public List<E> list(){
        List<E> list= new ArrayList<E>();
        for(int i=0; i<=top; i++) {
            list.add(container[i]);
        }
        return list;
    }
}
