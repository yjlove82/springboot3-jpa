package git.yjlove82.springboot3jpa.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAdminIps {

    @NotNull
    @Size(min = 1)
    @Valid
    private List<AdminIdIp> adminIps;

    @Getter
    @Setter
    public static class AdminIdIp{
        @NotBlank
        private String adminId;
        @NotBlank
        private String ip;
        private String etc;
    }
}
