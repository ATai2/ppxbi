//package com.ppx.ppxshiro.bean;
//
//
//import javax.servlet.ReadListener;
//import javax.servlet.ServletInputStream;
//import javax.servlet.ServletRequest;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Enumeration;
//
//public class RequestWrapper extends HttpServletRequestWrapper {
//    private final byte[] body;
//
//    /**
//     * 这个必须加,复制request中的bufferedReader中的值
//     * @param request
//     * @throws IOException
//     */
//    public RequestWrapper(HttpServletRequest request) throws IOException {
//        super(request);
//        body = getBodyString(request);
//    }
//
//    /**
//     * 获取请求Body
//     *
//     * @param request
//     * @return
//     */
//    public byte[] getBodyString(final ServletRequest request) throws IOException {
//        String contentType = request.getContentType();
//        String bodyString ="";
//
//        if (StringUtils.isNotBlank(contentType) && (contentType.contains("multipart/form-data") || contentType.contains("x-www-form-urlencoded"))){
//
//            Enumeration<String> pars=request.getParameterNames();
//
//            while(pars.hasMoreElements()){
//
//                String n=pars.nextElement();
//
//                bodyString+=n+"="+request.getParameter(n)+"&";
//
//            }
//
//            bodyString=bodyString.endsWith("&")?bodyString.substring(0, bodyString.length()-1):bodyString;
//
//            return bodyString.getBytes(Charset.forName("UTF-8"));
//
//        }else {
//
//            return StreamUtil.readBytes(request.getReader(), "UTF-8");
//
//        }
//    }
//
//
//    @Override
//    public BufferedReader getReader() throws IOException {
//        return new BufferedReader(new InputStreamReader(getInputStream()));
//    }
//
//    @Override
//    public ServletInputStream getInputStream() throws IOException {
//        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
//        return new ServletInputStream() {
//
//            @Override
//            public boolean isFinished() {
//                return false;
//            }
//
//            @Override
//            public boolean isReady() {
//                return false;
//            }
//
//            @Override
//            public void setReadListener(ReadListener listener) {
//
//            }
//
//            @Override
//            public int read() throws IOException {
//                return bais.read();
//            }
//        };
//    }
//}
