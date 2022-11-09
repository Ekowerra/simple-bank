CREATE TABLE Account (
  id uuid default RANDOM_UUID() not null,
  name nvarchar not null,
  creation_date TIMESTAMP WITH TIME ZONE default CURRENT_TIMESTAMP not null,
  primary key(id)
);