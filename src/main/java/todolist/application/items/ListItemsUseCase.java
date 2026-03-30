package todolist.application.items;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import todolist.infra.persistence.items.ItemRepository;
import todolist.interfaces.rest.items.responses.ItemResponseDTO;

@RequiredArgsConstructor
@Service
public class ListItemsUseCase {
  private final ItemRepository repository;

  @Transactional(readOnly = true)
  public List<ItemResponseDTO> execute() {
    return this.repository
                .findAll()
                .stream()
                .map(ItemResponseDTO::from)
                .toList();
  }
}
