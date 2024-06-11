package git.yjlove82.springboot3jpa.api.controller;

import git.yjlove82.springboot3jpa.api.request.PostAdminIps;
import git.yjlove82.springboot3jpa.api.request.PostAdmins;
import git.yjlove82.springboot3jpa.api.response.GetAdminsByNumber;
import git.yjlove82.springboot3jpa.api.response.GetAdmins;
import git.yjlove82.springboot3jpa.entity.Admin;
import git.yjlove82.springboot3jpa.entity.AdminIp;
import git.yjlove82.springboot3jpa.service.AdminService;
import jakarta.validation.Valid;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    private final ZoneId zoneId = ZoneId.of("Asia/Seoul");
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("admins")
    public List<GetAdmins> admins(){
        log.debug("get admin list");

        return adminService.getAdminList().stream().map(admin ->
            GetAdmins.builder()
                .id(admin.getId())
                .number(admin.getNumber())
                .name(admin.getName())
                .phone(admin.getPhone())
                .email(admin.getEmail())
                .date(admin.getDate().atZone(zoneId).format(dateTimeFormatter))
                .build()
        ).collect(Collectors.toList());
    }

    @GetMapping("admins/{number}")
    public ResponseEntity<GetAdminsByNumber> adminsByNumber(@PathVariable int number){
        log.debug("get admin by number");
        Admin admin = adminService.getAdminInfo(number);
        if(admin == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(GetAdminsByNumber.builder()
            .id(admin.getId())
            .number(admin.getNumber())
            .name(admin.getName())
            .phone(admin.getPhone())
            .email(admin.getEmail())
            .date(admin.getDate().atZone(zoneId).format(dateTimeFormatter))
            .build()
        );
    }

    @GetMapping("admins-id/{id}")
    public ResponseEntity<GetAdminsByNumber> adminsById(@PathVariable String id){
        log.debug("get admin by id");
        Admin admin = adminService.getAdminInfo(id);
        if(admin == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(GetAdminsByNumber.builder()
            .id(admin.getId())
            .number(admin.getNumber())
            .name(admin.getName())
            .phone(admin.getPhone())
            .email(admin.getEmail())
            .date(admin.getDate().atZone(zoneId).format(dateTimeFormatter))
            .build()
        );
    }

    @PostMapping(value = "admins", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int admins(@RequestBody PostAdmins admin){
        log.debug("create admin");
        return adminService.createAdmin(Admin.builder()
            .id(admin.getId())
            .pass(admin.getPass())
            .name(admin.getName())
            .phone(admin.getPhone())
            .email(admin.getEmail())
            .build()).getNumber();
    }

    @PostMapping(value = "admin/ips", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int admins(@RequestBody @Valid PostAdminIps adminIps){
        log.debug("create admin");
        return adminService.createAdminIp(
            adminIps.getAdminIps().stream()
                .map(adminIp -> AdminIp.builder()
                    .adminId(adminIp.getAdminId())
                    .ip(adminIp.getIp())
                    .etc(adminIp.getEtc())
                    .build()).toList()
        );
    }
}
