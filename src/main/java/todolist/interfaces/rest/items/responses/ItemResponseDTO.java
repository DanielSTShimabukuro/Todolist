package todolist.interfaces.rest.items.responses;

import java.time.LocalDateTime;
import java.util.UUID;

import todolist.domain.items.Item;
import todolist.domain.items.ItemType;

public record ItemResponseDTO(
  UUID id,
  String name,
  String description,
  ItemType type,
  LocalDateTime createdAt,
  LocalDateTime updatedAt,
  UUID userId
) {
  public static ItemResponseDTO from(Item item) {
    return new ItemResponseDTO(item.getId(), item.getName(), item.getDescription(), item.getType(), item.getCreatedAt(), item.getUpdatedAt(), item.getUser().getId());
  }
}
