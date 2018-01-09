package com.cognizant.model;

public class DocumentUploadStatus {
	
	private String status;

	private String documentID;
	
	public DocumentUploadStatus(String status,String documentID) {
        this.status = status;
        this.documentID=documentID;
    }
	
    public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

    public String getStatus() {
        return status;
    }

}
