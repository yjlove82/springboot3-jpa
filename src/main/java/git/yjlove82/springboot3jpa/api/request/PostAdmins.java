package git.yjlove82.springboot3jpa.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAdmins {
    private String id;
    private String name;
    private String pass;
    private String phone;
    private String email;
}
