package postgres;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PostgresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
