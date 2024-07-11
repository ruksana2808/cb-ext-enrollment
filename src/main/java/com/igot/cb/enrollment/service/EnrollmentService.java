package com.igot.cb.enrollment.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.igot.cb.util.dto.CustomResponse;

public interface EnrollmentService {

  public CustomResponse enrollUser(JsonNode userCourseEnroll, String token);

  public CustomResponse readByCourseId(String id);
}
