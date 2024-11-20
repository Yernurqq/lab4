package postgres;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresRepository extends JpaRepository<PostgresEntity, Long> {
}
