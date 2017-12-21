package ro.paulbrodner.alfresco.community;

import java.net.URISyntaxException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import org.testng.annotations.BeforeClass;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author paul.brodner
 */
abstract class RestTest {
	private RequestSpecification request = RestAssured.given();
	private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
 
	@BeforeClass(alwaysRun = true)
	protected RequestSpecification initializeRequest() throws URISyntaxException {
		requestSpecBuilder = new RequestSpecBuilder();
		
		configureRequest().setBasePath(RestEndPoint.CORE.getBasePath())
						  .setBaseUri("http://localhost")
						  .setPort(8080)
						  .setContentType(ContentType.JSON)
						  .log(LogDetail.ALL)
						  .setAuth(RestAssured.basic("admin", "admin"));		
		request.spec(requestSpecBuilder.build());				
		return request;
	}
	
	/**
	 * @return {@link RequestSpecification} instance
	 */
	public RequestSpecification sendRequest() {
		return request;
	}
	
	/**
	 * @return {@link RequestSpecBuilder} instance
	 */
	public RequestSpecBuilder configureRequest() {
		request.spec(requestSpecBuilder.build());
		return requestSpecBuilder;
	}
	
	/**
	 * @param currentUser
	 * @param password
	 * @return {@link RequestSpecification} instance
	 */
	public RequestSpecification changeBasicAuth(String username, String password) {
		configureRequest().setAuth(RestAssured.basic(username, password));
		return request;
	}
	
	public JsonObjectBuilder definePayload() {
		return Json.createObjectBuilder();
	}	
	
	public JsonArrayBuilder definePayloads() {
		return Json.createArrayBuilder();
	}
}
