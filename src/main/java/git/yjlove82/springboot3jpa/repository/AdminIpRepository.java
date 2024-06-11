package git.yjlove82.springboot3jpa.repository;

import git.yjlove82.springboot3jpa.entity.AdminIp;
import git.yjlove82.springboot3jpa.entity.AdminIpId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminIpRepository extends JpaRepository<AdminIp, AdminIpId> {

}