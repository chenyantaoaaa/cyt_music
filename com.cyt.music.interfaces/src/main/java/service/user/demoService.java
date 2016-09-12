package service.user;

import java.util.List;

import com.cyt.music.interfaces.pojo.user.UserInfo;

public interface demoService {
		public List<UserInfo> demoQuery(UserInfo userInfo) throws Exception;
		
		public UserInfo editDemo(Integer id) throws Exception;
		
		public void editItemsSubmit(UserInfo userInfo) throws Exception;
}
