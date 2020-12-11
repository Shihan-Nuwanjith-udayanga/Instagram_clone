package ijse.ws.instagram_clone.service;

import ijse.ws.instagram_clone.dto.UserDTO;
import ijse.ws.instagram_clone.util.StandardResponse;

public interface UserService {
    StandardResponse registerUser(UserDTO userDTO) throws Exception;

    boolean loginUser(UserDTO userDTO)throws Exception;
}
