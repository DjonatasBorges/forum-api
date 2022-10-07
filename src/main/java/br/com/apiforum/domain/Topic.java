package br.com.apiforum.domain;

import br.com.apiforum.enums.StatusTopic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    @CreationTimestamp
    private ZonedDateTime creationDate = ZonedDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopic status = StatusTopic.NOT_ANSWERED;

    @ManyToOne
    private User author;

    @ManyToOne
    private Course course;

    @OneToMany
    private List<Answer> answer = new ArrayList<>();
}
