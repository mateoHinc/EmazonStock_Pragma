package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.feigns.DTO.response;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationResponse {
    private boolean authorized;
    private String email;
    private String role;
}
