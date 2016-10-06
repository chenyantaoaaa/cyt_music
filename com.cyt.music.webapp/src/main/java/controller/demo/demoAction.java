package controller.demo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import service.user.demoService;

import com.cyt.music.common.exception.BizException;
import com.cyt.music.impl.mapper.sys.CommonSqlMapper;
import com.cyt.music.impl.util.RunUtil;
import com.cyt.music.interfaces.pojo.common.PageInfo;
import com.cyt.music.interfaces.pojo.user.UserInfo;

@Controller
@RequestMapping("/demo")
public class demoAction {
	
	private final static Logger LOG = Logger.getLogger(demoAction.class);
	
	@Autowired
	private demoService demoService;
	
	
	@RequestMapping(value = "/demoQuery")
	public  String demoQuery(Model model,UserInfo userInfo) throws Exception{
//		testLog4j();
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageParams(11, 2, 3);
//		userInfo.setPageInfo(pageInfo);
		List<UserInfo> UserList=demoService.demoQuery(userInfo);	
		model.addAttribute("UserItems", UserList);
		System.err.println(RunUtil.patchZero(Long.parseLong("1"), "000000"));
		return "demo/demo.jsp";
	}
	
	private void  testLog4j(){
		LOG.info("demoAction开始工作了=============================================INFO");
		LOG.debug("demoAction开始工作了=============================================DEBUG");
		LOG.error("demoAction开始工作了=============================================ERROR");
	}
	
	@RequestMapping("/editDemo")
	public  String editDemo(Model model,Integer id) throws Exception{
//		UserInfo userInfo=demoService.editDemo(id);	
		
		UserInfo userInfo=null;
		if(userInfo==null){
			throw new BizException("对不起对象为空");
		}
		model.addAttribute("userInfo", userInfo);
		return "demo/editDemo.jsp";
	}
	
	@RequestMapping("/editDemoSubmit")
	public  String editItemsSubmit(UserInfo userInfo) throws Exception{
		demoService.editItemsSubmit(userInfo);
		return "success.jsp";
	}
	
	@RequestMapping("/deleteItems")
	public  String deleteItems(Integer [] Items_id) throws Exception{
		//此方法主要测试前端的批量(数组)传值  具体delete实现简单此处不做业务层实现
		return "success.jsp";
	}
}


