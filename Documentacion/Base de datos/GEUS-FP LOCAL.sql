-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 22-05-2018 a las 18:43:30
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `geus01_database`
--
CREATE DATABASE IF NOT EXISTS `geus01_database` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `geus01_database`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GEUS001_USUARIOS`
--

CREATE TABLE `GEUS001_USUARIOS` (
  `GEUS001_USUARIOS_ID` int(11) NOT NULL,
  `GEUS001_USUARIOS_NOMBRE` varchar(45) DEFAULT NULL,
  `GEUS001_USUARIOS_APELLIDO` varchar(40) NOT NULL,
  `GEUS001_USUARIOS_EMAIL` varchar(40) NOT NULL,
  `GEUS001_USUARIOS_PASSWORD` varchar(20) NOT NULL,
  `GEUS001_USUARIOS_CARGO` int(11) NOT NULL,
  `GEUS001_USUARIOS_SUELDO` float NOT NULL,
  `GEUS001_USUARIOS_FECHAINC` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `GEUS001_USUARIOS`
--

INSERT INTO `GEUS001_USUARIOS` (`GEUS001_USUARIOS_ID`, `GEUS001_USUARIOS_NOMBRE`, `GEUS001_USUARIOS_APELLIDO`, `GEUS001_USUARIOS_EMAIL`, `GEUS001_USUARIOS_PASSWORD`, `GEUS001_USUARIOS_CARGO`, `GEUS001_USUARIOS_SUELDO`, `GEUS001_USUARIOS_FECHAINC`) VALUES
(1, 'Angel Luis', 'Vidal', 'angelvidal@geus.com', 'YWRtaW4=', 2, 2000, '2018-03-14'),
(2, 'Esther', 'Garcia', 'danieldiezarias@gmail.com', 'cm9vdA==', 1, 1000, '2018-04-05'),
(3, 'Rafael', 'Perez', 'rafaelperez@geus.com', 'c3VwZXI=', 3, 10000, '2018-05-01'),
(5, 'Daniel', 'Diez', 'danieldiez_95@hotmail.com', 'cm9vdA==', 1, 1000, '2018-05-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GEUS002_TAREAS`
--

CREATE TABLE `GEUS002_TAREAS` (
  `GEUS002_TAREAS_ID` int(11) NOT NULL,
  `GEUS002_TAREAS_NOMBRE` varchar(40) NOT NULL,
  `GEUS002_TAREAS_DESCRIPCION` text NOT NULL,
  `GEUS002_TAREAS_EMISOR` int(11) NOT NULL,
  `GEUS002_FECHA_TAREA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `GEUS002_TAREAS`
--

INSERT INTO `GEUS002_TAREAS` (`GEUS002_TAREAS_ID`, `GEUS002_TAREAS_NOMBRE`, `GEUS002_TAREAS_DESCRIPCION`, `GEUS002_TAREAS_EMISOR`, `GEUS002_FECHA_TAREA`) VALUES
(1, 'Tres en raya - JavaScript', 'Crear una aplicación en JS que permita jugar a dos personas de manera simultanea. Deberá tener una interfaz agradable.', 1, '2018-05-20 14:31:37'),
(2, 'Listado de tareas', 'Sistema que permita un listado de tareas.', 1, '2018-05-20 14:32:03'),
(3, 'Pagina web', 'Crear una pagina web del tema que se desee, siendo esta responsiva.', 1, '2018-05-20 14:32:26'),
(4, 'Aplicacion android', 'Crear aplicación android que permita la gestión de usuarios.', 1, '2018-05-20 14:32:57'),
(5, 'Tarea de prueba', 'Tarea para obtener listados', 1, '2018-05-20 21:21:35');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GEUS003_TRABAJADORES_ASIGNADOS`
--

CREATE TABLE `GEUS003_TRABAJADORES_ASIGNADOS` (
  `GEUS003_TRABAJADORES_ID_TAREA` int(11) NOT NULL,
  `GEUS003_TRABAJADORES_ID_EMPLEADO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `GEUS003_TRABAJADORES_ASIGNADOS`
--

INSERT INTO `GEUS003_TRABAJADORES_ASIGNADOS` (`GEUS003_TRABAJADORES_ID_TAREA`, `GEUS003_TRABAJADORES_ID_EMPLEADO`) VALUES
(1, 2),
(1, 5),
(2, 2),
(3, 5),
(4, 2),
(5, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GEUS004_WORKFLOW`
--

CREATE TABLE `GEUS004_WORKFLOW` (
  `GEUS004_WORKFLOW_ID_TAREA` int(11) NOT NULL,
  `GEUS004_WORKFLOW_ID_ESTADO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `GEUS004_WORKFLOW`
--

INSERT INTO `GEUS004_WORKFLOW` (`GEUS004_WORKFLOW_ID_TAREA`, `GEUS004_WORKFLOW_ID_ESTADO`) VALUES
(1, 2),
(2, 3),
(3, 2),
(4, 2),
(5, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GEUS005_TAREAS_DIRECTIVO`
--

CREATE TABLE `GEUS005_TAREAS_DIRECTIVO` (
  `GEUS005_TAREAS_DIRECTIVO_ID_TAREA` int(11) NOT NULL,
  `GEUS005_TAREAS_DIRECTIVO_ID_DIRECTIVO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `GEUS005_TAREAS_DIRECTIVO`
--

INSERT INTO `GEUS005_TAREAS_DIRECTIVO` (`GEUS005_TAREAS_DIRECTIVO_ID_TAREA`, `GEUS005_TAREAS_DIRECTIVO_ID_DIRECTIVO`) VALUES
(1, 3),
(2, 3),
(4, 3),
(3, 3),
(5, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GEUS006_ESTADOS`
--

CREATE TABLE `GEUS006_ESTADOS` (
  `GEUS006_ESTADOS_NOMBRE_ESTADO` varchar(20) NOT NULL,
  `GEUS006_ESTADOS_ID_ESTADO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `GEUS006_ESTADOS`
--

INSERT INTO `GEUS006_ESTADOS` (`GEUS006_ESTADOS_NOMBRE_ESTADO`, `GEUS006_ESTADOS_ID_ESTADO`) VALUES
('PENDIENTE', 1),
('APROBADA', 2),
('RECHAZADA', 3),
('FINALIZADA', 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `GEUS001_USUARIOS`
--
ALTER TABLE `GEUS001_USUARIOS`
  ADD PRIMARY KEY (`GEUS001_USUARIOS_ID`);

--
-- Indices de la tabla `GEUS002_TAREAS`
--
ALTER TABLE `GEUS002_TAREAS`
  ADD PRIMARY KEY (`GEUS002_TAREAS_ID`);

--
-- Indices de la tabla `GEUS006_ESTADOS`
--
ALTER TABLE `GEUS006_ESTADOS`
  ADD PRIMARY KEY (`GEUS006_ESTADOS_ID_ESTADO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `GEUS001_USUARIOS`
--
ALTER TABLE `GEUS001_USUARIOS`
  MODIFY `GEUS001_USUARIOS_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `GEUS002_TAREAS`
--
ALTER TABLE `GEUS002_TAREAS`
  MODIFY `GEUS002_TAREAS_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
