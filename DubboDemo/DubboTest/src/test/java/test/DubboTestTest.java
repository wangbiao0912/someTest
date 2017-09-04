package test;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import javax.security.auth.login.AppConfigurationEntry;

/** 
* DubboTest Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 4, 2017</pre> 
* @version 1.0 
*/ 
public class DubboTestTest { 

    @Before
    public void before() throws Exception {
        System.out.println("读取配置文件 。。。");
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public  void dubboTest()
    {
        System.out.print("测试开始了。。。。。");
    }

} 
