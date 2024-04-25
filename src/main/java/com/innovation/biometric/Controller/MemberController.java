package com.innovation.biometric.Controller;

import com.innovation.biometric.Model.Member;
import com.innovation.biometric.Model.MemberImage;
import com.innovation.biometric.Model.User;
import com.innovation.biometric.Services.MemberService;
import com.innovation.biometric.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MemberController {


    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;

    @GetMapping("/getAllMembers")
    public List<Member> getAll(){
        return memberService.getAll();
    }

    @GetMapping("/getMember/{id}")
    public Member getMemberById(@PathVariable Long id){
        return memberService.getMemberById(id);
    }


//    @PostMapping({"/addMember"})
//    public Member addMember(@RequestBody Member member){
//        return userService.registerNewMember(member);
//    }

    @PostMapping(value = {"/addMember"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Member addNewMember(@RequestPart("member") Member member, @RequestPart("memberImage")MultipartFile[] files){
        try{
            Set<MemberImage> images = uploadImage(files);
            member.setMemberImage(images);
            return memberService.addMember(member);
        }catch(Exception e){
              System.out.println(e.getMessage());
              return null;
        }
    }

    public Set<MemberImage> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<MemberImage> memberImage = new HashSet<>();

        for (MultipartFile file:multipartFiles){
            MemberImage memberImage1 = new MemberImage(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            memberImage.add(memberImage1);
        }
  return memberImage;
    }

    @PutMapping("/updateMember/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody Member member){
        memberService.updateMember(id, member);
    }

    @DeleteMapping("/deleteMember/{id}")
    public void delete(@PathVariable Long id){
        memberService.deleteMember(id);
    }
}
