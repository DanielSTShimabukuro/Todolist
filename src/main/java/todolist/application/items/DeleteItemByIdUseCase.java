package todolist.application.items;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import todolist.application.exceptions.NotFoundException;
import todolist.domain.items.Item;
import todolist.infra.persistence.items.ItemRepository;

@RequiredArgsConstructor
@Service
public class DeleteItemByIdUseCase {
  private final ItemRepository repository;

  @Transactional
  public void execute(UUID id) {
    Item item = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Item Not Found."));

    this.repository.delete(item);
  }
}
