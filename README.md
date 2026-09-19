# Taiwan Ecological Risk Map — Backend

Backend REST API for the Taiwan Ecological Risk Map, a web-based geospatial visualization platform developed as part of an MSc Computer Science dissertation project.

The backend integrates processed ecological and stray-animal risk data stored in PostgreSQL/PostGIS and exposes the data to the frontend through REST and GeoJSON APIs.

## Project Overview

The platform is designed to support the visualization of ecological risk associated with stray animals across Taiwan.

The backend provides data for:

- City/county hotspot risk scores
- Ecological conservation areas
- Important wildlife habitats
- Natural reserve areas
- Nature reserves
- Terrestrial wildlife protected areas
- Ecological conservation corridors
- State forest management areas
- Forest wildlife distribution
- Wildlife attacks associated with stray animals
- Wildlife rescue centres

Spatial data is stored using PostgreSQL with PostGIS and returned to the frontend primarily as GeoJSON.

## Technology Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- PostGIS
- Maven

## Architecture

The main layers are:

- **Controller** — Handles HTTP requests and REST endpoints.
- **Service** — Contains application and data-processing logic.
- **Repository** — Handles database queries and spatial SQL.
- **Database** — Stores hotspot scores, ecological indicators and spatial datasets.

## Database

The application uses PostgreSQL with the PostGIS extension.

The primary database schema is:

```text
taiwan_ecology
```

Important datasets include:

```text
city_boundary
city_ecological_indicators
city_hotspot_scores
ecological_conservation_corridors
forest_wildlife_distribution
important_wildlife_habitats
national_green_network_zones
natural_reserve_areas
nature_reserves
state_forest_management_areas
terrestrial_wildlife_protected_areas
```

Additional tables are used for wildlife attack and rescue-centre information.

## API

Examples of API endpoints include:

```http
GET /api/hotspots
GET /api/hotspots/{cityName}
GET /api/ecological-layers/{layerName}
```

Example ecological layer:

```http
GET /api/ecological-layers/nature-reserves
```

Spatial endpoints return GeoJSON that can be rendered directly by mapping libraries such as Leaflet.

## Local Development

### Prerequisites

Install:

- Java 21
- Maven
- PostgreSQL
- PostGIS

### Database Configuration

The application expects the following environment variables:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

Example:

```text
DB_URL=jdbc:postgresql://localhost:5432/your_database
DB_USERNAME=your_username
DB_PASSWORD=your_password
```

The application configuration uses:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

### Run the Application

Using Maven:

```bash
./mvnw spring-boot:run
```

or:

```bash
mvn spring-boot:run
```

The application runs on port `8080` by default unless another port is supplied through the `PORT` environment variable.

## PostGIS

PostGIS is required because the platform stores and processes spatial datasets.

To check whether PostGIS is available:

```sql
SELECT PostGIS_Version();
```

The application uses PostGIS functionality such as:

```sql
ST_Transform(...)
ST_AsGeoJSON(...)
```

to transform spatial data and generate GeoJSON responses.

## Hotspot Risk Data

The hotspot model combines city-level indicators representing:

- Stray-animal pressure
- Ecological exposure
- Shelter-related pressure

The indicators are normalized before being combined into a weighted hotspot score. Cities/counties are subsequently ranked and assigned risk classifications for visualization on the frontend.

The calculated results are stored in the database and exposed through the hotspot API.

## Deployment

The backend can be deployed using a cloud platform supporting Java and PostgreSQL/PostGIS.

The production environment should provide:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
PORT
```

The current deployment architecture is designed to keep the Spring Boot application and PostGIS database separate:

```text
Frontend
   ↓
Spring Boot REST API
   ↓
PostgreSQL + PostGIS
```

## Related Repository

The Vue frontend is maintained in a separate repository:

```text
hotspot-frontend
```

## Research Context

This application was developed as part of an MSc Computer Science dissertation investigating the use of geospatial visualization for communicating ecological risks associated with stray animals in Taiwan.

The platform is intended for research and visualization purposes. Risk scores are aggregated at city/county level and should not be interpreted as precise predictions of individual wildlife incidents.

## Data Sources

The project integrates data derived from publicly available and research-related sources, including:

- Taiwan Ministry of Agriculture open data
- Taiwan animal protection / stray-animal datasets
- Ecological and protected-area spatial datasets
- WildOne wildlife rescue and attack information

Please refer to the dissertation and the platform's data-source information for detailed dataset descriptions and citations.

## License

No license has currently been specified.

Unless a license is added, making this repository public does not automatically grant others permission to copy, modify, or redistribute the source code.
