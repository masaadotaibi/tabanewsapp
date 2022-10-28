package com.tabdaul.tabanewsapp.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/25/2022 at 23:46
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
