# jetkins_test

Simple **Maven + JDK 17 + Git** sample project for learning Jenkins CI/CD on ATOM.

Local path: `~/projects/jetkins_test`  
Intended GitHub URL: https://github.com/awesometawkir/jetkins_test

## Push to GitHub (one-time)

Local CLI auth on this machine is expired. After you create an **empty** public repo named `jetkins_test` (no README) at https://github.com/new :

```bash
gh auth login -h github.com -p https -w
cd ~/projects/jetkins_test
git push -u origin main
```

Then use `https://github.com/awesometawkir/jetkins_test.git` as the Jenkins Git URL.

## What this project is

| Piece | Details |
| --- | --- |
| Language | Java 17 |
| Build | Apache Maven (`pom.xml`) |
| Tests | JUnit 5 (`AppTest`) |
| App | `com.example.demo.App` — prints a greeting and exposes `greet` / `add` |

## Build locally (optional)

```bash
cd ~/projects/jetkins_test
mvn -B clean test
mvn -B package
java -jar target/jetkins-test-1.0.0-SNAPSHOT.jar
```

## Your Jenkins setup (already on this machine)

- UI: http://localhost:8081
- Compose project: `~/projects/jenkins-cicd`
- Container JDK: `/opt/java/openjdk` (JDK 17)
- Start if needed: `cd ~/projects/jenkins-cicd && docker compose up -d`

## Suggested Jenkins lab steps

### 1. Install tools in Jenkins (Manage Jenkins → Tools)

- **JDK**: name it e.g. `jdk17`, JAVA_HOME = `/opt/java/openjdk` (or Install automatically)
- **Maven**: name it e.g. `maven3`, Install automatically (or point at a Maven home)

### 2. Freestyle job (classic)

1. New Item → Freestyle project → name e.g. `jetkins-test-freestyle`
2. Source Code Management → Git → Repository URL = this GitHub repo HTTPS URL
3. Branch: `*/main`
4. Build Environment / Build steps:
   - Invoke top-level Maven targets: `clean test package`
5. Save → Build Now → open Console Output

### 3. Pipeline job (recommended)

1. New Item → Pipeline → name e.g. `jetkins-test-pipeline`
2. Pipeline → Definition: **Pipeline script from SCM**
3. SCM: Git → same repo URL, branch `*/main`
4. Script Path: `Jenkinsfile`
5. Save → Build Now

A starter `Jenkinsfile` is included in this repo.

### 4. What success looks like

- Git checkout succeeds
- Maven downloads dependencies
- JUnit tests pass (`AppTest`)
- `package` produces `jetkins-test-1.0.0-SNAPSHOT.jar` in `target/`

## Project layout

```
jetkins_test/
├── Jenkinsfile
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/example/demo/App.java
    └── test/java/com/example/demo/AppTest.java
```
