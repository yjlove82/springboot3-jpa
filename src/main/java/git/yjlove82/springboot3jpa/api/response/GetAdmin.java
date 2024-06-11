package git.yjlove82.springboot3jpa.api.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetAdmin {
    private String adminId;
    private int number;
    private String adminName;
    private String adminPhone;
    private String adminEmail;
    private Short adminLevel;
    private String adminIp;
    private String date;
}
