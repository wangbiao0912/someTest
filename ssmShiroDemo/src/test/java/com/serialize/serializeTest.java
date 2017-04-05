package com.serialize;

import org.junit.Test;


import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;


/**
 * 
 * 项目名称：ssmShiroDemo   
 * 类名称：serializeTest   
 * 类描述：   
 *			对象序列化
 * 创建人：wangbiao  
 * 创建时间：2017年4月5日 下午3:22:32   
 * @version
 */
@Slf4j
public class serializeTest {

	/**
	 * 对象二进制流目的
	 *  将对象转换成与平台无关的二进制流，从而保存在磁盘或者进行网络传输，其他程序获取到这个二进制流可以还原成对象。
	 *  序列化机制可以使对象脱离程序的运行而对立存在。
	 *  
	 */

	/**
	 * 对象序列化
	 */
	@Test
	public void serialize()
	{
		/**
		 * byte数值转字符串
		 */
		String d="iiujhjifdgdf";
		System.out.println(new String(d.getBytes())+".。。");
		
		/*
     	jedis.set("////", d);
        jedis.set("foo11111", "bars");
        jedis.hset("测试", "吃", "ll");
      	log.info("foo:{}"+jedis.get("foo11111"));
      */
		    Jedis jedis = new Jedis("localhost");
		    jedis.select(2);
	     	byte[] skey = SerializeUtil.serialize("key");
			byte[] svalue = SerializeUtil.serialize("value");
			jedis.set(skey,svalue);
			byte[] newValue=jedis.get(skey);
			System.out.println(SerializeUtil.deserialize(newValue)+">>");
	        jedis.close();
	}
	
}
 