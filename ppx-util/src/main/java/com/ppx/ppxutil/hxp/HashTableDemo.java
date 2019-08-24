package com.ppx.ppxutil.hxp;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab=new HashTab(7);
        String key="";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: add emp");
            System.out.println("list: add emp");
            System.out.println("exit: add emp");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("Please input id:");
                    int id = scanner.nextInt();
                    System.out.println("Input name:");
                    String name=scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":

                    break;
                default:
                    break;
            }
        }
    }

    static class HashTab {
        EmpLinkedList[] empLinkedListArray;
        int size;
        public HashTab(int size) {
            this.size=size;
            this.empLinkedListArray = new EmpLinkedList[size];
            for (int i = 0; i < size; i++) {
                empLinkedListArray[i]=new EmpLinkedList();
            }
        }

        void add(Emp emp) {
            int empLinkedListNo = hashFun(emp.id);
            empLinkedListArray[empLinkedListNo].add(emp);
        }
        void list(){
            for (int i = 0; i < size; i++) {
                empLinkedListArray[i].list();
            }
        }

        void findEmpById(int id) {

        }

        int hashFun(int id) {
            return id % size;
        }
    }
    static class Emp {
        int id;
        String name;
        Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class EmpLinkedList {
        private Emp head;

        public void add(Emp emp) {
            if (head == null) {
                head=emp;
            }
        }
        void list() {

        }

        void list(int no) {
            if (head == null) {
                System.out.println("LinkedList["+no+"] is null");
                return;
            }
            System.out.println("LinkedList["+no+"] info:");
            Emp curEmp=head;
            while (true) {
                System.out.println(curEmp.toString());
                if (curEmp.next == null) {
                    break;
                }
                curEmp=curEmp.next;
            }
        }

        Emp findEmpById(int id) {
            if (head == null) {
                System.out.println("empty");
                return null;
            }
            Emp currEmp=head;
            while (true) {
                if (currEmp.id == id) {
                    break;
                }
                if (currEmp.next == null) {
                    currEmp=null;
                    break;
                }
                currEmp=currEmp.next;
            }
            return currEmp;
        }
    }
}
