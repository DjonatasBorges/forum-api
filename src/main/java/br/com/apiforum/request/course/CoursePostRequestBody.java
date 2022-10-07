package br.com.apiforum.request.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoursePostRequestBody {

    @NotNull @NotEmpty @NotBlank
    private String name;

    @NotNull @NotEmpty @NotBlank
    private String category;

}
