package todolist.domain.items;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todolist.domain.users.User;
import todolist.interfaces.rest.items.requests.ItemRequestDTO;

@Entity(name = "items")
@Table(name = "items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Setter
  @Column(nullable = false, length = 30)
  private String name;

  @Setter
  @Column(length = 5000)
  private String description;

  @Setter
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private ItemType type;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(nullable = false, name = "user_id")
  private User user;

  public Item(ItemRequestDTO request, User user) {
    this.name = request.name();
    this.description = request.description();
    this.type = ItemType.PENDING;
    this.user = user;
  }
}
