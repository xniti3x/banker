package com.banker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Token {
    private String access;
    private int access_expires;
    private String refresh;
    private int refresh_expires;
}
