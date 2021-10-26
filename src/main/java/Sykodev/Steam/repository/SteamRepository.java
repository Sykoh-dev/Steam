package Sykodev.Steam.repository;

import Sykodev.Steam.models.entity.Steam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SteamRepository extends JpaRepository<Steam, Long> {
}
