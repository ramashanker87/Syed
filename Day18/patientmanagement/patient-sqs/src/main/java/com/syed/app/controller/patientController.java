package com.syed.app.controller;

import com.prashant.app.module.Patient;
import com.prashant.app.service.PatientService;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class patientController {

    private final PatientService patientService;

    private final ObjectMapper objectMapper;

    public patientController(PatientService patientService, ObjectMapper objectMapper) {
        this.patientService = patientService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Patient patient, @RequestHeader("sessionid") String sessionId) throws JsonProcessingException {
        Map<String, Object> headers = new HashMap<>();
        String correlationId = UUID.randomUUID().toString();
        headers.put("sessionid", sessionId);
        headers.put("correlationId", correlationId);
        String requestMessage = objectMapper.writeValueAsString(patient);
        patientService.sendMessage(requestMessage, headers);
        return sessionId;
    }
}
