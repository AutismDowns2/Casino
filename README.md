# Casino
[![CI/CD Pipeline](https://github.com/AlexAr730/Casino/actions/workflows/build.yml/badge.svg)](https://github.com/AlexAr730/Casino/actions/workflows/build.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=bugs)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=coverage)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=AlexAr730_Casino&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=AlexAr730_Casino)
Implementation of a Simple App with the next operations:
* Get random nations
* Get random currencies
* Get random Aircraft
* Get application version
* health check
Including integration with GitHub Actions, Sonarqube (SonarCloud), Coveralls and
Snyk
### Folders Structure
In the folder `src` is located the main code of the app
In the folder `test` is located the unit tests
### How to install it
Execute:
```shell
$ mvnw spring-boot:run
```
to download the node dependencies
### How to test it
Execute:
```shell
$ mvnw clean install
```
### How to get coverage test
Execute:
```shell
$ mvwn -B package -DskipTests --file pom.xml
```