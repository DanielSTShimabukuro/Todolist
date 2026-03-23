package todolist.interfaces.rest.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import todolist.application.users.CreateUserUseCase;
import todolist.interfaces.rest.users.requests.UserCreateRequestDTO;
import todolist.interfaces.rest.users.responses.UserResponseDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
  private final CreateUserUseCase createUserUseCase;

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateRequestDTO request) {
    UserResponseDTO response = this.createUserUseCase.execute(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
