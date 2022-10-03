package br.com.apiforum.mappers;

import br.com.apiforum.domain.Course;
import br.com.apiforum.request.course.CoursePostRequestBody;
import br.com.apiforum.request.course.CoursePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CourseMapper {
    public static final CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    public abstract Course convertToCourseMethodPost(CoursePostRequestBody coursePostRequestBody);

    public abstract Course convertToCourseMethodPut(CoursePutRequestBody coursePutRequestBody);
}
