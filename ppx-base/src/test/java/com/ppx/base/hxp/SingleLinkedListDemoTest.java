package com.ppx.base.hxp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListDemoTest {

    private SingleLinkedListDemo.SingleLinkedList singleLinkedList;
    SingleLinkedListDemo.HeroNode hero1 = new SingleLinkedListDemo.HeroNode(1, "宋江", "及时雨");
    SingleLinkedListDemo.HeroNode hero2 = new SingleLinkedListDemo.HeroNode(2, "宋江2", "及时雨2");
    SingleLinkedListDemo.HeroNode hero3 = new SingleLinkedListDemo.HeroNode(3, "宋江3", "及时雨3");
    SingleLinkedListDemo.HeroNode hero4 = new SingleLinkedListDemo.HeroNode(4, "宋江4", "及时雨4");

    @Before
    public void setUp() throws Exception {
        singleLinkedList = new SingleLinkedListDemo.SingleLinkedList();
    }

    @Test
    public void test_addOrder() {
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.list();
    }
    @Test
    public void test_addnoOrder(){
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
    }

    @Test
    public void test_reverse(){
        test_addnoOrder();
        singleLinkedList.reveseStack();
        singleLinkedList.list();
    }
    @Test
    public void test_reverseRecuise(){
        test_addnoOrder();
        SingleLinkedListDemo.SingleLinkedList dest=new SingleLinkedListDemo.SingleLinkedList();
        singleLinkedList.reverseRecurse(singleLinkedList.head.next,dest);
        dest.list();
    }

    @Test
    public void test_reverseList(){
        test_addnoOrder();
        singleLinkedList.reverseLink(singleLinkedList.head);
        singleLinkedList.list();
    }
}