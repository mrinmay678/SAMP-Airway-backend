CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    is_admin BOOLEAN NOT NULL DEFAULT FALSE,
    unique (id)
);
CREATE TABLE locations (
    id TEXT NOT NULL PRIMARY KEY,
    city TEXT NOT NULL,
    country TEXT NOT NULL,
    unique (id)
);
CREATE TABLE flights (
    id BIGSERIAL PRIMARY KEY,
    flight_name TEXT NOT NULL,
    fare DECIMAL NOT NULL,
    current_capacity BIGINT NOT NULL DEFAULT 0,
    max_capacity BIGINT NOT NULL,
    unique (id)
);
CREATE TABLE trips (
    id BIGSERIAL PRIMARY KEY,
    source TEXT NOT NULL,
    destination TEXT NOT NULL,
    flight BIGINT NOT NULL,
    departure TIMESTAMP NOT NULL,
    arrival TIMESTAMP NOT NULL,
    FOREIGN KEY(source) references locations(id),
    FOREIGN KEY(destination) references locations(id),
    FOREIGN KEY(flight) references flights(id),
    unique (id)
);
CREATE TABLE bookings (
    id BIGSERIAL PRIMARY KEY,
    userid BIGINT NOT NULL,
    trip BIGINT NOT NULL,
    flight BIGINT NOT NULL,
    total_fare DECIMAL NOT NULL,
    FOREIGN KEY(userid) references users(id),
    FOREIGN KEY(trip) references trips(id),
    FOREIGN KEY(flight) references flights(id),
    unique (id)
);

CREATE TABLE user_details (
    id BIGSERIAL PRIMARY KEY,
    userid BIGINT NOT NULL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    profile_pic TEXT NOT NULL,
    country_code TEXT NOT NULL,
    phone_number TEXT NOT NULL,
    bookings BIGINT NOT NULL,
    FOREIGN KEY(userid) references users(id),
    FOREIGN KEY(bookings) references bookings(id),
    unique (id)
);
