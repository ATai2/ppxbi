package com.ppx.common.ppxutil.demos.hxp;

public class DoubleLinkedDemo {
    public static void main2(String[] args) {

    }

    static class DoubleLinkedList {

        private HeroNode2 head;

        public HeroNode2 getHead() {
            return head;
        }

        public void add(HeroNode2 heroNode) {
            HeroNode2 temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = heroNode;
            heroNode.pre = temp;
        }

        public void update(HeroNode2 heroNode) {
            if (head.next == null) {
                return;
            }
            HeroNode2 temp = head.next;
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

        public void delete(int no) {

            if (head.next == null) {
                System.out.println("Link is empty");
                return;
            }

            HeroNode2 temp = head.next;
            boolean flag = false;
            while (temp.next != null) {
                if (temp.next.no == no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.println("item could not be deleted.");
            }
        }

        public void list(HeroNode2 head) {
            if (head.next == null) {
                return;
            }
            // head can't be moved
            HeroNode2 temp = head.next;
            while (temp != null) {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }
    }

    static class HeroNode2 {
        int no;
        String name;
        String nickName;
        HeroNode2 pre;
        HeroNode2 next;

        public HeroNode2(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode2{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
