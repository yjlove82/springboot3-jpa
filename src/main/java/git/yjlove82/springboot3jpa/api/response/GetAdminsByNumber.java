package git.yjlove82.springboot3jpa.api.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetAdminsByNumber {
    private String id;
    private int number;
    private String name;
    private String phone;
    private String email;
    private String date;
}
