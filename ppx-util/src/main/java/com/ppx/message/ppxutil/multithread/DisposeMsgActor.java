package com.ppx.message.ppxutil.multithread;//package com.ppx.base.multithread;
//
//import akka.actor.AbstractActor;
//
//public class DisposeMsgActor extends AbstractActor {
//    @Override
//    public Receive createReceive() {
//        return receiveBuilder().match(Msg.class, t -> {
//            //收到消息
//            System.out.println(self() + "  receive msg  from " + sender() + ": " + t.getContent());
//            System.out.println(self() + " dispose msg : " + t.getContent());
//        }).matchAny(t -> {
//            System.out.println("no disposer");
//        }).build();
//    }
//}
