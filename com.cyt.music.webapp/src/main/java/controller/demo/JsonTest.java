package controller.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.Param;

import service.user.demoService;

import com.cyt.music.impl.logic.common.CommonLogic;
import com.cyt.music.interfaces.pojo.common.PageInfo;
import com.cyt.music.interfaces.pojo.common.PageResultForBootstrap;
import com.cyt.music.interfaces.pojo.user.UserInfo;

@Controller
@RequestMapping("/demo")
public class JsonTest {
	
	
	@Autowired
	private demoService demoService;
	
	@Autowired
	private CommonLogic commonLogic;
	
//	请求json串(商品信息)，输出json(商品信息)
//	@RequestBody将请求的商品信息的json串转成itemsCustom对象
//	@ResponseBody将itemsCustom转成json输出
	@RequestMapping(value="/requestJson")
	public @ResponseBody PageResultForBootstrap requestJson(Integer pageSize,Integer pageNumber,String username,UserInfo info) throws Exception{
//		@RequestBody UserInfo userInfo	
//		@RequestBody  UserInfo [] users
		//@ResponseBody将itemsCustom转成json输出

//		// 获取数据库时间
//		Long[] time = commonLogic.getNowTime();
//		Long loginDate = time[0];
//		Long loginTime = time[1];
//		System.err.println(loginDate);
//		System.err.println(loginTime);
		
		
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageParams(11, pageSize, pageNumber);
		UserInfo userInfo=new UserInfo();
//		userInfo.setPageInfo(pageInfo);
		
		List<UserInfo> UserList=demoService.demoQuery(userInfo);
		PageResultForBootstrap pageResultForBootstrap=new PageResultForBootstrap();
		pageResultForBootstrap.setRows(UserList);
		pageResultForBootstrap.setTotal(11);
		
		return pageResultForBootstrap;
	}
	
//	//请求key/value，输出json
//	@RequestMapping("/responseJson")
//	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
//		
//		//@ResponseBody将itemsCustom转成json输出
//		return itemsCustom;
//	}
	

}
