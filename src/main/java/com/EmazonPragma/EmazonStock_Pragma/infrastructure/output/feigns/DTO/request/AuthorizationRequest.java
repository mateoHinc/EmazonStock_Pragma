package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.feigns.DTO.request;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationRequest {
    private String token;
}
