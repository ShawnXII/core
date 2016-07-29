package test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.forerunner.foundation.domain.po.user.Member;
import com.forerunner.foundation.service.system.ResourceService;
import com.forerunner.foundation.service.system.RoleService;
import com.forerunner.foundation.service.user.AccountService;
import com.forerunner.foundation.service.user.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext-jdbc.xml","classpath*:/applicationContext-aop.xml"})
public class SpringTest {
		
	@Autowired
	private ResourceService resourceService;
	
/*	@Autowired
	private AccountService accountService;*/
	
	@Test
	public void testAccount(){
		//System.out.println(resourceService.findOne(1L));
	}
	
	
}
