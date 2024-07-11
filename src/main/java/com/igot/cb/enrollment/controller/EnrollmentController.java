package com.igot.cb.enrollment.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.igot.cb.enrollment.service.EnrollmentService;
import com.igot.cb.util.dto.CustomResponse;
import com.igot.cb.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

  @Autowired
  private EnrollmentService enrollmentService;

  @PostMapping("/create")
  public ResponseEntity<CustomResponse> create(@RequestBody JsonNode userCourseEnroll, @RequestHeader(Constants.X_AUTH_TOKEN) String token) {
    CustomResponse response = enrollmentService.enrollUser(userCourseEnroll, token);
    return new ResponseEntity<>(response, response.getResponseCode());
  }

  @GetMapping("/listByUserId/{id}")
  public ResponseEntity<?> readByCourseId(@PathVariable String id, @RequestHeader(Constants.X_AUTH_TOKEN) String token) {
    CustomResponse response = enrollmentService.readByCourseId(id);
    return new ResponseEntity<>(response, response.getResponseCode());
  }
}
