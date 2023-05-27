package com.capstone.environment.controller;

import com.capstone.environment.domain.Mission;
import com.capstone.environment.dto.MissionRecordDTO;
import com.capstone.environment.dto.MissionResDTO;
import com.capstone.environment.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/home/mission")
    public ArrayList<MissionResDTO> mission() {

        return missionService.mission();
    }

    @GetMapping("/mission/{user_id}/{mission_id}")
    public MissionResDTO missionDetail(@PathVariable Long user_id, @PathVariable Long mission_id) {
        return missionService.missionDetail(user_id, mission_id);
    }

    // 미션 완료 버튼
    @PostMapping("/mission/{user_id}/{mission_id}/finish")
    public String missionFinish(@PathVariable Long user_id, @PathVariable Long mission_id) {
        return missionService.missionFinish(user_id, mission_id);
    }

    // 미션 인증글 작성
    @PostMapping("/mission/{user_id}/{mission_id}")
    public String missionRecord(@PathVariable Long user_id, @RequestBody MissionRecordDTO missionRecordDTO) {
        return missionService.missionRecord(user_id, missionRecordDTO);
    }

    // 미션 인증글 수정
    @PatchMapping("/mission/{user_id}/{mission_id}/{mission_record_id}")
    public String missionRecordUpdate(@PathVariable Long mission_id,
                                      @RequestBody MissionRecordDTO missionRecordDTO) {
        return missionService.missionRecordUpdate(mission_id, missionRecordDTO);
    }

    // 미션 인증글 삭제
    @DeleteMapping("/mission/{user_id}/{mission_id}/{mission_record_id}")
    public String missionRecordDelete(@PathVariable Long mission_record_id) {
        return missionService.missionRecordDelete(mission_record_id);
    }
}
