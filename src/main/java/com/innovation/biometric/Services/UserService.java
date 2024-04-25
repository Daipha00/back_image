package com.innovation.biometric.Services;

import com.innovation.biometric.Model.HealthOfficer;
import com.innovation.biometric.Model.Member;
import com.innovation.biometric.Model.Role;
import com.innovation.biometric.Model.User;
import com.innovation.biometric.Reposiory.MemberRepo;
import com.innovation.biometric.Reposiory.RoleRepo;
import com.innovation.biometric.Reposiory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired

    private MemberRepo memberRepo;

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createNewUser(User user){
        return userRepo.save(user);
    }

    @Transactional
    public void initUserRoles(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Role for admin only");
        roleRepo.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Role for user only");
        roleRepo.save(userRole);


        Role memberRole = new Role();
        memberRole.setRoleName("Member");
        memberRole.setRoleDescription("Role for member only");
        roleRepo.save(memberRole);

        User adminUser = new User();
        adminUser.setId(1L);
        adminUser.setUserName("haji");
        adminUser.setUserPassword(getEncodedPassword("admin123"));
        adminUser.setUserFirstName("Rahel");
        adminUser.setUserLastName("Ombeni");
        adminUser.setEmail("msagaladaines@gmail.com");
        adminUser.setAddress("Jumbi");
        adminUser.setPhoneNumber("0710287645");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepo.save(adminUser);

    }

    public User registerNewUser (User user){
        Role role = roleRepo.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepo.save(user);
    }
    public Member registerNewMember (Member member){
        Role role = roleRepo.findById("Member").get();
        Set<Role> memberRoles = new HashSet<>();
       memberRoles.add(role);
        member.setRole(memberRoles);
        member.setUserPassword(getEncodedPassword(member.getUserPassword()));

        return memberRepo.save(member);
    }

//    public User registerHealthOfficer (HealthOfficer healthOfficer){
//        Role role = roleRepo.findById("Officer").get();
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(role);
//        healthOfficer.setRole(userRoles);
//        healthOfficer.setUserPassword(getEncodedPassword(healthOfficer.getUserPassword()));
//
//        return userRepo.save(healthOfficer);
//    }

    public String getEncodedPassword (String password){
        return passwordEncoder.encode(password);
    }
}
