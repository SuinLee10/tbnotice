package com.example.tbnotice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


public class CommonDto {
    @Builder
    @Schema
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TbnoticeDetailResDto {
        String id;
        String title;
        String cate;
        String content;
    }
}
