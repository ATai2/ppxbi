package com.ppx.common.message.ppxutil.multithread;//package com.ppx.com.ppx.common.base.multithread;
//
//import akka.actor.AbstractActor;
//import akka.actor.ActorSelection;
//
//public class ProduceMsgActor extends AbstractActor {
//    @Override
//    public Receive createReceive() {
//        return receiveBuilder()
//                .match(String.class, t->{
//                    System.out.println(self()+" receive msg from "+sender()+":"+t);
//                    Msg msg=new Msg("haha");
//                    System.out.println(self() + " produce msg: " + msg.getContent());
//
//                    ActorSelection nextDisposeRefs = getContext().actorSelection("/user/DisposeMsgActor");
//
//                    nextDisposeRefs.tell(msg,self());
//                })
//                .matchAny(t->{
//                    System.out.println("no disposer.");
//                })
//                .build();
//    }
//}
