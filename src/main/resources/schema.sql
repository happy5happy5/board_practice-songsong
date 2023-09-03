CREATE TABLE IF NOT EXISTS board
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    writer       VARCHAR(100) NOT NULL,
    password     VARCHAR(40)  NOT NULL,
    title        VARCHAR(300) NOT NULL,
    content      TEXT         NOT NULL,
    parent_id    BIGINT       DEFAULT NULL,
    level        INT          DEFAULT 0,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
#
# CREATE TABLE IF NOT EXISTS user
# (
#     uid          BIGINT AUTO_INCREMENT PRIMARY KEY,
#     userid       VARCHAR(100) NOT NULL UNIQUE,
#     name         VARCHAR(100) NOT NULL,
#     email        VARCHAR(100) NOT NULL,
#     phone        VARCHAR(100) NOT NULL,
#     password     VARCHAR(40)  NOT NULL,
#     created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
# );
#
# CREATE TABLE IF NOT EXISTS query
# (
#     qid          BIGINT AUTO_INCREMENT PRIMARY KEY,
#     userid       VARCHAR(100) NOT NULL UNIQUE,
#     title        VARCHAR(300) NOT NULL,
#     content      TEXT         NOT NULL,
#     created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
#     foreign key (userid) references user (userid) on delete cascade on update cascade
# );
#
# CREATE TABLE IF NOT EXISTS comment
# (
#     cid          BIGINT AUTO_INCREMENT PRIMARY KEY,
#     qid          BIGINT       DEFAULT NULL,
#     userid       VARCHAR(100) DEFAULT NULL,
#     pid          BIGINT,
#     level        INT          DEFAULT 0,
#     content      TEXT NOT NULL,
#     created_time TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
#     foreign key (pid) references comment (cid) on update cascade,
#     foreign key (qid) references query (qid) on update cascade,
#     foreign key (userid) references user (userid) on update cascade
# );
#
# # CREATE TABLE IF NOT EXISTS comment_reply
# # (
# #     id           BIGINT AUTO_INCREMENT PRIMARY KEY,
# #     bid          BIGINT    DEFAULT NULL,
# #     cid          BIGINT    DEFAULT NULL,
# #     writer       VARCHAR(100) NOT NULL,
# #     password     VARCHAR(40)  NOT NULL,
# #     content      TEXT         NOT NULL,
# #     created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
# #     foreign key (bid) references board (id) on delete cascade on update cascade,
# #     foreign key (cid) references comment (id) on delete cascade on update cascade
# # );
#
#
# CREATE TABLE IF NOT EXISTS user_role
# (
#     uid  BIGINT DEFAULT NULL,
#     role VARCHAR(100) NOT NULL,
#     foreign key (uid) references user (uid) on delete cascade on update cascade
# );
#
# CREATE TABLE IF NOT EXISTS email_auth
# (
#     id           BIGINT AUTO_INCREMENT PRIMARY KEY,
#     email        VARCHAR(100) NOT NULL,
#     auth_key     VARCHAR(100) NOT NULL,
#     created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
# );
#
#
#
#
#
#
