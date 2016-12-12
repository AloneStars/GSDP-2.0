package com.gsdp.email;

import com.gsdp.exception.EmailSendException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Send {

	static Properties prop = null;

	static InputStream  in = null;

	static MailSenderInfo mailInfo = null;

	static SimpleMailSender sms = null;

	public Send(String filePath) {

		prop = new Properties();

		in = getClass().getResourceAsStream(filePath);

		mailInfo = new MailSenderInfo();

		sms = new SimpleMailSender();

		try {

			prop.load(in);

			mailInfo.setMailServerHost(prop.getProperty("stmp"));
			mailInfo.setMailServerPort(prop.getProperty("port"));
			mailInfo.setValidate(true);
			mailInfo.setUserName(prop.getProperty("username"));
			mailInfo.setPassword(prop.getProperty("password"));//您的邮箱密码
			mailInfo.setFromAddress(prop.getProperty("username"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public static boolean email(String toAddress,String Subject , String Content) throws EmailSendException{

		mailInfo.setToAddress(toAddress);
		mailInfo.setSubject(Subject);
		mailInfo.setContent(Content);
		try{
			if(Send.prop.getProperty("type").equals("html")){
				if(sms.sendHtmlMail(mailInfo))
					return true;
				else
					throw new EmailSendException("send email failure");
			}else if(Send.prop.getProperty("type").equals("text")){
				if(sms.sendTextMail(mailInfo))
					return true;
				else
					throw new EmailSendException("send email failure");
			}else{
				System.out.println("请配置邮件类型");
				return  false;
			}
		}catch (Exception e){
			e.printStackTrace();
			throw new EmailSendException("send email failure");
		}
	}




	public static void main(String[] args){
		//这个类主要是设置邮件
		Send send = new Send("/email.properties");

		System.out.println(send.mailInfo.toString());

		send.email("1138494584@qq.com","邮件标题", "邮件类容");

	}

}
