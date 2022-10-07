package br.com.apiforum.request.answer;

import br.com.apiforum.domain.Topic;
import br.com.apiforum.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponse {
    private Long id;

    private String message;

    private Topic topic;

    private ZonedDateTime creationDate;

    private User author;

    private Boolean solution = false;
}
