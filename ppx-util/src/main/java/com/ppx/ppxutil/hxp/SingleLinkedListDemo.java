package com.ppx.ppxutil.hxp;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "宋江2", "及时雨2");
        HeroNode hero3 = new HeroNode(3, "宋江3", "及时雨3");
        HeroNode hero4 = new HeroNode(4, "宋江4", "及时雨4");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.list();
    }

    static class SingleLinkedList {

        public HeroNode head = new HeroNode(0, "", "");

        public void reverseRecurse(HeroNode src, SingleLinkedList dest) {
            if (src != null) {
                reverseRecurse(src.next, dest);
                src.next = null;
//                if (src != head) {
                    dest.add(src);
//                }
            }
        }

        //        public void reverseRecurse(HeroNode src,SingleLinkedList dest){
//            if (src != null) {
//                reverseRecurse(src.next, dest);
//                dest.add(src);
//            }
//            int i=0;
//        }
        public void reveseStack() {
            System.out.println();
            Stack<HeroNode> stack = new Stack<>();
            HeroNode temp = head;
            while (temp.next != null) {
                stack.push(temp.next);
                temp = temp.next;
            }
            temp = head;
            while (stack.size() > 0) {
                temp.next = stack.pop();
                temp = temp.next;
            }
            temp.next = null;
        }

        public void reverseLink(HeroNode head){
            if (head.next == null ||head.next.next==null) {
                return;
            }
            HeroNode cur=head.next;
            HeroNode temp;
            HeroNode reverseHead=new HeroNode(0,"","");
            while (cur != null) {
                temp=cur.next;
                cur.next=reverseHead.next;
                reverseHead.next=cur;
                cur= temp;
            }
            head.next=reverseHead.next;
        }
        // add item to the list
        //if not consider order
        public void add(HeroNode heroNode) {
            HeroNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = heroNode;
        }

        //      add
        public void addByOrder(HeroNode heroNode) {
            HeroNode temp = head;
            boolean flag = false;
            while (temp.next != null) {
                if (temp.next.no > heroNode.no) {
                    break;
                } else if (temp.next.no == heroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                System.out.println(" hero to insert exist, can not add");
            } else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        public void delete(int no) {
            HeroNode temp = head;
            boolean flag = false;
            while (temp.next != null) {
                if (temp.next.no == no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.next = temp.next.next;
            } else {
                System.out.println("item could not be deleted.");
            }
        }

        //
        public void update(HeroNode heroNode) {
            if (head.next == null) {
                return;
            }
            HeroNode temp = head.next;
            boolean flag = false;
            while (temp.next != null) {
                if (temp.no == heroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
            }
        }

        public int getLength(HeroNode head) {
            if (head.next == null) {
                return 0;
            }
            int length = 0;
            HeroNode node = head.next;
            while (node != null) {
                length++;
                node = node.next;
            }
            return length;
        }

        public void list() {
            if (head.next == null) {
                return;
            }
            // head can't be moved
            HeroNode temp = head.next;
            while (temp != null) {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }
    }

    static class HeroNode {
        int no;
        String name;
        String nickName;
        HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
