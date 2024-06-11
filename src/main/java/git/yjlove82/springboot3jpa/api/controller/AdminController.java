package git.yjlove82.springboot3jpa.api.controller;

import git.yjlove82.springboot3jpa.api.response.GetAdmin;
import git.yjlove82.springboot3jpa.api.response.GetAdminList;
import git.yjlove82.springboot3jpa.entity.Admin;
import git.yjlove82.springboot3jpa.service.AdminService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @GetMapping("admins")
    public List<GetAdminList> admins(){
        return adminService.getAdminList().stream().map(a ->
            GetAdminList.builder()
                .adminId(a.getId())
                .number(a.getNumber())
                .adminName(a.getName())
                .adminPhone(a.getPhone())
                .adminEmail(a.getEmail())
                .build()
        ).collect(Collectors.toList());
    }

    @GetMapping("admins/{number}")
    public ResponseEntity<GetAdmin> adminByNumber(@PathVariable int number){
        Admin admin = adminService.getAdminInfo(number);
        if(admin == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(GetAdmin.builder()
            .adminId(admin.getId())
            .number(admin.getNumber())
            .adminName(admin.getName())
            .adminPhone(admin.getPhone())
            .adminEmail(admin.getEmail())
            .build()
        );
    }
}
