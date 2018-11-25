package com.kerwin.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {

    SimpleAccountRealm realm = new SimpleAccountRealm();

    @Before
    public void addUser(){
        realm.addAccount("kerwin","123456");
    }

    @Test
    public void testAuthentication(){

        //1.构建securityManager环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("kerwin","123456");
        subject.login(token);
        System.out.println("isAuthenticated:"+subject.isAuthenticated());
    }
}
