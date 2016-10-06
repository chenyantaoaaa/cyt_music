package service.comment;

import com.cyt.music.interfaces.pojo.comment.CommentInfo;
import com.cyt.music.interfaces.pojo.comment.TopicComResult;
import com.cyt.music.interfaces.pojo.comment.TopicInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
public interface CommentInfoService {
	public List<TopicComResult> queryCommentInfo() throws Exception;

	public TopicInfo praiseTopic(Integer flag) throws Exception;

	public TopicInfo queryTopicInfo(Integer flag) throws Exception;

	public void addComment(CommentInfo commentInfo) throws Exception;
}
