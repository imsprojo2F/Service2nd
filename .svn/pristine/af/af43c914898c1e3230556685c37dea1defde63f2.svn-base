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
public class TestMail {

	public static void main(String[] args) {
		String to = "";
		String name = "";
		String phone = "";
		String mail = "";
		String demand = "";
		while (true) {

			if ("".equals(name)) {
				name = "暂未填写";
			}
			if ("".equals(phone)) {
				phone = "暂未填写";
			}
			if ("".equals(mail)) {
				mail = "暂未填写";
			}
			// 发件人邮箱
			String from = "zooori@foxmail.com";// 自己设置
			// 收件人邮箱
			to = "1021275605@qq.com";// 自己设置
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
					return new PasswordAuthentication("zooori@foxmail.com", "636809FSL"); // 发件人的帐号和密码
				}
			});
			try {
				// 创建MimeMessage 对象
				MimeMessage message = new MimeMessage(session);
				// 增加发件人
				message.setFrom(new InternetAddress(from));
				// 增加收件人
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				// 主题
				message.setSubject("ZooORI诚信研究实验室-客户需求表");
				// 正文
				message.setText("【客户姓名】：" + name + "\r\n" + "【手机号码】：" + phone + "\r\n" + "【邮箱地址】：" + mail + "\r\n"
						+ "【目标需求】：" + demand);
				// 发送
				Transport.send(message);
				System.out.println("已发送");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		}
	}

}
