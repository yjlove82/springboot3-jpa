package git.yjlove82.springboot3jpa.service;

import git.yjlove82.springboot3jpa.entity.Admin;
import git.yjlove82.springboot3jpa.repository.AdminRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public List<Admin> getAdminList(){
        return Optional
            .of(adminRepository.findAll())
            .orElseGet(Collections::emptyList);
    }

    public Admin getAdminInfo(int number){
        return adminRepository.findById(number).orElse(null);
    }
}
