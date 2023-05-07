package com.example.teachSystem.Serve;

import com.example.teachSystem.Entity.Knowledge;
import com.example.teachSystem.Entity.ReadLog;
import com.example.teachSystem.formbean.KnowledgeForm;

import java.util.List;

public interface KnowledgeService {

    KnowledgeForm saveKnowledge(Knowledge knowledge);

    Knowledge getKnowledgeById(Integer id);

    List<Knowledge> getAllKnowledge();

    Knowledge updateKnowledge(Integer id, Knowledge knowledge);

    void deleteKnowledgeById(Integer id);
//    KnowledgeForm addExample(Integer id);
    void addReadLog(Integer knowledgeId, String reader);

    List<ReadLog> getReadLogs(Integer knowledgeId, Integer limit, Integer offset);
    Long getReadCount(Integer knowledgeId);
}
