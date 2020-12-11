package ijse.ws.instagram_clone.dto;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO {

    private String name;
    private String username;
    private String password;
    private MultipartFile pro_pic;

    public UserDTO() {
    }

    public UserDTO(String name, String username, String password, MultipartFile pro_pic) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.pro_pic = pro_pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getPro_pic() {
        return pro_pic;
    }

    public void setPro_pic(MultipartFile pro_pic) {
        this.pro_pic = pro_pic;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pro_pic=" + pro_pic +
                '}';
    }
}