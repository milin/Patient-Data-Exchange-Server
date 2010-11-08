package com.check.www;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class FileUploadForm extends org.apache.struts.action.ActionForm 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 670668742808972354L;

	private FormFile file;

    private String message;

    public FileUploadForm() {
        super();
    // TODO Auto-generated constructor stub
    }

    /**
     * @return the file
     */
    public FormFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(FormFile file) {
        this.file = file;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

}
