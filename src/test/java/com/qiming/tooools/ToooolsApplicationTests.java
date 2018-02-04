package com.qiming.tooools;

import com.qiming.tooools.utils.EmailSender;
import com.qiming.tooools.model.Email;
import com.qiming.tooools.model.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToooolsApplicationTests {

	@Value("${spring.mail.port}") String a;
	@Autowired
	EmailSender emailSender;

	@Test
	public void contextLoads() {
		Email email = new Email();
		email.setFromName("崔启明");
		email.setSubject("测试1");
		email.setTemplateName("dailyNotify");
		email.setModel(new HashMap<>());
		emailSender.sendEmail(email);

	}

}
