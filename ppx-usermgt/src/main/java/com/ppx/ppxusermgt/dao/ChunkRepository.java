package com.ppx.ppxusermgt.dao;

import com.ppx.ppxusermgt.entity.Chunk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChunkRepository extends JpaRepository<Chunk, Long>, JpaSpecificationExecutor {
}
