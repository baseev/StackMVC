package com.baseev.stack;

import java.util.List;

import com.baseev.stack.impl.ArrayStack;

public class StackFactory
{
    private static ArrayStack<Integer> arrayStack;
    
    public static void createInstance(Integer size) {
        arrayStack = new ArrayStack<Integer>(size);
    }

    public static Integer getTop() {
        return arrayStack.getTop();
    }
    
    public static boolean isEmpty() {
        return arrayStack.isEmpty();
    }
    
    public static Integer pop() {
        return arrayStack.pop();
    }
    
    public static void push(Integer item) {
        arrayStack.push(item);
    }
    
    public static int size() {
        return arrayStack.size();
    }
    
    public static List<Integer> list() {
        return arrayStack.list();
    }
}
