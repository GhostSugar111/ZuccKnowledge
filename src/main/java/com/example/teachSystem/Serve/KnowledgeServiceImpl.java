package com.example.teachSystem.Serve;

import com.example.teachSystem.Entity.Knowledge;
import com.example.teachSystem.formbean.KnowledgeForm;
import com.example.teachSystem.repository.KnowledgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;

    @Autowired
    public KnowledgeServiceImpl(KnowledgeRepository knowledgeRepository) {
        this.knowledgeRepository = knowledgeRepository;
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
}
