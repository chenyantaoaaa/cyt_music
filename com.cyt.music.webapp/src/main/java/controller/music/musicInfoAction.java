package controller.music;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.music.MusicInfoService;

import com.cyt.music.interfaces.pojo.music.MusicInfo;
import com.cyt.music.interfaces.pojo.music.MusicResult;

@Controller
@RequestMapping("/music")
public class musicInfoAction {

	@Autowired
	private MusicInfoService musicInfoService;
	
	@RequestMapping(value = "/queryMusicInfo")
	public @ResponseBody
	MusicResult queryMusicInfo() throws Exception {
//		MusicInfo musicInfo1=new MusicInfo();
//		musicInfo1.setAuthor("周杰伦");
//		musicInfo1.setTitle("告白气球");
//		musicInfo1.setImage("/pic/picture/a0c72ebd-0462-4a4b-ae27-e79724dad49c.jpg");
//		musicInfo1.setUrl("/pic/music/11.mp3");
//		
//		MusicInfo musicInfo2=new MusicInfo();
//		musicInfo2.setAuthor("周杰伦1");
//		musicInfo2.setTitle("告白气球1");
//		musicInfo2.setImage("/pic/picture/a0c72ebd-0462-4a4b-ae27-e79724dad49c.jpg");
//		musicInfo2.setUrl("/pic/music/12.mp3");
//		List<MusicInfo> musics=new ArrayList<MusicInfo>();
//		for (int i = 0; i <40; i++) {
//			musics.add(musicInfo1);
//		}		
//		musics.add(musicInfo2);
		
		MusicInfo musicInfo=new MusicInfo();
		List<MusicInfo> musics=musicInfoService.queryMusicInfo(musicInfo);
		
		MusicResult result=new MusicResult();
		result.setStart(0);
		result.setMusics(musics);
		result.setUploader("taoshao");
		
		return result;
	}
}
