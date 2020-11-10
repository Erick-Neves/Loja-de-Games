package com.SlimeInc.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SlimeInc.games.model.Linguagens;

@Repository
public interface LinguagensRepository extends JpaRepository<Linguagens, Long>{
	
	public List<Linguagens> findAllByNomeContainingIgnoreCase (String nome);

}
