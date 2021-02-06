package com.example.demo.training;
import com.example.demo.model.Category;
import com.example.demo.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    Optional<Subcategory> findOneByName(String name);

    @Query("select s from Subcategory s where s.category = :category")
    public List<Subcategory> findAllByCategory(Category category);
}
