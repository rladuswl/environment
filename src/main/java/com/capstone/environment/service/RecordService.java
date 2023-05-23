package com.capstone.environment.service;

import com.capstone.environment.domain.Record;
import com.capstone.environment.domain.User;
import com.capstone.environment.dto.RecordReqDTO;
import com.capstone.environment.repository.RecordRepository;
import com.capstone.environment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    public List<Record> records(Long user_id) {
        List<Record> recordList = recordRepository.findByUserId(user_id);
        return recordList;
    }

    public Record recordDetail(Long record_id) {
        Optional<Record> record = recordRepository.findById(record_id);
        return record.get();
    }

    public String record(Long user_id, RecordReqDTO recordReqDTO) {

        Optional<User> user = userRepository.findById(user_id);

        Record record = Record.builder()
                .title(recordReqDTO.getTitle())
                .content(recordReqDTO.getContent())
                .image(recordReqDTO.getImage())
                .user(user.get()).build();

        recordRepository.save(record);

        return "200";
    }

    public String recordUpdate(Long record_id, RecordReqDTO recordReqDTO) {

        Optional<Record> record = recordRepository.findById(record_id);

        record.get().setTitle(recordReqDTO.getTitle());
        record.get().setContent(recordReqDTO.getContent());
        record.get().setImage(recordReqDTO.getImage());

        recordRepository.save(record.get());

        return "200";
    }

    public String recordDelete(Long record_id) {
        recordRepository.deleteById(record_id);
        return "200";
    }
}
