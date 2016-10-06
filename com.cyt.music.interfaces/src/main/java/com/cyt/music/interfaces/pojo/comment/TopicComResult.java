package com.cyt.music.interfaces.pojo.comment;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class TopicComResult {
		private TopicInfo topicInfo;

		private List<CommentInfo> commentInfoList;

	public void setTopicInfo(TopicInfo topicInfo) {
		this.topicInfo = topicInfo;
	}

	public void setCommentInfoList(
			List<CommentInfo> commentInfoList) {
		this.commentInfoList = commentInfoList;
	}

	public TopicInfo getTopicInfo() {
		return topicInfo;
	}

	public List<CommentInfo> getCommentInfoList() {
		return commentInfoList;
	}
}
