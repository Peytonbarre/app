# Competitive Birding Application

A Java console application for tracking bird sightings, maintaining daily streaks, and competing with friends.

## Features

- User accounts with authentication
- Log bird sightings with timestamp
- Daily streak tracking
- Leaderboard ranking users by total birds spotted
- Friend system for social competition
- 201 bird species database

## Requirements

- Java 11+
- PostgreSQL
- Maven

## Setup

1. Clone the repository
2. Configure PostgreSQL connection in `DatabaseConnection.java`
3. Run `mvn clean package`
4. Execute `mvn exec:java -Dexec.mainClass="com.wings.App"`

## Database Schema

- `users` - User accounts and streaks
- `birds` - Bird species with rarity and habitat
- `spotted_birds` - Bird sightings by user
- `friendships` - User relationships (many-to-many)

## Architecture

- **models/** - Data classes (User, Bird, SpottedBird)
- **repository/** - Data access interfaces and implementations
- **service/** - Business logic
- **controller/** - Console UI
- **database/** - Connection and initialization

## Testing

Run tests with `mvn test`

10+ unit tests covering:
- User creation (valid, null, duplicate, empty)
- Bird spotting
- Leaderboard calculations
- Streak calculations

Tests mock repository layer and use Mockito.

## Usage

1. Create account or login
2. View available birds and search by name/habitat
3. Spot a bird to add to your collection
4. View your sightings and current streak
5. Check leaderboard for rankings
6. Add friends to compete