package com.n22.demo;

import com.n22.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author wangsiyong
 * @Description: 邮件服务测试
 * @date 2018/8/216:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

	@Autowired
	private MailService mailService;

	@Autowired
	private TemplateEngine templateEngine;

	/**
	 * 发送文本格式邮件
	 * @throws Exception
	 */
	@Test
	public void testSimpleMail() throws Exception {
		mailService.sendSimpleMail("wangsy@n22.com.cn","test simple mail"," hello this is simple mail");
	}

	/**
	 * 发送html格式邮件
	 * @throws Exception
	 */
	@Test
	public void testHtmlMail() throws Exception {
		String content="<html>\n" +
				"<body>\n" +
				"    <h3>hello world ! 这是一封html邮件!</h3>\n" +
				"</body>\n" +
				"</html>";
		mailService.sendHtmlMail("wangsy@n22.com.cn","test simple mail",content);
	}

	/**
	 * 发送带附件的邮件
	 */
	@Test
	public void sendAttachmentsMail() {
		String filePath="D:\\发布\\catalina.sh";
		mailService.sendAttachmentsMail("wangsy@n22.com.cn", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}

	/**
	 * 发送带静态资源的邮件
	 */
	@Test
	public void sendInlineResourceMail() {
		String rscId = "neo006";
		String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
		String imgPath = "D:\\发布\\1.jpg";
		mailService.sendInlineResourceMail("wangsy@n22.com.cn", "主题：这是有图片的邮件", content, imgPath, rscId);
	}

	/**
	 * 邮件模板
	 */
	@Test
	public void sendTemplateMail() {
		//创建邮件正文
		Context context = new Context();
		context.setVariable("id", "006");
		String emailContent = templateEngine.process("emailTemplate", context);
		mailService.sendHtmlMail("wangsy@n22.com.cn","主题：这是模板邮件",emailContent);
	}
}
