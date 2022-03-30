package com.company.stack;

import com.company.list.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class ListStack {

    private LinkedList<Employee> stack;

    public ListStack(){
        stack = new LinkedList<>();
    }

    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee peek(){
        return stack.peek();
    }

    public Employee pop(){
        return stack.pop();
    }

    public void printStack(){
        Iterator<Employee> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
