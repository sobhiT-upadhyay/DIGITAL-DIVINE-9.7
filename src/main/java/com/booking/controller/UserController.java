package com.booking.controller;
import com.booking.payload.UserDTO;
import com.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //localhost:8080/api/users/create
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(
            @RequestParam("firstName") String firstName,

            @RequestParam("lastName") String lastName,

            @RequestParam("email") String email,

            @RequestParam("password") String password,

            @RequestParam("phoneNumber") String phoneNumber,

            @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) {

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setPhoneNumber(phoneNumber);
        userDTO.setProfileImage(profileImage);

        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    //add this method to the UserController for pagination sort the user and get data from the database
//http://localhost:8080/api/users?page=0&size=2&sort=email,desc
    @GetMapping
    public ResponseEntity<Page<UserDTO>> getUsers(@PageableDefault(size =
            10,sort = "id") Pageable pageable){
        Page<UserDTO> users = userService.getUsers(pageable);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    //this is using for deleting user
    // public ResponseEntity<void> deleteUser(@PathVariable Long id) in void is using then did not get any response back while we delete the user
    //when we add string to the method then gives us response back public ResponseEntity<String> deleteUser(@PathVariable Long id)
    //http://localhost:8080/api/users/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Delete Sucessfully",HttpStatus.OK);
    }

    //This will update all photo ,Password ,everything.
    //http://localhost:8080/api/users/1
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id,

                                          @RequestParam("firstName") String firstName,

                                          @RequestParam("lastName") String lastName,

                                          @RequestParam("email") String email,

                                          @RequestParam("password") String password,

                                          @RequestParam("phoneNumber") String phoneNumber,

                                          @RequestParam(value = "profileImage", required = false)
                                          MultipartFile profileImage) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setPhoneNumber(phoneNumber);
        userDTO.setProfileImage(profileImage);
        UserDTO createdUser = userService.updateUser(id,userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
// this method is used for downloading for the data in the form of Excel
    //localhost:8080/api/users/download
@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
public ResponseEntity<InputStreamResource> downloadUsersAsExcel() {
    try {
        InputStreamResource stream = userService.getUserAsExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.xlsx");
        headers.add("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        return ResponseEntity.ok()
                .headers(headers)
                .body(stream);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    // this method is used for downloading for the data in the form of pdf
    //http://localhost:8080/api/users/users/pdf
    @GetMapping(value = "/users/pdf", produces =
            MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getUserAsPdf() {
        try {
            InputStreamResource pdf = userService.getUserAsPdf();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=users.pdf");
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdf);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //http://localhost:8080/api/users/csv

    @GetMapping(value = "/csv",produces = "text/csv")
    public ResponseEntity<InputStreamResource> getUserCsv() {
        InputStreamResource csvStream = userService.getUserCsv();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.csv");
        return
                ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType(" text/csv")).body(csvStream);
    }

}




