package org.talent.todolist.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.talent.todolist.entity.Category;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HttpResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "Asia/Rangoon")
    private Date timeStamp;
    private int httpResponse;
    private HttpStatus httpStatus;
    // message related to the http response
    private String message;
//    private Category category;
    private Object object;

    public HttpResponse(Object object, HttpStatus httpStatus) {
        this.timeStamp = new Date();
        this.httpResponse = httpStatus.value();
        this.httpStatus = httpStatus;
        this.message = httpStatus.getReasonPhrase().toUpperCase();
        this.object = object;
    }
}
