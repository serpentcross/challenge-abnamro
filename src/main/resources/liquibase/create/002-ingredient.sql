CREATE TABLE IF NOT EXISTS ingredient (
    id UUID UNIQUE  NOT NULL CONSTRAINT PK_ingredient PRIMARY KEY,
    vegetable BOOLEAN NOT NULL DEFAULT FALSE,
    name VARCHAR UNIQUE NOT NULL
);