drop database if exists ebidding_account;
create database ebidding_account;
use ebidding_account;

CREATE TABLE IF NOT EXISTS account (
                                     id VARCHAR(255),
                                     name VARCHAR(255) NOT NULL default '',
                                     member_since TIMESTAMP NOT NULL default current_timestamp,
                                     role VARCHAR(255) NOT NULL default '',
                                     password_hash VARCHAR(100) default '',
                                     PRIMARY KEY (id)
) ENGINE=InnoDB;