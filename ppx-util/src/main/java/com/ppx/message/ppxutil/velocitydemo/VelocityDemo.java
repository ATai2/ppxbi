package com.ppx.message.ppxutil.velocitydemo;//package com.ppx.base.velocitydemo;
//
//
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.Velocity;
//import org.apache.velocity.exception.MethodInvocationException;
//import org.apache.velocity.exception.ParseErrorException;
//import org.apache.velocity.exception.ResourceNotFoundException;
//
//import java.io.StringWriter;
//
//public class VelocityDemo {
//    public static void main(String[] args) {
//        Velocity.init();
//        VelocityContext context = new VelocityContext();
//        context.put("name", new String("Velocity"));
//        Template template = null;
//
//        try {
//            template = Velocity.getTemplate("mytemplate.vm");
//        } catch (ResourceNotFoundException rnfe) {
//            // couldn't find the template
//        } catch (ParseErrorException pee) {
//            // syntax error: problem parsing the template
//        } catch (MethodInvocationException mie) {
//            // something invoked in the template
//            // threw an exception
//        } catch (Exception e) {
//        }
//
//        StringWriter sw = new StringWriter();
//
//        template.merge(context, sw);
//    }
//
//
//}
