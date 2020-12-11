package ijse.ws.instagram_clone.controller;

import ijse.ws.instagram_clone.dto.UserDTO;
import ijse.ws.instagram_clone.service.AmazonS3ClientService;
import ijse.ws.instagram_clone.service.UserService;
import ijse.ws.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private AmazonS3ClientService amazonS3ClientService;


    @PostMapping(value = "/register", consumes = { "multipart/form-data" })
    public ResponseEntity<StandardResponse> register(UserDTO userDTO, @RequestPart(value = "pro_pic") MultipartFile file) {
        try {
            System.out.println(userDTO);
            System.out.println(file);
            System.out.println("register call : ");
            this.amazonS3ClientService.uploadFileToS3Bucket(userDTO.getPro_pic(), true);
            StandardResponse responseResponse = userService.registerUser(userDTO);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/login")
    public ResponseEntity<StandardResponse> login(@RequestBody UserDTO userDto) {
        try {
            boolean islogged = userService.loginUser(userDto);
            if (islogged) {
                System.out.println("Ïs Loggin");
                return new ResponseEntity<>(new StandardResponse(200, "true", null), HttpStatus.OK);
            } else {
                System.out.println("Loggin fail");
                return new ResponseEntity<>(new StandardResponse(500, "Loggin fail", null), HttpStatus.OK);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
