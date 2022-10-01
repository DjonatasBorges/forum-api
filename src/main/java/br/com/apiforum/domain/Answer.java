package br.com.apiforum.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("topicId")
//    @JoinColumn(name = "ID_TOPIC")
//    private Topic topic;

    @CreationTimestamp
    private ZonedDateTime creationDate = ZonedDateTime.now();

//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("authorId")
//    @JoinColumn(name = "ID_AUTHOR")
//    private User author;

    private Boolean solution = false;
}
