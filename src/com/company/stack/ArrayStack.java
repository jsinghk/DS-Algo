package com.company.stack;

import com.company.list.Employee;

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity){
        stack= new Employee[capacity];
    }

    public void push(Employee employee){
        if (top == stack.length){
            Employee[] newArray = new Employee[2*stack.length];
            System.arraycopy(stack,0,newArray,0,stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }

    public Employee pop(){
        if (top == 0){
            throw new EmptyStackException();
        }

        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    public Employee peek(){
        if (top == 0){
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public void printStack(){
        for (int i=top-1;i>=0;i--){
            System.out.println(stack[i]);
        }
    }
}
