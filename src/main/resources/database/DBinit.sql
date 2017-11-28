CREATE TABLE IF NOT EXISTS manufacturer (
  manufacturer_id   BINARY(16) NOT NULL UNIQUE PRIMARY KEY,
  manufacturer_name VARCHAR(45) NOT NULL
);
CREATE TABLE IF NOT EXISTS product (
  product_id   BINARY(16) NOT NULL UNIQUE PRIMARY KEY,
  product_name VARCHAR(45) NOT NULL,
  prise DECIMAL(10,2),
  manufacturer_id BINARY(16) NOT NULL,
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturer (manufacturer_id)
);