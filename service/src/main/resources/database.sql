-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : ven. 26 mars 2021 à 18:40
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `library`
--

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

DROP TABLE IF EXISTS `auteur`;
CREATE TABLE IF NOT EXISTS `auteur`
(
    `Id`     bigint(20) NOT NULL AUTO_INCREMENT,
    `Nom`    varchar(45) DEFAULT NULL,
    `Prenom` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`Id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

--
-- Déchargement des données de la table `auteur`
--

INSERT INTO `auteur` (`Id`, `Nom`, `Prenom`)
VALUES (1, 'jk rowling', 'caroline'),
       (2, 'Hugo', 'Victor'),
       (3, 'Zola', 'Emile'),
       (4, 'Moliere', NULL),
       (5, 'SARTRE', 'JEAN PAUL'),
       (6, 'RACINE', 'JEAN');

-- --------------------------------------------------------

--
-- Structure de la table `auteur_ouvrage`
--

DROP TABLE IF EXISTS `auteur_ouvrage`;
CREATE TABLE IF NOT EXISTS `auteur_ouvrage`
(
    `auteur_ID`  bigint(20) NOT NULL,
    `ouvrage_ID` bigint(20) NOT NULL,
    PRIMARY KEY (`auteur_ID`, `ouvrage_ID`),
    KEY `fk_auteur_has_ouvrage_ouvrage1_idx` (`ouvrage_ID`),
    KEY `fk_auteur_has_ouvrage_auteur1_idx` (`auteur_ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Déchargement des données de la table `auteur_ouvrage`
--

INSERT INTO `auteur_ouvrage` (`auteur_ID`, `ouvrage_ID`)
VALUES (1, 2),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 9),
       (2, 3),
       (4, 10),
       (6, 11);

-- --------------------------------------------------------

--
-- Structure de la table `ouvrage`
--

