package todolist.application.users;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import todolist.domain.users.User;
import todolist.infra.persistence.users.UserRepository;
import todolist.interfaces.rest.users.requests.UserCreateRequestDTO;
import todolist.interfaces.rest.users.responses.UserResponseDTO;

@RequiredArgsConstructor
@Service
public class CreateUserUseCase {
  private final UserRepository repository;

  @Transactional
  public UserResponseDTO execute(UserCreateRequestDTO request) {
    User user = new User(request);

    repository.save(user);

    return UserResponseDTO.from(user);
  }
}
