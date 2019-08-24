package com.ppx.common.message.ppxutil.hxp;

public class Josefu {

    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
        circleSingleLinkedList.showBoy();
    }
}

class CircleSingleLinkedList {
    private Boy first = new Boy(-1);

    /**
     * add boy to form circled linklist
     *
     * @param nums
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums value is not right.");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            // create boy node
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * iterate linked list
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("Linked list is none");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("The num of the boy %d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("input error");
            return;
        }

        Boy helper = first;
//        helper points to the last item of the circle
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();

        }
//
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {
            if (helper == first) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("boy %d get out.\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }

    }
}


class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
