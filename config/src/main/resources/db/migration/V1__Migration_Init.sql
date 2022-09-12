-- Drop Table Customer
DROP TABLE IF EXISTS CUSTOMER;

-- Drop Table Product
DROP TABLE IF EXISTS PRODUCT;

-- Drop Table Product
DROP TABLE IF EXISTS INVENTORY;

-- Drop Table Orders
DROP TABLE IF EXISTS ORDERS;

-- Drop Table Order Details
DROP TABLE IF EXISTS ORDER_DETAILS;

-- Drop Table Transactions
DROP TABLE IF EXISTS ACCOUNT;

-- Drop Table Transactions
DROP TABLE IF EXISTS TRANSACTIONS;


-- Create Table Customer
CREATE TABLE CUSTOMER (
    ID                  BIGINT PRIMARY KEY NOT NULL,
    NAME                VARCHAR(50) NOT NULL,
    EMAIL               VARCHAR(50) NOT NULL,
    PHONE_NUMBER        VARCHAR(15) NOT NULL,
    ADDRESS             VARCHAR(255) NOT NULL,
    CREATED_AT          TIMESTAMP WITH TIME ZONE,
    CREATED_BY          BIGINT,
    UPDATED_AT          TIMESTAMP WITH TIME ZONE,
    UPDATED_BY          BIGINT,
    DELETED_AT          TIMESTAMP WITH TIME ZONE,
    DELETED_BY          BIGINT
);

-- Create Index Customer
CREATE INDEX idx_customer ON CUSTOMER USING btree(ID);

-- Create Table Product
CREATE TABLE PRODUCT
(
    ID                  BIGINT PRIMARY KEY NOT NULL,
    TYPE                VARCHAR(20) NOT NULL,
    SERI_NAME           VARCHAR(50) NOT NULL,
    PRICE               DOUBLE PRECISION NOT NULL,
    IS_STOCK            BOOLEAN NOT NULL,
    CREATED_AT          TIMESTAMP WITH TIME ZONE,
    CREATED_BY          BIGINT,
    UPDATED_AT          TIMESTAMP WITH TIME ZONE,
    UPDATED_BY          BIGINT,
    DELETED_AT          TIMESTAMP WITH TIME ZONE,
    DELETED_BY          BIGINT
) ;

-- Create Index Product
CREATE INDEX idx_product ON PRODUCT USING btree(ID);

-- Create Table Inventory
CREATE TABLE INVENTORY
(
    ID                  BIGINT PRIMARY KEY NOT NULL,
    PRODUCT_ID          BIGINT NOT NULL,
    AVAILABLE_QUANTITY  BIGINT,
    CREATED_AT          TIMESTAMP WITH TIME ZONE,
    CREATED_BY          BIGINT,
    UPDATED_AT          TIMESTAMP WITH TIME ZONE,
    UPDATED_BY          BIGINT,
    DELETED_AT          TIMESTAMP WITH TIME ZONE,
    DELETED_BY          BIGINT,
    CONSTRAINT FK_PRODUCT_INV
            FOREIGN KEY(PRODUCT_ID)
                REFERENCES PRODUCT(ID)
) ;

-- Create Index Inventory
CREATE INDEX idx_inventory ON INVENTORY USING btree(ID);
CREATE INDEX idx_product_inventory ON INVENTORY USING btree(PRODUCT_ID);

-- Create Table Orders
CREATE TABLE ORDERS
(
    ID                  BIGINT PRIMARY KEY,
    CUSTOMER_ID         BIGINT NOT NULL,
    AMOUNT              DOUBLE PRECISION NOT NULL,
    ORDER_DATE          TIMESTAMP WITH TIME ZONE NOT NULL,
    ORDER_NUMBER        VARCHAR(20) NOT NULL,
    CREATED_AT          TIMESTAMP WITH TIME ZONE,
    CREATED_BY          BIGINT,
    UPDATED_AT          TIMESTAMP WITH TIME ZONE,
    UPDATED_BY          BIGINT,
    DELETED_AT          TIMESTAMP WITH TIME ZONE,
    DELETED_BY          BIGINT,
    CONSTRAINT FK_CUSTOMER_ORD
        FOREIGN KEY(CUSTOMER_ID)
            REFERENCES CUSTOMER(ID)
) ;

-- Create Index Orders
CREATE INDEX idx_orders ON ORDERS USING btree(ID);
CREATE INDEX idx_customer_orders ON ORDERS USING btree(CUSTOMER_ID);


