package com.example.demo.subcategory;
import com.example.demo.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    Optional<Subcategory> findOneByName(String name);

    @Query("select s from Subcategory s where s.category = :category")
    public List<Subcategory> findAllByCategory(Category category);
}
