package todolist.infra.persistence.users;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.domain.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    
}
