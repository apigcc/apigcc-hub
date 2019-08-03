package com.apigcc.hub.dto;

import com.apigcc.hub.entity.BookGroup;
import lombok.Data;

import java.util.List;

@Data
public class BookDTO {

    String id;
    /**
     * 项目名标题
     */
    String title;

    List<BookGroup> groups;

}
