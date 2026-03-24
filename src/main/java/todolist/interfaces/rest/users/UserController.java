package todolist.interfaces.rest.users;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import todolist.application.users.CreateUserUseCase;
import todolist.application.users.GetAllUsersUseCase;
import todolist.application.users.GetUserByIdUseCase;
import todolist.application.users.UpdateUserByIdUseCase;
import todolist.interfaces.rest.users.requests.UserRequestDTO;
import todolist.interfaces.rest.users.responses.UserResponseDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
  private final CreateUserUseCase createUserUseCase;
  private final GetAllUsersUseCase getAllUsersUseCase;
  private final GetUserByIdUseCase getUserByIdUseCase;
  private final UpdateUserByIdUseCase updateUserByIdUseCase;

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO request) {
    UserResponseDTO response = createUserUseCase.execute(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    List<UserResponseDTO> response = getAllUsersUseCase.execute();

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id) {
    UserResponseDTO response = getUserByIdUseCase.execute(id);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponseDTO> updateUserById(@PathVariable UUID id, UserRequestDTO request) {
    UserResponseDTO response = updateUserByIdUseCase.execute(id, request);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
