package es.udc.pojoapp.web.pages.user;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

import es.udc.pojoapp.model.userprofile.UserProfile;
import es.udc.pojoapp.model.userservice.UserProfileDetails;
import es.udc.pojoapp.model.userservice.UserService;
import es.udc.pojoapp.web.pages.Index;
import es.udc.pojoapp.web.services.AuthenticationPolicy;
import es.udc.pojoapp.web.services.AuthenticationPolicyType;
import es.udc.pojoapp.web.util.UserSession;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;

@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)

public class UpdateProfile {

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Property
    private String email;
    
    @Property
    private String dni;
    
    @Property
    private long telefono;
    
    @Property
    private String fechaNacimiento;
    
    @Property
    private String tipoUsuario;
    
    @Property
    private int numeroPuntos;

    @SessionState(create=false)
    private UserSession userSession;

    @Inject
    private UserService userService;

    void onPrepareForRender() throws InstanceNotFoundException {

        UserProfile userProfile;

        userProfile = userService.findUserProfile(userSession
                .getUserProfileId());
        firstName = userProfile.getFirstName();
        lastName = userProfile.getLastName();
        email = userProfile.getEmail();
        dni = userProfile.getDni();
        telefono = userProfile.getTelefono();
        fechaNacimiento = userProfile.getFechaNacimiento();

    }

    Object onSuccess() throws InstanceNotFoundException {

        userService.updateUserProfileDetails(
                userSession.getUserProfileId(), new UserProfileDetails(
                        firstName, lastName, email, dni, telefono, 
                fechaNacimiento,tipoUsuario, numeroPuntos));
        userSession.setFirstName(firstName);
        return Index.class;

    }

}