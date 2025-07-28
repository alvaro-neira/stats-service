# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot microservice called `stats-service` for the CamPhoto application. It manages comment statistics and displays using DynamoDB as the data store and Thymeleaf for web templates.

## Build and Development Commands

### Maven Commands
- **Build the project**: `mvn clean compile`
- **Run tests**: `mvn test`
- **Run the application**: `mvn spring-boot:run`
- **Package the application**: `mvn clean package`

### Development Server
- **Local development**: The application runs on port 5000 (configured in application.properties)
- **Hot reload**: Spring Boot DevTools is included for automatic restart during development

## Architecture

### Package Structure
- `com.camphotoapp.common.model` - Shared DynamoDB entity models with custom converters
- `com.camphotoapp.stats.config` - Spring configuration classes (DynamoDB setup)
- `com.camphotoapp.stats.controller` - Web controllers for Thymeleaf views
- `com.camphotoapp.stats.repository` - Data access layer for DynamoDB operations

### Key Components

**DynamoDB Integration**:
- Uses AWS SDK v1 for DynamoDB annotations and mapping
- `DynamoDbConfig` sets up AmazonDynamoDB client for US_EAST_1 region
- `Comment` entity uses hash key (commentId) and range key (timestamp)
- Includes TimestampIndex GSI for querying by timestamp

**Data Model**:
- Comments have type, status, attachments, locale, and audit fields
- Custom converters for enums (CommentType, CommentStatus) and data types (Instant, Locale)
- Stores Unix milliseconds for timestamps in DynamoDB

**Web Layer**:
- Thymeleaf templates in `src/main/resources/templates/`
- Controllers serve HTML views, not REST APIs
- Comment listing at `/comments` endpoint

### Technology Stack
- Spring Boot 3.5.4 with Java 17
- AWS DynamoDB (SDK v1) for persistence
- Thymeleaf for server-side templating
- Lombok for reducing boilerplate code
- Spring Boot DevTools for development