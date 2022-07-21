-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Lug 21, 2022 alle 14:36
-- Versione del server: 10.4.21-MariaDB
-- Versione PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `esame_finale`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `articoli`
--

CREATE TABLE `articoli` (
  `id` int(30) NOT NULL,
  `codice` varchar(30) NOT NULL,
  `descrizione` varchar(150) NOT NULL,
  `peso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `articoli`
--

INSERT INTO `articoli` (`id`, `codice`, `descrizione`, `peso`) VALUES
(1, 'PNDRV8', 'Pen drive USB 8G no brand', 0.15),
(3, 'DCP-J715E', 'Stampante Brother DCP-J715 W', 5.3),
(4, 'LNVCX1', 'Notebook Lenovo Carbon X1', 1.9),
(7, 'ALCPPC3', 'Smartphone Alcatel POP C3', 0.53),
(8, 'BSHT1R', 'Ampli Combo valvolare BlackStar HT 1-R', 6);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini`
--

CREATE TABLE `ordini` (
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `data` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ordini`
--

INSERT INTO `ordini` (`id`, `numero`, `data`) VALUES
(1, 323232, '21/07/2022'),
(2, 244424, '22/07/2022'),
(3, 43434343, '19/07/2022'),
(4, 545454, '21/07/2022'),
(5, 656565, '22/07/2022'),
(6, 76766, '25/07/2022'),
(7, 87878, '21/07/2022'),
(8, 99898, '22/07/2022'),
(9, 91919, '23/07/2022');

-- --------------------------------------------------------

--
-- Struttura della tabella `tariffe_corrieri`
--

CREATE TABLE `tariffe_corrieri` (
  `id` int(11) NOT NULL,
  `nome_corriere` varchar(50) NOT NULL,
  `nome_tarifa` varchar(50) NOT NULL,
  `peso_max` double NOT NULL,
  `costo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `tariffe_corrieri`
--

INSERT INTO `tariffe_corrieri` (`id`, `nome_corriere`, `nome_tarifa`, `peso_max`, `costo`) VALUES
(1, 'SDA', 'Economy', 1, 5.9),
(2, 'SDA', 'Veloce', 5, 7.9),
(3, 'SDA', 'Bigbox', 30, 12.9),
(4, 'DHL', 'Veloce', 1.5, 6.5),
(5, 'DHL', 'Assicurata', 7.5, 9.9),
(6, 'DHL', 'XXL', 40, 13.9),
(7, 'UPS', 'Economy', 0.7, 5.2),
(8, 'UPS', 'Standard', 3, 6.9),
(9, 'UPS', 'Jumbo', 25, 11.5),
(10, 'SDA', 'Economy', 1, 5.9),
(11, 'SDA', 'Veloce', 5, 7.9),
(12, 'SDA', 'Bigbox', 30, 12.9),
(13, 'DHL', 'Veloce', 1.5, 6.5),
(14, 'DHL', 'Assicurata', 7.5, 9.9),
(15, 'DHL', 'XXL', 40, 13.9),
(16, 'UPS', 'Economy', 0.7, 5.2),
(17, 'UPS', 'Standard', 3, 6.9),
(18, 'UPS', 'Jumbo', 25, 11.5);

-- --------------------------------------------------------

--
-- Struttura della tabella `voce`
--

CREATE TABLE `voce` (
  `id` int(11) NOT NULL,
  `id_ordine` int(11) NOT NULL,
  `id_articolo` int(11) NOT NULL,
  `n_articoli` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `voce`
--

INSERT INTO `voce` (`id`, `id_ordine`, `id_articolo`, `n_articoli`) VALUES
(1, 1, 3, 2),
(2, 2, 2, 1),
(3, 2, 3, 1),
(4, 3, 3, 1),
(5, 3, 4, 1),
(6, 4, 1, 2),
(7, 4, 4, 1),
(8, 5, 4, 2),
(9, 5, 1, 1),
(10, 6, 1, 3),
(11, 7, 2, 7),
(12, 8, 5, 1),
(13, 8, 3, 1),
(14, 9, 5, 6);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `articoli`
--
ALTER TABLE `articoli`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `ordini`
--
ALTER TABLE `ordini`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `tariffe_corrieri`
--
ALTER TABLE `tariffe_corrieri`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `voce`
--
ALTER TABLE `voce`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `articoli`
--
ALTER TABLE `articoli`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `ordini`
--
ALTER TABLE `ordini`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT per la tabella `tariffe_corrieri`
--
ALTER TABLE `tariffe_corrieri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT per la tabella `voce`
--
ALTER TABLE `voce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
