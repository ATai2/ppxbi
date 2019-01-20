package com.ppx.ppxorder.utils;

import com.netflix.hystrix.contrib.javanica.utils.CommonUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

@Slf4j
@Getter
@Component
@Aspect
public class LogInterceptor {
    public static final String UNKNOWN = " unknown ";
    @Resource
    private HttpServletRequest request;

    @Pointcut("execution(* com.ppx.ppxorder.controller*..*(..))")
    public void log() {
        log.info(String.valueOf(request.getParameterMap()));
    }

    @AfterReturning(pointcut = "log()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        if (StringUtils.equals(System.getProperty("environment"), "DEV")) {
            devEnvironmentLog(joinPoint, returnValue);
        } else {
            productEnvironmentLog(joinPoint, returnValue);
        }
    }

    private void devEnvironmentLog(JoinPoint joinPoint, Object returnValue) {
        StringBuilder sb = new StringBuilder("\nSpringMVC action report -------- ")
                .append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .append(" ------------------------------\n");
        sb.append(getController(joinPoint));
        sb.append(getMethod(joinPoint));
        sb.append(getUri());
        sb.append(getParameter(joinPoint));
        sb.append("RemoteAddr  : " + Utils.getIpAddr(request) + "\n");
        sb.append(getReturn(returnValue));
        sb.append("--------------------------------------------------------------------------------\n");
        System.out.print(sb.toString());
    }

    private void productEnvironmentLog(JoinPoint joinPoint, Object returnValue) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.getRequestURI()).append(", ");
        sb.append("IP: " + Utils.getIpAddr(request)).append(", [");

        Map<String, String[]> parameters = request.getParameterMap();
        for (Map.Entry<String, String[]> entity : parameters.entrySet()) {
            sb.append(String.format("%s = %s, ", entity.getKey(), StringUtils.join(entity.getValue(), ',')));
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        log.info(sb.toString());
    }

    private Map<String, MultipartFile> getRequestFileMap(JoinPoint joinPoint) {
        Map<String, MultipartFile> fileMap = null;
        if (Utils.isJava8()) {
            Object[] args = joinPoint.getArgs();
            for (Object object : args) {
                if (object instanceof MultipartHttpServletRequest) {
                    MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) object;
                    fileMap = multipartHttpServletRequest.getFileMap();
                    break;
                }
            }
        }
        return fileMap;
    }

    private String getController(JoinPoint joinPoint) {
        return new StringBuffer().append("Controller  : ").append(joinPoint.getTarget().getClass().getName()).append(".(")
                .append(joinPoint.getTarget().getClass().getSimpleName()).append(".java:1)").toString();
    }

    private String getMethod(JoinPoint joinPoint) {
        return new StringBuffer().append("\nMethod      : ").append(joinPoint.getSignature().getName()).append("\n").toString();
    }

    private String getUri() {
        String uri = request.getRequestURI();
        if (uri != null) {
            return new StringBuffer().append("url         : ").append(uri)
                    .append(" user=" + request.getRemoteUser()).append("\n").toString();
        }
        return "";
    }

    private String getParameter(JoinPoint joinPoint) {
        StringBuffer sb = new StringBuffer();
        Map<String, MultipartFile> fileMap = getRequestFileMap(joinPoint);
        Enumeration<String> e = request.getParameterNames();
        if (e.hasMoreElements() || (fileMap != null && fileMap.size() > 0)) {
            sb.append("Parameter   : ");
            while (e.hasMoreElements()) {
                String name = e.nextElement();
                String[] values = request.getParameterValues(name);
                if (values.length == 1) {
                    sb.append(name).append("=").append(values[0]);
                } else {
                    sb.append(name).append("[]={");
                    for (int i = 0; i < values.length; i++) {
                        if (i > 0)
                            sb.append(",");
                        sb.append(values[i]);
                    }
                    sb.append("}");
                }
                sb.append("  ");
            }
            if (fileMap != null && fileMap.size() > 0) {
                for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
                    MultipartFile file = entry.getValue();
                    sb.append(entry.getKey()).append("=").append(file.getOriginalFilename());
                    sb.append(" (contentType=" + file.getContentType() + ",size=" + file.getSize() + ")");
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String getReturn(Object returnValue) {
        StringBuffer sb = new StringBuffer();
        String returnJSON = Utils.bean2json(returnValue);
        sb.append("return      : ").append(returnJSON).append("\n");
        return sb.toString();
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        return ip;
    }
}
