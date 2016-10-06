package controller.comment;

import com.cyt.music.impl.logic.common.CommonLogic;
import com.cyt.music.impl.service.comment.CommentInfoServiceImpl;
import com.cyt.music.interfaces.pojo.comment.CommentInfo;
import com.cyt.music.interfaces.pojo.comment.TopicComResult;
import com.cyt.music.interfaces.pojo.comment.TopicInfo;
import com.cyt.music.interfaces.pojo.common.PageResultForBootstrap;
import com.cyt.music.interfaces.pojo.recommond.RecommondInfo;
import controller.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.comment.CommentInfoService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/comment")
public class CommentAction extends BaseAction {

	@Autowired
	private CommonLogic commonLogic;

	@Autowired
	private CommentInfoService commentInfoService;

	@RequestMapping(value = "/queryTopicComInfo")
	public @ResponseBody
	List<TopicComResult> queryMusicInfo() throws Exception {
		List<TopicComResult> list1=commentInfoService.queryCommentInfo();
		return list1;
	}

	@RequestMapping(value = "/praiseTopic")
	public @ResponseBody
	TopicInfo praiseTopic(@RequestBody Map mapvo, HttpServletRequest request,HttpServletResponse response) throws Exception {
		TopicInfo topic=new TopicInfo();
		Cookie[] cookies=request.getCookies();
		Cookie cookieFlag=getCookieByName(request,"admire");

		if(cookieFlag==null) {
			Cookie cookie = new Cookie("admire", "admire");
			cookie.setMaxAge(30 * 60);// 设置为30min
			cookie.setPath("/");
			response.addCookie(cookie);
			topic=commentInfoService.praiseTopic(Integer.parseInt(mapvo.get("flag").toString()));
		}else{
			topic=commentInfoService.queryTopicInfo(Integer.parseInt(mapvo.get("flag").toString()));
		}
		return topic;
	}

	@RequestMapping(value = "/addComment")
	public @ResponseBody
	void addComment(@RequestBody CommentInfo commentInfo) throws Exception {
		commentInfoService.addComment(commentInfo);
	}

}