DROP TABLE IF EXISTS `ouvrage`;
CREATE TABLE IF NOT EXISTS `ouvrage`
(
    `Id`          bigint(20)                                                         NOT NULL AUTO_INCREMENT,
    `Titre`       varchar(150)                                                       NOT NULL,
    `Editeur`     varchar(45)                                                        NOT NULL,
    `genre`       enum ('SCIENCE_FICTION','HORREUR','HISTORIQUE','ROMANCE','GUERRE') NOT NULL,
    `type`        enum ('REVUE','BD','ROMAN')                                        NOT NULL,
    `exemplaires` int(11)                                                            NOT NULL,
    `parution`    date                                                               NOT NULL,
    PRIMARY KEY (`Id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8;

--
-- Déchargement des données de la table `ouvrage`
--

INSERT INTO `ouvrage` (`Id`, `Titre`, `Editeur`, `genre`, `type`, `exemplaires`, `parution`)
VALUES (1, 'test', 'test', 'SCIENCE_FICTION', 'REVUE', 0, '2021-02-21'),
       (2, 'Harry Potter et l\'ordre du phenix', 'HACHETTE', 'SCIENCE_FICTION', 'REVUE', 3, '2003-01-02'),
       (3, 'Les misérables', 'HACHETTE', 'HISTORIQUE', 'ROMAN', 3, '1862-01-01'),
       (4, 'Harry Potter à l\'école des sorciers', 'HACHETTE', 'SCIENCE_FICTION', 'ROMAN', 3, '1997-01-01'),
       (5, 'Harry Potter et la chambre des secrets', 'HACHETTE', 'SCIENCE_FICTION', 'ROMAN', 3, '1998-01-01'),
       (6, 'Harry Potter et le prisonnier d\'Azkaban', 'HACHETTE', 'SCIENCE_FICTION', 'ROMAN', 3, '1990-01-01'),
       (7, 'Harry Potter et la coupe de feu', 'HACHETTE', 'SCIENCE_FICTION', 'ROMAN', 3, '2000-01-01'),
       (8, 'Harry Potter et le prince de sang mélée', 'HACHETTE', 'SCIENCE_FICTION', 'ROMAN', 3, '2005-01-01'),
       (9, 'Harry Potter et les reliques de la mort', 'HACHETTE ', 'SCIENCE_FICTION', 'ROMAN', 2, '2007-01-01'),
       (10, 'Le malade imaginaire', '', 'ROMANCE', 'ROMAN', 1, '1673-01-01'),
       (11, 'Andromaque', '', 'HISTORIQUE', 'ROMAN', 1, '1667-01-01');

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE IF NOT EXISTS `personnel`
(
    `Id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `Nom`         varchar(45) NOT NULL,
    `Prenom`      varchar(45) NOT NULL,
    `Fonction`    varchar(45) DEFAULT NULL,
    `Identifiant` varchar(45) NOT NULL,
    `Password`    varchar(45) NOT NULL,
    PRIMARY KEY (`Id`),
    UNIQUE KEY `Identifiant_UNIQUE` (`Identifiant`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`Id`, `Nom`, `Prenom`, `Fonction`, `Identifiant`, `Password`)
VALUES (1, 'BOUCAU', 'CAROLINE', 'BIBLIOTHECAIRE', '00000001', 'CHOCOLAT'),
       (2, 'SPECKENS', 'JULIEN', 'DIRECTEUR', '0000002', 'BANANE');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation`
(
    `id`                  bigint(11) NOT NULL AUTO_INCREMENT,
    `usager_id`           bigint(20) NOT NULL,
    `ouvrage_id`          bigint(20) NOT NULL,
    `dt_emprunt`          date       DEFAULT NULL,
    `dt_retour`           date       DEFAULT NULL,
    `prev_reservation_id` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_ouvrage_has_usager_usager1_idx` (`usager_id`),
    KEY `fk_ouvrage_has_usager_ouvrage1_idx` (`ouvrage_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 21
  DEFAULT CHARSET = utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `usager_id`, `ouvrage_id`, `dt_emprunt`, `dt_retour`, `prev_reservation_id`)
VALUES (5, 1, 2, '2020-02-19', '2020-02-22', NULL),
       (6, 1, 2, '2020-02-19', '2021-03-05', NULL),
       (7, 1, 1, '2020-02-19', NULL, NULL),
       (11, 4, 2, '2021-02-20', NULL, NULL),
       (12, 4, 7, '2020-02-20', NULL, NULL),
       (14, 1, 2, NULL, '2021-02-21', NULL),
       (17, 1, 1, '2021-02-19', NULL, 5),
       (18, 1, 2, '2020-02-19', '2021-03-05', NULL),
       (19, 1, 2, '2020-02-19', NULL, 18),
       (20, 1, 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `usager`
--

DROP TABLE IF EXISTS `usager`;
CREATE TABLE IF NOT EXISTS `usager`
(
    `Id`        bigint(20)  NOT NULL AUTO_INCREMENT,
    `Nom`       varchar(45) NOT NULL,
    `Prenom`    varchar(45) NOT NULL,
    `Pseudo`    varchar(45) DEFAULT NULL,
    `Password`  varchar(45) NOT NULL,
    `Adresse`   varchar(45) NOT NULL,
    `Postal`    varchar(45) NOT NULL,
    `Ville`     varchar(45) NOT NULL,
    `Mail`      varchar(45) NOT NULL,
    `Telephone` varchar(45) NOT NULL,
    PRIMARY KEY (`Id`),
    UNIQUE KEY `Pseudo_UNIQUE` (`Pseudo`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8;

--
-- Déchargement des données de la table `usager`
--

INSERT INTO `usager` (`Id`, `Nom`, `Prenom`, `Pseudo`, `Password`, `Adresse`, `Postal`, `Ville`, `Mail`, `Telephone`)
VALUES (1, 'USER1', 'TEST', 'TEST', 'TEST', 'rue ', '59510', 'hem', 'pâsdemail@gmail.com', '0600000000'),
       (2, 'User1', 'UserP1', 'UserP1', 'test', 'rue de moliere', '59200', 'hem', 'pasdemail@gmail.com', '0600000000'),
       (3, 'User2', 'UserP2', 'UserP2', 'test', 'rue de racine', '59200', 'HEM', 'pasdemail2@gmail.com', '0600000000'),
       (4, 'User3', 'UserP3', 'UserP3', 'test', 'rue victor hugo', '59200', 'hem', 'pasdemail3@gmail.com',
        '0600000000');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `auteur_ouvrage`
--
ALTER TABLE `auteur_ouvrage`
    ADD CONSTRAINT `FK9l5sdgdlo659rlg2fgpfucnxn` FOREIGN KEY (`auteur_ID`) REFERENCES `auteur` (`Id`),
    ADD CONSTRAINT `FKqlib485w6nnuhrworm0mk2b91` FOREIGN KEY (`ouvrage_ID`) REFERENCES `ouvrage` (`Id`),
    ADD CONSTRAINT `fk_auteur_has_ouvrage_auteur1` FOREIGN KEY (`auteur_ID`) REFERENCES `auteur` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    ADD CONSTRAINT `fk_auteur_has_ouvrage_ouvrage1` FOREIGN KEY (`ouvrage_ID`) REFERENCES `ouvrage` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
    ADD CONSTRAINT `fk_ouvrage_has_usager_ouvrage1` FOREIGN KEY (`ouvrage_id`) REFERENCES `ouvrage` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    ADD CONSTRAINT `fk_ouvrage_has_usager_usager1` FOREIGN KEY (`usager_id`) REFERENCES `usager` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
