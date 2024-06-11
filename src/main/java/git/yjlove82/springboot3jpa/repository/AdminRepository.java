package git.yjlove82.springboot3jpa.repository;

import git.yjlove82.springboot3jpa.entity.Admin;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findById(String id);
}