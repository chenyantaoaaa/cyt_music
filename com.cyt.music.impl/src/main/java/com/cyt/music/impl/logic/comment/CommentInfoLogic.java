package com.cyt.music.impl.logic.comment;

import Constants.SerialNoConstants;
import com.cyt.music.impl.logic.common.CommonLogic;
import com.cyt.music.impl.mapper.comment.CommentInfoMapper;
import com.cyt.music.impl.mapper.comment.TopicInfoMapper;
import com.cyt.music.interfaces.pojo.comment.CommentInfo;
import com.cyt.music.interfaces.pojo.comment.TopicComResult;
import com.cyt.music.interfaces.pojo.comment.TopicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
@Component
public class CommentInfoLogic {

	@Autowired
	private CommentInfoMapper commentInfoMapper;

	@Autowired
	private TopicInfoMapper topicInfoMapper;

	@Autowired
	private CommonLogic commonLogic;

	public List<TopicComResult> queryCommentInfo() throws Exception {
		List<TopicInfo> topicList=topicInfoMapper.queryTopicInfo(null);
		List<CommentInfo> commentList=commentInfoMapper.queryCommentInfo(null);
		List<TopicComResult> topicComResults=new ArrayList<TopicComResult>();
		for (TopicInfo topicInfo : topicList) {
			TopicComResult topicComResult=new TopicComResult();
			topicComResult.setTopicInfo(topicInfo);
			List<CommentInfo> list=new ArrayList<CommentInfo>();
			for (CommentInfo commentInfo : commentList) {
				if(commentInfo.getTopicId()==topicInfo.getId()){
					list.add(commentInfo);
				}
			}
			topicComResult.setCommentInfoList(list);
			topicComResults.add(topicComResult);
		}
		return topicComResults;
	}

	public TopicInfo praiseTopic(Integer
			flag) throws Exception {
		TopicInfo info=topicInfoMapper.selectByPrimaryKey(flag);
		int admire=info.getAdmiration();
		info.setAdmiration((admire+1));
		topicInfoMapper.updateByPrimaryKey(info);
		return info;
	}

	public TopicInfo queryTopicInfo(Integer
			flag) throws Exception {
		TopicInfo info=topicInfoMapper.selectByPrimaryKey(flag);
		return info;
	}

	public void addComment(CommentInfo commentInfo) throws Exception {
		Long [] times=commonLogic.getNowTime();
		long date=times[0];
		long time=times[1];

		String name=commentInfo.getName();
		commentInfo.setId( Integer.parseInt(commonLogic.getMaxCount(SerialNoConstants.COMMNET_NO).toString()));
		commentInfo.setName(name+"网友");
		commentInfo.setHeadImage("youke.png");
		commentInfo.setInputDate((int)date);
		commentInfo.setInputTime((int)time);
		commentInfo.setAdmiration(0);
		commentInfoMapper.insert(commentInfo);
	}
}
