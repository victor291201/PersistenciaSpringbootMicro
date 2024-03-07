package com.micro.micro.repository;

import com.micro.micro.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByCreadorAndDestinator(String creator, String destinator );

}
