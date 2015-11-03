package com.baseev.stack;

public interface Stack<E>
{
    public E getTop();
    public E pop();
    public void push(E item);
    public boolean isEmpty();
    public int size();
}
