package br.com.apiforum.request.topic;

import br.com.apiforum.domain.Answer;
import br.com.apiforum.domain.Course;
import br.com.apiforum.domain.User;
import br.com.apiforum.enums.StatusTopic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicResponse {
    private Long id;

    private String title;

    private String message;

    private ZonedDateTime creationDate;

    private StatusTopic status;

    private User author;

    private Course course;

    private List<Answer> answer = new ArrayList<>();
}
