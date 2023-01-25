package dev.filipe.crudspring.repository;

import dev.filipe.crudspring.entity.MedicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.DoubleStream;

@Repository
public interface MedicRepository extends JpaRepository<MedicEntity, Long> {

    Page<MedicEntity> findAllByAtivoTrue(Pageable pageable);
}
