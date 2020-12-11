package ijse.ws.instagram_clone.service.impl;

import ijse.ws.instagram_clone.dto.UserDTO;
import ijse.ws.instagram_clone.entity.User;
import ijse.ws.instagram_clone.repository.UserRepository;
import ijse.ws.instagram_clone.service.UserService;
import ijse.ws.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public StandardResponse registerUser(UserDTO userDTO) throws Exception {
        if(userRepository.existsByUsername(userDTO.getUsername())){
            return new StandardResponse(500,"User Already Exists", null);
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPro_pic("https://myawsimagebucket.s3.us-east-2.amazonaws.com/" + userDTO.getPro_pic().getOriginalFilename());
        User save = userRepository.save(user);
        System.out.println(save);

        return null;
    }

    @Override
    public boolean loginUser(UserDTO userDTO) throws Exception {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        User set =  userRepository.findUserByUsername(user.getUsername());
        if (set !=null) {
            return true;
        }
        return false;
    }
}
