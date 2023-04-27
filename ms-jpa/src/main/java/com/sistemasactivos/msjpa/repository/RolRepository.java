package com.sistemasactivos.msjpa.repository;

import com.sistemasactivos.msjpa.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
