package hewe.shop.convert;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

/**
 * 时间转换
 * 
 * @author HEWE 2016年10月20日
 */
public class DateConvert implements Converter<String, Date> {
	private static final Logger log = Logger.getLogger(DateConvert.class);

	private String pattern = null;// 存放转换格式,可以在xml中配置,无配置,默认为"yyyy-MM-dd"

	public Date convert(String source) {

		if (source == null || source.trim().equals("")) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		format.setLenient(false);
		try {
			return format.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}

	}

	public String getPattern() {
		if (this.pattern == null) {
			this.pattern = "yyyy-MM-dd";
		}
		return pattern;
	}

	public void setPattern(String pattern) {

		this.pattern = pattern;
		log.debug("pattern:" + this.pattern);
	}

}