-- Create Table Order Details
CREATE TABLE ORDER_DETAILS
(
    ID                  BIGINT PRIMARY KEY,
    AMOUNT              DOUBLE PRECISION NOT NULL,
    PRICE               DOUBLE PRECISION NOT NULL,
    QUANTITY            BIGINT NOT NULL,
    PRODUCT_ID          BIGINT NOT NULL,
    ORDER_ID            BIGINT NOT NULL,
    CREATED_AT          TIMESTAMP WITH TIME ZONE,
    CREATED_BY          BIGINT,
    UPDATED_AT          TIMESTAMP WITH TIME ZONE,
    UPDATED_BY          BIGINT,
    DELETED_AT          TIMESTAMP WITH TIME ZONE,
    DELETED_BY          BIGINT,
    CONSTRAINT FK_PRODUCT_ORDTL
        FOREIGN KEY(PRODUCT_ID)
            REFERENCES PRODUCT(ID),
    CONSTRAINT FK_ORDERS_ORDTL
        FOREIGN KEY(ORDER_ID)
            REFERENCES ORDERS(ID)
) ;

-- Create Index Order Details
CREATE INDEX idx_order_details ON ORDER_DETAILS USING btree(ID);
CREATE INDEX idx_product_order_details ON ORDER_DETAILS USING btree(PRODUCT_ID);
CREATE INDEX idx_orders_order_details ON ORDER_DETAILS USING btree(ORDER_ID);

-- Create Table Account
CREATE TABLE ACCOUNT
(
    ID                  BIGINT PRIMARY KEY,
    CUSTOMER_ID         BIGINT NOT NULL,
    ACCOUNT_NUMBER      VARCHAR(30) NOT NULL,
    ACCOUNT_NAME        VARCHAR(50) NOT NULL,
    BANK_CODE           VARCHAR(20) NOT NULL,
    BANK_NAME           VARCHAR(20) NOT NULL,
    AVAILABLE_BALANCE   DOUBLE PRECISION NOT NULL,
    CREATED_AT          TIMESTAMP WITH TIME ZONE,
    CREATED_BY          BIGINT,
    UPDATED_AT          TIMESTAMP WITH TIME ZONE,
    UPDATED_BY          BIGINT,
    DELETED_AT          TIMESTAMP WITH TIME ZONE,
    DELETED_BY          BIGINT,
    CONSTRAINT FK_CUSTOMER_ACCT
        FOREIGN KEY(CUSTOMER_ID)
            REFERENCES CUSTOMER(ID)
) ;

-- Create Index Orders
CREATE INDEX idx_account ON ACCOUNT USING btree(ID);
CREATE INDEX idx_customer_account ON ACCOUNT USING btree(CUSTOMER_ID);

-- Create Table Transaction
CREATE TABLE TRANSACTIONS
(
    ID                  BIGINT PRIMARY KEY,
    CUSTOMER_ID         BIGINT NOT NULL,
    ORDER_ID            BIGINT NOT NULL,
    TRANSACTION_DATE    TIMESTAMP WITH TIME ZONE NOT NULL,
    AMOUNT              DOUBLE PRECISION NOT NULL,
    REFERENCE_NUMBER    VARCHAR(20) NOT NULL,
    SOURCE_ACCOUNT      VARCHAR(20) NOT NULL,
    SENDER_NAME         VARCHAR(50) NOT NULL,
    SENDER_BANK_CODE    VARCHAR(10) NOT NULL,
    SENDER_BANK_NAME    VARCHAR(50) NOT NULL,
    TARGET_ACCOUNT      VARCHAR(20) NOT NULL,
    RECEIVER_NAME       VARCHAR(50) NOT NULL,
    RECEIVER_BANK_CODE  VARCHAR(10) NOT NULL,
    RECEIVER_BANK_NAME  VARCHAR(50) NOT NULL,
    STATUS              VARCHAR(10) NOT NULL,
    DESCRIPTION         VARCHAR(100) NOT NULL,
    CREATED_AT          TIMESTAMP WITH TIME ZONE,
    CREATED_BY          BIGINT,
    UPDATED_AT          TIMESTAMP WITH TIME ZONE,
    UPDATED_BY          BIGINT,
    DELETED_AT          TIMESTAMP WITH TIME ZONE,
    DELETED_BY          BIGINT,
    CONSTRAINT FK_CUSTOMER_TRX
            FOREIGN KEY(CUSTOMER_ID)
                REFERENCES CUSTOMER(ID),
    CONSTRAINT FK_ORDERS_TRX
            FOREIGN KEY(ORDER_ID)
                REFERENCES ORDERS(ID)
) ;

-- Create Index Transactions
CREATE INDEX idx_transactions ON TRANSACTIONS USING btree(ID);
CREATE INDEX idx_orders_transactions ON TRANSACTIONS USING btree(ORDER_ID);