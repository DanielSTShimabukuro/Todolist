package todolist.application.users;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import todolist.infra.persistence.users.UserRepository;
import todolist.interfaces.rest.users.responses.UserResponseDTO;

@RequiredArgsConstructor
@Service
public class GetAllUsersUseCase {
  private final UserRepository repository;

  public List<UserResponseDTO> execute() {
    return this.repository
                .findAll()
                .stream()
                .map(user -> UserResponseDTO.from(user))
                .toList();
  }
}
