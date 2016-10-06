package controller.guita;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import service.guita.GuitaInfoService;

import com.cyt.music.interfaces.pojo.common.PageInfo;
import com.cyt.music.interfaces.pojo.common.PageResultForBootstrap;
import com.cyt.music.interfaces.pojo.guita.GuitaInfo;
import com.cyt.music.interfaces.pojo.guita.GuitaInfoVo;

@Controller
@RequestMapping("/guita")
public class guitaInfoAction {

	@Autowired
	private GuitaInfoService guitaInfoService;

	@RequestMapping(value = "/queryGuitaInfo")
	public @ResponseBody
	PageResultForBootstrap queryGuitaInfo(Integer pageSize, Integer pageNumber)
			throws Exception {

		GuitaInfo guitaInfo = new GuitaInfo();

		int total = guitaInfoService.queryGuitaInfoCount(guitaInfo);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageParams(total, pageSize, pageNumber);
		GuitaInfoVo guitaInfoVo = new GuitaInfoVo();
		guitaInfoVo.setPageInfo(pageInfo);
		// guitaInfoVo.setScoreName("1");

		List<GuitaInfo> guitaList = guitaInfoService
				.queryGuitaInfo(guitaInfoVo);
		PageResultForBootstrap pageResultForBootstrap = new PageResultForBootstrap();
		pageResultForBootstrap.setRows(guitaList);
		pageResultForBootstrap.setTotal(total);

		return pageResultForBootstrap;
	}

	// @RequestBody GuitaInfo guitaInfo HttpServletRequest request
	@RequestMapping(value = "/addGuitaInfo")
	public @ResponseBody
	PageResultForBootstrap addGuitaInfo(GuitaInfo guitaInfo,
			HttpServletRequest request,
			@RequestParam("fileup[]") MultipartFile[] files) throws Exception {
		StringBuilder scoreImages = new StringBuilder("");
		if (files != null && files.length > 0) {
			// 循环获取file数组中得文件
			for (MultipartFile score_image : files) {
				String originalFilename = score_image.getOriginalFilename();
				if (score_image != null && originalFilename != null
						&& originalFilename.length() > 0) {
					// //存放图片的物理路径
					String pic_path = "F:\\upload\\picture\\";
					String newFileName = UUID.randomUUID()
							+ originalFilename.substring(originalFilename
									.lastIndexOf("."));
					File newFile = new File(pic_path + newFileName);
//					score_image.transferTo(newFile);
					scoreImages.append(newFileName).append(";");
				}
			}
		}
		if (!scoreImages.equals("")) {
			String scoreImage = scoreImages.toString().substring(0,
					scoreImages.length() - 1);
			System.err.println(scoreImage);
			guitaInfo.setScoreImage(scoreImage);
		}
		
		guitaInfoService.addGuitaInfoCount(guitaInfo);

		PageResultForBootstrap pageResultForBootstrap = new PageResultForBootstrap();
		return pageResultForBootstrap;
	}
}
