package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.feigns;

import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.feigns.DTO.request.AuthorizationRequest;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.feigns.DTO.response.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.configuration.FeignClientConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-MICROSERVICE", url = "${EmazonPragma.EmazonUser_Pragma.base-url}", configuration = FeignClientConfiguration.class)
public interface AuthorizationFeign {
    @PostMapping(value = "/auth/authorize", consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthorizationResponse authorize(@RequestBody AuthorizationRequest authorizationRequest);
}
