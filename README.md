# oauth-login-api
oauth2.0 프로토콜기반 인증서버 (제휴앱관리,계정관리)

---

## 목차

 * [기능리스트](#기능리스트)

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
   * 플랫폼 설정: Client 사이트도메인
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

