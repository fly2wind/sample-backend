CREATE TABLE t_order
(
    id               BIGINT       NOT NULL AUTO_INCREMENT,
    customer_id      VARCHAR(255) NOT NULL,
    status           VARCHAR(64)  NOT NULL,
    price            DECIMAL(15, 2) DEFAULT NULL,
    address_province VARCHAR(255)   DEFAULT NULL,
    address_city     VARCHAR(255)   DEFAULT NULL,
    address_detail   VARCHAR(255)   DEFAULT NULL,
    version          BIGINT         DEFAULT NULL,
    create_time      DATETIME     NULL,
    create_by        VARCHAR(64)  NULL,
    update_time      DATETIME     NULL,
    update_by        VARCHAR(64)  NULL,
    delete_time      DATETIME     NULL,
    delete_by        VARCHAR(64)  NULL,
    PRIMARY KEY (id)
);

CREATE TABLE t_order_items
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id   BIGINT         NOT NULL,
    product_id BIGINT         NOT NULL,
    price      DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    quantity   INTEGER        NOT NULL DEFAULT 0,
    CONSTRAINT t_order_items_fk_order_id FOREIGN KEY (order_id) REFERENCES t_order (id)
);
