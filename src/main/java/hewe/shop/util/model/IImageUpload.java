package hewe.shop.util.model;

import org.springframework.web.multipart.MultipartFile;

public interface IImageUpload {
	public String upload(MultipartFile file);
}
