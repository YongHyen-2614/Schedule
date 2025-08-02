# Schedule Management API (1~2단계 구현)

---

## 기능 요약

- **회원가입**: 유저 생성
- **일정**: 생성, 조회, 수정, 삭제
- **댓글**: 생성, 조회, 수정, 삭제 (일정과 연관)

---

## API 명세

### 회원 기능

#### 
[POST] /members/signup – 회원가입
[POST] /schedules/create – 일정 생성
[GET] /schedules – 전체 일정 조회
[GET] /schedules/{id} – 일정 단건 조회
[PUT] /schedules/{id} – 일정 수정
[DELETE] /schedules/{id} – 일정 삭제
[POST] /schedules/{Id}/comments – 댓글 등록
[GET] /schedules/{Id}/comments – 일정의 댓글 전체 조회
[GET] /schedules/{Id}/comments/{commentId} – 댓글 단건 조회
[PUT] /schedules/{Id}/comments/{commentId} – 댓글 수정
[DELETE] /schedules/{Id}/comments/{commentId} – 댓글 삭제

ERD
[Member]
- id (PK)
- username
- password
- age
- created_at
- modified_at

[Schedule]
- id (PK)
- title
- contents
- member_id (FK → Member.id)
- created_at
- modified_at

[Comment]
- id (PK)
- content
- username
- schedule_id (FK → Schedule.id)
- created_at
- modified_at

관계:
Member (1) ─── (N) Schedule  
Schedule (1) ─── (N) Comment
