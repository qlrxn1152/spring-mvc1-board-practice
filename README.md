# Spring MVC1 Board Practice

Spring MVC1에서 학습한 내용을 적용해보기 위한 게시판 미니 프로젝트입니다.

## 프로젝트 목적

이 프로젝트는 Spring MVC의 기본 흐름을 직접 구현하며 복습하는 것을 목표로 합니다.

- Controller
- Request Mapping
- Model
- View Resolver
- Thymeleaf
- Form 처리
- Redirect
- PRG 패턴
- Memory Repository

## 기술 스택

- Java
- Spring Boot
- Spring MVC
- Thymeleaf
- Lombok
- Gradle

## 주요 기능

- 게시글 목록 조회
- 게시글 상세 조회
- 게시글 작성
- 게시글 수정
- 게시글 삭제

## URL 설계

| 기능 | Method | URL |
|---|---|---|
| 게시글 목록 | GET | `/posts` |
| 게시글 상세 | GET | `/posts/{postId}` |
| 게시글 작성 폼 | GET | `/posts/new` |
| 게시글 저장 | POST | `/posts/new` |
| 게시글 수정 폼 | GET | `/posts/{postId}/edit` |
| 게시글 수정 | POST | `/posts/{postId}/edit` |
| 게시글 삭제 | POST | `/posts/{postId}/delete` |

## 프로젝트 구조

```text
src/main/java/com/example/mvcboard
 ├── controller
 │    └── PostController.java
 ├── domain
 │    └── Post.java
 ├── service
 │    └── impl
   │    └── PostServiceImpl.java
 │    └── PostService.java
 └── repository
 │    └── impl
 │      └── PostRepositoryImpl.java
 │    └── PostRepository.java
