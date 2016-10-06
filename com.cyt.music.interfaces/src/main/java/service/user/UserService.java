package service.user;

import com.cyt.music.interfaces.pojo.user.UserInfo;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/27.
 */
public interface UserService {

	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public UserInfo getByUserName(String userName);

	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String userName);

	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String userName);
}
