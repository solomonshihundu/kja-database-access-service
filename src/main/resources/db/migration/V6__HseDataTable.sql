CREATE TABLE housedata (
      id UUID NOT NULL PRIMARY KEY,
      name varchar(100) NOT NULL,
      imageUrl varchar(100) NOT NULL,
      location varchar (100)NOT NULL,
      description varchar(200) NOT NULL,
      price varchar (100) NOT NULL 
);