package vaannila;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport{

	private File userImage;
	
	private String userImageContentType;
	
	private String userImageFileName;
	
	private static final String UPLOADS_DIRECTORY = "c:/uploads/";
		
	public String execute()
	{
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(UPLOADS_DIRECTORY);
			sb.append(userImageFileName);
			
			File theFile = new File(sb.toString());
			FileUtils.copyFile(userImage, theFile);

		} catch (Exception e) {
			addActionError(e.getMessage());
			return INPUT;
		}
		
		return SUCCESS;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}
	
}
