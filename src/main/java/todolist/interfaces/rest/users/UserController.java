package todolist.interfaces.rest.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import todolist.application.users.CreateUserUseCase;
import todolist.application.users.GetAllUsersUseCase;
import todolist.interfaces.rest.users.requests.UserCreateRequestDTO;
import todolist.interfaces.rest.users.responses.UserResponseDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
  private final CreateUserUseCase createUserUseCase;
  private final GetAllUsersUseCase getAllUsersUseCase;

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateRequestDTO request) {
    UserResponseDTO response = createUserUseCase.execute(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    List<UserResponseDTO> response = getAllUsersUseCase.execute();

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
