CREATE TABLE IF NOT EXISTS `javateste`.`agenda` (
  `id` INT NOT NULL,
  `paciente_id` INT NOT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_agenda_paciente_idx` (`paciente_id` ASC) VISIBLE,
  CONSTRAINT `fk_agenda_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `javateste`.`paciente` (`id`))