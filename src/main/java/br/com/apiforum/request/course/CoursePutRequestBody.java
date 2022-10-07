package br.com.apiforum.request.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoursePutRequestBody {
    @NotNull @Min(1)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    private String name;

    private String category;

}
