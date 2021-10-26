package Sykodev.Steam.repository;

import Sykodev.Steam.models.entity.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
}
