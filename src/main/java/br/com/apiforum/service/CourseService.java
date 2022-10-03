package br.com.apiforum.service;

import br.com.apiforum.domain.Course;
import br.com.apiforum.mappers.CourseMapper;
import br.com.apiforum.repository.CourseRepository;
import br.com.apiforum.request.course.CoursePostRequestBody;
import br.com.apiforum.request.course.CoursePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findByIdOrThrowBadRequestException(long id) {
        return courseRepository.findById(id).get();
    }

    public Course save(CoursePostRequestBody coursePostRequestBody) {
        return courseRepository.save(CourseMapper.INSTANCE.convertToCourseMethodPost(coursePostRequestBody));
    }

    public void delete(long id) {
        courseRepository.deleteById(id);
    }

    public Course replace(CoursePutRequestBody coursePutRequestBody) {
        Course savedCourse = findByIdOrThrowBadRequestException(coursePutRequestBody.getId());
        Course course = CourseMapper.INSTANCE.convertToCourseMethodPut(coursePutRequestBody);
        course.setId(savedCourse.getId());
        return courseRepository.save(course);
    }
}
