package com.capstone.environment.service;

import com.capstone.environment.domain.Record;
import com.capstone.environment.domain.User;
import com.capstone.environment.dto.RecordReqDTO;
import com.capstone.environment.dto.RecordResDTO;
import com.capstone.environment.repository.RecordRepository;
import com.capstone.environment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    public ArrayList<RecordResDTO> records(Long user_id) {
        List<Record> recordList = recordRepository.findByUserId(user_id);

        ArrayList<RecordResDTO> resDTOArrayList = new ArrayList<>();

        for (Record r : recordList) {
            RecordResDTO recordResDTO = RecordResDTO.builder()
                    .title(r.getTitle())
                    .content(r.getContent())
                    .image(r.getImage()).build();

            resDTOArrayList.add(recordResDTO);
        }
        return resDTOArrayList;
    }

    public RecordResDTO recordDetail(Long record_id) {
        Optional<Record> record = recordRepository.findById(record_id);
        RecordResDTO recordResDTO = RecordResDTO.builder()
                .title(record.get().getTitle())
                .content(record.get().getContent())
                .image(record.get().getImage()).build();
        return recordResDTO;
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
