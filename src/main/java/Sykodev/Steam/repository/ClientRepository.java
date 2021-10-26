package Sykodev.Steam.repository;

import Sykodev.Steam.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
