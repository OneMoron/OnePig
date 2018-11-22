package com.itheima.controller.advice;

import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAdvice {

    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;


    @Around("execution(* com.itheima.controller.*.*(..))")
    public Object around(ProceedingJoinPoint pjp){
        Object obj = null;
        try {
            //得到访问开始时间
            Date now = new Date();
            //得到当访问的方法所在类
            Class clazzsss = pjp.getThis().getClass();
            System.out.println(clazzsss);
            Class clazz = pjp.getTarget().getClass();
            //拿到当前处理器类上的注解
            RequestMapping rmclazz = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            String clazzpath = rmclazz.value()[0];///product
            //放行方法
            Object[] args = pjp.getArgs();
            obj = pjp.proceed(args);
            //创建一个日志对象
            SysLog log = new SysLog();
            log.setExecutionTime(new Date().getTime()-now.getTime());
            log.setIp(request.getRemoteAddr());
            log.setMethod("类名为："+clazz.getName()+",方法为："+pjp.getSignature().getName());
            log.setUrl(request.getRequestURI());
            log.setUsername(request.getRemoteUser());
            log.setVisitTime(now);
            //日志入库
            sysLogService.save(log);
        }catch (Throwable t){
            t.printStackTrace();
        }
        return obj;
    }
}
