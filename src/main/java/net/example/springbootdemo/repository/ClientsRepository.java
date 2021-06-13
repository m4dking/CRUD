package net.example.springbootdemo.repository;

import net.example.springbootdemo.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients,Long> {

    List<Clients> findClientsByManager(String manger);

    List<Clients> findClientsByAdress(String adress);
}
