package com.ppx.learn.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanFactory {
    /**
     *
     */
    Map<String,Object> map = new HashMap<String,Object>();
    public BeanFactory(String xml){
        parseXml(xml);
    }

    public void parseXml(String xml) throws LubanSpringException{

        File file = new File(this.getClass().getResource("/").getPath()+"//"+xml);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element elementRoot = document.getRootElement();
            Attribute attribute = elementRoot.attribute("default");
            boolean flag=false;
            if (attribute!=null){
                flag=true;
            }
            for (Iterator<Element> itFirlst = elementRoot.elementIterator(); itFirlst.hasNext();) {
                /**
                 * setup1、实例化对象
                 */
                Element elementFirstChil = itFirlst.next();
                Attribute attributeId = elementFirstChil.attribute("id");
                String beanName = attributeId.getValue();
                Attribute attributeClass = elementFirstChil.attribute("class");
                String clazzName  = attributeClass.getValue();
                Class clazz = Class.forName(clazzName);

                /**
                 * 维护依赖关系
                 * 看这个对象有没有依赖（判断是否有property。或者判断类是否有属性）
                 * 如果有则注入
                 */
                Object object = null;
                for (Iterator<Element> itSecond = elementFirstChil.elementIterator(); itSecond.hasNext();){
                    // 得到ref的value，通过value得到对象（map）
                    // 得到name的值，然后根据值获取一个Filed的对象
                    //通过field的set方法set那个对象

                    //<property name="dao" ref="dao"></property>
                    Element elementSecondChil = itSecond.next();
                    if(elementSecondChil.getName().equals("property")){
                        //由於是setter，沒有特殊的構造方法
                        object= clazz.newInstance();
                        String refVlaue = elementSecondChil.attribute("ref").getValue();
                        Object injetObject= map.get(refVlaue) ;
                        String nameVlaue = elementSecondChil.attribute("name").getValue();
                        Field field = clazz.getDeclaredField(nameVlaue);
                        field.setAccessible(true);
                        field.set(object,injetObject);
                    }else{
                        //證明有特殊構造
                        String refVlaue = elementSecondChil.attribute("ref").getValue();
                        Object injetObject= map.get(refVlaue) ;
                        Class injectObjectClazz = injetObject.getClass();
                        Constructor constructor = clazz.getConstructor(injectObjectClazz.getInterfaces()[0]);
                        object = constructor.newInstance(injetObject);
                    }

                }
                if(object==null) {
                    if (flag) {
                        if (attribute.getValue().equals("byType")) {
                            //判斷是否有依賴
                            Field fields[] = clazz.getDeclaredFields();
                            for (Field field : fields) {
                                //得到屬性的類型，比如String aa那麽這裏的field.getType()=String.class
                                Class injectObjectClazz = field.getType();
                                /**
                                 * 由於是bytype 所以需要遍历map当中的所有对象
                                 * 判断对象的类型是不是和这个injectObjectClazz相同
                                 */
                                int count = 0;
                                Object injectObject = null;
                                for (String key : map.keySet()) {
                                    Class temp = map.get(key).getClass().getInterfaces()[0];
                                    if (temp.getName().equals(injectObjectClazz.getName())) {
                                        injectObject = map.get(key);
                                        //记录找到一个，因为可能找到多个count
                                        count++;
                                    }
                                }

                                if (count > 1) {
                                    throw new LubanSpringException("需要一个对象，但是找到了两个对象");
                                } else {
                                    object = clazz.newInstance();
                                    field.setAccessible(true);
                                    field.set(object, injectObject);
                                }
                            }
                        }
                    }
                }

                if(object==null){//沒有子標簽
                    object = clazz.newInstance();
                }
                map.put(beanName,object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }
    public Object getBean(String beanName){
        return map.get(beanName);
    }
}
