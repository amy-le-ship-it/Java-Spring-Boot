package com.example.myproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.myproject.domain.User;
import com.example.myproject.service.UploadService;
import com.example.myproject.service.UserService;

import jakarta.servlet.ServletContext;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.*;

;

@Controller
public class UserController {
  private final UserService userService;
  private final UploadService uploadService;


  public UserController(UserService userService, UploadService uploadService) {
    this.userService = userService;
    this.uploadService = uploadService;
  }

  @RequestMapping("/")
  public String getHome(Model model) {
    List<User> users = userService.getAllUserByEmail("nthuyngoc2002@gmail.com");
    model.addAttribute("users", users);
    return "hello";
  }

  @RequestMapping("/admin/user")
  public String getUserPage(Model model) {
    List<User> users = this.userService.getAllUser();
    System.out.println("Users: " + users.size());
    users.forEach(System.out::println);
    model.addAttribute("users", users);
    return "admin/user/show";
  }

  // get id
  @RequestMapping("/admin/user/{id}")
  public String getUserDetailPage(Model model, @PathVariable long id) { // lấy động được id
    // System.out.println("Check path id:" + id);

    User user = this.userService.getByUserId(id); // lấy ra id bên service
    model.addAttribute("user", user); // hiển thị id lên view
    model.addAttribute("id", id);
    return "admin/user/detail";
  }

  @GetMapping("/admin/user/create") // GET
  public String getCreateUserPage(Model model) {
    model.addAttribute("newUser", new User());
    return "admin/user/create";
  }

  @PostMapping(value = "/admin/user/create")
  public String createUserPage(Model model, @ModelAttribute("newUser") User hoidanit,
      @RequestParam("hoidanitFile") MultipartFile file) { //
    // System.out.println("run here" + newUser);
    // this.userService.handleSaveUser(newUser);

    String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
    return "redirect:/admin/user";
  }

  @RequestMapping("/admin/user/update/{id}") // GET
  public String getUpdateUserPage(Model model, @PathVariable long id) {
    User currenUser = this.userService.getByUserId(id);
    model.addAttribute("newUser", currenUser);
    return "admin/user/update";
  }

  @PostMapping("/admin/user/update") // Method POST
  public String postUpdateUser(Model model, @ModelAttribute("newUser") User newUser) {
    User currenUser = this.userService.getByUserId(newUser.getId()); // lúc này bên phía view đã có id rồi
    if (currenUser != null) {
      // System.out.println("run here");
      currenUser.setAddress(newUser.getAddress());
      currenUser.setFullName(newUser.getFullName());
      currenUser.setPhoneNumber(newUser.getPhoneNumber());

      // lưu xuống database: (fix bug here)
      this.userService.handleSaveUser(currenUser);
    }

    return "redirect:/admin/user"; // khi tạo xong tự chuyển trang
  }

  // Delete:
  @GetMapping("/admin/user/delete/{id}")
  public String getDeleteUpdateUserPage(Model model, @PathVariable long id) {
    model.addAttribute("id", id);

    // Cách 1: để lấy đúng giá trị id (vì ban đầu id = 0 -> vì nếu truyền ngay là
    // new mà không set lại giá trị id)
    // User user = new User();
    // user.setId(id);

    model.addAttribute("newUser", new User()); // truyền user vừa set id vào
    return "admin/user/delete";
  }

  @PostMapping("/admin/user/delete")
  public String postDeleteUpdateUser(Model model, @ModelAttribute("newUser") User newUser) {
    // System.out.println("run here");

    this.userService.deleteByUser(newUser.getId());
    return "redirect:/admin/user"; // khi tạo xong tự chuyển trang
  }

}
