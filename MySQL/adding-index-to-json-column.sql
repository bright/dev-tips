CREATE TABLE `orders`
(
    `id`           INT UNSIGNED                                            NOT NULL,
    `data`         JSON                                                    NOT NULL,
    `order_number` VARCHAR(20) GENERATED ALWAYS AS (`data` ->> '$.number') NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `orders_order_number_idx` (`order_number`)
);
