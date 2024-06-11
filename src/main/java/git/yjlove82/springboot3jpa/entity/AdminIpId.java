package git.yjlove82.springboot3jpa.entity;

import jakarta.persistence.Column;
import java.io.Serial;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AdminIpId implements Serializable {

    @Serial
    private static final long serialVersionUID = -898593985738688949L;

    @Column(name = "admin_id", nullable = false, length = 20)
    private String adminId;

    @Column(name = "ip", nullable = false, length = 20)
    private String ip;

}