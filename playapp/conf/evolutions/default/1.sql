# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  id                            varchar(255) not null,
  name                          varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists user;

