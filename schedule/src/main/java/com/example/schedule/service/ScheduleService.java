package com.example.schedule.service;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.dto.ScheduleWithAgeResponseDto;
import com.example.schedule.entity.Member;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.MemberRepository;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final MemberRepository memberRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String title, String content, String username) {

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, content);
        schedule.setMember(findMember);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }
    public ScheduleWithAgeResponseDto findById(Long id) {
        Schedule findBoard = scheduleRepository.findByIdOrElseThrow(id);
        Member writer = findBoard.getMember();

        return new ScheduleWithAgeResponseDto(findBoard.getTitle(), findBoard.getContents(), writer.getAge());
    }
    public void delete(Long id) {

        Schedule findBoard = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findBoard);
    }
    public void update(Long id, String title, String contents) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정이 존재하지 않습니다."));

        schedule.update(title, contents);
    }

  }


