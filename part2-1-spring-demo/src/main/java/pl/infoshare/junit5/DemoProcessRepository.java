package pl.infoshare.junit5;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoProcessRepository extends JpaRepository<DemoProcess, Integer> {
}
