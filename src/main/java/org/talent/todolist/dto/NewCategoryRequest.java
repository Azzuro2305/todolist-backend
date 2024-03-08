package org.talent.todolist.dto;

import lombok.*;
import org.talent.todolist.entity.Category;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewCategoryRequest {
    private String name;
    private String imageUrl;
}
