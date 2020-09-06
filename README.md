ECONOVATION HEROES 2기 2기 Java Racing Game Practice

#####step1
- 접근제어자 접근 범위를 생각하고 사용하기
- CamelCase 따르기
- 스터디 규칙 : 모든 변수명은 줄여쓰지 않는다
- 불필요한 공백 포함하지 않기
- Java 는 메모리를 직접 접근하여 해제하지 않고 Garbage Collector 를 사용하여
 메모리 해제함.
 
 #####step2
 - primitive 타입과 wrapper 타입의 차이점 
 - 게임의 룰은 어떤 클래스에 적용할 것인가?
 - code formatting 습관 들이기
 - magic number 상수로 추출(상수는 네이밍은 대문자로 하는 것이 룰)
 - 의존성 측면 고려하고 코드짜기
 
 ######refactoring: 
 - InputView 클래스 상수 타입 변환
 - Race 클래스 상수 네이밍 대문자 처리
 - CamelCase에 따라 네이밍 고치기
 - 게임의 룰을 관리할 Rule 클래스 생성
 - setter 사용 지양
 - 불필요한 코드 주석 및 공백 제거
 - stream api 적용
 - 게임 시작을 위한 input 과 관련된 print 는 inputview로 옮기기
 - View 에 대한 책임을 Main(RacingGame) 으로 위임
 - InputView static 메소드로 구성하여 객체 생성 비용을 절감하기
 (추가)
 - 메서드 체이닝을 적용해서 Arrays.stream(trimmedInputCarName).forEach(~~)
  로 이어 붙이기
 - util 목적으로 사용하실 클래스 객체 생성 비용 줄이기
 - 의미없는 메모리 낭비 없애기
 - 가독성에 유리하게 선언과 할당 같은 곳에서 해주기
 ######해야할 일
 - 테스트 코드 작성
 테스트 코드를 작성하다보니 public으로만 테스트가 안된다는 점에서 코드가 잘 짜여지지 않다고 느꼈다.
 테스트 코드를 먼저 작성하고 그에 맞추어 코드를 작성해야할까?
 
 
 

 
