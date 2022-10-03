package br.com.apiforum.repository;

import br.com.apiforum.domain.Course;
import br.com.apiforum.request.course.CoursePutRequestBody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
