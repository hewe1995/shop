package hewe.shop.util.model;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("imageUploadUtil")
public class ImageUploadUtil implements IImageUpload {

	private static final String ROOTPATH = "F://savefile";

	/**
	 * @param filename
	 *            文件实际名称
	 * @return UUID_filename
	 */
	public String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;
	}

	/**
	 * @param filename
	 *            文件实际保存的名称
	 * @param savePath
	 *            文件保存的路径
	 * @return 路径名
	 */
	public String makePath(String filename, String savePath) {

		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15

		String dir = savePath + "\\" + dir1 + "\\" + dir2; // upload\2\3
															// upload\3\5
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}

	public String upload(MultipartFile file) {

		String fileName = file.getOriginalFilename();
		String saveName = this.makeFileName(fileName);
		String savePath = this.makePath(saveName, ROOTPATH);
		File saveFile = new File(savePath, saveName);
		if (!saveFile.exists()) {
			saveFile.mkdirs();
		}

		try {
			file.transferTo(saveFile);
			return saveName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
