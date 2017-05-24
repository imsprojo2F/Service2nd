/**   
* @Title: Test01.java 
* @Package com.zooori.util.email 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月30日 下午4:24:42 
* @version V1.0   
*/
package com.server.util.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @ClassName: Test01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月30日 下午4:24:42
 *       http://blog.csdn.net/pan_haufei/article/details/52192161
 */
public class SendMail extends Thread {

	private String HEAD;
	private String TEXT;
	private String to;

	private boolean _run = true;

	public void stopThread(boolean run) {
		this._run = !run;
	}

	public void setHEAD(String HEAD) {
		this.HEAD = HEAD;
	}

	public void setTEXT(String TEXT) {
		this.TEXT = TEXT;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void run() {
		while (_run) {
			sendMail(to, HEAD, TEXT);
		}

	}

	public static void sendMail(String TO, String HEAD, String TEXT) {

		String from = "lfqinghui@foxmail.com";// 自己设置
		// 获取系统属性
		Properties properties = System.getProperties();
		// 设置邮件的服务器
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.host", "smtp.qq.com");
		// 设置邮件需要密码
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.debug", "true");
		// properties.setProperty("mail.smtp.auth",true);
		// 建立邮件会话
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("lfqinghui@foxmail.com", "lgnpjgxiodskdccd"); // 发件人的帐号和密码
			}
		});
		try {
			// 创建MimeMessage 对象
			MimeMessage message = new MimeMessage(session);
			// 增加发件人
			message.setFrom(new InternetAddress(from));
			// 增加收件人
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
			// 主题
			message.setSubject(HEAD);
			// 正文
			message.setText(TEXT);
			// 发送
			Transport.send(message);
			System.out.println(TO + "--已发送");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
