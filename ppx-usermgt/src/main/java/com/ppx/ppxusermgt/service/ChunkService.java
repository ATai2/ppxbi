package com.ppx.ppxusermgt.service;

import com.ppx.ppxusermgt.entity.Chunk;

public interface ChunkService {
    void saveChunk(Chunk chunk);

    boolean checkChunk(String identifier, Integer chunkNumber);
}
