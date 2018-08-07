package com.n22.demo.service;

/**
 * @author wangsiyong
 * @Description: 邮件服务接口
 * @date 2018/8/216:07
 */
public interface MailService {
	public void sendSimpleMail(String to, String subject, String content);

	public void sendHtmlMail(String to, String subject, String content);

	public void sendAttachmentsMail(String to, String subject, String content, String filePath);

	public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
