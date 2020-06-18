CREATE TABLE houseData (
      id UUID NOTNULL PRIMARY KEY,
      name varchar(100) NOTNULL,
      imageUrl varchar(100) NOTNULL,
      location varchar (100)NOTNULL,
      description varchar(200) NOTNULL,
      price double (100) NOTNULL 
);