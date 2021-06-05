-- -----------------------------------------------------
-- Table `hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS hibernate_sequence
(
    `next_val` BIGINT NOT NULL
)
    AUTO_INCREMENT = 1;

insert into hibernate_sequence (next_val)
values (1);

CREATE TABLE IF NOT EXISTS cargo_type
(
    id                    INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cargo_name            VARCHAR(50),
    cargo_unloading_ratio FLOAT
);

CREATE TABLE IF NOT EXISTS crane
(
    id           INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    crane_speed  FLOAT,
    crane_active BOOLEAN,
    cargo_id     INTEGER,
    CONSTRAINT crane_cargo_id
        FOREIGN KEY (cargo_id)
            REFERENCES cargo_type (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ship
(
    id          INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ship_name   VARCHAR(50),
    cargo_id    INTEGER NOT NULL,
    ship_weight FLOAT,
    CONSTRAINT ship_cargo_id
        FOREIGN KEY (cargo_id)
            REFERENCES cargo_type (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS schedule
(
    id                          INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    schedule_arrival_date       VARCHAR(50),
    schedule_real_arrival_date  VARCHAR(50),
    ship_id                     INTEGER,
    crane_id                    INTEGER,
    schedule_weight             DOUBLE,
    schedule_start_of_unloading VARCHAR(255),
    schedule_end_of_unloading   VARCHAR(255),
    CONSTRAINT schedule_ship_id
        FOREIGN KEY (ship_id)
            REFERENCES ship (id) ON DELETE CASCADE,
    CONSTRAINT schedule_crane_id
        FOREIGN KEY (crane_id)
            REFERENCES crane (id) ON DELETE CASCADE
);
