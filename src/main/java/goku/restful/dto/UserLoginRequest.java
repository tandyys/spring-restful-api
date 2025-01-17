package goku.restful.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginRequest {
      @NotBlank
      @Size(max = 100)
      private String email;

      @NotBlank
      @Size(max = 100)
      private String password;
}
