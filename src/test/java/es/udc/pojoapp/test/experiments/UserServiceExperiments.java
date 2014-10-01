package es.udc.pojoapp.test.experiments;

import static es.udc.pojoapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static es.udc.pojoapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.udc.pojoapp.model.userprofile.UserProfile;
import es.udc.pojoapp.model.userservice.IncorrectPasswordException;
import es.udc.pojoapp.model.userservice.UserProfileDetails;
import es.udc.pojoapp.model.userservice.UserService;
import es.udc.pojo.modelutil.exceptions.DuplicateInstanceException;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;

public class UserServiceExperiments {

	public static void main(String[] args) {

		/* Get service object. */
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE });
		UserService userService = ctx.getBean(UserService.class);

		try {
			// Register user.
			UserProfile userProfile = userService.registerUser("serviceUser",
					"userPassword", new UserProfileDetails("name", "lastName",
					"user@udc.es","33333333s",981888888,"23/02/1989","normal",0));
			System.out.println("User with userId '"
					+ userProfile.getUserProfileId() + "' has been created");
			System.out.println(userProfile);

			// Find user.
			userProfile = userService.login("serviceUser", "userPassword",
					false);
			System.out.println("User with userId '"
					+ userProfile.getUserProfileId() + "' has been retrieved");
			System.out.println(userProfile);

			// ... proceed in the same way for other entities / methods / use
			// cases

		} catch (IncorrectPasswordException | InstanceNotFoundException
				| DuplicateInstanceException e) {
			e.printStackTrace();
		}

	}

}
