package test;

import DataStructure.LinkedList;

public class LinkedListTest {

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.insertData(3);
        list.insertData(6);
        list.insertData(5);
        list.insertData(8);
        list.insertData(4);
        list.insertData(2);
        list.insertData(1);
        list.insertData(7);
        list.insertData(9);
        list.reverse();
        list.removeData();
        list.removeData();
        list.removeData();
        list.removeData();
    }
}
