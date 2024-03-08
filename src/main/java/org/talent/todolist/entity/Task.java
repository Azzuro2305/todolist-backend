package org.talent.todolist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.talent.todolist.enumeration.RepeatType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
//    @Column(columnDefinition = "NVARCHAR(30)")
    private String startTime;
    private String endTime;

    @Enumerated(EnumType.STRING) // without this, the default is EnumType.ORDINAL
    private RepeatType repeatType;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;


    public Task(String label, String startTime, String endTime, RepeatType repeatType, Category category) {
        this.label = label;
        this.startTime = startTime;
        this.endTime = endTime;
        this.repeatType = repeatType;
        this.category = category;
    }
}
