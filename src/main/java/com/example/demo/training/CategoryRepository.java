package com.example.demo.training;
import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findOneByName(String name);
}
