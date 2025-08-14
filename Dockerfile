
# 1. 베이스 이미지 선택 (Java 24)
FROM openjdk:24-jdk-slim

LABEL authors="jsh03"

# 2. Gradle 빌드 결과물인 JAR 파일의 경로를 변수로 지정
ARG JAR_FILE=build/libs/*.jar

# 3. JAR 파일을 app.jar 라는 이름으로 컨테이너 내부에 복사
COPY ${JAR_FILE} app.jar

# 4. 컨테이너가 시작될 때 애플리케이션 실행
ENTRYPOINT ["java","-jar","/app.jar"]