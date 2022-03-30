package com.company.hashtable;

import com.company.list.Employee;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static java.lang.String.format;

public class ChainedHashTable {

    private LinkedList<Employee>[] hashTable;

    public ChainedHashTable() {
        hashTable = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            hashTable[i] = new LinkedList<Employee>();
        }
    }

    public void put(Employee employee) {
        int key = hashKey(employee.getId());
        hashTable[key].add(employee);
    }

    public Employee get(int key) {
        int hashKey = hashKey(key);
        Employee getEmployee = null;
        for (Employee employee : hashTable[hashKey]) {
            if (employee.getId() == key) {
                getEmployee = employee;
                break;
            }
        }
        if (getEmployee == null) {
            throw new NoSuchElementException(format("Employee with the Id:%s doesn't exist", key));
        }

        return getEmployee;
    }

    public Employee remove(int key) {
        int hashKey = hashKey(key);
        Employee getEmployee = null;
        int index = 0;
        for (Employee employee : hashTable[hashKey]) {
            if (employee.getId() == key) {
                getEmployee = employee;
                break;
            }
            index++;
        }
        if (getEmployee != null) {
            hashTable[hashKey].remove(index);
        } else {
            throw new NoSuchElementException(format("Employee with the Id:%s doesn't exist", key));
        }

        return getEmployee;
    }

    public void printHashTable() {
        int i = 0;
        for (LinkedList<Employee> list : hashTable) {
            int j = 0;
            if (list.isEmpty()) {
                System.out.println(i++ + "-" + j + " : null");
                continue;
            }
            for (Employee employee : list) {
                System.out.println(i + "-" + j++ + " : " + employee);
            }
            i++;
        }
    }

    private int hashKey(int key) {
        return key % hashTable.length;
    }

}
