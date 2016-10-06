package com.cyt.music.impl.service.comment;

import com.cyt.music.impl.logic.comment.CommentInfoLogic;
import com.cyt.music.interfaces.pojo.comment.CommentInfo;
import com.cyt.music.interfaces.pojo.comment.TopicComResult;
import com.cyt.music.interfaces.pojo.comment.TopicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.comment.CommentInfoService;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
@Service
public class CommentInfoServiceImpl implements CommentInfoService {
	@Autowired
	private CommentInfoLogic commentInfoLogic;

	@Override
	public List<TopicComResult> queryCommentInfo() throws Exception {
		return commentInfoLogic.queryCommentInfo();
	}

	@Override
	public TopicInfo praiseTopic(Integer
			flag) throws Exception {
		return commentInfoLogic.praiseTopic(flag);
	}

	@Override
	public TopicInfo queryTopicInfo(Integer flag) throws Exception {
		return commentInfoLogic.queryTopicInfo(flag);
	}

	@Override
	public void addComment(CommentInfo commentInfo) throws Exception {
		commentInfoLogic.addComment(commentInfo);
	}
}
