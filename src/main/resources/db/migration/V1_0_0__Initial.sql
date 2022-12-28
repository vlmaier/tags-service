CREATE TABLE tags
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE card_tags
(
    id        SERIAL PRIMARY KEY,
    tag_id    INTEGER NOT NULL,
    card_name VARCHAR(255),
    CONSTRAINT fk_tag
        FOREIGN KEY (tag_id)
            REFERENCES tags (id)
);
