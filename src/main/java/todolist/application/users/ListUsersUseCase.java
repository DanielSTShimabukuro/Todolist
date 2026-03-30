package todolist.application.users;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import todolist.infra.persistence.users.UserRepository;
import todolist.interfaces.rest.users.responses.UserResponseDTO;

@RequiredArgsConstructor
@Service
public class ListUsersUseCase {
  private final UserRepository repository;

  @Transactional(readOnly = true)
  public List<UserResponseDTO> execute() {
    return this.repository
                .findAll()
                .stream()
                .map(UserResponseDTO::from)
                .toList();
  }
}
