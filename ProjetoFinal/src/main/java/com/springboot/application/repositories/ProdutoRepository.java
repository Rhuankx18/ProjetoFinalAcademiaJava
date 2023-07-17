package com.springboot.application.repositories;

import com.springboot.application.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface   ProdutoRepository extends JpaRepository<Produto, Long> {

}
