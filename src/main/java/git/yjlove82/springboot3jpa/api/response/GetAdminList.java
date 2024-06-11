package git.yjlove82.springboot3jpa.api.response;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetAdminList implements Serializable {

    private String adminId;
    private int number;
    private String adminName;
    private String adminPhone;
    private String adminEmail;
    private Short adminLevel;
    private String adminIp;
    private String date;
}