package ro.paulbrodner.alfresco.community;

import static org.hamcrest.CoreMatchers.equalTo;

import java.net.URISyntaxException;

import org.testng.annotations.Test;

import ro.paulbrodner.Randomizer;

/**
 * Based on {@link https://docs.alfresco.com/4.2/concepts/install-single-test.html}
 * @author paul.brodner
 */
public class SmokeTest extends RestTest {
	
	String currentUser = Randomizer.prefix("currentUser");	 
	String siteTitle = Randomizer.prefix("site"); 
		 
	/**
	 * {@link https://api-explorer.alfresco.com/api-explorer/#!/people/createPerson}
	 * @throws InterruptedException 
	 */
	@Test(priority = 0)
	public void adminCanCreateOneUser() throws InterruptedException {				
		String userFirstName	= Randomizer.prefix("fn");
		String userLastName		= Randomizer.prefix("ln");
				
		sendRequest().body(definePayload()
							.add("id", currentUser)
							.add("firstName", userFirstName)
							.add("lastName", userLastName)
							.add("email", String.format("%s@test.com", Randomizer.prefix("email")))
							.add("password", "password")
							.build().toString())
					 .post("/people")
					 .then()
					 .assertThat()
					 	.statusCode(201)
					 .and()
					 	.body("entry.firstName", equalTo(userFirstName))
					 .and()
					 	.body("entry.lastName", equalTo(userLastName));		 		
	}
	
	/**
	 * {@link https://api-explorer.alfresco.com/api-explorer/#!/authentication/createTicket}
	 * @throws URISyntaxException
	 */
	@Test(priority = 1)
	public void userIsAbleToLogin() throws URISyntaxException {								
		sendRequest().basePath(RestEndPoint.AUTH.getBasePath())
					 .body(definePayload()
							.add("userId", currentUser)
							.add("password", "password")
							.build().toString()		
							)
					 .post("/tickets")
					 .then()
					 .assertThat()
					 	.statusCode(201)
					 .and()
					 	.body("entry.userId", equalTo(currentUser));
	}

	/**
	 * {@link http://localhost:8080/api-explorer/#!/sites/createSite}
	 */
	@Test(priority = 1)
	public void userIsCreatingOneSite() {
		sendRequest().basePath(RestEndPoint.CORE.getBasePath())
					 .auth().basic(currentUser, "password")
					 .body(definePayload()
							 .add("title", siteTitle)
							 .add("visibility", "PUBLIC")
							 .build().toString()
						   )
					 .post("/sites")
					 .then()
					 .assertThat()
					 	.statusCode(201)
					 .and()
					 	.body("entry.title", equalTo(siteTitle))
					 .and()
					 	.body("entry.role", equalTo("SiteManager"));
	}	
}
