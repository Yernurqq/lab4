package controllers;

import mongo.MongoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import postgres.PostgresEntity;
import postgres.PostgresRepository;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    // Инъекция зависимостей для PostgreSQL
    @Autowired
    private PostgresRepository postgresRepository;

    // Инъекция зависимостей для MongoDB
    @Autowired
    private MongoEntityRepository mongoRepository;

    // CRUD для PostgreSQL
    // Создание
    @PostMapping("/postgres")
    public PostgresEntity createPostgres(@RequestBody PostgresEntity entity) {
        return postgresRepository.save(entity);
    }

    // Чтение всех
    @GetMapping("/postgres")
    public List<PostgresEntity> getAllPostgres() {
        return postgresRepository.findAll();
    }

    // Обновление
    @PutMapping("/postgres/{id}")
    public PostgresEntity updatePostgres(@PathVariable Long id, @RequestBody PostgresEntity entity) {
        PostgresEntity existing = postgresRepository.findById(id).orElseThrow();
        existing.setName(entity.getName());
        existing.setDescription(entity.getDescription());
        return postgresRepository.save(existing);
    }

    // Удаление
    @DeleteMapping("/postgres/{id}")
    public void deletePostgres(@PathVariable Long id) {
        postgresRepository.deleteById(id);
    }

    // CRUD для MongoDB
    // Создание
    @PostMapping("/mongo")
    public com.example.lab4.mongo.MongoEntity createMongo(@RequestBody com.example.lab4.mongo.MongoEntity entity) {
        return mongoRepository.save(entity);
    }

    // Чтение всех
    @GetMapping("/mongo")
    public List<com.example.lab4.mongo.MongoEntity> getAllMongo() {
        return mongoRepository.findAll();
    }

    // Обновление
    @PutMapping("/mongo/{id}")
    public com.example.lab4.mongo.MongoEntity updateMongo(@PathVariable String id, @RequestBody com.example.lab4.mongo.MongoEntity entity) {
        com.example.lab4.mongo.MongoEntity existing = mongoRepository.findById(id).orElseThrow();
        existing.setName(entity.getName());
        existing.setDescription(entity.getDescription());
        return mongoRepository.save(existing);
    }

    // Удаление
    @DeleteMapping("/mongo/{id}")
    public void deleteMongo(@PathVariable String id) {
        mongoRepository.deleteById(id);
    }
}
