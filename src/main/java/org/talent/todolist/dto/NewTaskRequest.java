package org.talent.todolist.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.talent.todolist.entity.Category;
import org.talent.todolist.enumeration.RepeatType;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class NewTaskRequest {
    private String label;
    private String startTime;
    private String endTime;
    private RepeatType repeatType;
    private Category category;
    // getters and setters

    public NewTaskRequest(String label, String startTime, String endTime, RepeatType repeatType, Category category) {
        this.label = label;
//        this.startTime = LocalTime.parse(startTime);
//        this.endTime = LocalTime.parse(endTime);
        this.startTime = startTime;
        this.endTime = endTime;
        this.repeatType = repeatType;
        this.category = category;
    }
}
