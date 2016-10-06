package controller.recommend;

import com.cyt.music.interfaces.pojo.common.PageResultForBootstrap;
import com.cyt.music.interfaces.pojo.recommond.RecommondInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.recommond.RecommonInfoService;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/recommend")
public class recommendAction {

	@Autowired
	private RecommonInfoService recommonInfoService;

	@RequestMapping(value = "/queryRecomInfo")
	public @ResponseBody
	List<RecommondInfo> queryMusicInfo(@RequestBody RecommondInfo  recommondInfo) throws Exception {
		List<RecommondInfo> list=recommonInfoService.queryRecommonInfo(recommondInfo);
		return list;
	}

	@RequestMapping(value = "/addRecomInfo")
	public @ResponseBody PageResultForBootstrap  addRecomInfo(RecommondInfo  recommondInfo,@RequestParam("fileup[]") MultipartFile[] files) throws Exception {
		StringBuilder recomImages = new StringBuilder("");
		if (files != null && files.length > 0) {
			// 循环获取file数组中得文件
			for (MultipartFile recom_image : files) {
				String originalFilename = recom_image.getOriginalFilename();
				if (recom_image != null && originalFilename != null
						&& originalFilename.length() > 0) {
					// //存放图片的物理路径
					String pic_path = "F:\\upload\\recommond_pic\\";
					String newFileName = UUID.randomUUID()
							+ originalFilename.substring(originalFilename
							.lastIndexOf("."));
					File newFile = new File(pic_path + newFileName);
					recom_image.transferTo(newFile);
					recomImages.append(newFileName).append(";");
				}
			}
		}
		if (!recomImages.equals("")) {
			String recomImage = recomImages.toString().substring(0,
					recomImages.length() - 1);
			System.err.println(recomImage);
			recommondInfo.setImage(recomImage);
		}

		int i=recommonInfoService.addRecomInfo(recommondInfo);
		PageResultForBootstrap pageResultForBootstrap = new PageResultForBootstrap();
		return pageResultForBootstrap;
	}
}
