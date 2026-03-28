package todolist.infra.persistence.items;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.domain.items.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
  
}
