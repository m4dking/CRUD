package net.example.springbootdemo.repository;

import net.example.springbootdemo.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients,Long> {
}
