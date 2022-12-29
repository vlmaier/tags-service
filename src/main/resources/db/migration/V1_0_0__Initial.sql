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

INSERT INTO tags
VALUES (1, 'On Reveal'),
       (2, 'Ongoing'),
       (3, 'Move'),
       (4, 'Add Card'),
       (5, 'Destroy'),
       (6, 'Stack Power'),
       (7, 'Discard'),
       (8, 'Draw Card'),
       (9, 'Manipulate Power'),
       (10, 'Manipulate Cost'),
       (11, 'Conditional'),
       (12, 'No Ability');
