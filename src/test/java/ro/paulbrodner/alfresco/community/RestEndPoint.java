package ro.paulbrodner.alfresco.community;

/**
 * @author paul.brodner
 */
public enum RestEndPoint {
	CORE("/alfresco/api/-default-/public/alfresco/versions/1"), 
	AUTH("/alfresco/api/-default-/public/authentication/versions/1");

	private String basePath;

	RestEndPoint(String baseURL) {
		this.setBasePath(baseURL);
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
}
