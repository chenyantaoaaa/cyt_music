package controller.user;

import com.cyt.music.interfaces.pojo.user.UserInfo;
import com.cyt.music.interfaces.pojo.user.loaderResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@Controller
@RequestMapping("/user")
public class userAction {
	/**
	 * 用户登录
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public @ResponseBody String login(@RequestBody UserInfo user,HttpServletRequest request){
		Subject subject= SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			subject.login(token);
			Session session=subject.getSession();
			System.out.println("sessionId:"+session.getId());
			System.out.println("sessionHost:"+session.getHost());
			System.out.println("sessionTimeout:"+session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "fail";
		}
	}

	/**
	 * 用户登出
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public @ResponseBody String logout(HttpServletRequest request){
		Subject subject= SecurityUtils.getSubject();
		subject.logout();
		return "success";
	}

	@RequestMapping("/session")
	public @ResponseBody
	loaderResponse session(HttpServletRequest request){
		loaderResponse loaderResponse=new loaderResponse();
		Subject subject= SecurityUtils.getSubject();
		Session session=subject.getSession();
		List<String> roleList=new ArrayList<String>();
		if(subject.hasRole("admin")){
			roleList.add("admin");
		}
		if(subject.hasRole("teacher")){
			roleList.add("teacher");
		}
		if(subject.getPrincipals()!=null){
			loaderResponse.setUserName(subject.getPrincipals().getPrimaryPrincipal().toString());
		}

		loaderResponse.setRoleList(roleList);
		return loaderResponse;
	}
}