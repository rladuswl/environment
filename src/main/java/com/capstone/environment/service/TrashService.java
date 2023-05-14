package com.capstone.environment.service;

import com.capstone.environment.domain.Trash;
import com.capstone.environment.repository.TrashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrashService {

    private final TrashRepository trashRepository;

    public String trash(String word) {
        String result = "";

        List<Trash> trash = trashRepository.findAll(word);
        //System.out.println(trash.get(0).getItem());

        result = trash.get(0).getItem();

        return result;
    }
}
