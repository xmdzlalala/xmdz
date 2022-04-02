package com.xmdz.utils;

import org.apache.ibatis.session.SqlSession;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;

    //构造方法
    public TransactionInvocationHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session=null;
        Object obj=null;
        try {
            session=SqlSessionUtils.getSession();

            //处理业务逻辑
           obj= method.invoke(target,args);

           //处理业务逻辑完毕后，提交事务
            session.commit();

        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtils.myClose(session);

        }

        return obj;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);

    }
}
