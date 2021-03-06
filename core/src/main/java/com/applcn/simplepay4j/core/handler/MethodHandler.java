package com.applcn.simplepay4j.core.handler;

import com.applcn.simplepay4j.core.model.AccountModel;
import com.applcn.simplepay4j.core.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 请求方法代理处理类
 * @author dayaoguai
 */
public class MethodHandler implements InvocationHandler {

    private MethodProxy subject;

    private AccountModel accountModel;

    public MethodHandler(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.subject = accountModel.init();
        this.subject.init(accountModel);
        Object result = method.invoke(subject, args);
        System.gc();
        return result;
    }
}
