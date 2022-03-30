package com.company.list;

public class EmployeeDoublyNode extends EmployeeNode{

    private EmployeeDoublyNode previous;

    public EmployeeDoublyNode(Employee employee) {
        super(employee);
    }

    public EmployeeDoublyNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeDoublyNode previous) {
        this.previous = previous;
    }
}
