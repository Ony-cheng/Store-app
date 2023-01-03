package ony.store.repositories;

import ony.store.model.SomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<SomeEntity, Long> {
}
