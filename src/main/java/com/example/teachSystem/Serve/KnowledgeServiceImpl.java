package com.example.teachSystem.Serve;

import com.example.teachSystem.Entity.Knowledge;
import com.example.teachSystem.Entity.ReadLog;
import com.example.teachSystem.formbean.KnowledgeForm;
import com.example.teachSystem.repository.KnowledgeRepository;
import com.example.teachSystem.repository.ReadLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;
    private final ReadLogRepository readLogRepository;
//    private final RedisTemplate<String, Long> redisTemplate;
    public List<Knowledge> getPrerequisites(Integer knowledgeId) {
        Knowledge currentKnowledge = knowledgeRepository.findById(knowledgeId)
                .orElseThrow(() -> new EntityNotFoundException("Knowledge not found"));
        String frontIds = currentKnowledge.getFront();
        if (frontIds == null || frontIds.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> frontIdsList = Arrays.stream(frontIds.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return knowledgeRepository.findAllById(frontIdsList);
    }

    @Autowired
    public KnowledgeServiceImpl(KnowledgeRepository knowledgeRepository, ReadLogRepository readLogRepository) {
        this.knowledgeRepository = knowledgeRepository;
        this.readLogRepository = readLogRepository;
//        this.redisTemplate = redisTemplate;
    }

    @Override
    public KnowledgeForm saveKnowledge(Knowledge knowledge) {
        knowledgeRepository.save(knowledge);
        return new KnowledgeForm(knowledge);
    }

    @Override
    public Knowledge getKnowledgeById(Integer id) {
        Optional<Knowledge> optionalKnowledge = knowledgeRepository.findById(id);
        return optionalKnowledge.orElse(null);
    }
    @Override
    public List<Knowledge> getKnowledgesByIds(List<Integer> ids) {
        return knowledgeRepository.findByIdIn(ids);
    }

    @Override
    public List<Knowledge> getAllKnowledge() {
        return knowledgeRepository.findAll();
    }

    @Override
    public Knowledge updateKnowledge(Integer id, Knowledge knowledge) {
        Knowledge existingKnowledge = knowledgeRepository.findById(id).orElse(null);
        if (existingKnowledge != null) {
            existingKnowledge.setName(knowledge.getName());
            existingKnowledge.setIntro(knowledge.getIntro());
            existingKnowledge.setKeystatement(knowledge.getKeystatement());
            existingKnowledge.setExample(knowledge.getExample());
            existingKnowledge.setFront(knowledge.getFront());
            return knowledgeRepository.save(existingKnowledge);
        } else {
            return null;
        }
    }

//    @Override
//    public KnowledgeForm addExample(Integer id){
//        Knowledge knowledge = knowledgeRepository.findById(id).orElse(null);
//
//    }
    @Override
    public void deleteKnowledgeById(Integer id) {
        knowledgeRepository.deleteById(id);
    }

    @Override
    public void addReadLog(Integer knowledgeId, String reader) {

    }

    @Override
    public List<ReadLog> getReadLogs(Integer knowledgeId, Integer limit, Integer offset) {
        return null;
    }

    @Override
    public Long getReadCount(Integer knowledgeId) {
        return null;
    }
}
