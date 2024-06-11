package git.yjlove82.springboot3jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "admin_ip")
@IdClass(AdminIpId.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminIp {

    @Id
    @Column(name = "admin_id", nullable = false, length = 20)
    private String adminId;

    @Id
    @Column(name = "ip", nullable = false, length = 20)
    private String ip;

    @Column(name = "etc", length = 200)
    private String etc;

}