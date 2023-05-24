package com.capstone.environment.service;

import com.capstone.environment.domain.Mission;
import com.capstone.environment.domain.MissionRecord;
import com.capstone.environment.domain.User;
import com.capstone.environment.domain.UserMission;
import com.capstone.environment.dto.MissionRecordDTO;
import com.capstone.environment.dto.MissionResDTO;
import com.capstone.environment.repository.MissionRecordRepository;
import com.capstone.environment.repository.MissionRepository;
import com.capstone.environment.repository.UserMissionRepository;
import com.capstone.environment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final MissionRecordRepository missionRecordRepository;
    private final UserMissionRepository userMissionRepository;

    public ArrayList<MissionResDTO> mission(Long user_id) {

        Optional<User> user = userRepository.findById(user_id);
        List<UserMission> userFinishMission = user.get().getMissionFinishList();

        List<Mission> missionList = missionRepository.findAll();

        System.out.println("missionList" + missionList);
        System.out.println("userFinishMission" + userFinishMission);

        ArrayList<MissionResDTO> missionResDTOList = new ArrayList<>();

        for (Mission m : missionList) {
            MissionResDTO missionResDTO = MissionResDTO.builder()
                    .content(m.getContent())
                    .image(m.getImage())
                    .finish("false").build();

            for (UserMission um : userFinishMission) {
                Optional<Mission> mi = missionRepository.findById(um.getMission().getId());
                if (m == mi.get()) {
                    missionResDTO.setFinish("true");
                }
            }

            System.out.println("missionResDTO" + missionResDTO);

            missionResDTOList.add(missionResDTO);
        }

        return missionResDTOList;
    }

    public MissionResDTO missionDetail(Long user_id, Long mission_id) {
        Optional<Mission> mission = missionRepository.findById(mission_id);

        Optional<User> user = userRepository.findById(user_id);
        List<UserMission> userFinishMission = user.get().getMissionFinishList();

        MissionResDTO missionResDTO = MissionResDTO.builder()
                .content(mission.get().getContent())
                .image(mission.get().getImage())
                .finish("false").build();

        for (UserMission um : userFinishMission) {
            Optional<Mission> m = missionRepository.findById(um.getMission().getId());
            if (mission.get() == m.get()) {
                missionResDTO.setFinish("true");
                break;
            }
        }

        return missionResDTO;
    }

    public String missionFinish(Long user_id, Long mission_id) {
        Optional<User> user = userRepository.findById(user_id);
        Optional<Mission> mission = missionRepository.findById(mission_id);

        UserMission userMission = UserMission.builder()
                .mission(mission.get())
                .user(user.get()).build();

        userMissionRepository.save(userMission);

        return "200";
    }

    public String missionRecord(Long user_id, MissionRecordDTO missionRecordDTO) {

        Optional<User> user = userRepository.findById(user_id);

        MissionRecord missionRecord = MissionRecord.builder()
                .content(missionRecordDTO.getContent())
                .image(missionRecordDTO.getImage())
                .user(user.get()).build();

        missionRecordRepository.save(missionRecord);

        return "200";
    }

    public String missionRecordUpdate(Long mission_record_id, MissionRecordDTO missionRecordDTO) {
        Optional<MissionRecord> missionRecord = missionRecordRepository.findById(mission_record_id);

        missionRecord.get().setContent(missionRecordDTO.getContent());
        missionRecordRepository.save(missionRecord.get());

        return "200";
    }

    public String missionRecordDelete(Long mission_record_id) {
        missionRecordRepository.deleteById(mission_record_id);
        return "200";
    }
}
