package org.com.cyt.music.impl;

import com.cyt.music.impl.logic.demo.demoLogic;
import com.cyt.music.impl.mapper.user.UserInfoMapper;
import com.cyt.music.impl.service.demo.demoServiceImpl;
import com.cyt.music.interfaces.pojo.user.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations ="classpath:config/spring/applicationContext-*.xml") 
public class DemoTest {
	
	private SqlSessionFactory sqlSessionFactory;

	@Autowired 
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private demoLogic demoLogic;
	
	@Autowired
	private demoServiceImpl demoServiceImpl;
	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = null;
//		"config/mybatis/sqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
	
	
//	@Test
	public void demoTestQuery() throws IOException  {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		List<UserInfo> userInfoList=sqlSession.selectList("com.cyt.music.impl.mapper.user.UserInfoMapper.demoTestQuery");
		
		System.out.println(userInfoList.get(0));
		System.out.println(userInfoList.get(1));
		
		sqlSession.close();
	}
	
//	@Test
	public void test() throws IOException  {
		UserInfo userInfo=new UserInfo();
//		List<UserInfo> userInfoList=userInfoMapper.demoTestQuery(userInfo);
//		System.out.println(userInfoList.get(0));
//		System.out.println(userInfoList.get(1));
	}
	
	@Test
	public void wholeTest() throws Exception  {
		UserInfo userInfo=new UserInfo();
		List<UserInfo> userInfoList=demoLogic.demoQuery(userInfo);
		System.out.println(userInfoList.get(0));
		System.out.println(userInfoList.get(1));
	}
	
//	@Test
	public void wholeTest2() throws Exception  {
		UserInfo userInfo=new UserInfo();
		List<UserInfo> userInfoList=demoServiceImpl.demoQuery(userInfo);
		System.out.println(userInfoList.get(0));
		System.out.println(userInfoList.get(1));
	}
}
