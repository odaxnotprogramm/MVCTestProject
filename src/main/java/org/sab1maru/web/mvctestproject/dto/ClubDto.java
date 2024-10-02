package org.sab1maru.web.mvctestproject.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClubDto {
    private Integer id;
    private String title;
    private String photoUrl;
    private String content;
}
