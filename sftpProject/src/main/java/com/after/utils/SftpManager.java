package com.after.utils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SftpManager
{
	private String				strRemoteHost	= "";
	private String				strUserName = "";
	private String				strPassword = "";
	private int						nPort = 36044;
	//Session session = null;
	//Channel channel = null;
	//ChannelSftp chSftp = null;

	public SftpManager(String strRemoteHost, String strUserName, String strPassword, int nPort)
	{
		super();
		this.strRemoteHost = strRemoteHost;
		this.strUserName = strUserName;
		this.strPassword = strPassword;
		this.nPort = nPort;
	}
	
	public Session getSftpSession() throws JSchException{
		JSch jsch = new JSch();// 创建JSch对象
		Session session = jsch.getSession(this.strUserName, this.strRemoteHost, this.nPort);// 根据用户名，主机IP，端口获取一个session对象
		return session;
	}
	

	/*
	 * @param sftpDetails
	 * @param timeout
	 * @return
	 * @throws JSchException
	*/
	public ChannelSftp getChannel() throws JSchException
	{
		JSch jsch = new JSch();// 创建JSch对象
		Session session = jsch.getSession(this.strUserName, this.strRemoteHost, this.nPort);// 根据用户名，主机IP，端口获取一个session对象
		if (strPassword != null)
		{
			session.setPassword(strPassword);// 设置密码
		}
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);// 为session对象设置properties
		session.setTimeout(60000);// 设置timeout时间
		session.connect();// 通过session建立链接
		Channel channel = session.openChannel("sftp");// 打开sftp通道
		channel.connect();// 建立sftp通道的链接
		return (ChannelSftp) channel;
	}

	
	public String uploadFile(ChannelSftp chSftp,String strLocalFileName, String strRemoteFileName)
	{
		try
		{
			chSftp = getChannel();
			log.info("getChannel() connect time :: ");
		}catch (Exception e)
		{
			log.error("异常：",e);
			return "sftp连接失败";
		}
		try
		{
			log.debug("Uploading file:" + strLocalFileName);
			chSftp.put(strLocalFileName, strRemoteFileName, ChannelSftp.OVERWRITE);// 以覆盖形式上传
			log.debug("File uploaded:" + strLocalFileName);
			return "success";
		}catch (Exception e)
		{
			log.error("异常：", e);
		}finally {
			try {
				closeChannel(chSftp);
			} catch (Exception e2) {
				log.error("异常：", e2);
			}
		}
		return "sftp发送失败";
	}
	
	
	/*
	 * @param strFromName
	 * @param strToName
	 * @return
	*/
	public String rename(ChannelSftp chSftp,String strFromName, String strToName)
	{
		try
		{
			chSftp = getChannel();
			log.info("getChannel() connect time :: " );
		}catch (Exception e)
		{
			log.error("异常：",e);
			return "sftp连接失败";
		}
		try
		{
			log.debug("Renaming file:" + strFromName + " to " + strToName);
			chSftp.rename(strFromName, strToName);
			log.debug("Renamed file:" + strFromName + " to " + strToName);
			return "success";
		}catch (Exception e)
		{
			log.error(e.getMessage());
		}finally {
			try {
				closeChannel(chSftp);
			} catch (Exception e2) {
				log.error("异常：", e2);
			}
		}
		return "ftp发送失败";
	}
	
	
	public void closeChannel(ChannelSftp chSftp) throws Exception
	{
		if (chSftp != null) {
			if (chSftp.isConnected()) {
				chSftp.getSession().disconnect();
				chSftp.disconnect();
				log.info("---------> KaServer sftp close chanel sucess");
			}else if (chSftp.isClosed()) {
				log.info("---------> KaServer sftp is closed already");
			}
		}
/*
		if (session != null) {
			if (session.isConnected()) {
				session.disconnect();
				log.info("---------> sftp close session sucess");
			}
		}*/
	}
}
