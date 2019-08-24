package com.ppx.message.ppxutil.hxp;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {

    }

    static class CircleArrayQueue{
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;

        public CircleArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            arr=new int[maxSize];
        }

        private boolean isFull() {
            return (rear+1)%maxSize==front;
        }

        private boolean isEmpty(){
            return rear==front;
        }

        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("Full");
                return;
            }
            arr[rear]=n;
            rear=(rear+1)%maxSize;
 
        }

        public void showQueue(){
            if (isEmpty()) {
                System.out.println("empty");
                return;
            }
            for (int i = front; i < front+size(); i++) {
                System.out.printf("arr[%d]=%d \n",i,arr[i]);
            }
        }

        public int size(){
            return (rear+maxSize-front)%maxSize;
        }


    }
}
