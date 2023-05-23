package com.capstone.environment.controller;

import com.capstone.environment.domain.Record;
import com.capstone.environment.dto.RecordReqDTO;
import com.capstone.environment.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    // 기록 전체보기
    @GetMapping("/home/record/{user_id}")
    public List<Record> records(@PathVariable Long user_id) {

        return recordService.records(user_id);
    }

    // 기록 상세보기
    @GetMapping("/record/{record_id}")
    public Record recordDetail(@PathVariable Long record_id) {
        return recordService.recordDetail(record_id);
    }

    // 기록 작성
    @PostMapping("/record/{user_id}")
    public String record(@PathVariable Long user_id, @RequestBody RecordReqDTO recordReqDTO) {
        return recordService.record(user_id, recordReqDTO);
    }

    // 기록 수정
    @PatchMapping("/record/{record_id}")
    public String recordUpdate(@PathVariable Long record_id, @RequestBody RecordReqDTO recordReqDTO) {
        return recordService.recordUpdate(record_id, recordReqDTO);
    }

    // 기록 삭제
    @DeleteMapping("/record/{record_id}")
    public String recordDelete(@PathVariable Long record_id) {
        return recordService.recordDelete(record_id);
    }
}
