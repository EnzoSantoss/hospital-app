CREATE TABLE IF NOT EXISTS `javateste`.`agenda` (
  `id` INT NOT NULL,
  `paciente_id` INT NOT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  `createdAt` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `deletedAt` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_agenda_paciente_idx` (`paciente_id` ASC) VISIBLE,
  CONSTRAINT `fk_agenda_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `javateste`.`paciente` (`id`))