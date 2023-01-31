# oauth-login-api
oauth2.0 프로토콜기반 인증서버 (제휴앱관리,계정관리)

---

## 목차

 * [기능리스트](#기능리스트)
 * [테이블 스키마](#테이블&nbsp;스키마)

---

### 기능리스트

1. 계정관리
   * 로그인화면 view
     * redirect 기능 추가 (oauth 제휴앱 인증을 위해)
   * 로그인 기능
   * 계정정보 조회: 닉네임, 이메일, 생년월일, 성별, 이름, AccountId
   * 연동된 제휴앱 관리
2. 제휴앱 관리
   * appId, appName 등록
   * 제휴앱 정보 조회: appKey (admin, rest)
   * 팀(권한) 관리
   * Redirect URI 관리
   * Client Secret 관리
   * 동의항목 관리 (scope)
3. oauth 제휴앱 인증
   * 로그인화면 view
     * redirect를 통해 특정 제휴앱 연동여부 체크
     * 미연동시 연동안내화면 제공 (동의여부, 동의항목)
   * 인가코드(authorization_code) 요청 API
   * 토큰발급 API
   * 토큰 유효성체크 API
   * Access Token 재발급 API (by, Refresh Token)
   * 로그아웃 API (토큰파기 - access_token, refresh_token)
   * 연결끊기 API (제휴앱 연결끊기)
4. 부가기능
   * PKCE 기능 (보안)
   * 공식문서 학습하면서 추가할 예정


### 테이블&nbsp;스키마

 * 사용자 계정관리 테이블
   ```
   create table USER_MGMT_TB
   (
      USER_ID varchar(255) not null,
      PASSWORD varchar(255) not null,
      NICKNAME varchar(255),
      EMAIL varchar(255) not null,
      BIRTHDAY varchar(255),
      GENDER varchar(255) check(GENDER IN ('W', 'M')),
      KOR_NAME varchar(255),
      UPDATED_AT timestamp default now(),
      CREATED_AT timestamp not null default now(),
      primary key (USER_ID)
   );
   comment on table USER_MGMT_TB is '사용자 계정관리 테이블';
   comment on column USER_MGMT_TB.USER_ID is '사용자 ID';
   ```
 
 * 제휴앱 관리 테이블
   ```
   create table APP_MGMT_TB
   (
      APP_ID varchar(255) not null,
      APP_NAME varchar(255) not null,
      APPKEY_ADMIN varchar(255),
      APPKEY_REST varchar(255),
      CLIENT_SECRET varchar(255),
      CLIENT_SECRET_STATUS tinyint check(CLIENT_SECRET_STATUS IN (0, 1)),
      UPDATED_AT timestamp default now(),
      CREATED_AT timestamp not null default now(),
      primary key (APP_ID)
   )
   ```
 
 * 제휴앱 팀(권한)관리 테이블
   ```
   create table APP_MEMBER_TB
   (
      APP_ID varchar(255) not null,
      USER_ID varchar(255) not null,
      GRANT_TYPE varchar(255),
      UPDATED_AT timestamp default now(),
      CREATED_AT timestamp not null default now(),
      primary key (APP_ID, USER_ID)
      foreign key (APP_ID) references APP_MGMT
      foreign key (USER_ID) references USER
   )
   ```

 * Redirect URI 관리 테이블
   ```
   create table APP_REDIRECT_TB
   (
      APP_ID varchar(255) not null,
      REDIRECT_URI varchar(255),
      UPDATED_AT timestamp default now(),
      CREATED_AT timestamp not null default now(),
      primary key (APP_ID, REDIRECT_URI)
      foreign key (APP_ID) references APP_MGMT
   )
   ```
  
 * 동의항목 관리 테이블
   ```
   create table APP_SCOPE_TB
   (
      APP_ID varchar(255) not null,
      SCOPE_ID varchar(255),
      SCOPE_NAME varchar(255),
      CONSENT_TYPE tinyint check(CONSENT_TYPE IN (0, 1, 2, 3)),  # 0: 사용안함, 1: 필수동의, 2: 선택동의, 3: 이용중 동의
      UPDATED_AT timestamp default now(),
      CREATED_AT timestamp not null default now(),
      primary key (APP_ID, SCOPE_ID)
      foreign key (APP_ID) references APP_MGMT
   )
   ```
 