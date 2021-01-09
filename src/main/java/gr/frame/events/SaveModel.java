package gr.frame.events;

import java.io.Serializable;

public class SaveModel implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String inputFromTAInput = null;

	private String inputFromTAPreview = null;
	private String inputFromTAHtmlEntitys = null;
	private String inputFromTAIso_8859_7 = null;

	public SaveModel() {
	}

	public SaveModel(String inputFromTAInput, String inputFromTAPreview, String inputFromTAHtmlEntitys, String inputFromTAIso_8859_7) {
		super();
		this.inputFromTAInput = inputFromTAInput;
		this.inputFromTAPreview = inputFromTAPreview;
		this.inputFromTAHtmlEntitys = inputFromTAHtmlEntitys;
		this.inputFromTAIso_8859_7 = inputFromTAIso_8859_7;
	}

	public String getInputFromTAHtmlEntitys() {
		if(inputFromTAHtmlEntitys == null) {
			inputFromTAHtmlEntitys = "";
		}
		return inputFromTAHtmlEntitys;
	}

	public void setInputFromTAHtmlEntitys(String inputFromTAHtmlEntitys) {
		this.inputFromTAHtmlEntitys = inputFromTAHtmlEntitys;
	}

	public String getInputFromTAInput() {
		if(inputFromTAInput == null) {
			inputFromTAInput = "";
		}
		return inputFromTAInput;
	}

	public void setInputFromTAInput(String inputFromTAInput) {
		this.inputFromTAInput = inputFromTAInput;
	}

	public String getInputFromTAIso_8859_7() {
		if(inputFromTAIso_8859_7 == null) {
			inputFromTAIso_8859_7 = "";
		}
		return inputFromTAIso_8859_7;
	}

	public void setInputFromTAIso_8859_7(String inputFromTAIso_8859_7) {
		this.inputFromTAIso_8859_7 = inputFromTAIso_8859_7;
	}

	public String getInputFromTAPreview() {
		if(inputFromTAPreview == null) {
			inputFromTAPreview = "";
		}
		return inputFromTAPreview;
	}

	public void setInputFromTAPreview(String inputFromTAPreview) {
		this.inputFromTAPreview = inputFromTAPreview;
	}


}
