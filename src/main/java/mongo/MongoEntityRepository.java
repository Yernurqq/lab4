package mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoEntityRepository extends MongoRepository<com.example.lab4.mongo.MongoEntity, String> {

}
