CREATE TABLE IF NOT EXISTS cargo_type
(
    id         BIGINT NOT NULL PRIMARY KEY,
    cargo_name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS crane
(
    id           BIGINT PRIMARY KEY,
    crane_speed  FLOAT,
    crane_active BOOLEAN,
    cargo_id     BIGINT,
    CONSTRAINT crane_cargo_id
        FOREIGN KEY (cargo_id)
            REFERENCES cargo_type (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ship
(
    id          BIGINT NOT NULL PRIMARY KEY,
    ship_name   VARCHAR(50),
    cargo_id    BIGINT NOT NULL,
    ship_weight FLOAT,
    CONSTRAINT ship_cargo_id
        FOREIGN KEY (cargo_id)
            REFERENCES cargo_type (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS schedule
(
    id                          BIGINT PRIMARY KEY,
    schedule_arrival_date       VARCHAR(50),
    schedule_real_arrival_date  VARCHAR(50),
    ship_id                     BIGINT NOT NULL,
    crane_id                    BIGINT NOT NULL,
    schedule_weight             FLOAT,
    schedule_start_of_unloading VARCHAR(50),
    schedule_end_of_unloading   VARCHAR(50),
    CONSTRAINT schedule_ship_id
        FOREIGN KEY (ship_id)
            REFERENCES ship (id) ON DELETE CASCADE,
    CONSTRAINT schedule_crane_id
        FOREIGN KEY (crane_id)
            REFERENCES crane (id) ON DELETE CASCADE
);
