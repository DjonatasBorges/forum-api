package br.com.apiforum.request.user;

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
@NoArgsConstructor
@AllArgsConstructor
public class UserPutRequestBody {

    @NotNull @Min(0)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    private String name;

    @NotNull @NotEmpty @NotBlank
    private String email;

    @NotNull @NotEmpty @NotBlank
    private String password;

}
