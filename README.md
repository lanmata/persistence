<div align="center">

<img src="docs/images/um-dev-creatives-logo.png" alt="UM Dev Creatives" width="120" />

# 🗄️ Persistence

**JPA persistence library for UM Dev Creative** — entity classes and Spring Data repositories for users, roles,
features, people, contacts, notices, managed clients, and audit events, backed by PostgreSQL.

[![SonarQube Cloud](https://sonarcloud.io/images/project_badges/sonarcloud-light.svg)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)

[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=com.umdc%3Apersistence)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)

[![Quality gate status](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=coverage)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)

[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
[![Maintainability issues](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=software_quality_maintainability_issues)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
[![Reliability issues](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=software_quality_reliability_issues)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
[![Security issues](https://sonarcloud.io/api/project_badges/measure?project=com.umdc%3Apersistence&metric=software_quality_security_issues)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)

<br/>

[![Java](https://img.shields.io/badge/Java-25%20LTS-blue?logo=java&style=flat-square)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen?logo=spring&style=flat-square)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.1.3-brightgreen?logo=spring&style=flat-square)](https://spring.io/projects/spring-cloud)
[![Maven](https://img.shields.io/badge/Maven->=3.8-red?logo=apachemaven&style=flat-square)](https://maven.apache.org/)

[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-42.7.13-blue?logo=postgresql&style=flat-square)](https://www.postgresql.org/)
[![HikariCP](https://img.shields.io/badge/HikariCP-Spring%20Boot%20managed-blue?style=flat-square)](https://github.com/brettwooldridge/HikariCP)
[![JUnit](https://img.shields.io/badge/JUnit-6.1.3-red?logo=junit&style=flat-square)](https://junit.org/)
[![Mockito](https://img.shields.io/badge/Mockito-5.23.0-red?logo=mockito&style=flat-square)](https://site.mockito.org/)
[![SonarCloud](https://img.shields.io/badge/SonarCloud-detected-4E9BCF?logo=sonarcloud&style=flat-square)](https://sonarcloud.io/)

</div>

Overview
--------
Persistence is the shared data-access library for UM Dev Creative. It provides JPA entity classes that map the UM Dev Creative
database schema and a Spring Data repository interface for each entity, covering the common
operations (get, create, update, delete) plus a few domain-specific finders such as
`UserRepository.findByAlias`. It also holds the entities for managed-client (M2M) registration and
the audit trail.

The library is consumed as a Maven dependency (`com.umdc:persistence`) by services such as Backbone
REST. It works with any database supported by a JDBC driver; PostgreSQL is the driver declared in
`pom.xml`. The consuming application owns the datasource and Spring Data configuration.

Requirements
------------
Minimum requirements to build Persistence locally:
- Java 25 (JDK, LTS) or a compatible runtime (Amazon Corretto 25 recommended)
- Maven 3.8+ — **there is no `mvnw` wrapper in this repo**; use your own `mvn`
- `REPSY_USERNAME` / `REPSY_PASSWORD` environment variables, used by `ci_settings.xml` to
  authenticate against the private UM Dev Creative Repsy repository (`com.umdc:commons`)

Quick build
-----------
This project uses Maven — no wrapper script. From the repository root:

```bash
# Fast syntax check (compile only, no tests)
mvn -DskipTests compile

# Full suite: JUnit + JaCoCo + PMD — the correctness/quality gate
mvn test

# Run a single test class
mvn -Dtest=UserEntityTest test

# Produce the library JAR (target/persistence.jar)
mvn -DskipTests package
```

To resolve the private `com.umdc:commons` dependency, export the Repsy credentials and pass the CI
settings file:

```bash
export REPSY_USERNAME=<repsy-user>
export REPSY_PASSWORD=<repsy-password>
mvn -s ci_settings.xml test
```

> Never commit credentials. `ci_settings.xml` only references the environment variables.

Using the library
-----------------
Add the dependency to the consuming project:

```xml
<dependency>
    <groupId>com.umdc</groupId>
    <artifactId>persistence</artifactId>
    <version>0.0.3</version>
</dependency>
```

Then enable the entities and repositories in the consuming Spring Boot application:

```java
@EntityScan("com.umdc.persistence.general.domains")
@EnableJpaRepositories("com.umdc.persistence.general.repositories")
```

Known issues and workarounds
-----------------------------
1. **`Could not resolve com.umdc:commons`**
   - Cause: the private Repsy repository requires credentials.
   - Workaround: export `REPSY_USERNAME` / `REPSY_PASSWORD` and run Maven with `-s ci_settings.xml`.

2. **Tests that read `test.user.password` get `null`**
   - Cause: `System.getProperty("test.user.password")` is unset unless passed to the JVM.
   - Workaround: tests use `System.getProperty("test.user.password", UUID.randomUUID().toString())`
     so no real password is needed.

3. **Vulnerable transitive dependency flagged by the scanner**
   - Workaround: override the Spring Boot managed version through a `<properties>` entry. `pom.xml`
     already pins `jackson-2-bom.version` and `logback.version` this way. Verify with
     `mvn dependency:tree -Dincludes=<groupId>:<artifactId>`, and drop the override once Spring Boot
     ships a fixed version.

Continuous Integration
-----------------------
CI lives in `.gitlab-ci.yml` (GitLab CI) and runs SonarCloud analysis:
- **`sonarcloud-check`** — `mvn verify sonar:sonar -s ci_settings.xml`

`REPSY_USERNAME` and `REPSY_PASSWORD` must be defined as CI/CD variables (or GitHub Actions secrets)
so that `ci_settings.xml` can resolve them.

## How to verify Sonar coverage locally

1) Generate the JaCoCo XML report (runs tests and produces XML/HTML reports):
   ```bash
   mvn clean verify
   ```

2) Confirm the report exists:
   ```bash
   test -f target/site/jacoco/jacoco.xml && echo "report present"
   ```

3) Run Sonar analysis locally (requires a Sonar token):
   ```bash
   mvn sonar:sonar -Dsonar.host.url=https://sonarcloud.io -Dsonar.token=<SONAR_TOKEN>
   ```

Notes:
- `jacoco:check` enforces a minimum of 80% line and 70% branch coverage per package.
- `pom.xml` excludes XML, `*Application.*`, `config/` and `mapper/` from Sonar analysis and coverage.
- `maven-pmd-plugin` (ruleset `ruleset.xml`) runs `check` and `cpd-check` in the `test` phase and fails
  the build on violations.

## Documentation

- [Official documentation](https://prx.myjetbrains.com/youtrack/articles/PRX-A-61/Persistence)
- `CHANGELOG` — project changelog (Keep a Changelog / SemVer)
- `ruleset.xml` — PMD ruleset

Domain modules
--------------
Entities live in `com.umdc.persistence.general.domains`, repositories in
`com.umdc.persistence.general.repositories`.

| Module | Entities | Purpose |
|---|---|---|
| Addresses | `AddressEntity` | Postal address records |
| Applications | `ApplicationEntity` | Application (tenant) registry |
| Contacts | `ContactEntity`, `ContactTypeEntity` | Contact records and their types |
| Features and roles | `FeatureEntity`, `RoleEntity`, `RoleFeatureEntity`, `RoleFeaturePK` | Feature entitlements linked to roles |
| Identification documents | `IdentificationDocumentEntity` | Identification document records |
| Managed clients | `ManagedClientEntity`, `ManagedClientAuditEventEntity` | M2M client registration and its audit events |
| Audit | `AuditEventEntity` | Audit trail events |
| Notices | `NoticeEntity`, `NoticeId`, `NoticeTypeEntity` | Notices and their types |
| People | `PersonEntity` | Person records |
| Service types | `ServiceTypeEntity` | Service type registry |
| Users | `UserEntity`, `ApplicationRoleUserEntity`, `ApplicationRoleUserEntityId` | Users and their application/role links |

Tech stack and versions
-----------------------
| Technology | Version | Source |
|---|--------------:|---|
| Java (language / runtime) | 25 | pom.xml |
| Spring Boot (parent, `spring-boot-starter-data-jpa`) | 4.1.1 | pom.xml |
| Spring Cloud | 2025.1.3 | pom.xml |
| Spring Data BOM | 2025.1.6 | pom.xml |
| Maven (build tool) | >=3.8 | pom.xml |
| PostgreSQL JDBC driver | 42.7.13 | pom.xml |
| HikariCP | detected | pom.xml (Spring Boot managed) |
| Gson | 2.14.0 | pom.xml |
| UM Dev Creative Commons (`com.umdc:commons`) | 0.0.3 | pom.xml |
| Jackson (security override) | 2.22.3 | pom.xml |
| Logback (security override) | 1.6.5 | pom.xml |
| JUnit Jupiter | 6.1.3 | pom.xml |
| Mockito | 5.23.0 | pom.xml |
| JaCoCo | 0.8.15 | pom.xml |
| PMD plugin | 3.28.0 | pom.xml |
| Surefire / Failsafe | 3.5.6 | pom.xml |
| SonarCloud (project properties present) | detected | pom.xml, .gitlab-ci.yml |

Note: "detected" means the technology is present but there is no single pinned version string to
extract (managed by a BOM, or an external managed service).

Files scanned
-------------
- `pom.xml` — project metadata, properties, dependencies, plugin versions
- `ci_settings.xml` — Maven settings for the private Repsy repository
- `.gitlab-ci.yml` — CI pipeline (SonarCloud)
- `ruleset.xml` — PMD ruleset

License
-------
Proprietary and confidential — Copyright (c) 2024-2026 UM Dev Creative. All Rights Reserved. This is not
open-source software.

More
----
For questions, reach out to:

<luis.antonio.mata@gmail.com>

[![SonarQube Cloud](https://sonarcloud.io/images/project_badges/sonarcloud-light.svg)](https://sonarcloud.io/summary/new_code?id=com.umdc%3Apersistence)
