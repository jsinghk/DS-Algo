package com.company.hashtable;

import com.company.list.Employee;
import java.util.NoSuchElementException;
import static java.lang.String.format;

public class ArrayHashTable {

    private Employee[] hashTable;

    public ArrayHashTable() {
        hashTable = new Employee[10];
    }

    //With Linear Probing
    public void put(Employee employee) {
        int key = hashKey(employee.getId());
        if (occupied(key)) {
            int stopIndex = key;
            if (key == hashTable.length - 1) {
                key = 0;
            } else {
                key++;
            }
            while (occupied(key) && key != stopIndex) {
                key = (key + 1) % hashTable.length;
            }
        }
        if (occupied(key)) {
            System.out.println("Sorry, no empty position to add");
        } else
            hashTable[hashKey(key)] = employee;
    }

    //With Linear Probing
    public Employee get(int key) {
        int hashKey = setKey(key);
        if (hashKey == -1) {
            throw new NoSuchElementException(format("Employee with the Id:%s doesn't exist", key));
        } else {
            return hashTable[hashKey(hashKey)];
        }
    }

    //With Linear Probing
    public Employee remove(int key){
        int hashKey = setKey(key);
        if (hashKey == -1) {
            throw new NoSuchElementException(format("Employee with the Id:%s doesn't exist", hashKey));
        } else {
            Employee employee = hashTable[hashKey(hashKey)];
            hashTable[hashKey(hashKey)] = null;
            return employee;
        }
    }

    public void printHashTable() {
        int i = 0;
        for (Employee employee : hashTable) {
            System.out.println(i++ + " : " + employee);
        }
    }

    private int hashKey(int key) {
        return key % hashTable.length;
    }

    private boolean occupied(int key) {
        return hashTable[key] != null;
    }

    //With Linear Probing
    private int setKey(int key) {
        int hashKey = hashKey(key);
        if (occupied(hashKey) && hashTable[hashKey].getId() == key) {
            return hashKey;
        }

        int stopIndex = hashKey;
        if (hashKey == hashTable.length - 1) {
            hashKey = 0;
        } else {
            hashKey++;
        }
        while (hashKey != stopIndex) {
            if (occupied(hashKey)){
                if (hashTable[hashKey].getId() == key){
                    break;
                }
            }
            hashKey = (hashKey + 1) % hashTable.length;
        }
        if (hashKey == stopIndex){
            return -1;
        } else {
            return hashKey;
        }
    }
}
