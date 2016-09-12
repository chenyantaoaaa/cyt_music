package controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyt.music.impl.logic.common.CommonLogic;
import com.cyt.music.interfaces.pojo.common.PageResultForBootstrap;
import com.cyt.music.interfaces.pojo.common.WeatherInfo;

@Controller
@RequestMapping("/home")
public class homeAction {
	
	@Autowired
	private CommonLogic commonLogic;
	
	@RequestMapping(value="/weather")
	public @ResponseBody WeatherInfo requestJson(@RequestBody WeatherInfo weatherInfo) throws Exception{
		

		String cityName=weatherInfo.getCityname().substring(0,(weatherInfo.getCityname().length()-1));
		WeatherInfo weatherInfos=commonLogic.getWeather(cityName);
		return weatherInfos;
	}

}
